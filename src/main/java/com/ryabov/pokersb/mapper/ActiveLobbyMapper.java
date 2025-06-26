package com.ryabov.pokersb.mapper;

import com.ryabov.pokersb.dto.ActiveGameCodeDTO;
import com.ryabov.pokersb.entity.ActiveGameCode;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActiveGameCodeMapper {
    ActiveGameCodeDTO activeGameCodeToActiveGameCodeDTO(ActiveGameCode activeGameCode);
    ActiveGameCode activeGameCodeDtoToActiveGameCode(ActiveGameCodeDTO activeGameCodeRequest);
}
