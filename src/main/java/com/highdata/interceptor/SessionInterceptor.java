package com.highdata.interceptor;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.highdata.entity.User;

public class SessionInterceptor implements HandlerInterceptor {

    private final Logger logger = Logger.getLogger(this.getClass());

    private List<String> excludedUrls;
    public void setExcludedUrls(List<String> excludedUrls) {  
        this.excludedUrls = excludedUrls;  
    }
    /**
     * 在业务处理器处理请求之前被调用
     * 如果返回false 则退出本拦截器，本拦截器后面的postHandle与afterCompletion不再执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
        HttpServletResponse response, Object handler) throws Exception {
        String requestUri = request.getRequestURI();
        for (String url : excludedUrls) {
            if (requestUri.contains(url)) {
                return true;
            }
        }

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            logger.info("Pedirect to login page");
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        request.setAttribute("user", user);
        return true;
    }

  
    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
     */
    @Override
    public void postHandle(HttpServletRequest request,
        HttpServletResponse response, Object handler, ModelAndView modelAndView)
        throws Exception {
        // TODO Auto-generated method stub
        
    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用
     * 当拦截器抛出异常时,依然会从当前拦截器往回执行所的拦截器的afterCompletion()
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
        HttpServletResponse response, Object handler, Exception ex)
        throws Exception {
        // TODO Auto-generated method stub
        
    }

}
