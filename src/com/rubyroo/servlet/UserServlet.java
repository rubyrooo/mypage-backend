package com.rubyroo.servlet;

import com.rubyroo.bean.Result;
import com.rubyroo.bean.User;
import com.rubyroo.service.DBService;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/v1/user/insert")
public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //1. 避免乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        //2.接收浏览器传递的数据
        String name = request.getParameter("name");
        String ageText = request.getParameter("age");
        String city = request.getParameter("city");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String weixin = request.getParameter("weixin");
        String qq = request.getParameter("qq");
        String weibo = request.getParameter("weibo");
        String sex = request.getParameter("sex");
        String description = request.getParameter("description");
        int age = -1;
        if(ageText != null){
            try {
                age = Integer.parseInt(ageText);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        //3. 调用Service，将数据存储到数据库中
        User user = new User(name,age,city,address,email,phone,weixin,qq,weibo,sex,description);
        int userId = DBService.insertUser(user);

        //4. 将储存的结果，封装成JSON格式，发送给浏览器
        Result r = null;
        if(userId>0) {
            r = new Result(0,"用户创建成功",userId);
        }else{
            r = new Result(-1,"用户新增失败");
        }
        String json = r.toJSON();
        response.getWriter().append(json);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
