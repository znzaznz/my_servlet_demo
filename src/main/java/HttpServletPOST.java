import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class HttpServletPOST extends HttpServlet {
    @Override
    public void init() {
        System.out.println("POST请求init了");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 试试看可以拿到嘛
        Map<String, String[]> paramMap = req.getParameterMap();
        for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(Arrays.toString(entry.getValue()));
        }

        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("password"));

//        // 再试试抄来的这个
//        StringBuilder requestBody = new StringBuilder();
//        BufferedReader reader = req.getReader();
//        String line;
//
//        while ((line = reader.readLine()) != null) {
//            requestBody.append(line);
//        }
//
//        System.out.println(requestBody.toString());
//
//        // requestBody 包含了请求体的内容，您可以进行解析和处理
//        resp.getWriter().write("Request body: " + requestBody.toString());
    }
}
