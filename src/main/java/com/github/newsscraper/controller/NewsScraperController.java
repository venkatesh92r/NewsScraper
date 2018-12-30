package com.github.newsscraper.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.newsscraper.NewsScraperApplication;
import com.github.newsscraper.dto.NewsItem;
import com.github.newsscraper.entities.NewsItemEntity;
import com.github.newsscraper.repo.NewsItemRepository;
import com.github.newsscraper.service.NewsScraperService;
import com.github.newsscraper.service.WebScraper;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
public class NewsScraperController {
	
	@Autowired
	NewsScraperService newsScraperService;
	
	@RequestMapping(value="/scrapeArticles", method=RequestMethod.GET)
	public String testController() throws IOException{

		newsScraperService.scrapeArticles();
		return "Data loaded successfully";
	}
	
	@RequestMapping(value="/authors/{author}/articles", method=RequestMethod.GET)
	public List<NewsItem> getNewsByAuthor(@PathVariable("author") String author){
		return newsScraperService.getNewsByAuthor(author);
	}

	@RequestMapping(value="/authors", method=RequestMethod.GET)
	public List<String> getAuthors(){
		return newsScraperService.getAuthors();
	}
	
	@RequestMapping(value="/articles", method=RequestMethod.GET)
	public List<NewsItem> getArticles(@RequestParam("title") String title,
			@RequestParam("description") String description ){
		return Collections.emptyList();
	}
}
