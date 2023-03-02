package com.example.auth.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="user_privilege")
public class UserPrivilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String privilege_Name;

}
