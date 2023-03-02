package com.example.auth.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="user_role_to_privilege")
public class UserRoleToPrivilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private UserRole role;
    @ManyToOne
    private UserPrivilege privilege;
}
