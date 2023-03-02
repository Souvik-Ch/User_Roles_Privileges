package com.example.auth.controller;

import com.example.auth.entities.UserPrivilege;
import com.example.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    List<String> userPrivileges;

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<List<String>> getUserPrivileges(@PathVariable("id") String id) throws Exception {
        List<UserPrivilege> userPrivilegeList = userService.fetchUserPrivilegesByUserId(Integer.valueOf(id));

        for(UserPrivilege userPrivilege : userPrivilegeList){
            userPrivileges.add(userPrivilege.getPrivilege_Name());
        }
        return  new ResponseEntity<>(userPrivileges, HttpStatus.OK);
    }

}
