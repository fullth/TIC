package com.tic.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tic.app.service.PropReadService;

@Controller
public class MapController {
	
	@Autowired
	PropReadService propReadService;
	
	@GetMapping(value="testMapView")
	public String testMapView(Model model) throws IOException {
		
		@SuppressWarnings("rawtypes")
		List getPropArr = propReadService.readProp();
		String apiKey = (String) getPropArr.get(3);
		
		System.out.println(apiKey);
		
		model.addAttribute("apiKey", apiKey);
		
		return "testMapView";
	}
}
