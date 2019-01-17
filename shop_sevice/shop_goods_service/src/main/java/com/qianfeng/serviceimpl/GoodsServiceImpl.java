package com.qianfeng.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qianfeng.dao.IGoodsDao;
import com.qianfeng.entity.Goods;
import com.qianfeng.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @version 1.0
 * @Author 落花飘香
 * @Date 2019/1/16
 */
@Service
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private IGoodsDao goodsDao;

    @Override
    public List<Goods> queryAll() {
        return goodsDao.selectList(null);
    }

    @Override
    public Goods insert(Goods goods) {
        goodsDao.insert(goods);
        return goods;
    }
}
