package xyz.ray.web.servlet;

import com.alibaba.fastjson.JSON;
import xyz.ray.pojo.Hero;
import xyz.ray.pojo.PageBean;
import xyz.ray.service.HeroService;
import xyz.ray.service.impl.HeroServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/hero/*")
public class HeroServlet extends BaseServlet {
    private HeroService heroService = new HeroServiceImpl();

    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Hero> heroes = heroService.selectAll();
        String jsonString = JSON.toJSONString(heroes);
        resp.setContentType("text/json;charset=utf-8"); //告知浏览器响应的数据是什么, 告知浏览器使用什么字符集进行解码
        resp.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        BufferedReader br = req.getReader();
        String params = br.readLine();
        System.out.println(params);
        Hero hero = JSON.parseObject(params, Hero.class);
        heroService.add(hero);
        resp.getWriter().write("success");
    }

    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = req.getReader();
        String params = br.readLine(); //json字符串
        int[] ids = JSON.parseObject(params, int[].class);
        heroService.deleteByIds(ids);
        resp.getWriter().write("success");
    }

    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收 url?currentPage=1&pageSize=5
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        PageBean<Hero> pageBean = heroService.selectByPage(currentPage, pageSize);

        String jsonString = JSON.toJSONString(pageBean);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 找了好久的错误
        req.setCharacterEncoding("UTF-8");
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        // 获取查询条件对象
        BufferedReader br = req.getReader();
        String params = br.readLine(); //json字符串
        Hero hero = JSON.parseObject(params, Hero.class);

        PageBean<Hero> pageBean = heroService.selectByPageAndCondition(currentPage, pageSize, hero);

        String jsonString = JSON.toJSONString(pageBean);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String _id = req.getParameter("id");
        int id = Integer.parseInt(_id);
        heroService.deleteById(id);
        resp.getWriter().write("success");
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        BufferedReader br = req.getReader();
        String params = br.readLine(); //json字符串
        Hero hero = JSON.parseObject(params, Hero.class);
        heroService.update(hero);
        resp.getWriter().write("success");
    }
}
