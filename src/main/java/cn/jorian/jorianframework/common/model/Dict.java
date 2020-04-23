package cn.jorian.jorianframework.common.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Auther: jorian
 * @Date: 2019/4/17 15:47
 * @Description:
 */
@NoArgsConstructor
@AllArgsConstructor
public enum Dict {

  USER_LOCK (0,"用户锁定"),
  USER_NOLOCK (0,"用户正常"),
  SEX_MALE (0,"男"),
  SEX_FEMALE (0,"女"),
  RESOURCE_MENU(1,"菜单"),
  RESOURCE_BUTTON(1,"按钮"),

  /*USER_LOCK (0,"用户锁定"),
  USER_LOCK (0,"用户锁定"),
  USER_LOCK (0,"用户锁定"),
  USER_LOCK (0,"用户锁定"),
  USER_LOCK (0,"用户锁定"),*/




  ;

  public Integer key;
  public String  value;



}
