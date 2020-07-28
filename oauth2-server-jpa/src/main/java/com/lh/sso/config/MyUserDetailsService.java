package com.lh.sso.config;

import com.lh.sso.entity.MyUser;
import com.lh.sso.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService  implements UserDetailsService {

    @Autowired
    MyUserRepository myUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        MyUser u = myUserRepository.findOneByUsername(s);
        if(u==null){
            throw new RuntimeException("用户不存在");
        }
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();

        // String username, String password, Collection<? extends GrantedAuthority > authorities
        return  new User(u.getUsername(),u.getPassword(), authorities);


    }
}
