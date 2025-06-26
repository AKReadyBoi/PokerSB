package com.ryabov.pokersb.dto;

import com.ryabov.pokersb.entity.Image;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
    String login;
    String email;
    String password;
    Long moneyWon;
    Double winRate;
    Double foldRate;
    Image avatar;
}
