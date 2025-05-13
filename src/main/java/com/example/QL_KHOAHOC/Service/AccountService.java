package com.example.QL_KHOAHOC.Service;

import com.example.QL_KHOAHOC.dtoRequest.AccountDto;
import com.example.QL_KHOAHOC.entity.Account;
import com.example.QL_KHOAHOC.responsitory.AccountResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
@Service
public class AccountService {
    @Autowired
    private AccountResponsitory accountResponsitory;

    public Account createAccount(AccountDto accountRequest) {
        Account acc = new Account();
        acc.setUsername(accountRequest.getUsername());
        acc.setPassword(accountRequest.getPassword());
        acc.setAccessDate(Instant.now());
        try {
            return accountResponsitory.save(acc);
        } catch (Exception e) {
            // Ghi log lỗi chi tiết hơn ở đây sẽ hữu ích
            System.err.println("Lỗi khi tạo tài khoản: " + e.getMessage());
            return null;
        }
    }

    public Account getAccountByEmail(String email) {
        return accountResponsitory.findByEmail(email).orElse(null);
    }
    public Account getAccountByUsername (String username) {
        return accountResponsitory.findByUsername(username).get()   ;
    }
    public boolean deleteAccount(Account account) {
        try {
            accountResponsitory.delete(account);
            return true;
        } catch (Exception e) {
            System.err.println("Lỗi khi xóa tài khoản: " + e.getMessage());
            return false;
        }
    }

    public List<Account> getAllAccounts() {
        return accountResponsitory.findAll();
    }

    public Account signIn(String email, String password) {
        Account account = accountResponsitory.findByEmail(email).orElse(null);
        if (account != null && account.getPassword().equals(password)) {
            return account;
        }
        return null;
    }
}
