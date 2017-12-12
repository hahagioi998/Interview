package String.Calculation;
/*
A thief trying to escape from a jail. He has to cross N walls each with varying heights (every height is greater than 0). He climbs X feet every time. But, due to the slippery nature of those walls, every time he slips back by Y feet. Now the task is to calculate the total number of jumps required to cross all walls and escape from the jail.
 */
public class ThiefEscape {
    /* function to calculate jumps required
     to cross walls */
    static int jumpcount(int x, int y, int n,
                         int height[])
    {
        int jumps = 0;

        for (int i = 0; i < n; i++) {
            if (height[i] <= x) {
                jumps++;
                continue;
            }

            /* If height of wall is greater than
               up move */
            int h = height[i];
            while (h > x)
            {
                jumps++;
                h = h - (x - y);
            }
            jumps++;
        }
        return jumps;
    }

    /*driver function*/
    public static void main(String args[])
    {
        int x = 10, y = 1;
        int height[] = { 11, 10, 10, 9 };
        int n = height.length;
        System.out.println(jumpcount(x, y, n, height));
    }
}
