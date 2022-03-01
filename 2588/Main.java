import java.util.Scanner;
public class Main {

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int a, b;
        a = input.nextInt();
        b = input.nextInt();

        int q, w, z;

        q = b - b/10*10;
        w = (b/10*10 - b/100*100)/10;
        z = b/100;

        System.out.println(a*q);
        System.out.println(w*a);
        System.out.println(z*a);
        System.out.println(a*b);
    }
}

