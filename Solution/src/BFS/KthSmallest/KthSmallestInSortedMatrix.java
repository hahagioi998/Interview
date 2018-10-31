package BFS.KthSmallest;

import java.util.Comparator;
import java.util.PriorityQueue;

//利用点和邻近点的关系做BFS，BFS可以找最短的路径
public class KthSmallestInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {

        //create a min heap
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                if (c1.value == c2.value) {
                    return 0;
                }
                return c1.value > c2.value ? 1 : -1;
            }
        });

        int row = matrix.length;
        int column = matrix[0].length;

        boolean[][] visited = new boolean[row][column];
        visited[0][0] = true;

        pq.offer(new Cell(0, 0, matrix[0][0])); //push in the first number

        for (int i = 0; i < k - 1; i++) {//the initial one is put into the queue

            Cell cell = pq.poll();

            if (cell.row + 1 < row && !visited[cell.row + 1][cell.column]) {
                visited[cell.row + 1][cell.column] = true;
                pq.offer(new Cell(cell.row + 1, cell.column, matrix[cell.row + 1][cell.column]));
            }
            if (cell.column + 1 < column && !visited[cell.row][cell.column + 1]) {
                visited[cell.row][cell.column + 1] = true;
                pq.offer(new Cell(cell.row, cell.column + 1, matrix[cell.row][cell.column + 1]));
            }
        }

        return pq.poll().value;//smallest is on the top
    }


    class Cell{
        int row;
        int column;
        int value;

        Cell(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }
}
