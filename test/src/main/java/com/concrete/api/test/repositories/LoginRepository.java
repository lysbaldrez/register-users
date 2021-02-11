package com.concrete.api.test.repositories;

import com.concrete.api.test.model.Login;
import com.concrete.api.test.model.LoginRegister;
import com.concrete.api.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository<LoginRegister, Long>{

    List<Login> findByUser(User user);

}
