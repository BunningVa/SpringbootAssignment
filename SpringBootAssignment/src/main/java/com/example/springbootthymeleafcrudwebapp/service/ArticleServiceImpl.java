package com.example.springbootthymeleafcrudwebapp.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.springbootthymeleafcrudwebapp.model.Article;
import com.example.springbootthymeleafcrudwebapp.repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	@Override
	public List<Article> getAllArticle() {
		return articleRepository.findAll();
	}
	@Override
	public void saveArticle(Article employee) {
		this.articleRepository.save(employee);
		
	}
	@Override
	public Article getArticleById(long id) {
		Optional<Article> optional = articleRepository.findById(id);
		Article article = null;
		if(optional.isPresent()) {
			article = optional.get();
		}else {
			throw new RuntimeException("Employee not found for id::" + id);
		}
		return article;
	}
	@Override
	public List<Article> getArticleInfoByLastName(boolean isDeleted) {
		return articleRepository.getArticleInfoByLastName(isDeleted);
	}
	@Override
	public List<Article> getArticleInfoIsDeleted() {
		return articleRepository.getArticleInfoIsDeleted();
	}
	@Override
	public Page<Article> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return this.articleRepository.findPaginated(pageable);
	}

	
}
