package moe.ijnji;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;

public class ArticleMapListener implements ServletContextListener {

    private static final String ARTICLE_PATH = "/article";

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        File folder = new File(context.getRealPath(ARTICLE_PATH));
        HashMap<String, Article> map = new HashMap<>();
        for (File file : folder.listFiles()) {
            if (file.isFile())
                parseArticle(file, map);
        }
        context.setAttribute("article", map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {}

    private void parseArticle(File file, HashMap<String, Article> map) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            List<String> header = new ArrayList<>();
            List<String> body = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.equals("---")) {
                    header.add(line);
                } else {
                    break;
                }
            }
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                body.add(line);
            }
            String slug = file.getName().substring(0, file.getName().lastIndexOf(".") + 1);
        } catch (IOException e) {}
    }

    private Article constructArticle(List<String> header, List<String> body) {

    }

}
