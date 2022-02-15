package com.hanwhalife.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

@Getter
@Setter
@JsonSerialize
public class ResponseVo {
    String txt;
    @JsonSerialize
    JSONObject result;
}
