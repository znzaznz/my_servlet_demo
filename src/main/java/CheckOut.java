import javax.servlet.*;
import java.io.IOException;

public class CheckOut extends GenericServlet {
    @Override
    public void init() {
        System.out.println("checkOut被init");
    }


    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("用户checkout了");
    }

    @Override
    public void destroy() {
        System.out.println("checkOut is destory");
    }
}
