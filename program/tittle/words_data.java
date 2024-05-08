package program.tittle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.google.gson.Gson;

public class words_data {
    public demo word_data(String file) {
        String text = null;
        try {
            // https://api.warframe.market/v1/items
            text = readJsonData(file);
            // System.out.println(text);
        } catch (Exception e) {
            System.out.println("false");
        }
        Gson gson = new Gson();
        demo demo = gson.fromJson(text, demo.class);

        return demo;
    }

    demo demo = word_data("program/tittle/words.txt");

    public void getname() {
        System.out.println(demo.payload.get(0).length());
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

/**
 * Innerwords_data
 */
class demo {
    public List<String> payload;

    public List<String> getPayload() {
        return payload;
    }

    public void setPayload(List<String> payload) {
        this.payload = payload;
    }
}

class payload {
    public String name;
    public List<String> levelStats;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLevelStats() {
        return levelStats;
    }

    public void setLevelStats(List<String> levelStats) {
        this.levelStats = levelStats;
    }
}

class levelStats {
    List<String> stats;

    public List<String> getStats() {
        return stats;
    }

    public void setStats(List<String> stats) {
        this.stats = stats;
    }
}
