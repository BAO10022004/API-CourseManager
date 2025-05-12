package com.example.QL_KHOAHOC.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @ColumnDefault("''")
    @Column(name = "Username", nullable = false, length = 50)
    private String username;

    @Lob
    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "access_date", nullable = false)
    private Instant accessDate;

    @Lob
    @Column(name = "Email")
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RoleID")
    private Role roleID;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instant getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(Instant accessDate) {
        this.accessDate = accessDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRoleID() {
        return roleID;
    }

    public void setRoleID(Role roleID) {
        this.roleID = roleID;
    }

}