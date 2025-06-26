package com.ryabov.pokersb.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActiveGameCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String gameCode;
    @OneToMany(mappedBy = "currentLobby", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Account> players;
}
