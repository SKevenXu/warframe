package program.ducatssearch;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class search_id {
    public payload id_search() {
        String text = null;
        try {
            // like https://api.warframestat.us/pc/zh/vallisCycle/
            // cambionCycle是火卫二时间
            // cetusCycle是希图斯时间
            // vallisCycle是金星平原时间
            URL url = new URL("https://api.warframe.market/v1/items");
            // 2、连接服务器:打开服务器连接,得到对象conn
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("Language", "zh-hans");
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            // 3、加载数据:获取加载数据的字节输入流
            InputStream is = conn.getInputStream();
            // 4、将is装饰为能一次读取一行的字符输入流br
            // BufferedReader br = new BufferedReader(new InputStreamReader(is));
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            // 5、加载一行数据ca
            text = br.readLine();

        } catch (Exception e) {
            System.out.println("false");
        }
        // System.out.println(text);
        // getFile(text);
        Gson gson = new Gson();
        demo demo = gson.fromJson(text, demo.class);
        payload payload = gson.fromJson(demo.payload, payload.class);
        return payload;
    }

    payload pay = id_search();

    public void getname() {

        System.out.println(pay.items.get(0).item_name);
    }
}

class demo {
    JsonObject payload;

    public JsonObject getPayload() {
        return payload;
    }

    public void setPayload(JsonObject payload) {
        this.payload = payload;
    }
}

class payload {
    List<items> items;

    public List<items> getItems() {
        return items;
    }

    public void setItems(List<items> items) {
        this.items = items;
    }
}

class items {
    String url_name;
    String item_name;
    String id;

    public String getUrl_name() {
        return url_name;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setUrl_name(String url_name) {
        this.url_name = url_name;
    }
}
