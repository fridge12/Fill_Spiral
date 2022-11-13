import java.util.Scanner;

public class Spiral_Array {

    static int a[][];
    static int b;
    static int mid;
    public static void main(String[] args) {
        System.out.println("enter size");
        Scanner in = new Scanner(System.in);
        b = in.nextInt();
        a= new int[b][b];
        mid = (int)(((double)b/2.0)-0.5);
        fillArray();
        display();
    }

    public static void display(){
        for(int i =0;i<b;i++){
            for(int j =0;j<b;j++){
                String s = (a[i][j]<10)?"  ":" ";
                System.out.print(a[i][j]+s );
            }
            System.out.println("");
        }
    }


    public static void fillArray(){
        int b = Spiral_Array.b - ((Spiral_Array.b%2)-1);
        for (int i = 0; i < b * b; i++) {
            try {
                int irelative = (i / b) - (mid - ((Spiral_Array.b % 2) - 1));
                int jrelative = (i % b) - (mid - ((Spiral_Array.b % 2) - 1));

                int sum = irelative + jrelative;

                int cont = a[(sum>0)? -1 : 0][0];

                try {
                    if (a[(irelative) + mid][(jrelative) + mid] == 0) {
                        int val = (Math.abs(irelative) >= Math.abs(jrelative)) ? (2 * Math.abs(irelative) + 1) * (2 * Math.abs(irelative) + 1) + sum : (2 * jrelative) * (2 * jrelative) - sum + 1;

                        try {
                            a[irelative + mid][jrelative + mid] = val;
                        }
                        catch (Exception e) {}


                        try {
                            a[(-irelative) + mid][(-jrelative) + mid] = val - Math.max(Math.abs(irelative), Math.abs(jrelative)) * 4;
                        } catch (Exception e) {
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    try {
                        int val = (Math.abs(irelative) >= Math.abs(jrelative)) ? (2 * Math.abs(irelative) + 1) * (2 * Math.abs(irelative) + 1) + sum : (2 * jrelative) * (2 * jrelative) - sum + 1;
                        a[(-irelative) + mid][(-jrelative) + mid] = val - Math.max(Math.abs(irelative), Math.abs(jrelative)) * 4;
                    } catch (ArrayIndexOutOfBoundsException e2) {
                    }
                }
            }
            catch(Exception e){}
        }
    }
}