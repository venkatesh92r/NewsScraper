package com.github.newsscraper.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.github.newsscraper.NewsScraperApplication;
import com.github.newsscraper.dto.NewsItem;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class WebScraper {
	
	public NewsItem getNewsItem(String url) {

		Document document;
		try {
			document = Jsoup.connect(url).get();
			System.out.println("connecting url: " + url);

			Elements metaTags = document.getElementsByTag("meta");
			NewsItem newsItem = new NewsItem();
			newsItem.setUrl(url);
			for (Element metaTag : metaTags) {

				String switcher = metaTag.attr("name") != "" ? metaTag.attr("name") : metaTag.attr("property");
				switch (switcher) {
				case "article:author": {
					newsItem.setAuthor(metaTag.attr("content"));
					break;
				}
				case "title": {
					newsItem.setTitle(metaTag.attr("content"));
					break;
				}
				case "description": {
					newsItem.setDescription(metaTag.attr("content"));
					break;
				}
				}

			}
			return newsItem;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public Set<String> getHrefs(String url) throws IOException {
		Set<String> links = new HashSet<>();
		Document document = Jsoup.connect(url).get();

		Elements linksOnPage = document.select("a[href]");
		for (Element link : linksOnPage) {
			links.add(link.attr("abs:href"));
		}

		return links;
	}

}