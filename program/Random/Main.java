package program.Random;

import java.io.IOException;




public class Main {

    public static void main(String[] args)  throws IOException{
        Random ra=new Random();
        RandomToRivenAttribute rta=new RandomToRivenAttribute();
        weaponname wn=new weaponname();
        int rivennum=ra.RandomnumRiven();
        int temp=ra.Randomriven(rivennum);
        String[] riven=new String[rivennum];




        for(int i=0;i<rivennum;i++){
            riven[i]=rta.randomattribute(ra.Randomnum());
        }
        for(int i=0;i<riven.length;i++){
            System.out.println(riven[i]);
        }
        System.out.println(temp+"\n");


        System.out.println(wn.ReadGsonTest(ra.Weaponnum()));
        for(int i=0;i<riven.length;i++){
            if(i!=temp){
                System.out.println("+"+riven[i]);
            }
        }
        System.out.println("-"+riven[temp]);
        
        
       
        
        

        
    }
}
