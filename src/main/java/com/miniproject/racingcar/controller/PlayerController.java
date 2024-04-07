package com.miniproject.racingcar.controller;

import com.miniproject.racingcar.domain.Player;
import com.miniproject.racingcar.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/players/new")
    public String createForm() {
        return "players/createPlayerForm";
    }

    @PostMapping("/players/new")
    public String create(PlayerForm form) {
        Player player = new Player(form.getName());
        playerService.join(player);
        return "redirect:/";
    }

    @GetMapping("/players")
    public String list(Model model) {
        List<Player> players = playerService.findAll();
        model.addAttribute("players", players);
        return "players/playerList";
    }
}
