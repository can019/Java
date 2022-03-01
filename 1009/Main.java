import java.util.Scanner;
import java.lang.Math;
public class Main {

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int seq = input.nextInt();
        int [][] num = new int[seq][2];
        double last ,tmp;
        for (int i = 0; i < seq; i++){
            num[i][0] = input.nextInt();
            num[i][1] = input.nextInt();
        }
        for(int i = 0; i < seq; i++){
            last=1;
            if(num[i][0]%10==0)
                System.out.println(10);
            else{
                for(int j = 0; j < num[i][1];j++){
                    tmp = last*num[i][0];
                    last=(tmp-(Math.floor(tmp/10)*10));
                }
                System.out.println((int)last);
            }

        }
    }
}
