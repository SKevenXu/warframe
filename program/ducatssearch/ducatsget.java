package program.ducatssearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.swing.text.AbstractDocument.Content;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class ducatsget {
    public payload ducats_detail() {
        String text = null;
        try {
            // like https://api.warframestat.us/pc/zh/vallisCycle/
            // cambionCycle是火卫二时间
            // cetusCycle是希图斯时间
            // vallisCycle是金星平原时间
            URL url = new URL("https://api.warframe.market/v1/tools/ducats");
            // 2、连接服务器:打开服务器连接,得到对象conn
            URLConnection conn = url.openConnection();
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

    payload pay = ducats_detail();

    public String[] getid() {
        String[] ids = new String[pay.previous_hour.size()];
        // Gson gson=new Gson();
        // previous_hour pre=gson.fromJson(pay.previous_hour,previous_hour.class);
        for (int i = 0; i < ids.length; i++) {
            ids[i] = pay.previous_hour.get(i).id;
        }
        return ids;
    }

    public String[] getitem() {
        String[] item = new String[pay.previous_hour.size()];
        // Gson gson=new Gson();
        // previous_hour pre=gson.fromJson(pay.previous_hour,previous_hour.class);
        for (int i = 0; i < item.length; i++) {
            item[i] = pay.previous_hour.get(i).item;
        }
        return item;
    }

    public float[] getplat_worth() {
        float[] plat_worth = new float[pay.previous_hour.size()];
        // Gson gson=new Gson();
        // previous_hour pre=gson.fromJson(pay.previous_hour,previous_hour.class);
        for (int i = 0; i < plat_worth.length; i++) {
            plat_worth[i] = pay.previous_hour.get(i).plat_worth;
        }
        return plat_worth;
    }

    public float[] getducats_per_platinum() {
        float[] ducats_per_platinum = new float[pay.previous_hour.size()];
        // Gson gson=new Gson();
        // previous_hour pre=gson.fromJson(pay.previous_hour,previous_hour.class);
        for (int i = 0; i < ducats_per_platinum.length; i++) {
            ducats_per_platinum[i] = pay.previous_hour.get(i).ducats_per_platinum;
        }
        return ducats_per_platinum;
    }

    public int[] getducats() {
        int[] ducats = new int[pay.previous_hour.size()];
        // Gson gson=new Gson();
        // previous_hour pre=gson.fromJson(pay.previous_hour,previous_hour.class);
        for (int i = 0; i < ducats.length; i++) {
            ducats[i] = pay.previous_hour.get(i).ducats;
        }
        return ducats;
    }

    public String[] getdatetime() {
        String[] datetime = new String[pay.previous_hour.size()];
        // Gson gson=new Gson();
        // previous_hour pre=gson.fromJson(pay.previous_hour,previous_hour.class);
        for (int i = 0; i < datetime.length; i++) {
            datetime[i] = pay.previous_hour.get(i).datetime;
        }
        return datetime;
    }

    /*
     * public void readJson() throws UnsupportedEncodingException, IOException {
     * FileInputStream fis = new FileInputStream("program/ducatssearch/temp.txt");
     * try (Reader reader = new InputStreamReader(fis, "UTF-8")) {
     * Gson gson = new GsonBuilder().create();
     * payload p = gson.fromJson(reader, payload.class);
     * List<previous_hour> previous_hour = p.getPrevious_hour();
     * for (int i = 0; i < getid().length; i++) {
     * System.out.println(getid()[i]);
     * }
     * 
     * }
     * 
     * }
     */

    /*
     * public String backgeturlname(String urlname){
     * 
     * String temp=ducats_detail(urlname).items_in_set.get(0).url_name;
     * return temp;
     * }
     */

    /*
     * public static String readJsonData(String pactFile) {
     * // 读取文件数据
     * // System.out.println("读取文件数据util");
     * 
     * StringBuffer strbuffer = new StringBuffer();
     * File myFile = new File(pactFile);// "D:"+File.separatorChar+"DStores.json"
     * if (!myFile.exists()) {
     * System.err.println("Can't Find " + pactFile);
     * }
     * try {
     * FileInputStream fis = new FileInputStream(pactFile);
     * InputStreamReader inputStreamReader = new InputStreamReader(fis, "UTF-8");
     * BufferedReader in = new BufferedReader(inputStreamReader);
     * 
     * String str;
     * while ((str = in.readLine()) != null) {
     * strbuffer.append(str); // new String(str,"UTF-8")
     * }
     * in.close();
     * } catch (IOException e) {
     * e.getStackTrace();
     * }
     * // System.out.println("读取文件结束util");
     * return strbuffer.toString();
     * }
     */

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
    List<previous_hour> previous_hour;

    public List<previous_hour> getPrevious_hour() {
        return previous_hour;
    }

    public void setPrevious_hour(List<previous_hour> previous_hour) {
        this.previous_hour = previous_hour;
    }
}

class previous_hour {
    String datetime;
    int position_change_month;
    int position_change_week;
    int position_change_day;
    float plat_worth;
    int volume;
    float ducats_per_platinum;
    float ducats_per_platinum_wa;
    int ducats;
    String item;
    int median;
    float wa_price;
    String id;

    public String getDatetime() {
        return datetime;
    }

    public int getDucats() {
        return ducats;
    }

    public float getDucats_per_platinum() {
        return ducats_per_platinum;
    }

    public float getDucats_per_platinum_wa() {
        return ducats_per_platinum_wa;
    }

    public String getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public int getMedian() {
        return median;
    }

    public float getPlat_worth() {
        return plat_worth;
    }

    public int getPosition_change_day() {
        return position_change_day;
    }

    public int getPosition_change_month() {
        return position_change_month;
    }

    public int getPosition_change_week() {
        return position_change_week;
    }

    public int getVolume() {
        return volume;
    }

    public float getWa_price() {
        return wa_price;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public void setDucats(int ducats) {
        this.ducats = ducats;
    }

    public void setDucats_per_platinum(float ducats_per_platinum) {
        this.ducats_per_platinum = ducats_per_platinum;
    }

    public void setDucats_per_platinum_wa(float ducats_per_platinum_wa) {
        this.ducats_per_platinum_wa = ducats_per_platinum_wa;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setMedian(int median) {
        this.median = median;
    }

    public void setPlat_worth(float plat_worth) {
        this.plat_worth = plat_worth;
    }

    public void setPosition_change_day(int position_change_day) {
        this.position_change_day = position_change_day;
    }

    public void setPosition_change_month(int position_change_month) {
        this.position_change_month = position_change_month;
    }

    public void setPosition_change_week(int position_change_week) {
        this.position_change_week = position_change_week;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setWa_price(float wa_price) {
        this.wa_price = wa_price;
    }

}
/*
 * "datetime": "2024-05-10T08:00:00.000+00:00",
 * "position_change_month": -122,
 * "position_change_week": -96,
 * "position_change_day": -111,
 * "plat_worth": 148,
 * "volume": 32,
 * "ducats_per_platinum": 3.75,
 * "ducats_per_platinum_wa": 3.24,
 * "ducats": 15,
 * "item": "54a73e65e779893a797fff22",
 * "median": 4,
 * "wa_price": 4.62,
 * "id": "663de29dbba7740016f9b021"
 */
