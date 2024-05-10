package program.ducatssearch;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

import program.getItemUrlName.itemurlget;

public class Main {
    public static void main(String[] args) {

        /*
         * ducatsget du = new ducatsget();
         * itemurlget it = new itemurlget();
         * int num = it.getitemurl().length;
         */
        ducatsget du = new ducatsget();
        itemurlget it = new itemurlget();
        // String[] name = new String[du.getid().length];
        // for (int i = 0; i < du.getid().length; i++) {
        // for (int j = 0; j < it.getid().length; j++) {
        // if (du.getitem()[i].hashCode() == it.getid()[j].hashCode()) {
        // name[i] = it.getitemname()[j];
        // System.out.println(name[i]);
        // }
        // }
        // }
        // ArrayList<String> name = contains(du.getitem(), it.getid(),
        // it.getitemname());
        ArrayList<String> name = sethash(du.getitem(), it.getid(), it.getitemname());
        for (int i = 0; i < du.getid().length; i++) {
            System.out.println("物品id:\t" + du.getid()[i]);
            System.out.println("物品名字:\t" + name.get(i));
            // System.out.println("物品白金:\t" + du.getplat_worth()[i]);
            System.out.println("物品杜卡德:\t" + du.getducats()[i]);
            System.out.println("物品平均白金:\t" + du.getducats_per_platinum()[i]);
            System.out.println("物品刷新时间:\t" + du.getdatetime()[i]);
            System.out.println("\n");
        }

        // for (int i = 0; i < it.getitemname().length; i++) {

        // System.out.println(it.getid()[i]);
        // System.out.println(it.getitemname()[i]);
        // System.out.println(it.getitemurl()[i]);
        // System.out.println();

        // }
        /*
         * search_id sea = new search_id();
         * sea.getname();
         */

        /*
         * urlname_search u = new urlname_search();
         * System.out.println(u.geturlname()[0]);
         */

    }

    // public static ArrayList<String> contains(String[] array1, String[] array2,
    // String[] array3) {
    // ArrayList<String> array = new ArrayList<String>();
    // int num = 0;
    // // Arrays.sort(array1);
    // // Arrays.sort(array2);
    // for (String string : array2) {
    // if (ArrayUtils.contains(array1, string)) {
    // array.add(array3[num]);
    // System.out
    // .println("相同元素:" + string + "\t\t" + array1[num] + "\t\t" + array2[num] +
    // "\t\t" + array3[num]
    // + "\t\t" + array.get(num));
    // num++;
    // } else {
    // System.out.println("no");
    // }
    // }

    // return array;
    // }

    public static ArrayList<String> sethash(String[] array2, String[] array1, String[] array3) {
        // int[] array3=new int[array2.length];
        ArrayList<String> array = new ArrayList<String>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < array2.length; i++) {
            set.add(array2[i]);
        }
        for (int i = 0; i < array1.length; i++) {
            if (set.contains(array1[i])) {
                array.add(array3[i]);
                // System.out.println(array1[i] + "\t\ti=" + i + "\t\tname=" + array3[i]);
            }
        }
        return array;
    }
}
