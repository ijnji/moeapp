package moe.ijnji;

import java.io.File;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;

public static final ARTICLE_PATH = "/article";

public class ArticleMapListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        File folder = new File(context.getRealPath(ARTICLE_PATH));
        HashMap<String, Article> map = new HashMap<>();
        for (File file : folder.listFiles()) {
            if (file.isFile())
                processArticle(file, map);
        }
        context.setAttribute("article", map);
    }

    private void processArticle(File file, HashMap<String, Article> map) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                
            }
            String slug = file.getName().substring(0, file.getName().lastIndexOf(".") + 1);
        }
    }

}
