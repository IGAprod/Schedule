package com.kurs.kurs.Repository;

import com.kurs.kurs.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

    User findByUsername(String username);

}
