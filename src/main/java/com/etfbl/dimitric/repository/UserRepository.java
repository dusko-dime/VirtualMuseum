package com.etfbl.dimitric.repository;

import com.etfbl.dimitric.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getByUsernameAndActive(String username, Byte active);
}
