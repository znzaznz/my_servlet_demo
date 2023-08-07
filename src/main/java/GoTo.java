import javax.servlet.*;
import java.io.IOException;

public class GoTo extends GenericServlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("goto被创建了！");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("goto被执行了");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("goto被销毁了");
    }
}
