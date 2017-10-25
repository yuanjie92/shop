package com.shop.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by yuanjie on 2017/10/23.
 */
@Getter
@Setter
public class User {
    private Integer userId;
    private String uName;
    private String pwd;
    private String nation;
    private String location;
    private Integer gender;
}
