package cn.jorian.jorianframework.core.account.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;


@Data
public class Router {

    private String path;
    private String component;
    private String redirect;
    private String name;
    private Map<String,String > meta;
    private Boolean hidden;
    private List<Router> children;


}


