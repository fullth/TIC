package com.tic.app;

import java.io.IOException;

import org.json.JSONArray;
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
	public String newsCrawling(@RequestParam(value="topic")String topic, Model model) throws IOException {
		
		JSONArray result = newsAPIService.getNews(topic);
		
		for(Object i : result) {
			//XXX 받아온 JSON데이터의 Description 한글 깨짐. -> 프로젝트의 인코딩 설정문제.
			
			System.out.println(i);
		}
		model.addAttribute("result", result);
		
		return "home";
	}
	
}
