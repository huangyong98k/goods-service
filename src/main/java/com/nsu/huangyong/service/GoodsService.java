package com.nsu.huangyong.service;

import com.nsu.huangyong.pojo.Goods;
import com.nsu.huangyong.vo.CommonResp;
import com.nsu.huangyong.vo.GoodsInfo;

import java.util.List;

/**
 * 基础商品服务
 */
public interface GoodsService {
    /**
     * 商品入库
     */
    CommonResp addGoods(GoodsInfo goodsInfo);
    /**
     * 商品上架
     */
    CommonResp shangjia(String goodsNo);
    /**
     * 商品上架
     */
    CommonResp xiajia(String goodsNo);
    /**
     * 添加商品至收藏夹
     */
    CommonResp toCollector(String memberNo , String goodsNo);
    /**
     * 添加商品至购物车
     */
    CommonResp toTrolley(String memberNo , String goodsNo);

    Goods findGoods(String goodsNo);

    List<Goods> findGoodsList(String sellerNo);
}
