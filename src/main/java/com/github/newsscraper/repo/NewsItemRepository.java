package com.github.newsscraper.repo;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.github.newsscraper.entities.NewsItemEntity;

@Transactional
public interface NewsItemRepository  extends JpaRepository<NewsItemEntity, String>{
	List<NewsItemEntity> findByAuthor(String author);
	
	@Query("SELECT DISTINCT n.author FROM NewsItemEntity n")
	List<String> findDistinctAuthor();
	
}
