package com.ryabov.pokersb.service.implementation;

import com.ryabov.pokersb.dto.ActiveGameCodeDTO;
import com.ryabov.pokersb.mapper.ActiveGameCodeMapper;
import com.ryabov.pokersb.repository.ActiveGameCodeRepository;
import com.ryabov.pokersb.service.ActiveGameCodeService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ActiveGameCodeServiceImpl implements ActiveGameCodeService {
    ActiveGameCodeRepository activeGameCodeRepository;
    ActiveGameCodeMapper activeGameCodeMapper;


    @Override
    public ActiveGameCodeDTO findGameByCode(String activeGameCode) {
       return activeGameCodeMapper.activeGameCodeToActiveGameCodeDTO(activeGameCodeRepository.findByGameCode(activeGameCode));
    }

    @Override
    public void saveGameCode(ActiveGameCodeDTO activeGameCodeRequest) {
        activeGameCodeRepository.save(activeGameCodeMapper.activeGameCodeDtoToActiveGameCode(activeGameCodeRequest));
    }

    @Override
    public void deleteGameCode(ActiveGameCodeDTO activeGameCodeRequest) {
        activeGameCodeRepository.delete(activeGameCodeMapper.activeGameCodeDtoToActiveGameCode(activeGameCodeRequest));
    }


}
