package com.hanwhalife.utils;

import com.hanwhalife.vo.ResponseVo;
import okhttp3.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Map;

@Component
public class HttpUtil {

    @Value("${coinMarketCap.endpoint}")
    private String endpoint;

    @Value("${coinMarketCap.apiKey")
    private String CMC_API_KEY;

    public JSONObject doGet(String path, Map<String, String> params){
        HttpUrl.Builder httpBuilder = HttpUrl.get(endpoint + path).newBuilder();
        if(!CollectionUtils.isEmpty(params)){
            params.keySet()
                    .stream()
                    .forEach(item -> httpBuilder.addQueryParameter(item, params.get(item)));
        }
        Request request = generateRequest(httpBuilder.build());
        return executeCall(request);
    }

    private Request generateRequest(HttpUrl url){
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .addHeader("X-CMC_PRO_API_KEY", CMC_API_KEY)
                .addHeader("Accept", "application/json")
                .build();
        return request;
    }

    private JSONObject executeCall(Request request){
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        JSONObject resultJson = null;
        try {
            Response response = call.execute();
            resultJson = new JSONObject(response.body().string());
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return resultJson;
    }
}
