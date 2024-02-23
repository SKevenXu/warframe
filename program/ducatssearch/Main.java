package program.ducatssearch;

import program.getItemUrlName.itemurlget;

public class Main {
    public static void main(String[] args) {
        ducatsget du=new ducatsget();
        itemurlget it=new itemurlget();
        String temp[]=du.ducats_detail(it.getoneurlname("和平·高飞")).clone();
        /* System.out.println(du.ducats_detail(it.getoneurlname("Zephyr Prime 机体 蓝图"))[0]);
        System.out.println(du.ducats_detail(it.getoneurlname("Zephyr Prime 机体 蓝图"))[1]); */
        System.out.println(temp[0]+"\n"+temp[1]);
    }
}
