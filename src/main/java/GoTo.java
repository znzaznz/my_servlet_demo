import javax.servlet.*;
import java.io.IOException;

public class GoTo extends GenericServlet {
    @Override
    public void init() {
        System.out.println("goto被创建了！");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("goto被执行了");
    }

    @Override
    public void destroy() {
        System.out.println("goto is destroy");
    }
}
