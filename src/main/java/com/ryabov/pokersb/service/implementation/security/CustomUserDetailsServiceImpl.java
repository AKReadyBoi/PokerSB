package com.ryabov.pokersb.service.implementation;

import com.ryabov.pokersb.entity.Account;
import com.ryabov.pokersb.repository.AccountRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByLogin(username);
        return org.springframework.security.core.userdetails.User
                .builder()
                .username(account.getLogin())
                .password(account.getPassword())
                .roles("USER")
                .build();
    }
}
