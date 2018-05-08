package moe.ijnji;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;

@WebServlet(urlPatterns = {"/*"})
public class RootServlet extends HttpServlet {

    private static String INDEX_PATH = "WEB-INF/index.html";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String location = getServletContext().getRealPath(INDEX_PATH);
        File file = new File(location);
        Path path = file.toPath();
        OutputStream out = response.getOutputStream();
        response.setContentType("text/html");
        Files.copy(path, out);
    }

}
