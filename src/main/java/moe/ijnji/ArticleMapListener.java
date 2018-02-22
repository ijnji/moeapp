package moe.ijnji;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import com.esotericsoftware.yamlbeans.YamlReader;

@WebListener
public class ArticleMapListener implements ServletContextListener {

    private static final String ARTICLE_PATH = "/WEB-INF/article";

    @Override
    public void contextInitialized(ServletContextEvent event) {
            ServletContext context = event.getServletContext();
            File folder = new File(context.getRealPath(ARTICLE_PATH));
            HashMap<String, Article> store = new HashMap<>();
            for (File file : folder.listFiles()) {
                try {
                    if (file.isFile())
                        generateArticle(file, store);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            context.setAttribute("article", store);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {}

    private void generateArticle(File file, HashMap<String, Article> map) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> header = new ArrayList<>();
        List<String> body = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.equals("---")) {
                break;
            } else {
                header.add(line);
            }
        }
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            body.add(line);
        }

        String slug = file.getName().substring(0, file.getName().lastIndexOf("."));
        Article article = parseArticle(
            String.join("\n", header),
            String.join("\n", body)
        );
        map.put(slug, article);
    }

    private Article parseArticle(String header, String body) throws Exception {
        YamlReader reader = new YamlReader(header);
        Map map = (Map)reader.read();

        Article article = new Article();
        article.title = (String)map.get("title");
        article.date = Long.parseLong((String)map.get("date"));
        article.categories = (List<String>)map.get("categories");
        article.body = body;
        return article;
    }

}
