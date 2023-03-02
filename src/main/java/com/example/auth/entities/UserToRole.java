package com.example.auth.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="user_to_role")
public class UserToRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "userid")
    private UserAccount user;
    @ManyToOne
    private UserRole role;
}
