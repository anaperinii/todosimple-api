package com.anaperini.todosimple.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anaperini.todosimple.models.User;
import com.anaperini.todosimple.repositories.UserRepository;
import java.util.Optional;
import java.lang.RuntimeException;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.orElseThrow(()-> new RuntimeException(
            "Usuário não encontrado! Id: " + id + ", Tipo: " + User.class.getName())
            );
    }

    @Transactional
    public User createUser(User obj) {
        obj.setId(null);
        obj = this.userRepository.save(obj);
        return obj;
    }

    @Transactional
    public User updateUser(User obj) {
        User newObj = findById(obj.getId());
        newObj.setPassword(obj.getPassword());
        return this.userRepository.save(newObj);
    }

    public void deleteUser(Long id) {
        findById(id);
        try {
            this.userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir o usuário, pois há entidades relacionadas!");
        }
    }


}
