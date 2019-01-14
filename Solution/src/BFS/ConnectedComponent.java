package BFS;

public class ConnectedComponent {
  public int countComponents(int n, int[][] edges) {
    if (n <= 1) {
      return n;
    }

    int[] roots = new int[n];
    for (int i = 0; i < n; i++) {
      roots[i] = i;
    }

    for (int[] edge : edges) {
      int x = find(roots, edge[0]);
      int y = find(roots, edge[1]);
      //0 != 1
      if (x != y) {
        //index 0的root就等于1
        //roots[0,1,2,3,4] -> roots[1,1,2,3,4] ->
        roots[x] = y;
        n--;
      }
    }

    return n;
  }

  public int find(int[] roots, int id) {
    int x = id;
    //x = 0 或者1
    //root[0] = 0  roos[1] = 1 所以跳过
    while (roots[id] != id) {
      //把id变成roots[id]
      id = roots[id];
    }

    //
    while (roots[x] != id) {
      //交换
      int fa = roots[x];
      roots[x] = id;
      x = fa;
    }

    return id;
  }

  public static void main(String[] args) {
    ConnectedComponent cc = new ConnectedComponent();
    cc.countComponents(5, new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{3, 4}});
  }
}
