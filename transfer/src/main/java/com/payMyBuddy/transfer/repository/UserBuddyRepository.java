package com.payMyBuddy.transfer.repository;

import com.payMyBuddy.transfer.model.UserBuddy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBuddyRepository extends JpaRepository<UserBuddy, Long> {
}
