package com.daguero.springproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.daguero.springproject.models.Player;

@Service
public interface PlayerService {

    Player findById(String id);

    void delete(String id);
    
    Player save(Player player);
	
    void delete(Player player);
    
    List<Player> findAll();
    
}
