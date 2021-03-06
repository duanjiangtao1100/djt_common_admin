package cn.jorian.jorianframework.common.model;

import lombok.Data;

/**
 * author:djt
 */
@Data
public abstract class PageDTO {

    private Integer page = 1;

    private Integer limit = 10;

    private String sort = "createTime";

}
