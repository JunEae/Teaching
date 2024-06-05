package com.teaching.teaching.service;

import com.teaching.teaching.dto.SignupRequest;
import com.teaching.teaching.dal.DataAccessLayer;
import com.teaching.teaching.models.User;
import com.teaching.teaching.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final DataAccessLayer dataAccessLayer;
    @Autowired
    public UserDetailsServiceImpl(DataAccessLayer dataAccessLayer){
        this.dataAccessLayer = dataAccessLayer;
    }
    public String newUser(SignupRequest signupRequest) {
        User user = new User();
        user.setUserName(signupRequest.getUserName());
        user.setUserAge(signupRequest.getUserAge());
        user.setPassword(signupRequest.getPassword());
        user.setEmail(signupRequest.getEmail());
        return dataAccessLayer.newUserToDatabase(user);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = dataAccessLayer.getUserFromDatabaseByUsername(username);
        if (user == null) return null;
        return UserDetailsImpl.build(user);
    }
    public User loadUserEntityByUsername(String username) throws UsernameNotFoundException {
        return dataAccessLayer.getUserFromDatabaseByUsername(username);
    }


}
