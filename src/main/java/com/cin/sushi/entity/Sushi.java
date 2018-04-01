package com.cin.sushi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.cin.sushi.enums.SushiType;
import com.cin.sushi.enums.Tag;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="sushi")
public class Sushi {
	@Id
	private Long id;
	
	@Column
	private String name;
	
	@Column
	@Enumerated(EnumType.STRING)
	private SushiType type;
	
	@Column(name="tags")
	@Type(type="com.cin.sushi.hibernate.TagType")
	@Enumerated(EnumType.STRING)
	private List<Tag> tags;
	
	@Column
	private String ingredient;
	
	@Column
	private double price;
	
	@Column
	private int unit;
}
