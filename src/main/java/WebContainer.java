import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.*;

public class WebContainer {
    // 存储每个servlet对象对应的信息
    Map<String, String> urlToClassName = new HashMap<>();
    // 存储servlet声明的对应的对象
    Map<String, Servlet> servletMap = new HashMap<>();

    private Servlet createServlet(String pattern, String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ServletException {
        // 进行反射创建对象
        Class<?> clazz = Class.forName(className);
        Servlet servlet = (Servlet) clazz.newInstance();
        // 牢记需要初始化
        servlet.init(null);
        servletMap.put(pattern, servlet);
        return servlet;
    }

    // 启动web容器
    public void start(List<ServletConfiguration> servletConfigurationList) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ServletException {
        List<ServletConfiguration> needBuildAtStartServlets = new ArrayList<>();
        // 遍历list,存储下对应的class和对应的url
        for (ServletConfiguration servletConfiguration : servletConfigurationList) {
            urlToClassName.put(servletConfiguration.getUrlPattern(), servletConfiguration.getServletClass());
            Integer loadOnStartUp = servletConfiguration.getLoadOnStartUp();
            // 判断是否需要在start中声明并执行
            if (loadOnStartUp != null && loadOnStartUp >= 0) {
                needBuildAtStartServlets.add(servletConfiguration);
            }
        }

        // 重新排序
        needBuildAtStartServlets.sort(Comparator.comparing(ServletConfiguration -> ServletConfiguration.getLoadOnStartUp()));

        // 对needBuildAtStartServlets进行对象的声明
        for (ServletConfiguration needBuildAtStartServlet : needBuildAtStartServlets) {
            createServlet(needBuildAtStartServlet.getUrlPattern(), needBuildAtStartServlet.getServletClass());
        }
    }

    // 执行servlet的代码
    public void doServices(String urlPattern, ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 如果现有的对象已经存在这个urlPattern
        if (servletMap.containsKey(urlPattern)) {
            Servlet servlet = servletMap.get(urlPattern);
            servlet.service(servletRequest, servletResponse);
            return;
        }
        // 如果包含在url堆中却没有包含在已存在对象堆中
        if (urlToClassName.containsKey(urlPattern)) {
            Servlet servlet = createServlet(urlPattern, urlToClassName.get(urlPattern));
            servlet.service(servletRequest, servletResponse);
            return;
        }
        // 如果都不存在
        System.out.println("滚！");
        return;
    }

    // 销毁创建的对象
    public void destroy() {
        // 不如下面这一种的好
//        for (Map.Entry<String, Servlet> stringServletEntry : servletMap.entrySet()) {
//            servletMap.get(stringServletEntry).destroy();
//        }

        for (Servlet servlet : servletMap.values()) {
            servlet.destroy();
        }
    }
}
