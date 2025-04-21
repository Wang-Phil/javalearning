package matiji;

import java.util.Scanner;

/**
 * @version 1.0
 * @auther wangweicheng
 *
 */
public class Competition11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // code here
        int ours = input.nextInt();
        int enemy = input.nextInt();
        int oBlood[] = new int[ours];
        int oPower[] = new int[ours];
        int eBlood[] = new int[enemy];
        int ePower[] = new int[enemy];
        for(int i = 0; i < ours; i++){
            oBlood[i] = input.nextInt();
            oPower[i] = input.nextInt();
        }
        for(int i =0; i < enemy; i++){
            eBlood[i] = input.nextInt();
            ePower[i] = input.nextInt();
        }
        int o = 0, e = 0;
        while(o < ours && e < enemy){
            int o_hurt = oBlood[o] / ePower[e];     //可以承受o_hurt次攻击
            if(oBlood[o] % ePower[e] != 0){
                o_hurt++;
            }
            int e_hurt = eBlood[e] / oPower[o];     //可以承受e_hurt次攻击
            if(eBlood[e] % oPower[o] != 0){
                e_hurt++;
            }
            int final_hurt = Math.min(e_hurt, o_hurt);
            oBlood[o] -= ePower[e]*final_hurt;
            eBlood[e] -= oPower[o]*final_hurt;
            if(oBlood[o] <= 0){
                o++;
            }
            if(eBlood[e] <= 0){
                e++;
            }
        }
        if(o < ours){
            System.out.println("Win");
        }else if(e < enemy){
            System.out.println("QAQ");
        }else{
            System.out.println("Fine");
        }
        input.close();
    }
}
