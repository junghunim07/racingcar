package com.miniproject.racingcar.service;

import com.miniproject.racingcar.domain.Player;
import com.miniproject.racingcar.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository repository) {
        this.playerRepository = repository;
    }

    @Transactional
    public void join(Player player) {
        validationDuplicatePlayer(player);
        playerRepository.save(player);
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Optional<Player> findOne(String name) {
        return playerRepository.findOne(name);
    }

    private void validationDuplicatePlayer(Player player) {
        playerRepository.findOne(player.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("중복 회원 존재");
                });
    }
}
