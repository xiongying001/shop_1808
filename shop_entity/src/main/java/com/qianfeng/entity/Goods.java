package com.qianfeng.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @version 1.0
 * @Author 落花飘香
 * @Date 2019/1/16
 */
@Data
public class Goods implements Serializable {

    @TableId(type= IdType.AUTO)
    private int id;
    private String title;
    private String ginfo;
    private int gcount;
    private int tid;//分类表的外键
    private double allprice;
    private double price;
    private String gimage;
}
