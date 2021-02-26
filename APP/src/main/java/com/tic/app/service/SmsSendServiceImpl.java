package com.tic.app.service;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tic.app.mapper.RsvMapper;
import com.tic.app.model.RsvVO;
import com.tic.app.util.APIInit;

import model.response.GroupModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//윈도우(이클립스) <-> 맥(STS) 번갈아 커밋을 하니, 자주 의존성 문제가 발생...

@Service
public class SmsSendServiceImpl implements SmsSendService {
	
	@Autowired
	RsvMapper rsvMapper;
	
	@Override
	public void insertNumber(RsvVO rsvVO) throws Exception {
		rsvMapper.insertNumber(rsvVO);
	}
	
	public void sendSMS(String propTo, String propFrom, String propText) {
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String todayDate = simpleDateFormat.format(date);
		String reservedTime = "222500";
		
        JsonObject params = new JsonObject();
        JsonArray messages = new JsonArray();

        JsonObject msg = new JsonObject();
        msg.addProperty("to", propTo); 
        msg.addProperty("from", propFrom); 
        msg.addProperty("text", propText);
        //msg.addProperty("datetime", todayDate + reservedTime); 
        messages.add(msg);

        params.add("messages", messages);

        Call<GroupModel> api = APIInit.getAPI().sendMessages(APIInit.getHeaders(), params);
        api.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<GroupModel> call, Response<GroupModel> response) {
                if (response.isSuccessful()) {
                    System.out.println("statusCode : " + response.code());
                    GroupModel body = response.body();
                    System.out.println("groupId : " + body.getGroupId());
                    System.out.println("status: " + body.getStatus());
                    System.out.println("count: " + body.getCount().toString());
                } else {
                    try {
                        System.out.println(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<GroupModel> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
	}
}
