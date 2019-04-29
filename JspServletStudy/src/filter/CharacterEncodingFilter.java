package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "CharacterEncodingFilter")
public class CharacterEncodingFilter implements Filter {
    public void destroy() {
        System.out.println("过滤器开始销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        System.out.println("过滤器开始过滤");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        chain.doFilter(req,resp);
        //返回给过滤器的处理
        System.out.println("过滤器传递过滤结束");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器开始初始化");
    }


}
