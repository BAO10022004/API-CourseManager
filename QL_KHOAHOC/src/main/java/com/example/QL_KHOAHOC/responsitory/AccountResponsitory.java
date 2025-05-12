package com.example.QL_KHOAHOC.responsitory;

import com.example.QL_KHOAHOC.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountResponsitory extends JpaRepository<Account, Long> {
    List<Account> getAccountsByUsername(String username);

    List<Account> getAccountByEmail(String email);
    Optional<Account> findByEmail(String email);

    Optional<Account> findByUsername(String username);
}