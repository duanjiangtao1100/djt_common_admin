package cn.jorian.jorianframework.core.product.service;

import cn.jorian.jorianframework.core.product.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Djt
 * @since 2020-04-23
 */
public interface IProductService extends IService<Product> {
    public Object getProductList();
}
