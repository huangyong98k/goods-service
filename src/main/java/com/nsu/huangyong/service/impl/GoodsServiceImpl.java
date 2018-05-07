package com.nsu.huangyong.service.impl;

import com.nsu.huangyong.common.constant.CommonRespCode;
import com.nsu.huangyong.common.utils.NFruitsUtils;
import com.nsu.huangyong.dao.CollectorDao;
import com.nsu.huangyong.dao.GoodsDao;
import com.nsu.huangyong.dao.TrolleyDao;
import com.nsu.huangyong.pojo.Collector;
import com.nsu.huangyong.pojo.Goods;
import com.nsu.huangyong.pojo.Trolley;
import com.nsu.huangyong.service.GoodsService;
import com.nsu.huangyong.vo.CommonResp;
import com.nsu.huangyong.vo.GoodsInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品服务实现类
 * @author huangyong.nsu@qq.com
 */
@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private CollectorDao collectorDao;
    @Autowired
    private TrolleyDao trolleyDao;

    @Override
    public CommonResp addGoods(GoodsInfo goodsInfo) {
        try {
            goodsDao.save(transferToGoods(goodsInfo));
        } catch (Exception e) {
            log.error("error msg:{}  class:{}",e.getMessage(),e.getClass());
            return new CommonResp(CommonRespCode.FAIL,"服务异常");
        }
        return new CommonResp(CommonRespCode.SUCCESS);
    }

    @Override
    @Transactional
    public CommonResp shangjia(String goodsNo) {
        try {
            goodsDao.updateStatus(goodsNo,1);
        } catch (Exception e) {
            log.error("error msg:{}  class:{}",e.getMessage(),e.getClass());
            return new CommonResp(CommonRespCode.FAIL,"服务异常");
        }
        return new CommonResp(CommonRespCode.SUCCESS);
    }

    @Override
    @Transactional
    public CommonResp xiajia(String goodsNo) {
        try {
            goodsDao.updateStatus(goodsNo,2);
        } catch (Exception e) {
            log.error("error msg:{}  class:{}",e.getMessage(),e.getClass());
            return new CommonResp(CommonRespCode.FAIL,"服务异常");
        }
        return new CommonResp(CommonRespCode.SUCCESS);
    }

    @Override
    public CommonResp toCollector(String memberNo, String goodsNo) {
        collectorDao.save(new Collector(0,NFruitsUtils.getCurrentTime(),NFruitsUtils.getCurrentTime(),goodsNo,memberNo));
        return new CommonResp(CommonRespCode.SUCCESS);
    }

    @Override
    public CommonResp toTrolley(String memberNo, String goodsNo) {
        trolleyDao.save(new Trolley(0,NFruitsUtils.getCurrentTime(),goodsNo,memberNo));
        return new CommonResp(CommonRespCode.SUCCESS);
    }

    @Override
    public Goods findGoods(String goodsNo) {
        return goodsDao.findGoodsByGoodsNo(goodsNo);
    }

    @Override
    public List<Goods> findGoodsList(String sellerNo) {
        return goodsDao.findAllBySellerNo(sellerNo);
    }

    static Goods transferToGoods(GoodsInfo goodsInfo){
        Goods goods = new Goods();
        goods.setGoodsNo("GOO"+ NFruitsUtils.identifier());
        goods.setGoodsName(goodsInfo.getGoodsName());
        goods.setSellerNo(goodsInfo.getSellerNo());
        goods.setTitle(goodsInfo.getTitle());
        goods.setGoodsPrice(goodsInfo.getGoodsPrice());
        goods.setBrand(goodsInfo.getBrand());
        goods.setPack(goodsInfo.getPack());
        goods.setProductCity(goodsInfo.getProductCity());
        goods.setCategory(goodsInfo.getCategory());
        goods.setDiameter(goodsInfo.getDiameter());
        goods.setIntroduce(goodsInfo.getIntroduce());
        goods.setStatus(0);
        goods.setCreateTime(NFruitsUtils.getCurrentTime());
        goods.setUpdateTime(goods.getCreateTime());
        goods.setPic1Url(goodsInfo.getPic1Url());
        goods.setPic2Url(goodsInfo.getPic2Url());
        goods.setPic3Url(goodsInfo.getPic3Url());
        goods.setPic4Url(goodsInfo.getPic4Url());
        goods.setPic5Url(goodsInfo.getPic5Url());
        return goods;
    }

}
