package com.maxibit1.tgGodds.user.repository;

import com.maxibit1.tgGodds.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
