import javax.servlet.*;
import java.io.IOException;

public class GoOut extends GenericServlet {
    @Override
    public void init() {
        System.out.println("goOut被创建");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("离开了");
    }

    @Override
    public void destroy() {
        System.out.println("goOut被销毁");
    }
}
