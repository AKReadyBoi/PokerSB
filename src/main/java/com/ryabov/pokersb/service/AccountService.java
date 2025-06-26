package com.ryabov.pokersb.service;

import com.ryabov.pokersb.dto.UserDTO;
import com.ryabov.pokersb.entity.User;
import com.ryabov.pokersb.request.UserRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDTO getUser(long id);
    void saveUser(UserRequest userRequest);
    UserDTO putUserEmail(long id, UserRequest userRequest);
    UserDTO putUserPassword(long id, UserRequest userRequest);
    UserDTO putUserAvatar(long id, UserRequest userRequest);
    void deleteUser(long id);
}
