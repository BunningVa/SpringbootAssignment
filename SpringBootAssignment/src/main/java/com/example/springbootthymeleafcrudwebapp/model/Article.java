package com.example.springbootthymeleafcrudwebapp.model;



import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "articles")
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "title")
	private String title;
	
	
	@Column(name = "content", columnDefinition = "TEXT")
	private String content;
	
	
	@Column(name = "isDeleted", columnDefinition = "boolean default false")
	private boolean isDeleted = false;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	public boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
