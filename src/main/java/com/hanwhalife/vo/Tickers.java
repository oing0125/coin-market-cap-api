package com.hanwhalife.vo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Tickers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String base;
    private String target;
    private String market;
    private Timestamp last_traded_at;
    private float last_usd;
    private String volume;
    private float spread_per;
    private String ori_text;

    protected Tickers(){}

    public Tickers(String base, String target, String market){
        this.base = base;
        this.target = target;
        this.market = market;
    }
}
