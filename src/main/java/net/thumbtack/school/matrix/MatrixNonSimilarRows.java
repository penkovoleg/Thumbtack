package net.thumbtack.school.matrix;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class MatrixNonSimilarRows {

    private int[][] matrix;

    public MatrixNonSimilarRows(int[][] matrix) {
        this.matrix = matrix;
    }

    public Set<int[]> getNonSimilarRows() {
        Set<int[]> result = new CopyOnWriteArraySet<>();
        for (int[] element : matrix)
            result.add(element);

        HashSet<Integer> firstHs = new HashSet<>();
        HashSet<Integer> secondHs = new HashSet<>();
        for (int[] array : matrix) {
            for (int element : array) {
                firstHs.add(element);
            }
            int count = 0;
            for (int[] array1 : matrix) {
                for (int element1 : array1) {
                    secondHs.add(element1);
                }
                if (firstHs.equals(secondHs)) {
                    if (count > 0) result.remove(array1);
                    count++;
                }
                secondHs.clear();
            }
            firstHs.clear();
        }
        return result;
    }

}
