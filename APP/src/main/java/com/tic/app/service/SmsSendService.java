package com.tic.app.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tic.app.util.APIInit;

import model.response.GroupModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Service
public class SmsSendService {
	
	public void sendSMS(String propTo, String propFrom, String propText) {
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String todayDate = simpleDateFormat.format(date);
		String reservedTime = "210000";
		
        JsonObject params = new JsonObject();
        JsonArray messages = new JsonArray();

        JsonObject msg = new JsonObject();
        msg.addProperty("to", propTo); // ���� ���� ,�� ���� ex.) 0101234578,01056781234
        msg.addProperty("from", propFrom); // ������ϵ� ��ȣ�� ���.
        msg.addProperty("text", propText);
        msg.addProperty("datetime", today + reservedTime); // ����ð�. �׽�Ʈ ����.
        messages.add(msg);

        params.add("messages", messages);

        Call<GroupModel> api = APIInit.getAPI().sendMessages(APIInit.getHeaders(), params);
        api.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<GroupModel> call, Response<GroupModel> response) {
            	// ���� �� 200�� ��µ˴ϴ�.
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
