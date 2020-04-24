package cn.jorian.jorianframework.core.product.ProductDTO;

import cn.jorian.jorianframework.common.model.BaseModel;
import cn.jorian.jorianframework.common.model.PageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Djt
 * @since 2020-04-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ProductDTO extends PageDTO {

    private static final long serialVersionUID = 1L;

    private String name;

    private Double price;

}
