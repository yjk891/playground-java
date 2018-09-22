package com.github.lambda.playground.domain.user.repository;

import javax.transaction.Transactional;

import com.github.lambda.playground.domain.user.entity.AuthIdentity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AuthIdentityRepository extends PagingAndSortingRepository<AuthIdentity, Long> {
  @Query("SELECT a FROM AuthIdentity a WHERE a.username = :username")
  AuthIdentity findByUsername(@Param("username") String username);
}
