package com.payMyBuddy.transfert.repository;

import com.payMyBuddy.transfert.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
