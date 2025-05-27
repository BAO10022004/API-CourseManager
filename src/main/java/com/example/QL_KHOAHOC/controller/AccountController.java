package com.example.QL_KHOAHOC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QL_KHOAHOC.Service.AccountService;
import com.example.QL_KHOAHOC.dtoRequest.AccountDto;
import com.example.QL_KHOAHOC.dtoRequest.SignInRequest;
import com.example.QL_KHOAHOC.entity.Account;

@RestController
@RequestMapping("/api/accounts") // Thêm tiền tố /api/accounts cho tất cả các endpoint trong controller này
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/create") // Đổi đường dẫn thành /create cho rõ ràng hơn
    public ResponseEntity<Account> createAccount(@RequestBody AccountDto accountDto) {
        Account createdAccount = accountService.createAccount(accountDto);
        if (createdAccount != null) {
            return new ResponseEntity<>(createdAccount, HttpStatus.CREATED); // Trả về 201 Created khi tạo thành công
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Trả về 400 Bad Request nếu có lỗi
        }
    }

    @GetMapping("/{email}") // Đổi đường dẫn thành /email để thể hiện rõ ràng việc lấy theo email
    public ResponseEntity<Account> getUserByEmail(@PathVariable String email) { // Sử dụng @RequestParam thay vì @RequestBody cho tham số truyền trên URL
        Account account = accountService.getAccountByEmail(email) == null ? accountService.getAccountByUsername(email): accountService.getAccountByEmail(email) ;
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK); // Trả về 200 OK nếu tìm thấy
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Trả về 404 Not Found nếu không tìm thấy
        }
    }


    // Bạn có thể thêm các endpoint khác cho các chức3 năng còn lại của AccountService như sau:
    @DeleteMapping("/{username}") // Sử dụng @PathVariable để lấy username từ URL
    public ResponseEntity<Void> deleteAccount(@PathVariable String username) {
        // Nên tìm account theo username hoặc ID để xóa cho chính xác
        Account accountToDelete = accountService.getAccountByEmail(username); //Ví dụ
        if(accountToDelete != null){
            boolean isDeleted = accountService.deleteAccount(accountToDelete);
            if(isDeleted){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // trả về 204
            }
            else{
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<Account> signIn(@RequestBody SignInRequest signIn) {
        Account signedInAccount = accountService.signIn(signIn.getEmail(), signIn.getPassword());
        if (signedInAccount != null) {
            return new ResponseEntity<>(signedInAccount, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
