package com.qianfeng.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.qianfeng.entity.Goods;
import com.qianfeng.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @version 1.0
 * @Author 落花飘香
 * @Date 2019/1/16
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Value("${fdfs.ippath}")
    private String ippath;

    @Reference
    private IGoodsService goodsService;

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @RequestMapping("/list")
    public String getlist(Model model){
        List<Goods> goods = goodsService.queryAll();
        model.addAttribute("goods",goods);
        model.addAttribute("ippath",ippath);
        return "goodslist";
    }

    @RequestMapping("/insert")
    public String insert(Goods goods){
        Goods good = goodsService.insert(goods);
        System.out.println(good.getId());
        return "redirect:/goods/list";
    }

    @RequestMapping("/uploadimg")
    @ResponseBody
    public String uploadImg(MultipartFile file){
        StorePath path =null;
        try {
            path = fastFileStorageClient.uploadImageAndCrtThumbImage(
                    file.getInputStream(),
                    file.getSize(),
                    "PNG",
                    null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("图片的路径为："+ path.getFullPath());
        return "{\"imgpath\":\""+path.getFullPath()+"\"}";
    }

}
