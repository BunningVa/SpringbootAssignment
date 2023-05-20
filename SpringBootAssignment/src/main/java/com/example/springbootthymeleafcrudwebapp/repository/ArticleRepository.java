package com.example.springbootthymeleafcrudwebapp.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springbootthymeleafcrudwebapp.model.Article;




@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{
@Query(value="SELECT *FROM articles WHERE is_deleted=?1", nativeQuery =true )
List<Article> getArticleInfoByLastName(boolean isDeleted);
@Query(value="SELECT *FROM articles WHERE is_deleted=false ORDER BY id ASC" , nativeQuery =true )
List<Article> getArticleInfoIsDeleted();

@Query(value = "SELECT * FROM articles  WHERE is_deleted=false ORDER BY id ASC", nativeQuery = true)
Page<Article> findPaginated(Pageable pageable);


}
