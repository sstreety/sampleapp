package com.blogspot.geekabyte.sample;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * Created by susannestreety on 8/29/16.
 */
@WebServlet(value="/hello")
public class HelloWorld extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.getWriter().println("Hello world!!");
    }
}
