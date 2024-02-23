package program.Random;

public class Random {
    public int Randomnum(){
        int num;
        num = (int)(Math.random()*34) + 0;
        return num;
    }
    public int Randomriven(int num){
        int rivennum=0;
        
       
        /* num = (int)(Math.random()*2) + 0;
        if(num==1)
            rivennum="false"; */
        rivennum =(int)(Math.random()*num)+0;
        
        
        return rivennum;
    }
    public int RandomnumRiven(){
        int num;
        num = (int)(Math.random()*3) + 2;
        return num;
    }
    public int Weaponnum(){
        int num;
        num = (int)(Math.random()*380) + 0;
        return num;
    }
    

}

