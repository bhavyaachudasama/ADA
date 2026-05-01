import java.util.Scanner;

public class CoinChangeDP {

   
    public static int coinChange(int coins[], int n, int amount) {

        int dp[] = new int[amount + 1];

      
        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0; 

       
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {

                if (coins[j] <= i) {
                    int subResult = dp[i - coins[j]];

                    if (subResult != Integer.MAX_VALUE && subResult + 1 < dp[i]) {
                        dp[i] = subResult + 1;
                    }
                }
            }
        }

       
        if (dp[amount] == Integer.MAX_VALUE)
            return -1;

        return dp[amount];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of coin types: ");
        int n = sc.nextInt();

        int coins[] = new int[n];

        System.out.println("Enter coin values:");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        System.out.print("Enter amount: ");
        int amount = sc.nextInt();

        long startTime = System.nanoTime();

        int result = coinChange(coins, n, amount);

        long endTime = System.nanoTime();

        if (result == -1)
            System.out.println("Change cannot be made.");
        else
            System.out.println("Minimum coins required: " + result);

        System.out.println("Execution Time (ns): " + (endTime - startTime));

        sc.close();
    }
}