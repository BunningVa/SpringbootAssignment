package com.example.springbootthymeleafcrudwebapp.service;

import java.util.List;

import org.springframework.data.domain.Page;


import com.example.springbootthymeleafcrudwebapp.model.Article;

public interface ArticleService {
	List<Article> getAllArticle();
	void saveArticle(Article article);
	Article getArticleById(long id);
	List<Article> getArticleInfoByLastName(boolean isDeleted);
	List<Article> getArticleInfoIsDeleted();
	Page<Article> findPaginated(int pageNo, int pageSize);

}
