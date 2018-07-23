package com.cin.sushi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cin.sushi.entity.Sushi;
import com.cin.sushi.enums.SushiType;
import com.cin.sushi.enums.Tag;
import com.cin.sushi.service.SushiService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("sushi")
public class SushiController {
	
	@Autowired
	private SushiService sushiService;
	
	@GetMapping
	public List<Sushi> getAllSushi() {
		log.info("Get all sushi.");
		return sushiService.findAll();
	}
	
	@GetMapping(path="/page")
	public Page<Sushi> getSushiWithPage(Pageable pageable) {
		log.info("Get sushi with page {}.", pageable);
		return sushiService.findAll(pageable);
	}
	
	@GetMapping(path="/book")
	public List<Sushi> getSushiByBookId(Long bookId) {
		log.info("Get sushi with book id {}", bookId);
		return sushiService.findSushiByBookId(bookId);
	}
	
	@GetMapping(path="/type")
	public List<Sushi> getSushiBySushiType(SushiType type) {
		log.info("Get sushi with type {}", type);
		return sushiService.findByType(type);
	}
	
	@GetMapping(path="/save")
	public void saveSushi() {
		log.info("Create new sushi.");
		
		Sushi sushi = new Sushi();
		
		List<Tag> tags = new ArrayList<>();
		
		tags.add(Tag.COOKED);
		tags.add(Tag.VEGETABLE);
		
		sushi.setId(1l);
		sushi.setName("rice");
		sushi.setIngredient("plain sushi rice.");
		sushi.setPrice(2.0);
		sushi.setUnit(1);
		sushi.setTags(tags);
		sushi.setType(SushiType.START);
		sushiService.save(sushi);
		
		tags = new ArrayList<>();
		tags.add(Tag.COOKED);
		tags.add(Tag.VEGETABLE);
		
		sushi.setId(2l);
		sushi.setName("edamame");
		sushi.setIngredient("boiled green beans.");
		sushi.setPrice(4.0);
		sushi.setUnit(1);
		sushi.setTags(tags);
		sushi.setType(SushiType.START);
		sushiService.save(sushi);
		
		tags = new ArrayList<>();
		tags.add(Tag.COOKED);
		tags.add(Tag.VEGETABLE);
		tags.add(Tag.SPICY);
		
		sushi.setId(3l);
		sushi.setName("wakame salad");
		sushi.setIngredient("spicy wakame algae salad.");
		sushi.setPrice(4.0);
		sushi.setUnit(1);
		sushi.setTags(tags);
		sushi.setType(SushiType.START);
		sushiService.save(sushi);
		
		tags = new ArrayList<>();
		tags.add(Tag.RAW);
		
		sushi.setId(4l);
		sushi.setName("lover supermix");
		sushi.setIngredient("salmon, tuna, cooked shrimps, sea bass, raw shrimp, octopus, amberjack, butter fish.");
		sushi.setPrice(14.0);
		sushi.setUnit(12);
		sushi.setTags(tags);
		sushi.setType(SushiType.MIXED);
		sushiService.save(sushi);
		
		tags = new ArrayList<>();
		tags.add(Tag.RAW);
		
		sushi.setId(5l);
		sushi.setName("first love");
		sushi.setIngredient("salmon, tuna, shrimps.");
		sushi.setPrice(7.0);
		sushi.setUnit(6);
		sushi.setTags(tags);
		sushi.setType(SushiType.MIXED);
		sushiService.save(sushi);
		
		tags = new ArrayList<>();
		tags.add(Tag.RAW);
		
		sushi.setId(6l);
		sushi.setName("gynza");
		sushi.setIngredient("Oshi-Zushi with salmon tartare, ikura, avocado and shiso sauce.");
		sushi.setPrice(12.0);
		sushi.setUnit(6);
		sushi.setTags(tags);
		sushi.setType(SushiType.MIXED);
		sushiService.save(sushi);
		
		tags = new ArrayList<>();
		tags.add(Tag.COOKED);
		tags.add(Tag.SPICY);
		
		sushi.setId(7l);
		sushi.setName("takeshita street");
		sushi.setIngredient("Oishi-Sushi with grilled Teriyaki salmon, buffalo mozzarella, fried onion, spicy mayo.");
		sushi.setPrice(14.0);
		sushi.setUnit(6);
		sushi.setTags(tags);
		sushi.setType(SushiType.MIXED);
		sushiService.save(sushi);
			
		tags = new ArrayList<>();
		tags.add(Tag.COOKED);
		
		sushi.setId(8l);
		sushi.setName("thai salad");
		sushi.setIngredient("valerian salad, scalded scampi, soy sprouts, mango, hazelnuts, coconut milk.");
		sushi.setPrice(4.0);
		sushi.setUnit(1);
		sushi.setTags(tags);
		sushi.setType(SushiType.SALAD);
		sushiService.save(sushi);
		
		tags = new ArrayList<>();
		tags.add(Tag.RAW);
		
		sushi.setId(9l);
		sushi.setName("salad");
		sushi.setIngredient("green salad with crab, tuna sashimi, tomatoes, cucumber, cooked shrimp, sesame.");
		sushi.setPrice(7.0);
		sushi.setUnit(1);
		sushi.setTags(tags);
		sushi.setType(SushiType.SALAD);
		sushiService.save(sushi);
		
		tags = new ArrayList<>();
		tags.add(Tag.RAW);
		
		sushi.setId(10l);
		sushi.setName("salmon");
		sushi.setIngredient("fresh salmon.");
		sushi.setPrice(4.5);
		sushi.setUnit(3);
		sushi.setTags(tags);
		sushi.setType(SushiType.SASHIMI);
		sushiService.save(sushi);
		
		tags = new ArrayList<>();
		tags.add(Tag.RAW);
		
		sushi.setId(11l);
		sushi.setName("suzuki");
		sushi.setIngredient("fresh sea bass.");
		sushi.setPrice(4.0);
		sushi.setUnit(3);
		sushi.setTags(tags);
		sushi.setType(SushiType.SASHIMI);
		sushiService.save(sushi);
		
		tags = new ArrayList<>();
		tags.add(Tag.RAW);
		
		sushi.setId(12l);
		sushi.setName("tuna");
		sushi.setIngredient("fresh tuna.");
		sushi.setPrice(4.0);
		sushi.setUnit(3);
		sushi.setTags(tags);
		sushi.setType(SushiType.SASHIMI);
		sushiService.save(sushi);

		tags = new ArrayList<>();
		tags.add(Tag.COOKED);
		
		sushi.setId(13l);
		sushi.setName("south beach");
		sushi.setIngredient("flamed salmon, mango, avocado, strawberries, almonds, tobikko, teriyaki sauce.");
		sushi.setPrice(12.0);
		sushi.setUnit(8);
		sushi.setTags(tags);
		sushi.setType(SushiType.MAKI);
		sushiService.save(sushi);
		
		tags = new ArrayList<>();
		tags.add(Tag.COOKED);
		
		sushi.setId(15l);
		sushi.setName("shibuya rolls");
		sushi.setIngredient("fried shrimp in tempura, philadelphia, salmon, avocado.");
		sushi.setPrice(12.0);
		sushi.setUnit(8);
		sushi.setTags(tags);
		sushi.setType(SushiType.MAKI);
		sushiService.save(sushi);
		
		tags = new ArrayList<>();
		tags.add(Tag.COOKED);
		
		sushi.setId(14l);
		sushi.setName("roppong hills");
		sushi.setIngredient("fried shrimp in tempura, omelette, truffle oil, lettuce, zushi sauce.");
		sushi.setPrice(12.0);
		sushi.setUnit(8);
		sushi.setTags(tags);
		sushi.setType(SushiType.MAKI);
		sushiService.save(sushi);
		
		
		tags = new ArrayList<>();
		tags.add(Tag.RAW);
		
		sushi.setId(16l);
		sushi.setName("maguro temaki");
		sushi.setIngredient("tuna, avocado.");
		sushi.setPrice(4.0);
		sushi.setUnit(1);
		sushi.setTags(tags);
		sushi.setType(SushiType.MAKI);
		sushiService.save(sushi);
		
		tags = new ArrayList<>();
		tags.add(Tag.RAW);
		
		sushi.setId(17l);
		sushi.setName("safado temaki");
		sushi.setIngredient("salmon tartare, lettuce, chives, mayo, almonds.");
		sushi.setPrice(6.0);
		sushi.setUnit(1);
		sushi.setTags(tags);
		sushi.setType(SushiType.MAKI);
		sushiService.save(sushi);
		
		tags = new ArrayList<>();
		tags.add(Tag.SPICY);
		
		sushi.setId(18l);
		sushi.setName("chicken ramen");
		sushi.setIngredient("ramen in broth, grilled chicken, quail egg, curry, spices.");
		sushi.setPrice(8.0);
		sushi.setUnit(1);
		sushi.setTags(tags);
		sushi.setType(SushiType.RAMEN);
		sushiService.save(sushi);
		
		tags = new ArrayList<>();
		tags.add(Tag.SPICY);
		tags.add(Tag.COOKED);
		
		sushi.setId(19l);
		sushi.setName("udon soup");
		sushi.setIngredient("soup with noodles, prawns, crab, shitake mushrooms, vegetables, japanese crabstick.");
		sushi.setPrice(8.0);
		sushi.setUnit(1);
		sushi.setTags(tags);
		sushi.setType(SushiType.UDON);
		sushiService.save(sushi);
		
		tags = new ArrayList<>();
		tags.add(Tag.COOKED);
		
		sushi.setId(20l);
		sushi.setName("yakiudon fish");
		sushi.setIngredient("noodles with shrimp, zucchini and crab meat.");
		sushi.setPrice(8.0);
		sushi.setUnit(1);
		sushi.setTags(tags);
		sushi.setType(SushiType.UDON);
		sushiService.save(sushi);
		
		tags = new ArrayList<>();
		tags.add(Tag.VEGETABLE);
		
		sushi.setId(21l);
		sushi.setName("mango salad");
		sushi.setIngredient("fresh mango, lime, mint.");
		sushi.setPrice(5.0);
		sushi.setUnit(1);
		sushi.setTags(tags);
		sushi.setType(SushiType.DESSERT);
		sushiService.save(sushi);
		
		tags = new ArrayList<>();
		tags.add(Tag.VEGETABLE);
		
		sushi.setId(22l);
		sushi.setName("tiramisù");
		sushi.setIngredient("tiramisù with green tea and chocolate.");
		sushi.setPrice(5.0);
		sushi.setUnit(1);
		sushi.setTags(tags);
		sushi.setType(SushiType.DESSERT);
		sushiService.save(sushi);
	}
	
	@GetMapping(path="/{sushiId}")
	public Optional<Sushi> getSushi(@PathVariable Long sushiId) {
		return sushiService.findById(sushiId);
	}
	
	@DeleteMapping(path="/{sushiId}")
	public void deleteSushi(@PathVariable Long sushiId) {
		log.info("Delete sushi with sushi id {}.", sushiId);
		sushiService.deleteById(sushiId);
	}
	
}
