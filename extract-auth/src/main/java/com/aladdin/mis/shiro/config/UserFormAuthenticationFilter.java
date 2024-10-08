package com.aladdin.mis.shiro.config;
/**
 * Created by cles on 2020/5/18 23:08
 */

import com.aladdin.mis.common.system.entity.Result;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 自定义的角色过滤器
 * @author cles
 * @Date 2020/5/18 23:08
 */
public class UserFormAuthenticationFilter extends FormAuthenticationFilter {

    public UserFormAuthenticationFilter()
    {
        super();
    }

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response,
                                   Object mappedValue)
    {
        if (((HttpServletRequest)request).getMethod().toUpperCase().equals("OPTIONS"))
        {
            return true;
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
            throws Exception{
        // 判断是否登陆过
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                return executeLogin(request, response);
            } else {
                return true;
            }
        } else {
            //解决 WebUtils.toHttp 往返回response写数据跨域问题
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            String origin = httpRequest.getHeader("Origin");
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.setHeader("Access-Control-Allow-Origin", origin);
            //通过对 Credentials 参数的设置，就可以保持跨域 Ajax 时的 Cookie
            //设置了Allow-Credentials，Allow-Origin就不能为*,需要指明具体的url域
            httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");

            // 返回固定的JSON串
            Result result = new Result();
            result.setData(null);
            result.setCode(10001);
            result.setMessage("未登录或登录信息已过期，请重新登录");
            WebUtils.toHttp(response).setContentType("application/json; charset=utf-8");
            WebUtils.toHttp(response).getWriter().print(JSONObject.toJSONString(result));
            return false;
        }
    }
}
