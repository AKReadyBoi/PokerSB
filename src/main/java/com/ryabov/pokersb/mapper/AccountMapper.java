package com.ryabov.pokersb.mapper;

import com.ryabov.pokersb.dto.AccountDTO;
import com.ryabov.pokersb.entity.Account;
import com.ryabov.pokersb.request.UserRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    AccountDTO userToUserDto(Account account);
    Account userRequestToUser(UserRequest userRequest);
}
