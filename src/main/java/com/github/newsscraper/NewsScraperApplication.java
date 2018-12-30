package com.github.newsscraper;

import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.newsscraper.dto.NewsItem;
import com.github.newsscraper.entities.NewsItemEntity;
import com.github.newsscraper.repo.NewsItemRepository;
import com.github.newsscraper.service.WebScraper;

/**
*Start-up class of the spring boot application
*@author venkatesh92r
*/
@SpringBootApplication
public class NewsScraperApplication {
	public static final String url = "https://www.thehindu.com/archive/web/2010/10/03/";
	public static void main(String[] args) {
		SpringApplication.run(NewsScraperApplication.class, args);
	}
}

