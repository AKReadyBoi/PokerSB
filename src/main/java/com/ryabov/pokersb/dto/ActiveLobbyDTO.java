package com.ryabov.pokersb.dto;

import com.ryabov.pokersb.entity.Account;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActiveGameCodeDTO {
    String gameCode;
    Set<Account> players;
}
