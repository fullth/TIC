package com.tic.app.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsAPIService {

	@Autowired
	PropReadService propReadService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map getNews(String parse) {

		List getPropArr = propReadService.readProp();
				
		//JSONArray result = null;
		Map resultMap = new HashMap();
		List parseTitle = new ArrayList();
		List parseLink = new ArrayList();

		try {
			// TODO Http ResponseCode별 처리 추가.
			String text = URLEncoder.encode(parse, "UTF-8");
			String apiURL = getPropArr.get(0) + "?query=" + text;
			
			URL url = new URL(apiURL);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", (String) getPropArr.get(1));
			con.setRequestProperty("X-Naver-Client-Secret", (String) getPropArr.get(2));

			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}

			//JSONObject jsonObj = new JSONObject(response.toString());
			//JSONArray jsonArray = (JSONArray) jsonObj.get("items");

			//result = jsonArray;
			
			JSONObject jsonObj = new JSONObject(response.toString());
			JSONArray items = jsonObj.getJSONArray("items");
			
			for(int i = 0; i < items.length(); i++) {
				JSONObject parseObj = items.getJSONObject(i);
				
				String getLink = parseObj.getString("originallink");
				String getTitle = parseObj.getString("title");
				
				parseLink.add(getLink);
				parseTitle.add(getTitle);
			}
			
			resultMap.put("link", parseLink);
			resultMap.put("title", parseTitle);
			
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return resultMap;
	}
}