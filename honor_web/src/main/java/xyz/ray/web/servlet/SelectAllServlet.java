package xyz.ray.web.servlet;

import com.alibaba.fastjson.JSON;
import xyz.ray.pojo.Hero;
import xyz.ray.service.HeroService;
import xyz.ray.service.impl.HeroServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAll")
public class SelectAllServlet extends HttpServlet {
    private HeroService heroService = new HeroServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Hero> heroes = heroService.selectAll();
        String jsonString = JSON.toJSONString(heroes);
        resp.setContentType("text/json;charset=utf-8"); //告知浏览器响应的数据是什么, 告知浏览器使用什么字符集进行解码
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
