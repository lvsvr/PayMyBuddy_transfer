package com.payMyBuddy.transfer.repository;

import com.payMyBuddy.transfer.model.UserBuddy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBuddyRepository extends CrudRepository<UserBuddy, Long> {
}
