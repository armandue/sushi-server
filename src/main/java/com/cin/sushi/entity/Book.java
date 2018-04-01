package com.cin.sushi.entity;

import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.cin.sushi.entity.column.Dish;
import com.cin.sushi.enums.BookState;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="book_time")
	private ZonedDateTime bookTime;
	
	@Column
	private String name;
	
	@Column
	private String telephone;
	
	@Column
	private String address;
	
	@Column(name="deliver_time")
	private ZonedDateTime deliverTime;
	
	@Column
	@Enumerated(EnumType.STRING)
	private BookState state;
	
	@Column
	private String note;
	
	@Column(name="dish")
	@Type(type="com.cin.sushi.hibernate.DishType")
	private List<Dish> dishes;
}
