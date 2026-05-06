package com.aladdin.common.core.web;

import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * XSS过滤器
 *
 * @author cles
 * @date 2026/05/06
 */
public class XssFilter implements Filter {

    private static final Pattern[] PATTERNS = {
            Pattern.compile("<script[^>]*?>.*?</script>", Pattern.CASE_INSENSITIVE),
            Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE),
            Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE),
            Pattern.compile("on(load|click|mouse|key|focus|blur|change|submit|reset|select|error)\\s*=", Pattern.CASE_INSENSITIVE),
            Pattern.compile("eval\\s*\\(", Pattern.CASE_INSENSITIVE),
            Pattern.compile("expression\\s*\\(", Pattern.CASE_INSENSITIVE),
            Pattern.compile("<iframe[^>]*?>.*?</iframe>", Pattern.CASE_INSENSITIVE),
            Pattern.compile("<object[^>]*?>.*?</object>", Pattern.CASE_INSENSITIVE),
            Pattern.compile("<embed[^>]*?>", Pattern.CASE_INSENSITIVE)
    };

    private List<String> excludes = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) {
        String excludesParam = filterConfig.getInitParameter("excludes");
        if (StringUtils.hasText(excludesParam)) {
            for (String exclude : excludesParam.split(",")) {
                excludes.add(exclude.trim());
            }
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (isExcluded(httpRequest)) {
            chain.doFilter(request, response);
            return;
        }
        chain.doFilter(new XssHttpServletRequestWrapper(httpRequest), response);
    }

    private boolean isExcluded(HttpServletRequest request) {
        String uri = request.getRequestURI();
        for (String exclude : excludes) {
            if (uri.contains(exclude)) {
                return true;
            }
        }
        return false;
    }

    public static String stripXss(String value) {
        if (value == null) {
            return null;
        }
        String clean = value;
        for (Pattern pattern : PATTERNS) {
            clean = pattern.matcher(clean).replaceAll("");
        }
        clean = clean.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        clean = clean.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
        clean = clean.replaceAll("'", "&#39;");
        clean = clean.replaceAll("\"", "&quot;");
        return clean;
    }

    static class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

        public XssHttpServletRequestWrapper(HttpServletRequest request) {
            super(request);
        }

        @Override
        public String getParameter(String name) {
            String value = super.getParameter(name);
            return stripXss(value);
        }

        @Override
        public String[] getParameterValues(String name) {
            String[] values = super.getParameterValues(name);
            if (values == null) {
                return null;
            }
            String[] cleaned = new String[values.length];
            for (int i = 0; i < values.length; i++) {
                cleaned[i] = stripXss(values[i]);
            }
            return cleaned;
        }

        @Override
        public String getHeader(String name) {
            String value = super.getHeader(name);
            return stripXss(value);
        }
    }
}
