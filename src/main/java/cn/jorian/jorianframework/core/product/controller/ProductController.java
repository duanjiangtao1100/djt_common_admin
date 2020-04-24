package cn.jorian.jorianframework.core.product.controller;


import cn.jorian.jorianframework.common.response.ResponseCode;
import cn.jorian.jorianframework.common.response.SystemResponse;
import cn.jorian.jorianframework.core.product.entity.Product;
import cn.jorian.jorianframework.core.product.service.IProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Djt
 * @since 2020-04-23
 */
@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    IProductService iProductService;

    @ApiOperation("商品列表查询")
    @RequestMapping("/list")
    public SystemResponse productList() {
        return new SystemResponse(ResponseCode.SUCCESS, iProductService.getProductList());

    }
}

