package com.tic.app.service;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.springframework.stereotype.Service;

@Service
public class PropReadService {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List readProp() {
        
		String resource = "API.properties";
        Properties properties = new Properties();
        
        List propArr = new ArrayList();

        try {
            Reader reader = Resources.getResourceAsReader(resource);
            properties.load(reader);
            propArr.add(properties.getProperty("REQUEST_URL"));
            propArr.add(properties.getProperty("CLIENT_ID"));
            propArr.add(properties.getProperty("CLIENT_SECRET"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // ...? 커밋했는데 잔디가 안심어진다... 어렵다 깃...
		return propArr;
	}
}
