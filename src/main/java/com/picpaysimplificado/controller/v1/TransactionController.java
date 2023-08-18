package com.picpaysimplificado.controller.v1;

import com.picpaysimplificado.domain.model.Transaction;
import com.picpaysimplificado.dto.v1.NotificationDTO;
import com.picpaysimplificado.dto.v1.TransactionDTO;
import com.picpaysimplificado.repository.TransactionRepository;
import com.picpaysimplificado.service.v1.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transactionDTO){
        return ResponseEntity.ok()
                .body(transactionService.createAndPersistTransaction(transactionDTO));
    }
}
