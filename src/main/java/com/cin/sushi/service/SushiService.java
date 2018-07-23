package com.cin.sushi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cin.sushi.entity.Book;
import com.cin.sushi.entity.Sushi;
import com.cin.sushi.entity.column.Dish;
import com.cin.sushi.enums.SushiType;
import com.cin.sushi.repository.BookRepository;
import com.cin.sushi.repository.SushiRepository;

@Service
public class SushiService {

	@Autowired
	private SushiRepository sushiRepo;
	
	@Autowired
	private BookRepository bookRepo;
	
	public List<Sushi> findSushiByBookId(Long bookId) {
		Optional<Book> book = bookRepo.findById(bookId);
		if (book.isPresent()) {
			List<Long> sushiIds = book.get()
					.getDishes()
					.stream()
					.map(Dish::getSushiId)
					.collect(Collectors.toList());
			return sushiRepo.findByIdIn(sushiIds);
		}
		return null;
	}
	
	public List<Sushi> findAll() {
		return sushiRepo.findAll();
	};
	
	public Page<Sushi> findAll(Pageable pageable) {
		return sushiRepo.findAll(pageable);
	};
	
	public List<Sushi> findByType(SushiType type) {
		return sushiRepo.findByType(type);
	};
	
	public List<Sushi> findByIdIn(List<Long> ids) {
		return sushiRepo.findByIdIn(ids);
	}

	public void save(Sushi sushi) {
		sushiRepo.save(sushi);
	}

	public void deleteById(Long sushiId) {
		sushiRepo.deleteById(sushiId);
	}

	public Optional<Sushi> findById(Long sushiId) {
		return sushiRepo.findById(sushiId);
	};
}
