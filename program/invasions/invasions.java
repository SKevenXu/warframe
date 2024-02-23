package program.invasions;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.JsonObject;




public class invasions {
    public invasion[] invasions_detail() {
        String text=null;
        try {
            // like https://api.warframestat.us/pc/zh/vallisCycle/
            // cambionCycle是火卫二时间
            // cetusCycle是希图斯时间
            // vallisCycle是金星平原时间
            URL url = new URL("https://api.warframestat.us/pc/zh/invasions/");
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

           
            // 6、显示
        } catch (Exception e) {
            System.out.println("false");
        }
         Gson gson = new Gson();

        invasion[] inv = gson.fromJson(text, invasion[].class);
                

                
                
        return inv;
    }
    public invasion[] inv=invasions_detail();
/*     public String[] attacker=getattackerreward();
    public String[] defender=getdefenderreward(); */
    public String[] getattackerreward(){
        Gson gson = new Gson();
        int num=0;
        String[] attack=new String[inv.length];
        for(int i=0;i<inv.length;i++){
            if(inv[i].completion>0){
                attackerReward att=gson.fromJson(inv[i].attackerReward, attackerReward.class); 
                attack[num]=att.itemString;
                num++;
            }
        }
        
        
        return  attack;
    }
    public String[] getdefenderreward(){
        Gson gson = new Gson();
        int num=0;
        String[] defender=new String[inv.length];
        for(int i=0;i<inv.length;i++){
            if(inv[i].completion>0){
                defenderReward dfe=gson.fromJson(inv[i].defenderReward, defenderReward.class); 
                defender[num]=dfe.itemString;
                num++;
            }
        }
        
        
        return  defender;
    }
    public String[] getnode(){
        int num=0;
        String[] node=new String[inv.length];
        for(int i=0;i<inv.length;i++){
            if(inv[i].completion>0){
            node[num]=inv[i].node;
                num++;
            }
        }
        
        return node;
    }
    public String[] getattackingFaction(){
        int num=0;
        String[] attackingFaction=new String[inv.length];
        for(int i=0;i<inv.length;i++){
            if(inv[i].completion>0){
            attackingFaction[num]=inv[i].attackingFaction;
            num++;
            }
        }
        
        return attackingFaction;
    }
    public String[] getdefendingFaction(){
        int num=0;
        String[] defendingFaction=new String[inv.length];
        for(int i=0;i<inv.length;i++){
            if(inv[i].completion>0){
            defendingFaction[num]=inv[i].defendingFaction;
            num++;
            }
        }
        
        return defendingFaction;
    }
    public String[] getcompletion(){
        int num=0;
        String[] completions=new String[inv.length];
        for(int i=0;i<inv.length;i++){
            if(inv[i].completion>0){
            completions[num]=String.format("%.2f",inv[i].completion);
            num++;
            }
        }

        
        return completions;
    }
  

}
class invasion{
    String activation;
    String node;
    JsonObject attackerReward;
    String attackingFaction; 
    JsonObject defenderReward;
    String defendingFaction;
    float completion;
    boolean completed;

    

    public String getActivation(){
        return activation;
    }
    public void setActivation(String activation){
        this.activation=activation;
    }
    public String getNode(){
        return node;
    }
    public void setNode(String node){
        this.node=node;
    }
    public JsonObject getAttackerReward(){
        return attackerReward;
    }
    public void setAttackerReward(JsonObject attackerReward){
        this.attackerReward=attackerReward;
    }
    public String getAttackingFaction(){
        return attackingFaction;
    }
    public void setAttackingFaction(String attackingFaction){
        this.attackingFaction=attackingFaction;
    } 
    public JsonObject getDefenderReward(){
        return defenderReward;
    }
    public void setDefenderReward(JsonObject defenderReward){
        this.defenderReward=defenderReward;
    }
    public String getDefendingFaction(){
        return defendingFaction;
    }
    public void setDefendingFaction(String defendingFaction){
        this.defendingFaction=defendingFaction;
    }
    public float getCompletion(){
        return completion;
    }
    public void setCompletion(float completion){
        this.completion=completion;
    }
    public boolean getCompleted(){
        return completed;
    }
    public void setCompleted(boolean completed){
        this.completed=completed;
    }
    
}

class attackerReward {
    String itemString;
    public String getItemString(){
        return itemString;
    }   
    public void setItemString(String itemString){
        this.itemString=itemString;
        } 
    }

class defenderReward{
    String itemString;
    public String getItemString(){
        return itemString;
    }   
    public void setItemString(String itemString){
        this.itemString=itemString;
    } 
}



/* [
    {
        
        "activation": "2023-11-15T23:05:11.787Z",
        "node": "Numa (土星)",
        "attackerReward": {
            "itemString": "狙击特昂 破坏者 枪托",
        },
        "attackingFaction": "Corpus",
        "defenderReward": {
            "itemString": "卡拉克 亡魂 蓝图",
        },
        "defendingFaction": "Grineer",
        "completion": 7.316326530612244,
        "completed": false,
    }, */