package com.ryabov.pokersb.repository;

import com.ryabov.pokersb.dto.AccountDTO;
import com.ryabov.pokersb.entity.ActiveGameCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveGameCodeRepository extends JpaRepository<ActiveGameCode, Long> {
    ActiveGameCode findByGameCode(String gameCode);
    ActiveGameCode findByPlayers(AccountDTO accountDTO);

}
