package com.example.rent.controller;

import com.example.rent.entity.House;
import com.example.rent.entity.ManagerBean;
import com.example.rent.service.ManagerService;
import com.example.rent.service.impl.ManagerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/managerDetail")
public class ManagerHouseServlet extends HttpServlet {
    private ManagerService managerService = new ManagerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.接受参数
        String managerId = request.getParameter("managerId");
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");

        int managerid=0;
//        //2.处理参数
        if (managerId != null && managerId.length() > 0 ) {
           managerid=Integer.parseInt(managerId);
        }
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

//        System.out.println(currentPage);
//        System.out.println(pageSize);
//
        //3. 调用service查询PageBean对象
        ManagerBean<House> mb = managerService.managerQuery(managerid,currentPage, pageSize);
//
        //4. 将pageBean对象序列化为json，返回
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(mb);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json);

//    }


    }
}
