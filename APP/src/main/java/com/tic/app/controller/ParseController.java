package com.tic.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tic.app.service.NewsAPIService;

@Controller
public class ParseController {

	@Autowired
	NewsAPIService newsAPIService;
	
	@RequestMapping(value="/getNews")
	@SuppressWarnings("unchecked")
	public String newsCrawling(@RequestParam(value="topic")String topic, Model model) throws IOException {
		
		Map<String, Object> resultMap = newsAPIService.getNews(topic);
		
		// KEY: title, link
//		Iterator<String> keys = resultMap.keySet().iterator();
//        while (keys.hasNext()){
//            String key = keys.next();
//            System.out.println("KEY : " + key);
//        }
		
		List<Object> titleList = new ArrayList<Object>();
		List<Object> linkList = new ArrayList<Object>();
		
		titleList.add(resultMap.get("title"));
		String getTitle = titleList.toString();
		String splitTitle[] = getTitle.split(", ");
		for(int i = 0; i < splitTitle.length; i++) {
			titleList.add(splitTitle[i]);
		}
		
		linkList.add(resultMap.get("link"));
		String getLink = linkList.toString();
		String splitLink[] = getLink.split(", ");
		for(int i = 0; i < splitLink.length; i++) {
			linkList.add(splitLink[i]);
		}
		
		System.out.println("linkList size ::: " +linkList.size());
		System.out.println("titleList size ::: " +titleList.size());
		
		if(linkList.size() == titleList.size()) {
			System.out.println("PARSE SUCSESS !!!");
		}
		
		model.addAttribute("title", titleList);
		model.addAttribute("link", linkList);
		
		return "news";
	}
}
