package com.hanwhalife.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CryptoSearchParamVo {
    int size = 10;
    int currentPage = 1;

    public int getStart(){
        return size * (currentPage - 1) + 1;
    }
}
