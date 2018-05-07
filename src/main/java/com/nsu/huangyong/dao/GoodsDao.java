package com.nsu.huangyong.dao;

import com.nsu.huangyong.pojo.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GoodsDao extends JpaRepository<Goods,Long>, JpaSpecificationExecutor<Goods> {
    /**
     * 根据状态获取商品
     */
    List<Goods> findAllByStatus(int status);

    Goods findGoodsByGoodsNo(String goodsNo);

    List<Goods> findAllBySellerNo(String sellerNo);

    @Override
    Page<Goods> findAll(Specification<Goods> specification, Pageable pageable);

    @Override
    List<Goods> findAll(Specification<Goods> specification);

    @Modifying
    @Query(value = "update goods set status= ?2 where goods_no = ?1",nativeQuery = true)
    void updateStatus(String goodsNo, Integer status);

}
