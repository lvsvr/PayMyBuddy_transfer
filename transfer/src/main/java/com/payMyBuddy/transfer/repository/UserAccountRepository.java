package com.payMyBuddy.transfer.repository;

import com.payMyBuddy.transfer.model.User;
import com.payMyBuddy.transfer.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    UserAccount findByUser(User user);
}

