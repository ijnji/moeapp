package moe.ijnji;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;

public class Article {

    public String title;
    public long date;
    public List<String> categories;
    public String body;

    public Article() {}

    public JsonObject toIndexJson() {
        JsonObject obj = new JsonObject();
        obj.addProperty("title", this.title);
        obj.addProperty("date", this.date);
        JsonArray categoriesArray = new JsonArray();
        for (String c : this.categories)
            categoriesArray.add(c);
        obj.add("categories", categoriesArray);
        return obj;
    }

    public JsonObject toFullJson() {
        JsonObject obj = this.toIndexJson();
        obj.addProperty("body", this.body);
        return obj;
    }
}
