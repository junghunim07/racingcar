package com.miniproject.racingcar.repository;

import com.miniproject.racingcar.domain.Player;
import com.miniproject.racingcar.service.PlayerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
class PlayerRepositoryTest {

    @Autowired private PlayerRepository repository;

    @Test
    @DisplayName("회원 저장")
    void join() {
        //given
        Player player = new Player("memberA");

        //when
        repository.save(player);
        Player findPlayer = repository.findOne(player.getName()).get();

        //then
        assertThat(findPlayer.getName()).isEqualTo(player.getName());
    }

    @Test
    @DisplayName("업데이트")
    void update() {
        //given
        Player player = new Player("memberA");

        //when
        player.win();
        repository.update(player);

        //then
        assertThat(player.getTotal()).isEqualTo(1);
        assertThat(player.getVictory()).isEqualTo(1);
        assertThat(player.getPoint()).isEqualTo(20);
    }
}