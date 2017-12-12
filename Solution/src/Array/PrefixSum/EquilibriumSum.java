package Array.PrefixSum;
/*
The idea is to get total sum of array first. Then Iterate through the array and keep updating the left sum which is initialized as zero. In the loop, we can get right sum by subtracting the elements one by one. Thanks to Sambasiva for suggesting this solution and providing code for this.
 */
//Time Complexity: O(n)
public class EquilibriumSum {
    int equilibrium(int arr[], int n)
    {
        int sum = 0;      // initialize sum of whole array
        int leftsum = 0; // initialize leftsum

        /* Find sum of the whole array */
        for (int i = 0; i < n; ++i)
            sum += arr[i];

        for (int i = 0; i < n; ++i)
        {
            sum -= arr[i]; // sum is now right sum for index i

            //在这里查的话，正好leftsum是没有包括arr[i]的，而sum又减掉了arr[i]
            if (leftsum == sum)
                return i;

            leftsum += arr[i];
        }

        /* If no equilibrium index found, then return 0 */
        return -1;
    }

    public static void main(String[] args)
    {
        EquilibriumSum equi = new EquilibriumSum();
        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        int arr2[] = { 2, 3, 4, 1, 4, 5 };
        int arr_size = arr.length;
        System.out.println("First equilibrium index is " +
                equi.equilibrium(arr2, arr_size - 1));
    }
}
