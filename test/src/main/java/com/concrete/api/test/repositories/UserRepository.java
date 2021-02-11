package com.concrete.api.test.repositories;

import com.concrete.api.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String > {

    List<User> findByName(String name);
    List<User> findByNameContaining(String name);
    User findByEmail(String email);
    User findByToken(String token);
    List<User> findByEmailAndPassword(String email, String password);
    List<User> findByPassword(String password);

}
