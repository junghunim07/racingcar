package com.miniproject.racingcar.service;

import com.miniproject.racingcar.domain.Player;
import com.miniproject.racingcar.repository.PlayerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
class PlayerServiceTest {

    @Autowired PlayerRepository playerRepository;
    @Autowired PlayerService playerService;

    @Test
    @DisplayName("회원가입")
    void join() {
        //given
        Player player = new Player("memberA");

        //when
        playerService.join(player);
        Player findPlayer = playerService.findOne(player.getName()).get();

        //then
        assertThat(findPlayer.getName()).isEqualTo(player.getName());
    }

    @Test
    @DisplayName("회원 가입 중복")
    void duplicateJoin() {
        //given
        Player player1 = new Player("memberA");
        playerService.join(player1);

        //when
        Player player2 = new Player("memberA");

        //then
        assertThatThrownBy(() -> playerService.join(player2))
                .isInstanceOf(IllegalStateException.class);
    }
}