package com.nsu.huangyong.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Huang Yong on 2018-05-07
 **/
@Data
@Entity
@NoArgsConstructor
public class Collector {
    /**
     * id
     */
    @Id
    @GeneratedValue
    private Long id;
    private Integer status;
    private String createTime;
    private String updateTime;
    private String goodsNo;
    private String memberNo;

    public Collector(Integer status, String createTime, String updateTime, String goodsNo, String memberNo) {
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.goodsNo = goodsNo;
        this.memberNo = memberNo;
    }
}
