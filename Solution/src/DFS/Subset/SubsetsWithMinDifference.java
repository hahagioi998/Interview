package DFS.Subset;

public class SubsetsWithMinDifference {
    int total = 0;
    public int minDifference(int[] array) {
        // Write your solution here.
        int[] min = new int[]{Integer.MAX_VALUE};
        for(int i : array){
            total += i;
        }
        StringBuilder sb = new StringBuilder();
        helper(array, 0, min, 0, 0);
        return min[0];
    }

    private void helper(int[] array, int index, int[] min, int count, int sum){
        // if(index > array.length/2){ //not correct, because each level represents element, some element are not choosen

        if(index == array.length){//base case
            return;
        }

        //加
        sum += array[index];
        count++;
        if(count == array.length/2){ //length问题的变形
            min[0] = Math.min(min[0], Math.abs((total - sum) - sum));
        }
        helper(array, index + 1, min, count, sum);
        sum -= array[index];
        count--;

        //不加
        helper(array, index + 1, min, count, sum);// still has to do index + 1
    }
}
