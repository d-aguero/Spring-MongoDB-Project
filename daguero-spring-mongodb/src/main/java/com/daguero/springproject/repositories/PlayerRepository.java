package com.daguero.springproject.repositories;

import com.daguero.springproject.models.Player;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, String> {
	// TODO: keep empty?
}