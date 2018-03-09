package moe.ijnji;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;

@WebServlet(value = "/api/article/*")
public class ArticleServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	String slug = request.getPathInfo();
    	response.setContentType("text/html");
    	response.setCharacterEncoding("UTF-8");
    	response.getWriter().write(slug);
    }

}
