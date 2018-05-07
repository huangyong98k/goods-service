package com.nsu.huangyong.web;

import com.nsu.huangyong.pojo.Goods;
import com.nsu.huangyong.service.GoodsService;
import com.nsu.huangyong.vo.CommonResp;
import com.nsu.huangyong.vo.GoodsInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/goods")
@Api(value = "API-base-service",description = "商品服务")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value ="商品入库" )
    @PostMapping("/add")
    public CommonResp add(@RequestBody GoodsInfo goodsInfo){
        return goodsService.addGoods(goodsInfo);
    }
    @ApiOperation(value ="商品上架" )
    @GetMapping("/shangjia")
    public CommonResp shangjia(@RequestParam("goodsNo") String goodsNo){
        return goodsService.shangjia(goodsNo);
    }
    @ApiOperation(value ="商品下架" )
    @GetMapping("/xiajia")
    public CommonResp xiajia(@RequestParam("goodsNo") String goodsNo){
        return goodsService.xiajia(goodsNo);
    }
    @ApiOperation(value ="添加商品至收藏夹" )
    @GetMapping("/toCollector")
    public CommonResp toCollector(@RequestParam("memberNo") String memberNo,
                                  @RequestParam("goodsNo") String goodsNo){
        return goodsService.toCollector(memberNo,goodsNo);
    }
    @ApiOperation(value ="添加商品至购物车" )
    @GetMapping("/toTrolley")
    public CommonResp toTrolley(@RequestParam("memberNo") String memberNo,
                                @RequestParam("goodsNo") String goodsNo){
        return goodsService.toTrolley(memberNo,goodsNo);
    }
    @ApiOperation(value ="查看商品信息" )
    @GetMapping("/findGoods")
    public Goods findGoods(@RequestParam("goodsNo") String goodsNo){
        return goodsService.findGoods(goodsNo);
    }
    @ApiOperation(value ="查看所属商家商品信息" )
    @GetMapping("/findGoodsList")
    public List<Goods> findGoodsList(@RequestParam("sellerNo") String sellerNo){
        return goodsService.findGoodsList(sellerNo);
    }

}
