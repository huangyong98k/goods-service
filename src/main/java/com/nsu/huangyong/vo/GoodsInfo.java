package com.nsu.huangyong.vo;

import lombok.Data;


/**
 * Created by Huang Yong on 2018-05-07
 **/
@Data
public class GoodsInfo {
    private String sellerNo;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 标题
     */
    private String title;
    /**
     * 价格
     */
    private String goodsPrice;
    /**
     * 品牌
     */
    private String brand;
    /**
     * 包装
     */
    private String pack;
    /**
     * 原产地
     */
    private String productCity;
    /**
     * 类别
     */
    private String category;
    /**
     * 果实直径
     */
    private String diameter;
    /**
     * 介绍图片地址
     */
    private String introduce;
    /**
     * 图片1
     */
    private String pic1Url;
    private String pic2Url;
    private String pic3Url;
    private String pic4Url;
    private String pic5Url;
}
