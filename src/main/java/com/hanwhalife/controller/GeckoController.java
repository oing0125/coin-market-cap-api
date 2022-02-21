package com.hanwhalife.controller;

import com.hanwhalife.service.CryptoService;
import com.hanwhalife.service.GeckoService;
import com.hanwhalife.vo.CryptoSearchParamVo;
import com.hanwhalife.vo.GeckoChartParamVo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class GeckoController {

    @Autowired
    GeckoService geckoService;

    @GetMapping("/gecko/coins/{id}/market-chart")
    public ResponseEntity marketChart(@PathVariable("id") String id, GeckoChartParamVo paramVo){
        JSONObject result = geckoService.marketChart(id, paramVo);
        return ResponseEntity.status(HttpStatus.OK).body(result.toString());
    }

    @GetMapping("/gecko/coins/{id}")
    public ResponseEntity coinInfo(@PathVariable("id") String id){
        JSONObject result = geckoService.getCoinInfo(id);
        return ResponseEntity.status(HttpStatus.OK).body(result.toString());
    }

    @GetMapping("/gecko/coins")
    public ResponseEntity list(){
        JSONObject result = geckoService.getCoinList();
        return ResponseEntity.status(HttpStatus.OK).body(result.toString());
    }

}
