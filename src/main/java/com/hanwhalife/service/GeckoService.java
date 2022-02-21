package com.hanwhalife.service;

import com.hanwhalife.utils.HttpUtil;
import com.hanwhalife.vo.CryptoSearchParamVo;
import com.hanwhalife.vo.GeckoChartParamVo;
import com.hanwhalife.vo.ResponseVo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GeckoService {

    @Autowired
    HttpUtil httpUtil;

    @Value("${coinGecko.endpoint}")
    private String coinGeckoEndpoint;

    private static final String TICKER_PATH = "/v3/coins/{id}/market_chart";
    private static final String COIN_LIST_PATH = "/v3/coins";
    private static final String COIN_INFO_PATH = "/v3/coins/{id}";

    public JSONObject marketChart(String id, GeckoChartParamVo paramVo){
        Map<String, String> params = new HashMap<String, String>();
        params.put("interval", paramVo.getInterval());
        params.put("vs_currency", paramVo.getVsCurrency());
        params.put("days", paramVo.getDays());
        return httpUtil.doGet(coinGeckoEndpoint, TICKER_PATH.replace("{id}", id), params);
    }

    public JSONObject getCoinInfo(String id){
        return httpUtil.doGet(coinGeckoEndpoint, COIN_INFO_PATH.replace("{id}", id), null);
    }

    public JSONObject getCoinList(){
        return httpUtil.doGet(coinGeckoEndpoint, COIN_LIST_PATH, null);
    }

}
