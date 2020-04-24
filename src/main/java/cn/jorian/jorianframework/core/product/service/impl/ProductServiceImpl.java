package cn.jorian.jorianframework.core.product.service.impl;

import cn.jorian.jorianframework.common.exception.ServiceException;
import cn.jorian.jorianframework.core.job.entity.Job;
import cn.jorian.jorianframework.core.product.dto.ProductAddDTO;
import cn.jorian.jorianframework.core.product.dto.ProductDTO;
import cn.jorian.jorianframework.core.product.entity.Product;
import cn.jorian.jorianframework.core.product.mapper.ProductMapper;
import cn.jorian.jorianframework.core.product.service.IProductService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

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

    @Override
  public IPage<Product> getProductList(ProductDTO productDTO){
        Product product =new Product();
        BeanUtils.copyProperties(productDTO, product);
        QueryWrapper<Product> queryWrapper =new QueryWrapper<>();
        if(!StringUtils.isEmpty(productDTO.getName())){
            queryWrapper.eq("name",product.getName());
        }
        queryWrapper.orderByDesc(productDTO.getSort());
        IPage<Product> pagedata = this.page(new Page<>(productDTO.getPage(),productDTO.getLimit()),queryWrapper);
        return pagedata;
  }

    @Override
    public void add(ProductAddDTO productDTO) {
        Product product=new Product();
        BeanUtils.copyProperties(productDTO,product);
        product.setCreateTime(new Date());
        product.setUpdateTime(new Date());
        this.save(product);
    }

    @Override
    public void delete(String id) {
        if(id==null){
            throw new ServiceException("请输入要删除的id");
        }
        this.removeById(id);
    }

    @Override
    public void update(ProductDTO product) {
        if(product==null){
            throw new ServiceException("不能保存空的商品");
        }
        Product findProduct = this.getById(product.getId());
        if(findProduct ==null) {
            throw new ServiceException("更新的商品不存在");
        }
        BeanUtils.copyProperties(product,findProduct);
        this.updateById(findProduct);
    }
}
