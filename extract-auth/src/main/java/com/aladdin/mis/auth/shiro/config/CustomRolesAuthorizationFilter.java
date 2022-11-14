package com.aladdin.mis.auth.shiro.config;
/**
 * Created by cles on 2020/5/18 23:08
 */

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 自定义的角色过滤器
 * @author cles
 * @Date 2020/5/18 23:08
 */
public class CustomRolesAuthorizationFilter extends RolesAuthorizationFilter {

    @Override
    public boolean isAccessAllowed(ServletRequest req, ServletResponse resp, Object mappedValue) {
        Subject subject = getSubject(req, resp);
        String[] rolesArray = (String[]) mappedValue;
        //如果没有角色限制，直接放行
        if (rolesArray == null || rolesArray.length == 0) {
            return true;
        }
        for (int i = 0; i < rolesArray.length; i++) {
            //若当前用户是rolesArray中的任何一个，则有权限访问
            if (subject.hasRole(rolesArray[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        Subject subject = getSubject(request, response);
        if (subject.getPrincipal() != null) {
            return true;
        } else {
            //解决 WebUtils.toHttp 往返回response写数据跨域问题
            HttpServletRequest req = (HttpServletRequest) request;
            String origin = req.getHeader("Origin");
            HttpServletResponse resp = (HttpServletResponse) response;
            resp.setHeader("Access-Control-Allow-Origin", origin);
            //通过对 Credentials 参数的设置，就可以保持跨域 Ajax 时的 Cookie
            //设置了Allow-Credentials，Allow-Origin就不能为*,需要指明具体的url域
            resp.setHeader("Access-Control-Allow-Credentials", "true");

            WebUtils.toHttp(response).setContentType("application/json; charset=utf-8");
            WebUtils.toHttp(response).getWriter().print("401");
        }
        return false;
    }

//    @Override
//    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
//        HttpServletRequest servletRequest = (HttpServletRequest) request;
//        HttpServletResponse servletResponse = (HttpServletResponse) response;
//        //处理跨域问题，跨域的请求首先会发一个options类型的请求
//        if (servletRequest.getMethod().equals(HttpMethod.OPTIONS.name())) {
//            return true;
//        }
//        boolean isAccess = isAccessAllowed(request, response, mappedValue);
//        if (isAccess) {
//            return true;
//        }
//        servletResponse.setCharacterEncoding("UTF-8");
//        Subject subject = getSubject(request, response);
//        PrintWriter printWriter = servletResponse.getWriter();
//        servletResponse.setContentType("application/json;charset=UTF-8");
//        servletResponse.setHeader("Access-Control-Allow-Origin", servletRequest.getHeader("Origin"));
//        servletResponse.setHeader("Access-Control-Allow-Credentials", "true");
//        servletResponse.setHeader("Vary", "Origin");
//        String respStr = "";
//        if (subject.getPrincipal() == null) {
////            respStr = JSONObject.toJSONString(new BaseResponse<>(300, "您还未登录，请先登录"));
//        } else {
////            respStr = JSONObject.toJSONString(new BaseResponse<>(403, "您没有此权限，请联系管理员"));
//        }
//        printWriter.write(respStr);
//        printWriter.flush();
//        servletResponse.setHeader("content-Length", respStr.getBytes().length + "");
//        return false;
//    }
}
