package com.sportsmanager.backend.Services;

import com.sportsmanager.backend.Entities.User;
import com.sportsmanager.backend.Repositories.ReservaRepo;
import com.sportsmanager.backend.Repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User criarUser(User user){
        return userRepo.save(user);
    }

    public User procurarId(Long id){
        return userRepo.findById(id).get();
    }

    public List<User> obterTodosUtilizadores() {
        return userRepo.findAll();
    }
}
