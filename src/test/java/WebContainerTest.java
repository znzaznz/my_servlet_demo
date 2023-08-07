import org.junit.Test;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebContainerTest {
    private List<ServletConfiguration> getServletConfigurations() {
        List<ServletConfiguration> list = new ArrayList<>();
        ServletConfiguration servletConfiguration01 = new ServletConfiguration("/goTo", "GoTo");
        ServletConfiguration servletConfiguration02 = new ServletConfiguration("/goOut", "GoOut");
        ServletConfiguration servletConfiguration03 = new ServletConfiguration("/checkOut", "CheckOut", 1);
        ServletConfiguration servletConfiguration04 = new ServletConfiguration("/checkIn", "CheckIn", 2);
        list.add(servletConfiguration01);
        list.add(servletConfiguration02);
        list.add(servletConfiguration03);
        list.add(servletConfiguration04);
        return list;
    }

    @Test
    public void testDemo() throws ServletException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        // 分析servlet的配置单
        List<ServletConfiguration> servletConfigurationList = getServletConfigurations();
        // 创建webcontainer容器
        WebContainer webContainer = new WebContainer();
        // 启动webContainer
        webContainer.start(servletConfigurationList);
        // 发送请求
        webContainer.doServices("/goTo", null, null);
        webContainer.doServices("/checkIn", null, null);
        webContainer.doServices("/checkOut", null, null);
        webContainer.doServices("/goOut", null, null);

        webContainer.destroy();
    }
}
