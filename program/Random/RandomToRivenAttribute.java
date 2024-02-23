package program.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;



import java.util.ArrayList;
import java.util.List;



public class RandomToRivenAttribute {
	

	public String randomattribute(int num) {
        String name_url=null;
        Gson gson = new Gson();
        String reader=readJsonData("program\\Random\\rivenattribute.json");
		
		
			JsonObject jsonObject = new JsonParser().parse(reader).getAsJsonObject();
            
    //再转JsonArray 加上数据头
            JsonArray jsonArray = jsonObject.getAsJsonArray("attributes");


            ArrayList<attributes> attributes = new ArrayList<>();

    //循环遍历
            for (JsonElement user : jsonArray) {
        //通过反射 得到UserBean.class
                attributes att = gson.fromJson(user, new TypeToken<attributes>() {}.getType());
                attributes.add(att);
            }
			
			/* payload pay =gson.fromJson(reader, payload.class); */
			
				System.out.println("词条:\t"+attributes.get(num).effect);
				System.out.println("url:\t"+attributes.get(num).url_name);
				if(attributes.get(num).exclusive_to!=null){
					for(int j=0;j<attributes.get(num).exclusive_to.length;j++){
						System.out.println("适用于\t"+attributes.get(num).exclusive_to[j]);
					}
				}
				else{
					System.out.println("该词条为通用词条"+"\n");
				}
				name_url=attributes.get(num).effect;
				System.out.println("\n");
			
			/* System.out.println(attributes.get(0).url_name); */
			/* System.out.println("success"); */
				

				/* for(int i=0;i<attributes.size();i++){
					if(attributes.get(i).exclusive_to==null)
						shotgunnum++;
					if(attributes.get(i).exclusive_to!=null){
						for(int j=0;j<attributes.get(i).exclusive_to.length;j++){
						if (attributes.get(i).exclusive_to[j]=="shotgun") {
							shotgunnum++;
						}
					}
					}
					
				}
				System.out.println("shotgun:"+shotgunnum); */
				
 				/* String[] shotgunriven=new String[attributes.size()]; */







           return name_url;
            

}

    public static String readJsonData(String pactFile){
		// 读取文件数据
		//System.out.println("读取文件数据util");
		
		StringBuffer strbuffer = new StringBuffer();
		File myFile = new File(pactFile);//"D:"+File.separatorChar+"DStores.json"
		if (!myFile.exists()) {
			System.err.println("Can't Find " + pactFile); 
		}
		try {
			FileInputStream fis = new FileInputStream(pactFile);
			InputStreamReader inputStreamReader = new InputStreamReader(fis, "UTF-8");
			BufferedReader in  = new BufferedReader(inputStreamReader);
			
			String str;
			while ((str = in.readLine()) != null) {
				strbuffer.append(str);  //new String(str,"UTF-8")
			}
			in.close();
		} catch (IOException e) {
			e.getStackTrace();
		}
		//System.out.println("读取文件结束util");
		return strbuffer.toString();
	}

}

class payload{
	List<attributes> attributes;
	public List<attributes> getAttributes(){
		return attributes;
	}
	public void setAttributes(List<attributes> attributes){
		this.attributes=attributes;
	}
}
class attributes{
	String group;
	String[] exclusive_to;
	String url_name;
	String units;
	String effect;
	public String getGroup(){
		return group;
	}
	public void setGroup(String group){
		this.group=group;
	}
	public String[] getExclusive_to(){
		return exclusive_to;
	}
	public void setExclusive_to(String[] exclusive_to){
		this.exclusive_to=exclusive_to;
	}
	public String getUrl_name(){
		return url_name;
	}
	public void setUrl_name(String url_name){
		this.url_name=url_name;
	}
	public String getUnits(){
		return units;
	}
	public void setUnits(String units){
		this.units=units;
	}
	public String getEffect(){
		return effect;
	}
	public void setEffect(String effect){
		this.effect=effect;
	}
	
}

