package com.daguero.springproject.controllers;

import com.daguero.springproject.models.Player;
import com.daguero.springproject.services.PlayerService;
import com.daguero.springproject.services.PlayerServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlayerController {

	@Autowired
    private PlayerServiceImpl playerService;
    
    @Autowired
    public void setPlayerService(PlayerServiceImpl playerService) {
        this.playerService = playerService;
    }

    @RequestMapping("/player")
    public String player(Model model) {
    	List<Player> players;
    	try {
    		players = playerService.findAll();
    	} catch (Exception e) {
    		players = new ArrayList<>();
    	}
        model.addAttribute("players", players);
        return "player";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        return "create";
    }

    @RequestMapping("/save")
    public String save(@RequestParam String tag, @RequestParam String character, @RequestParam int wins, @RequestParam int losses) {
        Player player = new Player(tag, character, wins, losses);
        player = playerService.save(player);

        return "redirect:/show/" + player.getId();
    }

    @RequestMapping("/show/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("player", playerService.findById(id));
        return "show";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String id) {
        Player player = playerService.findById(id);
        playerService.delete(player);
        return "redirect:/player";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("player", playerService.findById(id));
        return "edit";
    }

    @RequestMapping("/update")
    public String update(@RequestParam String id, @RequestParam String tag, @RequestParam String character, @RequestParam int wins, @RequestParam int losses) {
        Player player = playerService.findById(id);
        player.setTag(tag);
        player.setCharacter(character);
        player.setWins(wins);
        player.setLosses(losses);
        playerService.save(player);
        return "redirect:/show/" + player.getId();
    }
}