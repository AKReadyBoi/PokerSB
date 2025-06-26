package com.ryabov.pokersb.service;

import com.ryabov.pokersb.dto.ActiveGameCodeDTO;
import org.springframework.stereotype.Service;

@Service
public interface ActiveGameCodeService {
    ActiveGameCodeDTO findGameByCode(String activeGameCode);
    void saveGameCode(ActiveGameCodeDTO activeGameCodeRequest);
    void deleteGameCode(ActiveGameCodeDTO activeGameCodeRequest);
}
