package program.ducatssearch;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;


public class ducatsget {
    public String[] ducats_detail(String urlname) {
        String text=null;
        try {
            // like https://api.warframestat.us/pc/zh/vallisCycle/
            // cambionCycle是火卫二时间
            // cetusCycle是希图斯时间
            // vallisCycle是金星平原时间
            URL url = new URL("https://api.warframe.market/v1/items/"+urlname);
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
        Gson gson = new Gson();
       data data=gson.fromJson(text, data.class);
        payload pay=gson.fromJson(data.payload, payload.class);
        item item=gson.fromJson(pay.item, item.class);
       /*  String tempdata=gson.toJson(pay);

        item it=gson.fromJson(tempdata, item.class); */
        
        
       String[] temp=new String[2];
        
        if(item.items_in_set.get(0).ducats==0){
            temp[0]="no ducats";
        }
        else{
            temp[0]=String.valueOf(item.items_in_set.get(0).ducats);
        }
        
        temp[1]=item.items_in_set.get(0).url_name;
        /* temp[0]=it.items_in_set.get(0).url_name;
        temp[1]=String.valueOf( it.items_in_set.get(0).ducats); */
        
        return temp;
    }
    /* public String backgeturlname(String urlname){
        
        String temp=ducats_detail(urlname).items_in_set.get(0).url_name;
        return temp;
    } */
   
}

class data{
    JsonObject payload;
    public JsonObject getpayload(){
        return payload;
    }
    public void setpayload(JsonObject payload){
        this.payload=payload;
    }
}

class payload{
     JsonObject item;
    public JsonObject getItem(){
        return item;
    }
    public void setItem(JsonObject item){
        this.item=item;
    }
    
}
class item{
     List<items_in_set> items_in_set;
    public List<items_in_set> getitems_in_set(){
        return items_in_set;
    }
    public void setItems_in_set(List<items_in_set> items_in_set){
        this.items_in_set=items_in_set;
    }
}
class items_in_set{
    
    int ducats;
    String url_name;
    public String geturl_name(){
        return url_name;
    }
    public void setUrl_name(String url_name){
        this.url_name=url_name;
    }
   
    public int getDucats(){
        return ducats;
    }
    public void setDucats(int ducats){
        this.ducats=ducats;
    }
}
/* "payload": {
    "item": {
      "id": "5a2feeb1c2c9e90cbdaa23d2",
      "items_in_set": [
        {
          "sub_icon": "sub_icons/warframe/prime_systems_128x128.png",
          "url_name": "mirage_prime_systems_blueprint",
          "mastery_level": 8,
          "thumb": "items/images/en/thumbs/mirage_prime_systems.e7f8f484dd6ae6c35f0767fff35a5109.128x128.png",
          "trading_tax": 2000,
          "set_root": false,
          "icon_format": "land",
          "quantity_for_set": 1,
          "ducats": 45,
          "icon": "items/images/en/mirage_prime_systems.e7f8f484dd6ae6c35f0767fff35a5109.png",
          "tags": [ */