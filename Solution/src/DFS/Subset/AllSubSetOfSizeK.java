package DFS.Subset;

public class AllSubSetOfSizeK {
    //Now for every inte­ger we have two options, whether to select it or ignore it.
    //Now if we select it, we will put TRUE in the boolean array at the cor­re­spond­ing index or if we ignore it, put FALSE at that index.
    //Print the ele­ments when cur­rentLength = k.

    //curlen is the number of char we have selected
    // in this problem, we need to care for the length of the result string
    public void subset(int[] A, int k, int index, int currLen, boolean[] used) {
        //一定要查看
        if (currLen == k) {
            for (int i = 0; i < A.length; i++) {
                if (used[i] == true) {
                    System.out.print(A[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        if (index == A.length) {//base case, below the last level of the tree
            return;
        }
        // For every index we have two options,
        // 1.. Either we select it, means put true in used[] and make currLen+1
        used[index] = true;
        subset(A, k, index + 1, currLen + 1, used);
        // 2.. OR we dont select it, means put false in used[] and dont increase
        // currLen
        used[index] = false;
        subset(A, k, index + 1, currLen, used);
    }

    public static void main(String[] args) {
        int A[] = { 1, 2, 3, 4, 5 };
        boolean[] B = new boolean[A.length];
        AllSubSetOfSizeK i = new AllSubSetOfSizeK();
        i.subset(A, 3, 0, 0, B);

    }

}
