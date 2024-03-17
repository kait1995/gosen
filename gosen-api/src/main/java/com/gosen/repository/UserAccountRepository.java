package com.gosen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gosen.model.UserAccountEntity;

public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Long>{

}
