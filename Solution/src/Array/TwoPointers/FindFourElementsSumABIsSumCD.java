package Array.TwoPointers;

import java.util.HashMap;

/*
A Simple Solution is to run four loops to generate all possible quadruples of array element. For every quadruple (a, b, c, d), check if (a+b) = (c+d). Time complexity of this solution is O(n4).

An Efficient Solution can solve this problem in O(n2) time. The idea is to use hashing. We use sum as key and pair as value in hash table.
 Loop i = 0 to n-1 :
    Loop j = i + 1 to n-1 :
        calculate sum
        If in hash table any index already exist
            Then print (i, j) and previous pair
            from hash table
        Else update hash table
    EndLoop;
EndLoop;

1) Extend the above solution with duplicates allowed in array.
2) Further extend the solution to print all quadruples in output instead of just one. And all quadruples should be printed printed in lexicographical order (smaller values before greater ones). Assume we have two solutions S1 and S2.

S1 : a1 b1 c1 d1 ( these are values of indices int the array )
S2 : a2 b2 c2 d2

S1 is lexicographically smaller than S2 iff
  a1 < a2 OR
  a1 = a2 AND b1 < b2 OR
  a1 = a2 AND b1 = b2 AND c1 < c2 OR
  a1 = a2 AND b1 = b2 AND c1 = c2 AND d1 < d2
 */
public class FindFourElementsSumABIsSumCD {
    static class ArrayElements {
        // Class to represent a pair
        class pair {
            int first, second;

            pair(int f, int s) {
                first = f;
                second = s;
            }
        }


        boolean findPairs(int arr[]) {
            // Create an empty Hash to store mapping from sum to
            // pair indexes
            HashMap<Integer, pair> map = new HashMap<Integer, pair>();
            int n = arr.length;

            // Traverse through all possible pairs of arr[]
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    // If sum of current pair is not in hash,
                    // then store it and continue to next pair
                    int sum = arr[i] + arr[j];
                    if (!map.containsKey(sum)) {
                        //记录indices
                        map.put(sum, new pair(i, j));

                    } else // Else (Sum already present in hash)
                    {
                        // Find previous pair
                        pair p = map.get(sum);

                        // Since array elements are distinct, we don't
                        // need to check if any element is common among pairs
                        System.out.println("(" + arr[p.first] + ", " + arr[p.second] +
                                ") and (" + arr[i] + ", " + arr[j] + ")");
                        return true;
                    }
                }
            }
            return false;
        }

        // Testing program
        public static void main(String args[])
        {
            int arr[] = {3, 4, 7, 1, 2, 9, 8};
            ArrayElements a = new ArrayElements();
            a.findPairs(arr);
        }
    }
// This code is contributed by Aakash Hasija
}
