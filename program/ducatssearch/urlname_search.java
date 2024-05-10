package program.ducatssearch;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class urlname_search {
    public demo url_detail() {
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

        return demo;

    }

    // public void getFile(String text) {
    // String filename = "program/ducatssearch/temp.txt";
    // try {
    // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new
    // File(filename)));
    // bufferedWriter.write(text);
    // bufferedWriter.close();
    // } catch (IOException e) {

    // e.printStackTrace();
    // }
    // }

    // public static String readJsonData(String pactFile) {
    // // 读取文件数据
    // // System.out.println("读取文件数据util");

    // StringBuffer strbuffer = new StringBuffer();
    // File myFile = new File(pactFile);// "D:"+File.separatorChar+"DStores.json"
    // if (!myFile.exists()) {
    // System.err.println("Can't Find " + pactFile);
    // }
    // try {
    // FileInputStream fis = new FileInputStream(pactFile);
    // InputStreamReader inputStreamReader = new InputStreamReader(fis, "UTF-8");
    // BufferedReader in = new BufferedReader(inputStreamReader);

    // String str;
    // while ((str = in.readLine()) != null) {
    // strbuffer.append(str); // new String(str,"UTF-8")
    // }
    // in.close();
    // } catch (IOException e) {
    // e.getStackTrace();
    // }
    // // System.out.println("读取文件结束util");
    // return strbuffer.toString();
    // }

    demo de = url_detail();
    // List<items> items = pay.getItems();

    public String[] geturlname() {
        Gson gson = new Gson();
        payload pay = gson.fromJson(de.payload, payload.class);

        // items[] items = gson.fromJson(pay.items, items[].class);
        String[] temp = new String[pay.items.size()];
        for (int i = 0; i < pay.items.size(); i++) {
            temp[i] = pay.items.get(i).url_name;
        }
        return temp;
    }

    public static String unicodeDecode(String string) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(string);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            string = string.replace(matcher.group(1), ch + "");
        }
        return string;
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