package com.hanwhalife.service;

import com.hanwhalife.utils.HttpUtil;
import com.hanwhalife.vo.CryptoSearchParamVo;
import com.hanwhalife.vo.ResponseVo;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CryptoService {

    @Autowired
    HttpUtil httpUtil;

    private static final String LIST_LATEST_PATH = "/cryptocurrency/listings/latest";
    private static final String LIST_CATEGORIES_PATH = "/cryptocurrency/categories";
    private static final String GET_CATEGORY_BY_ID_PATH = "/cryptocurrency/category";
    private static final String GET_CRYPTO_INFO_BY_ID_PATH = "/cryptocurrency/info";

    public ResponseVo test(){
        return new ResponseVo();
    }

    public JSONObject page(CryptoSearchParamVo searchParamVo){
        Map<String, String> params = new HashMap<String, String>();
        params.put("limit", searchParamVo.getSize() + "");
        params.put("start", searchParamVo.getStart() + "");
        return httpUtil.doGet(LIST_LATEST_PATH, params);
    }

    public JSONObject info(String id){
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        return httpUtil.doGet(GET_CRYPTO_INFO_BY_ID_PATH, params);
    }

    public JSONObject pageCategories(CryptoSearchParamVo searchParamVo){
        Map<String, String> params = new HashMap<String, String>();
        params.put("limit", searchParamVo.getSize() + "");
        params.put("start", searchParamVo.getStart() + "");
        return httpUtil.doGet(LIST_CATEGORIES_PATH, params);
    }

    public JSONObject getCategoryById(String id){
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        return httpUtil.doGet(GET_CATEGORY_BY_ID_PATH, params);
    }
}
