public class ServletConfiguration {
    // url的路径
    private String urlPattern;

    // servlet对应的类
    private String servletClass;

    // 定义是否在容器启动的时候就定义对应的servlet的类
    private Integer loadOnStartUp;

    public ServletConfiguration(String urlPattern, String servletClass, Integer loadOnStartUp) {
        this.urlPattern = urlPattern;
        this.servletClass = servletClass;
        this.loadOnStartUp = loadOnStartUp;
    }

    public ServletConfiguration(String urlPattern, String servletClass) {
        this.urlPattern = urlPattern;
        this.servletClass = servletClass;
        this.loadOnStartUp = -1;
    }

    public ServletConfiguration() {

    }

    public String getUrlPattern() {
        return urlPattern;
    }

    public String getServletClass() {
        return servletClass;
    }

    public Integer getLoadOnStartUp() {
        return loadOnStartUp;
    }
}
