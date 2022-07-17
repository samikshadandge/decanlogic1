import java.util.Scanner;

public class partition {
        static int findMin(int arr[], int n)
        {
            int sum = 0;
            for (int i = 0; i < n; i++)
                sum =sum+ arr[i];
            boolean arrr2[][] = new boolean[n + 1][sum + 1];
            for (int i = 0; i <= n; i++)
                arrr2[i][0] = true;
            for (int i = 1; i <= sum; i++)
                arrr2[0][i] = false;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= sum; j++) {
                    arrr2[i][j] = arrr2[i - 1][j];
                    if (arr[i - 1] <= j)
                        arrr2[i][j] |= arrr2[i - 1][j - arr[i - 1]];
                }
            }
            int diff = Integer.MAX_VALUE;
            for (int j = sum / 2; j >= 0; j--) {
                if (arrr2[n][j] == true) {
                    diff = sum - 2 * j;
                    break;
                }
            }
            return diff;
        }



        public static void main(String[] args)
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("enter the size of array");
            int n= sc.nextInt();
            int[] arr=new int[n];
            System.out.println("enter array element");
            for (int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            System.out.print("The minimum difference two set" + findMin(arr, n));
        }
    }


