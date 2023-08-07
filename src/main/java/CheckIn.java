import javax.servlet.*;
import java.io.IOException;

public class CheckIn extends GenericServlet {
    @Override
    public void init() {
        System.out.println("checkIn is init");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("用户checkIn");
    }

    @Override
    public void destroy() {
        System.out.println("checkout is destory");
    }
}
