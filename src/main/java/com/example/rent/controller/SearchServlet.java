package com.example.rent.controller;

import com.example.rent.entity.House;
import com.example.rent.entity.PageBean;
import com.example.rent.service.HouseService;
import com.example.rent.service.impl.HouseServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private HouseService houseService = new HouseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchContent=req.getParameter("searchContent");
        String currentPageStr = req.getParameter("currentPage");
        String pageSizeStr = req.getParameter("pageSize");

        int currentPage = 0;//当前页码，如果不传递，则默认为第一页
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }

        int pageSize = 0;//每页显示条数，如果不传递，默认每页显示5条记录
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 5;
        }

        PageBean<House> pb = houseService.pageQueryBySearch(searchContent,currentPage, pageSize);
        //4. 将pageBean对象序列化为json，返回
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(pb);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().println(json);
    }
}
