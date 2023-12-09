package com.gosen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gosen.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{

}
