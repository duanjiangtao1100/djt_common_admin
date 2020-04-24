package cn.jorian.jorianframework.core.product.service;

import cn.jorian.jorianframework.core.product.dto.ProductAddDTO;
import cn.jorian.jorianframework.core.product.dto.ProductDTO;
import cn.jorian.jorianframework.core.product.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Djt
 * @since 2020-04-23
 */
public interface IProductService extends IService<Product> {
    /**
     * 新增
     * @param productAddDTO
     */
    void add(ProductAddDTO productAddDTO);

    /**
     * 删除
     * @param id
     */
    void delete(String id);

    /**
     * 更新
     * @param productDTO
     */
    void update(ProductDTO productDTO);

    /**
     * 查询
     * @return
     */
    public Object getProductList(ProductDTO productDTO);


}
