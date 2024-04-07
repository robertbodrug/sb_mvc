package com.goit.sb_mvc.dao.user;

import com.goit.sb_mvc.dao.user.UserRepository;
import com.goit.sb_mvc.model.User;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    public final UserRepository repository;
    public User findByUsername(String username) {
        return repository.findById(username).orElse(null);
    }
}