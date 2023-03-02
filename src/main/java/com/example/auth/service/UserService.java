package com.example.auth.service;

import com.example.auth.entities.UserAccount;
import com.example.auth.entities.UserPrivilege;
import com.example.auth.entities.UserRoleToPrivilege;
import com.example.auth.entities.UserToRole;
import com.example.auth.repositories.UserAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final UserAccountRepository userAccountRepository;

    List<UserPrivilege> userPrivilegeList;
    public UserService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public List<UserPrivilege> fetchUserPrivilegesByUserId(Integer id) throws Exception {
        UserAccount userAccount = userAccountRepository.findByUserid(id);
        if (userAccount == null) {
            throw new Exception("User with userId [" + id + "] not found");
        }

        for (UserToRole userToRole : userAccount.getUserToRoles()) {
            for (UserRoleToPrivilege userRoleToPrivilege : userToRole.getRole().getUserRoleToPrivileges()) {
                userPrivilegeList.add(userRoleToPrivilege.getPrivilege());
            }
        }
        return userPrivilegeList;
    }
}
