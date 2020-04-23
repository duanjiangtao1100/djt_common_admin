package cn.jorian.jorianframework.common.aspect;


import cn.jorian.jorianframework.common.annotation.Log;
import cn.jorian.jorianframework.common.utils.JTokenTool;
import cn.jorian.jorianframework.common.utils.SpringTools;
import cn.jorian.jorianframework.config.jwt.JToken;
import cn.jorian.jorianframework.core.account.dto.LoginDTO;
import cn.jorian.jorianframework.core.account.dto.RestPasswordDTO;
import cn.jorian.jorianframework.core.system.dto.UserAddDTO;
import cn.jorian.jorianframework.core.system.entity.SysLog;
import cn.jorian.jorianframework.core.system.service.LogService;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * @author Licoy
 * @version 2018/4/27/17:19
 */
@Aspect
@Component
public class LogAspect {

    private final LogService logService;

    @Autowired
    public LogAspect( LogService logService) {
        this.logService = logService;
    }

    @Pointcut("@annotation(cn.jorian.jorianframework.common.annotation.Log)")
    public void log(){}

    @AfterReturning("log()")
    public void after(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        PrincipalCollection principalCollection = null;
        Subject subject = SecurityUtils.getSubject();
        if(subject.getPrincipals()!=null){
            principalCollection = subject.getPrincipals();
        }
        SysLog sysLog = new SysLog();
        //获取动作Action释义
        sysLog.setActionName(getMethodSysLogsAnnotationValue(joinPoint));
        //获取IP
        sysLog.setIp(SpringTools.getClientIp(request));
        sysLog.setAjax(SpringTools.ajax(request) ? 1 : 0);
        sysLog.setApi(request.getRequestURI());
        String s = this.paramFilter(joinPoint.getArgs());
        //根据系统需求自定义
        sysLog.setParams(s.length()>500 ? "数据过大，不给予记录" : s);
        sysLog.setHttpMethod(request.getMethod());
        sysLog.setClassMethod(joinPoint.getSignature().getDeclaringTypeName()
                + "." + joinPoint.getSignature().getName()+"()");
        //判断身份是否为空
        if(principalCollection!=null){
            JToken jToken = new JToken();
            BeanUtils.copyProperties(principalCollection.getPrimaryPrincipal(),jToken);
            String username = jToken.getUsername()!=null?jToken.getUsername(): JTokenTool.get(jToken.getToken(),"username");
            //从token中获取
            sysLog.setUsername(username);
        }else{
            sysLog.setUsername("游客");
        }
        sysLog.setCreateTime(new Date());
        logService.save(sysLog);//保存日志
    }

    private String getMethodSysLogsAnnotationValue(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature)signature;
        Method method = methodSignature.getMethod();
        if(method.isAnnotationPresent(Log.class)){
            //获取方法上注解中表明的权限
            Log log = method.getAnnotation(Log.class);

            return log.value();
        }
        return "未知";
    }

    private String paramFilter(Object[] params){
        //判断是否含有密码敏感数据
        final String filterString = "******";
        if(params.length>0){
            for (int i = 0; i < params.length; i++) {
                if(params[i] instanceof LoginDTO){
                    LoginDTO sign = (LoginDTO) params[i];
                    sign.setPassword(filterString);
                    params[i] = sign;
                }
                if(params[i] instanceof UserAddDTO){
                    UserAddDTO userAddDTO = (UserAddDTO) params[i];
                    userAddDTO.setPassword(filterString);
                    params[i] = userAddDTO;
                }
                if(params[i] instanceof RestPasswordDTO){
                    RestPasswordDTO resetPasswordDTO = (RestPasswordDTO) params[i];
                    resetPasswordDTO.setPassword(filterString);
                    params[i] = resetPasswordDTO;
                }
            }
        }
        return JSON.toJSONString(params);
    }


}
