package cn.jorian.jorianframework.core.product.service.impl;

import cn.jorian.jorianframework.core.product.ProductDTO.ProductDTO;
import cn.jorian.jorianframework.core.product.entity.Product;
import cn.jorian.jorianframework.core.product.mapper.ProductMapper;
import cn.jorian.jorianframework.core.product.service.IProductService;
import cn.jorian.jorianframework.core.system.entity.SysRole;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Djt
 * @since 2020-04-23
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
  public IPage<Product> getProductList(){
      ProductDTO productDTO=new ProductDTO();
    return  this.page(new Page<>(productDTO.getPage(),productDTO.getLimit()),new QueryWrapper<>());
  }
}
