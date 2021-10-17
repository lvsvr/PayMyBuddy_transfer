package com.payMyBuddy.transfert.repository;

import com.payMyBuddy.transfert.model.UserBuddy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBuddyRepository extends CrudRepository<UserBuddy, Long> {
}
