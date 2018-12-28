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

@SpringBootApplication
public class NewsScraperApplication {
	
	
	
	public static final String url = "https://www.thehindu.com/archive/web/2010/10/03/";

	public static void main(String[] args) {
		
		try {
			SpringApplication.run(NewsScraperApplication.class, args);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//new WebScraper().getPageLinks(url, 0);
		//SpringApplication.run(NewsScraperApplication.class, args);
	}

}

