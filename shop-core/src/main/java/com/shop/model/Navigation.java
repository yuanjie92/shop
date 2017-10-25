package com.shop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by yuanjie on 2017/10/24.
 */
@Getter
@Setter
public class Navigation {
    private Integer id;
    private Date createDate;
    private Date modifyDate;
    private Integer version;
    // 排序
    private Integer orders;
    // 是打开新窗体
    private Boolean isBlankTarget;
    // 导航菜单的名称
    private String name;
    // 0=顶部 1= 中间 2=底部
    private Integer position;
    // 点击后跳转的地址
    private String url;

}
