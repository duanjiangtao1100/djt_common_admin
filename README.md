1.轻量级   
2.集成shiro+jwt完成登录校验，权限控制，粒度为url级别  
3.集成MP代码生成器  
4.使用自定义注释完成日志收集  
# 所用技术栈  
1.SpringBoot 2.0  
2.Shiro 1.3  
3.Mybatis-Plus 3.X + MP代码生成器  
4.JWT 3.0
# 使用环境准备  
1.JDK1.8  
2.nginx 配置图片服务器  
3.mysql   
# 使用步骤  
1.克隆项目，
2.导入在mysql中建库并运行项目目录下sql文件夹内的djt_common_admin.sql数据库文件
3.配置redis，用于存储token,注意用户名密码正确
4.启动项目即可 



