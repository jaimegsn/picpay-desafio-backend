package com.picpaysimplificado.service.v1;

import com.picpaysimplificado.domain.enums.UserType;
import com.picpaysimplificado.domain.model.Transaction;
import com.picpaysimplificado.domain.model.User;
import com.picpaysimplificado.dto.v1.TransactionDTO;
import com.picpaysimplificado.exception.InsufficientBalanceException;
import com.picpaysimplificado.exception.MerchantUserNotAuthorizedException;
import com.picpaysimplificado.exception.UnauthorizedTransactionException;
import com.picpaysimplificado.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransactionService {
    private final UserService userService;
    private final TransactionRepository transactionRepository;
    private final RestTemplate restTemplate;
    private final NotificationService notificationService;

    @Autowired
    public TransactionService(UserService userService,
                              TransactionRepository transactionRepository,
                              RestTemplate restTemplate,
                              NotificationService notificationService) {

        this.userService = userService;
        this.transactionRepository = transactionRepository;
        this.restTemplate = restTemplate;
        this.notificationService = notificationService;
    }

    private void validateTransaction(User user, BigDecimal amount){
        if(user.getUserType().equals(UserType.MERCHANT)){
            throw new MerchantUserNotAuthorizedException("Merchant user is not authorized for transactions");
        }

        if(amount.compareTo(user.getBalance()) > 0){
            throw new InsufficientBalanceException("User does not have enough balance");
        }

        if(!authorizedTransaction(user, amount)){
            throw new UnauthorizedTransactionException("Unauthorized Transaction");
        };
    }

    private boolean authorizedTransaction(User user, BigDecimal value){
        ResponseEntity<Map> authorizedResponse = restTemplate.getForEntity(
                "https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6",
                Map.class);

        if(authorizedResponse.getStatusCode().equals(HttpStatus.OK)){
            String message = authorizedResponse.getBody().get("message").toString();
             return message.equalsIgnoreCase("Autorizado");
        }
        return false;
    }

    public Transaction createAndPersistTransaction(TransactionDTO transactionDTO){
        User sender = userService.findUserById(transactionDTO.getSenderId());
        User receiver = userService.findUserById(transactionDTO.getReceiverId());

        validateTransaction(sender, transactionDTO.getValue());

        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDTO.getValue());
        transaction.setSender(sender);
        transaction.setReceiver(receiver);
        transaction.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transaction.getAmount()));
        receiver.setBalance(receiver.getBalance().add(transaction.getAmount()));


        userService.updateBalanceUserById(sender, transactionDTO.getSenderId());
        userService.updateBalanceUserById(receiver, transactionDTO.getReceiverId());

        notificationService.sendNotification(sender, "Successfully completed transaction");
        notificationService.sendNotification(receiver, "Successfully received transaction");

        return transactionRepository.save(transaction);
    }
}
