package BinarySearch.SearchInRotatedArray;
/*
There could be duplicate elements in the array.
A = {3, 4, 5, 1, 2}, T = 4, return 1
        A = {3, 3, 3, 1, 3}, T = 1, return 3
        A = {3, 1, 3, 3, 3}, T = 1, return 1 */
// 这个问题在面试中不会让实现完整程序
// 只需要举出能够最坏情况的数据是 [1,1,1,1... 1] 里有一个0即可。
// 在这种情况下是无法使用二分法的，复杂度是O(n)
// 因此写个for循环最坏也是O(n)，那就写个for循环就好了
//  如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情况的情况，那你就写一个二分吧。
//  反正面试考的不是你在这个题上会不会用二分法。这个题的考点是你想不想得到最坏情况。
public class SearchInShiftedSortedArrayII {
    public int search(int[] A, int target) {
        if(A == null || A.length == 0){
            return -1;
        }
        for (int i = 0; i < A.length; i ++) {
            if (A[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
