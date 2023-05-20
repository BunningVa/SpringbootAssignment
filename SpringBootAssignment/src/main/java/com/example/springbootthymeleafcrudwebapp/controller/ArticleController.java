package com.example.springbootthymeleafcrudwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.springbootthymeleafcrudwebapp.model.Article;
import com.example.springbootthymeleafcrudwebapp.service.ArticleService;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, model);
	}
	@GetMapping("/add")
	public String addArticle(Model model) {
		Article article = new Article();
		model.addAttribute("article", article);
		return "new_article"; 
	}
	
	@PostMapping("/saveArticle")
	public String saveArticle(@ModelAttribute("article") Article article) {
		articleService.saveArticle(article);
		return "redirect:/";
	}
	@GetMapping("/update/{id}")
	public String updateArticle(@PathVariable("id") long id, Model model) {
		Article article = articleService.getArticleById(id);
		model.addAttribute("article", article);
		return "update_article";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteArticle(@PathVariable("id") long id, Model model) {
		Article article = articleService.getArticleById(id);
		model.addAttribute("article", article);
		return "delete_article";
	}
	
	@GetMapping("/view/{id}")
	public String viewArticle(@PathVariable("id") long id, Model model) {
		Article article = articleService.getArticleById(id);
		model.addAttribute("article", article);
		return "view_article";
	}
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, Model model) {
		int pageSize = 5;
		Page<Article> page = articleService.findPaginated(pageNo, pageSize);
		List<Article> listArticles = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listArticles",listArticles);
		return "index";
	}
	
}
