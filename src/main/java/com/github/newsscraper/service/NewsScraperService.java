package com.github.newsscraper.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.newsscraper.NewsScraperApplication;
import com.github.newsscraper.dto.NewsItem;
import com.github.newsscraper.entities.NewsItemEntity;
import com.github.newsscraper.repo.NewsItemRepository;

@Service
public class NewsScraperService {
	@Autowired
	NewsItemRepository newsItemRepo;
	
	@Autowired
	WebScraper webScraper;
	
	public void scrapeArticles() throws IOException{
		Set<NewsItem> newsItemSet;
		newsItemSet = webScraper.getHrefs(NewsScraperApplication.url).stream().filter(e->null!=e && e.endsWith(".ece"))
						.map(e-> webScraper.getNewsItem(e)).collect(Collectors.toSet());
		newsItemSet.stream().forEach(System.out::println);
		List<NewsItemEntity> entityList = new ArrayList<>();
		for(NewsItem newsItem:newsItemSet){
			if(null == newsItem)
				continue;
			NewsItemEntity newsEntity = new NewsItemEntity();
			newsEntity.setUrl(newsItem.getUrl());
			newsEntity.setTitle(newsItem.getTitle());
			newsEntity.setDescription(newsItem.getDescription());
			newsEntity.setAuthor(newsItem.getAuthor());
			entityList.add(newsEntity);
		}
		if(!entityList.isEmpty()){
			newsItemRepo.saveAll(entityList);
		}
	}

	private Set<String> getLinksToLoad(String rootUrl, String date) {
		// TODO Auto-generated method stub
		Set<String> outputSet = new TreeSet<>();	
		outputSet.add(rootUrl + date); 
		return null;
	}

	private List<NewsItem> mapEntityToDto(List<NewsItemEntity> entityList) {
		// TODO Auto-generated method stub
		List<NewsItem> outList = new ArrayList<>();
		for(NewsItemEntity entity:entityList){
			NewsItem newsItem = new NewsItem();
			newsItem.setAuthor(entity.getAuthor());
			newsItem.setUrl(entity.getUrl());
			newsItem.setTitle(entity.getTitle());
			newsItem.setDescription(entity.getDescription());
			outList.add(newsItem);
		}	
		return outList;
	}
	
	public List<String> getAuthors(){
		return newsItemRepo.findDistinctAuthor();
	}
	
	public List<NewsItem> getNewsByAuthor(String author){
		return mapEntityToDto(newsItemRepo.findByAuthor(author));
	}
	
}
