package com.cin.sushi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cin.sushi.entity.Sushi;
import com.cin.sushi.enums.SushiType;

public interface SushiRepository extends CrudRepository<Sushi, Long>, PagingAndSortingRepository<Sushi, Long>{
	public List<Sushi> findAll();
	public List<Sushi> findByType(SushiType type);
	public List<Sushi> findByIdIn(List<Long> ids);
}
