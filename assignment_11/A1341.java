package assignment_11;

import java.util.Scanner;

public class A1341 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            System.out.println(helper(n, a, b, c, d));
        }
    }

    public static String helper(int n, int a, int b, int c, int d) {
        int minWt = n*(a - b);
        int maxWt = n*(a + b);

        for(int i=c-d; i<=c+d; i++){
            if(i>=minWt && i<=maxWt){
                return "YES";
            }
        }
        return "NO";
    }
}
