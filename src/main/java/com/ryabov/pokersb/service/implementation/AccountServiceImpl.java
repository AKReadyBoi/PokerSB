package com.ryabov.pokersb.service.implementation;

import com.ryabov.pokersb.dto.UserDTO;
import com.ryabov.pokersb.entity.User;
import com.ryabov.pokersb.mapper.UserMapper;
import com.ryabov.pokersb.repository.UserRepository;
import com.ryabov.pokersb.request.UserRequest;
import com.ryabov.pokersb.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService, UserDetailsService {
    UserRepository userRepository;
    UserMapper mapper;
    @Override
    public UserDTO getUser(long id)  {
      return mapper.userToUserDto(findSafe(id));
    }

    @Override
    public void saveUser(UserRequest userRequest) {
        userRepository.save(mapper.userRequestToUser(userRequest));
    }

    @Override
    public UserDTO putUserEmail(long id, UserRequest userRequest)  {
        User user = findSafe(id);
        user.setEmail(userRequest.getEmail());
        return mapper.userToUserDto(user);
    }

    @Override
    public UserDTO putUserPassword(long id, UserRequest userRequest)  {
        User user = findSafe(id);
        user.setPassword(userRequest.getPassword());
        return mapper.userToUserDto(user);
    }

    @Override
    public UserDTO putUserAvatar(long id, UserRequest userRequest)  {
        User user = findSafe(id);
        user.setAvatar(user.getAvatar());
        return mapper.userToUserDto(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    private User findSafe(long id)  {
        return userRepository.findById(id)
                .orElseThrow(
                        ()->new UsernameNotFoundException("Didn`t find the user")
                );
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username)
                .orElseThrow(()->new UsernameNotFoundException("Didn`t find the user"))
                ;
        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}
