import java.util.Scanner;

public class SCS_DP {

    
    public static String scs(String X, String Y) {

        int m = X.length();
        int n = Y.length();

        int dp[][] = new int[m + 1][n + 1];

       
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i == 0 || j == 0)
                    dp[i][j] = 0;

                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        
        int i = m, j = n;
        StringBuilder scs = new StringBuilder();

        while (i > 0 && j > 0) {

            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                scs.append(X.charAt(i - 1));
                i--;
                j--;
            }

            else if (dp[i - 1][j] > dp[i][j - 1]) {
                scs.append(X.charAt(i - 1));
                i--;
            }

            else {
                scs.append(Y.charAt(j - 1));
                j--;
            }
        }

     
        while (i > 0) {
            scs.append(X.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            scs.append(Y.charAt(j - 1));
            j--;
        }

        return scs.reverse().toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String X = sc.nextLine();

        System.out.print("Enter second string: ");
        String Y = sc.nextLine();

        long startTime = System.nanoTime();

        String result = scs(X, Y);

        long endTime = System.nanoTime();

        System.out.println("Shortest Common Supersequence: " + result);
        System.out.println("Length: " + result.length());
        System.out.println("Execution Time (ns): " + (endTime - startTime));

        sc.close();
    }
}