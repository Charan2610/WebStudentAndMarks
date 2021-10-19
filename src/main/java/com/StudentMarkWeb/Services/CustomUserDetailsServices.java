package com.StudentMarkWeb.Services;

import com.StudentMarkWeb.Dao.UserRepo;
import com.StudentMarkWeb.Models.CustomDetails;
import com.StudentMarkWeb.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsServices implements UserDetailsService {

    private UserRepo userRepo;

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users user= userRepo.findByUsername(username);
       if(user==null){
           throw  new UsernameNotFoundException("User Not Found");
       }
        return  new CustomDetails(user);
    }
}
