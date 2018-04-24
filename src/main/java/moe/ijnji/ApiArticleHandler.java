package moe.ijnji;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApiArticleHandler {

    public static void handleGet(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
        if (path.length() == 0)
            handleIndexGet(request, response);
        else
            handleFullGet(request, response, path);
    }

    private static void handleIndexGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext context = request.getSession().getServletContext();
        Map<String, Article> store = (Map)context.getAttribute("article");
        JsonObject obj = new JsonObject();
        for (String slug : store.keySet()) {
            Article article = store.get(slug);
            obj.add(slug, article.toIndexJson());
        }
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        response.getWriter().write(gson.toJson(obj));
    }

    private static void handleFullGet(HttpServletRequest request, HttpServletResponse response, String path) throws IOException{
        String slug = path.substring(1);
        ServletContext context = request.getSession().getServletContext();
        Map<String, Article> store = (Map)context.getAttribute("article");

        if (!store.containsKey(slug))
            return;

        Article article = store.get(slug);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        response.getWriter().write(gson.toJson(article.toFullJson()));
    }

}
