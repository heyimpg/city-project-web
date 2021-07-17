import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter(urlPatterns = "/*")
public class EncodingFilter implements Filter {
    private String encoding = "utf-8";
    private String contentType = "text/html;charset=UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
        String encodingParam = filterConfig.getInitParameter("encoding");
        if (encodingParam != null) {
            encoding = encodingParam;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            request.setCharacterEncoding(encoding);
            response.setCharacterEncoding(encoding);
        // response.setContentType(contentType);
            chain.doFilter(request, response);
        //test filter
        /*PrintWriter writer = response.getWriter();
        writer.println("Filter....");
        writer.close();*/
    }

    @Override
    public void destroy() {
     //   Filter.super.destroy();
    }
}
