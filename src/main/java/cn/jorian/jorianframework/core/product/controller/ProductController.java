package cn.jorian.jorianframework.core.product.controller;


import cn.jorian.jorianframework.common.annotation.Log;
import cn.jorian.jorianframework.common.response.ResponseCode;
import cn.jorian.jorianframework.common.response.SystemResponse;
import cn.jorian.jorianframework.core.product.dto.ProductAddDTO;
import cn.jorian.jorianframework.core.product.dto.ProductDTO;
import cn.jorian.jorianframework.core.product.service.IProductService;
import cn.jorian.jorianframework.core.system.entity.SysRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Djt
 * @since 2020-04-23
 */
@Api(tags = "商品管理")
@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    IProductService iProductService;

    @ApiOperation("商品列表查询")
    @RequestMapping("/list")
    public SystemResponse productList(ProductDTO productDTO) {
        return new SystemResponse(ResponseCode.SUCCESS, iProductService.getProductList(productDTO));
    }

    @ApiOperation("新增商品")
    @RequestMapping(value="/create",method = RequestMethod.POST)
    @Log("新增商品")
    public SystemResponse roleAdd(@RequestBody @Validated @ApiParam(value = "商品信息")ProductAddDTO productAddDTO){
        iProductService.add(productAddDTO);
        return new SystemResponse(ResponseCode.SUCCESS);
    }
    @ApiOperation("删除商品")
    @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
    @Log("删除商品")
    public SystemResponse roleDelete(@PathVariable("id") @ApiParam(value = "商品")String id){
        iProductService.delete(id);
        return new SystemResponse(ResponseCode.SUCCESS);
    }
    @ApiOperation("更新商品")
    @RequestMapping(value="/update",method = RequestMethod.PUT)
    @Log("更新商品")
    public SystemResponse roleUpdate(@RequestBody @Validated @ApiParam(value = "商品更新数据") ProductDTO productDTO){
        iProductService.update(productDTO);
        return new SystemResponse(ResponseCode.SUCCESS);
    }


}

