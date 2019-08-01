package com.daguero.springproject.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daguero.springproject.models.Player;
import com.daguero.springproject.repositories.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {

	private PlayerRepository playerRepository;
	
	@Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
	
	@Override
	public Player findById(String id) {
		return playerRepository.findById(id).get();
	}

	@Override
	public void delete(String id) {
		playerRepository.deleteById(id);
	}

	@Override
	public Player save(Player player) {
		playerRepository.save(player);
		return player;
	}

	@Override
	public void delete(Player player) {
		playerRepository.delete(player);
	}

	@Override
	public List<Player> findAll() {
		List<Player> players = new ArrayList<>();
		playerRepository.findAll().forEach(players::add);
        return players;
	}

	
	
}
