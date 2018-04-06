package moe.ijnji;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Article {

    public String title;
    public long date;
    public List<String> categories;
    public String body;

    public Article() {}

    public String toString() {
        Map<String, String> map = new HashMap<>();
        map.put("title", title);
        map.put("date", Long.toString(date));
        map.put("categories", categories.toString());
        map.put("body", body);
        return map.toString();
    }
}
