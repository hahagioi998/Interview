package DFS.Subset;

public class MaxSumKnonOverlappingSubarray {
  static void calculatePresumArray(int presum[],
      int arr[],
      int n, int k)
  {
    for (int i = 0; i < k; i++)
      presum[0] += arr[i];

    // store sum of array index i to i+k
    // in presum array at index i of it.
    for (int i = 1; i <= n - k; i++)
      presum[i] += presum[i - 1] + arr[i + k - 1] -
          arr[i - 1];
  }

  // calculating maximum sum of
// m non overlapping array
  static int maxSumMnonOverlappingSubarray(int presum[],
      int m, int size,
      int k, int start)
  {
    // if m is zero then no need
    // any array of any size so
    // return 0.
    if (m == 0)
      return 0;

    // if start is greater then the
    // size of presum array return 0.
    if (start > size - 1)
      return 0;

    int mx = 0;

    // if including subarray of size k
    int includeMax = presum[start] +
        maxSumMnonOverlappingSubarray(presum,
            m - 1, size, k, start + k);

    // if excluding element and searching
    // in all next possible subarrays
    int excludeMax =
        maxSumMnonOverlappingSubarray(presum,
            m, size, k, start + 1);

    // return max
    return Math.max(includeMax, excludeMax);
  }

  // Driver code
  public static void main (String[] args)
  {
    int arr[] = { 2, 10, 7, 18, 5, 33, 0 };
    int n = arr.length;
    int m = 3, k = 2;
    int presum[] = new int[n + 1 - k] ;
    calculatePresumArray(presum, arr, n, k);

    // resulting presum array
    // will have a size = n+1-k
    System.out.println(maxSumMnonOverlappingSubarray(presum,
        m, n + 1 - k, k, 0));
  }
}
