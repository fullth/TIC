package com.tic.app.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

@Service
public class SmsSendServiceImpl implements SmsSendService {

	@Autowired
	RsvMapper rsvMapper;

	@Override
	public void insertNumber(RsvVO rsvVO) throws Exception {
		rsvMapper.insertNumber(rsvVO);
	}

	@Override
	public int selectCountNumber(RsvVO rsvVO) throws Exception {
		int count = rsvMapper.selectCountNumber(rsvVO);
		return count;
	}

	@Override
	public ArrayList<?> selectNumber(RsvVO rsvVo) throws Exception {
		rsvMapper.selectNumber(rsvVo);
		return null;
	}

	public void sendSMS(String propTo, RsvVO rsvVO) {
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String todayDate = simpleDateFormat.format(date);
		String reservedTime = "222500";

        JsonObject params = new JsonObject();
        JsonArray messages = new JsonArray();

        JsonObject msg = new JsonObject();
        msg.addProperty("to", propTo); 
        // TODO Modified to get from database.
        msg.addProperty("from", ""); 
        msg.addProperty("text", "Test send sms.");
        //msg.addProperty("datetime", todayDate + reservedTime); 
        messages.add(msg);

        params.add("messages", messages);

        Call<GroupModel> api = APIInit.getAPI().sendMessages(APIInit.getHeaders(), params);
        api.enqueue(new Callback<GroupModel>() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    System.out.println("statusCode : " + response.code());
                    GroupModel body = (GroupModel) response.body();
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
            public void onFailure(Call call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
	}
}
