package com.tic.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		
		List<?> result = newsAPIService.getNews(topic);
		List<Object> resultList = new ArrayList<Object>();
		
		for(Object i : result) {
			// 받아온 JSON데이터의 Description 한글 깨짐. -> 프로젝트의 인코딩 설정문제.
			System.out.println(i);
			resultList.add(i);
		}
		model.addAttribute("result", resultList);
		
		return "home";
		// TODO main.jsp에 출력 및 링크 제목으로 기사 본문 요약 가져오기.
	}
}
