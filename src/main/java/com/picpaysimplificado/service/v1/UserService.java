package com.picpaysimplificado.service.v1;

import com.picpaysimplificado.domain.model.User;
import com.picpaysimplificado.dto.v1.UserDTO;
import com.picpaysimplificado.exception.DocumentAlreadyRegisteredException;
import com.picpaysimplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    public User saveUser(UserDTO userDTO){
        User user = new User(userDTO);
        if(userRepository.findUserByDocument(user.getDocument()).isPresent()) {
            throw new DocumentAlreadyRegisteredException("The user of this document is already registered");
        }
        return userRepository.save(user);
    }

    public User updateBalanceUserById(User user, Long id){
        User referenceOfUser = userRepository.getReferenceById(id);
        referenceOfUser.setBalance(user.getBalance());
        return userRepository.save(referenceOfUser);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


}
