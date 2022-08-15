package xyz.ray.web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import xyz.ray.pojo.Hero;
import xyz.ray.service.HeroService;
import xyz.ray.service.impl.HeroServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    private HeroService heroService = new HeroServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        BufferedReader br = req.getReader();
        String params = br.readLine();
        System.out.println(params);
        Hero hero = JSON.parseObject(params, Hero.class);
        heroService.add(hero);
        resp.getWriter().write("success");
    }
}
