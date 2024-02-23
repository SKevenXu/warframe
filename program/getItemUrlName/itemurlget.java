package program.getItemUrlName;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.google.gson.Gson;

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

    payload pay = items_detail("localfile\\items_urlname.json");

    public String[] getitemurl() {

        String[] geturlname = new String[pay.items.size()];
        for (int i = 0; i < geturlname.length; i++) {
            geturlname[i] = pay.items.get(i).url_name;
        }
        return geturlname;
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