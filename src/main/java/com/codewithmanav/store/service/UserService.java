package com.codewithmanav.store.service;

import com.codewithmanav.store.kafka.UserEventProducer;
import com.codewithmanav.store.model.User;
import com.codewithmanav.store.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;
    private final UserEventProducer producer;

    public UserService(UserRepository repo, UserEventProducer producer) {
        this.repo = repo;
        this.producer = producer;
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public User createUser(User user) {
        User saved = repo.save(user);
        producer.sendUserCreatedEvent(saved); // 🚀 Send Kafka event
        return repo.save(user);
    }

    public User updateUser(Long id, User user) {
        user.setId(id);
        return repo.save(user);
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }
}
