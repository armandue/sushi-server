package com.cin.sushi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cin.sushi.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long>, PagingAndSortingRepository<Book, Long>{
	public List<Book> findAll();
	public List<Book> findByTelephone(String telephone);
}
