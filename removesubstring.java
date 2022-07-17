import java.util.Scanner;

public class removesubstring {

        static void getarr(String str, int arrry1[])
        {
            int n = str.length();
            int k,s = 0,l = 0;
            for (int i = 1; i < n; i++) {
                if (i > l) {
                    s = l = i;
                    while (l < n && str.charAt(l - s) == str.charAt(l))
                    {
                        l++;
                    }
                    arrry1[i] = l - s;
                    l--;
                }
                else {
                    k = i - s;
                    if (arrry1[k] < l - i + 1) {
                        arrry1[i] = arrry1[k];
                    }
                    else {
                        s = i;
                        while (l < n && str.charAt(l - s) == str.charAt(l)) {
                            l++;
                        }
                        arrry1[i] = l - s;
                        l--;
                    }
                }
            }
        }
        static String removestr(String str, String word) {
            String concat = word + "$" + str;
            int l = concat.length();
            int []r = new int[l];

            getarr(concat, r);
            String res="";
            int Size = word.length();

            for (int i = 0; i < l; ++i) {
                if (i + Size < l - 1 && r[i + Size + 1] == Size) {
                    i += Size - 1;
                }
                else if (i < str.length()) {
                    res += str.charAt(i);
                }
            }
            return res;
        }
        public static void main(String[] args)
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("enter the string");
            String str = sc.nextLine();
            System.out.println("enter string to remove");
            String substring = sc.nextLine();

            System.out.print(removestr(str, substring));
        }
    }


