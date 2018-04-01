package com.cin.sushi.controller;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cin.sushi.entity.Book;
import com.cin.sushi.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("book")
public class BookController {
	
	@Autowired
	private BookRepository bookRepo;
	
	@GetMapping
	public List<Book> getAllBook() {
		log.info("Get all books.");
		return bookRepo.findAll();
	}
	
	@GetMapping(path="/page")
	public Page<Book> getBooks(@RequestParam(required=false) Pageable pageable) {
		log.info("Get books by page {}.", pageable);
		return bookRepo.findAll(pageable);
	}
	
	@GetMapping(path="/telephone/{telephone}")
	public List<Book> getBookByTelephone(@PathVariable String telephone) {
		log.info("Get a book with telephone {}.", telephone);
		return bookRepo.findByTelephone(telephone);
	}
	
	@GetMapping(path="/{bookId}")
	public Optional<Book> getBook(@PathVariable Long bookId) {
		log.info("Get a book with id {}.", bookId);
		return bookRepo.findById(bookId);
	}
	
	@PostMapping
	public void saveBook(@RequestBody Book book) {
		log.info("Save a book {}.", book);
		ZonedDateTime bookTime = ZonedDateTime.now();
		book.setBookTime(bookTime);
		bookRepo.save(book);
	}
	
}
