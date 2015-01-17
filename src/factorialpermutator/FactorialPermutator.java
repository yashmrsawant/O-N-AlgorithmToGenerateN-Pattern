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
        int N = 6;
        SIZE = N;
        int factOfN = 1;
        System.out.println(counter);
        int suffix[] = new int[N];
        for(int i = 0 ; i < N ; i++) {
            suffix[i] = i;
        }
        int prefix[] = {};
        permutator(0, prefix, suffix);
        System.out.println(counter / (N * factOfN));
    }
    public static void permutator(int startIndex, int prefix[], int suffix[]) {
        
        if(suffix.length == 1) {
            for(int i = 0 ; i < prefix.length ; i++) {
                System.out.print(prefix[i]);
            }
            System.out.print(suffix[0]);
            System.out.println();
            return;
        }
        for(int i = 0 ; i < suffix.length ; i++) {
            counter++;
            int newPrefix[] = new int[prefix.length + 1];
            for(int j = 0 ; j < prefix.length ; j++) {
                newPrefix[j] = prefix[j];
            }

            newPrefix[prefix.length] = suffix[startIndex];
            int newSuffix[] = new int[suffix.length - 1];
            
            for(int j = 1 ; j < suffix.length ; j++) {
                newSuffix[j - 1] = suffix[(startIndex + j) % suffix.length];
            }
            
            permutator((startIndex % newSuffix.length), newPrefix, newSuffix);
            startIndex = (startIndex + 1) % suffix.length;
        }
    }
}
