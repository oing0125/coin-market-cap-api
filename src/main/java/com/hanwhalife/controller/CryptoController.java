package com.hanwhalife.controller;

import com.hanwhalife.service.CryptoService;
import com.hanwhalife.vo.CryptoSearchParamVo;
import com.hanwhalife.vo.ResponseVo;
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
public class CryptoController {

    @Autowired
    CryptoService cryptoService;

    @GetMapping("/test")
    public ResponseEntity info(HttpServletRequest req){
        JSONObject result = cryptoService.test().getResult();
        return ResponseEntity.status(HttpStatus.OK).body(result.toString());
//        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/crypto/latest")
    public ResponseEntity pageCrypto(CryptoSearchParamVo searchParamVo){
        JSONObject result = cryptoService.page(searchParamVo);
        return ResponseEntity.status(HttpStatus.OK).body(result.toString());
    }

    @GetMapping("/crypto/categories")
    public ResponseEntity pageCryptoCategories(CryptoSearchParamVo searchParamVo){
        JSONObject result = cryptoService.pageCategories(searchParamVo);
        return ResponseEntity.status(HttpStatus.OK).body(result.toString());
    }

    @GetMapping("/crypto/category/{id}")
    public ResponseEntity pageCryptoCategoryById(@PathVariable("id") String id){
        JSONObject result = cryptoService.getCategoryById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result.toString());
    }
}
