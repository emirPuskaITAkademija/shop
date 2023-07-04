package com.beautiful.shop.security;

import com.beautiful.shop.user.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/*
/login
CustomerUserDetailsService
UserDetails <--CustomUserDetails--> User(users)
 */
// User DB <---- CustomUserDetails ---> UserDetails
// Privilege DB <---- Mapiranje između  ---> Role
//
public class CustomUserDetails implements UserDetails {
    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    //https://www.baeldung.com/role-and-privilege-for-spring-security-registration
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //USER EMPLOYEE MANAGER ADMIN
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();//NE 76591a34-866d-45cf-9126-843e09f1efa1
                                  //DA alden123 hashed version
    }

    //username: "user"  -> alden.efendic
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
