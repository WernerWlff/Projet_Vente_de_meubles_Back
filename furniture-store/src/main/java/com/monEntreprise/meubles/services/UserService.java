package com.monEntreprise.meubles.services;

import com.monEntreprise.meubles.entities.User;
import com.monEntreprise.meubles.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    @Transactional
    public User createUser(User user){
        return userRepository.save(user);
    }

    @Transactional
    public Optional<User> updateUser(Long id, User userDetails){
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setFirstname(userDetails.getFirstname());
            existingUser.setLastname(userDetails.getLastname());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setPassword(userDetails.getPassword());
            User updatedUser = userRepository.save(existingUser);
            return Optional.of(updatedUser);
        }
        return Optional.empty();
    }

    @Transactional
    public Optional<User> deleteUser(Long id){
        Optional<User> user =userRepository.findById(id);

        if (user.isPresent()){
            userRepository.delete(user.get());
        }
        return user;
    }
}
