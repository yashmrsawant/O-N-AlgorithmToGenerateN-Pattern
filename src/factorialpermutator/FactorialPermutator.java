/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorialpermutator;


/**
 *
 * @author yashmsawant
 */
public class FactorialPermutator {

    
    /**
     * @param args the command line arguments
     */
    static int SIZE;
    static int counter = 0;
    public static void main(String[] args) {
        int N = 0;
        SIZE = N;
        int factOfN = 1;
        System.out.println(counter);
        int suffix[] = new int[N];
        for (int i = 0; i < N; i++) {
            suffix[i] = i;
        }
        int prefix[] = {};
        permute(0, prefix, suffix);
//        traditionalPermute(N, suffix, 0);
        System.out.println(counter);
    }

    public static void traditionalPermute(int n, int arr[], int i) {
        int j;
        if (i == n) {
            System.out.print(arr[i]);
        } else {
            for (j = i; j < n; j++) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                traditionalPermute(n, arr, i + 1);
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
    /**
     * 
     * @param startIndex is the position of the suffix first element 
     * @param prefix is the prefix of the pattern 
     * @param suffix is the suffix of the pattern, will determine the complexity
     *  permute method.
     *
     * 
     * The block <code>if (suffix.length == 1)</code> will print
     * the only possible combination of suffix and return for computing next
     * combination.
     *
     *
     * The part after <code>if (suffix.length == 1)</code> is reached if suffix
     * length is not 1 that is there may be many possible combination of suffix
     * therefore make a <code>newSuffix</code> which will have suffix length
     * <code>(suffix.length - 1)</code> and recursively compute the possible
     * combination of this new suffix and also the original suffix prefix
     * positioned by <code>startIndex</code> will change by increasing its value
     * by one <code>(startIndex + 1) % suffix.length</code>
     * 
     * 
     * T(N) = N * T(N - 1) + N
     *      = N! + N!(1 + 1/N + 1/(N * (N - 1)) + ... + 1/N!)
     *      
     *
     */
    public static void permute(int startIndex, int prefix[], int suffix[]) {
        if (suffix.length == 1) {
            for (int i = 0; i < prefix.length; i++) {
                System.out.print(prefix[i] + " ");
                }
            System.out.print(suffix[0]);
            System.out.println(" ");
            return;
        }
  
        for (int i = 0; i < suffix.length; i++) {
            counter++;
            int newPrefix[] = new int[prefix.length + 1];
            System.arraycopy(prefix, 0, newPrefix, 0, prefix.length);
            newPrefix[prefix.length] = suffix[startIndex];
            int newSuffix[] = new int[suffix.length - 1];
            for (int j = 1; j < suffix.length; j++) {
                newSuffix[j - 1] = suffix[(startIndex + j) % suffix.length];
            }
            permute((startIndex % newSuffix.length), newPrefix, newSuffix);
            startIndex = (startIndex + 1) % suffix.length;
        }
    }
}
