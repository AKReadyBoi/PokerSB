package com.ryabov.pokersb.service.implementation;

import com.ryabov.pokersb.entity.Account;
import com.ryabov.pokersb.repository.AccountRepository;
import com.ryabov.pokersb.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class OAuth2ServiceImpl implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    AccountRepository accountRepository;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = new DefaultOAuth2UserService().loadUser(userRequest);
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");
        if (accountRepository.findByEmail(email) == null) {
            Account account = new Account();
            account.setLogin(name);
            account.setEmail(email);
            account.setMoneyWon(0L);
            account.setWinRate(0.0);
            account.setFoldRate(0.0);
            account.setPassword(new BCryptPasswordEncoder().encode(UUID.randomUUID().toString()));
            accountRepository.save(account);
        }
        return oAuth2User;
    }
}
