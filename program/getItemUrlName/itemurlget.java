package program.getItemUrlName;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class itemurlget {
    public payload items_detail(String file) {
        String text = null;
        try {
            // https://api.warframe.market/v1/items
            text = readJsonData(file);

        } catch (Exception e) {
            System.out.println("false");
        }
        Gson gson = new Gson();
        payload pay = gson.fromJson(text, payload.class);

        return pay;
    }

    public payload url_detail() {
        String text = null;
        try {
            // like https://api.warframestat.us/pc/zh/vallisCycle/
            // cambionCycle是火卫二时间
            // cetusCycle是希图斯时间
            // vallisCycle是金星平原时间
            URL url = new URL("https://api.warframe.market/v1/items");
            // 2、连接服务器:打开服务器连接,得到对象conn
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            conn.setRequestProperty("Language", "zh-hans");
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
        payload pay = gson.fromJson(demo.payload, payload.class);
        return pay;

    }

    // payload pay = items_detail("localfile\\items_urlname.json");
    payload pay = url_detail();

    public String[] getitemurl() {

        String[] geturlname = new String[pay.items.size()];
        for (int i = 0; i < geturlname.length; i++) {
            geturlname[i] = pay.items.get(i).url_name;
        }
        return geturlname;
    }

    public String[] getid() {

        String[] id = new String[pay.items.size()];
        for (int i = 0; i < id.length; i++) {
            id[i] = pay.items.get(i).id;
        }
        return id;
    }

    public String[] getitemname() {

        String[] getitemName = new String[pay.items.size()];
        for (int i = 0; i < getitemName.length; i++) {
            getitemName[i] = pay.items.get(i).item_name;
        }
        return getitemName;
    }

    public String getoneurlname(String name) {
        String url = null;
        for (int i = 0; i < getitemname().length; i++) {
            if (getitemname()[i].hashCode() == name.hashCode()) {
                url = getitemurl()[i];
            }
        }
        return url;
    }

    public String getonename(String url) {
        String name = null;
        for (int i = 0; i < getitemurl().length; i++) {
            if (getitemurl()[i].hashCode() == url.hashCode()) {
                name = getitemname()[i];
            }
        }
        return name;
    }

    public static String readJsonData(String pactFile) {
        // 读取文件数据
        // System.out.println("读取文件数据util");

        StringBuffer strbuffer = new StringBuffer();
        File myFile = new File(pactFile);// "D:"+File.separatorChar+"DStores.json"
        if (!myFile.exists()) {
            System.err.println("Can't Find " + pactFile);
        }
        try {
            FileInputStream fis = new FileInputStream(pactFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fis, "UTF-8");
            BufferedReader in = new BufferedReader(inputStreamReader);

            String str;
            while ((str = in.readLine()) != null) {
                strbuffer.append(str); // new String(str,"UTF-8")
            }
            in.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
        // System.out.println("读取文件结束util");
        return strbuffer.toString();
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
    String item_name;
    String url_name;
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getUrl_name() {
        return url_name;
    }

    public void setUrl_name(String url_name) {
        this.url_name = url_name;
    }
}