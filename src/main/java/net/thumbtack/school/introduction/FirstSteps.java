package net.thumbtack.school.introduction;

public class FirstSteps {

    public int sum(int x, int y) {//1
        return x + y;
    }

    public int mul(int x, int y) {//2
        return x * y;
    }

    public int div(int x, int y) {//3
        return x / y;
    }

    public int mod(int x, int y) {//4
        return x % y;
    }

    public boolean isEqual(int x, int y) {//5
        return x == y;
    }

    public boolean isGreater(int x, int y) {//6
        return x > y;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight,
                                int yBottom, int x, int y) {//7
        return xLeft <= x && xRight >= x && yTop <= y && yBottom >= y;
    }

    public int sum(int[] array) {//8
        int sum = 0;
        for (int element : array)
            sum += element;
        return sum;
    }

    public int mul(int[] array) {//9
        if (array.length == 0) return 0;
        else {
            int mul = 1;
            for (int element : array)
                mul *= element;
            return mul;
        }
    }

    public int min(int[] array) {//10
        int min = Integer.MAX_VALUE;
        for (int element : array)
            if (min > element) min = element;
        return min;
    }

    public int max(int[] array) {//11
        int max = Integer.MIN_VALUE;
        for (int element : array)
            if (max < element) max = element;
        return max;
    }

    public double average(int[] array) {//12
        if (array.length == 0) return 0;
        else {
            int sum = 0;
            for (int element : array)
                sum += element;
            return (double) sum / array.length;
        }
    }

    public static boolean isSortedDescendant(int[] array) {//13
        for (int i = 0; i < array.length - 1; i++)
            if (array[i] <= array[i + 1])
                return false;
        return true;
    }

    public void cube(int[] array) {//14
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i] * array[i];
        }
    }

    public boolean find(int[] array, int value) {//15
        for (int element : array) {
            if (element == value)
                return true;
        }
        return false;
    }

    public void reverse(int[] array) {//16
        int element;
        for (int i = 0; i < array.length / 2; i++) {
            element = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = element;
        }
    }

    public boolean isPalindrome(int[] array) {//17
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i])
                return false;
        }
        return true;
    }

    public int sum(int[][] matrix) {//18
        int sum = 0;
        for (int[] array : matrix) {
            for (int element : array) {
                sum += element;
            }
        }
        return sum;
    }

    public int max(int[][] matrix) {//19
        int max = Integer.MIN_VALUE;
        for (int[] array : matrix) {
            for (int element : array)
                if (max < element) max = element;
        }
        return max;
    }

    public int diagonalMax(int[][] matrix) {//20
        if (matrix.length == 0 || matrix.length == 1)
            return Integer.MIN_VALUE;
        else {
            int max = matrix[0][0];
            for (int i = 0; i < matrix.length; i++) {
                if (max < matrix[i][i]) max = matrix[i][i];
            }
            return max;
        }
    }

    public static boolean isSortedDescendant(int[][] matrix) {//21
        for (int[] array : matrix) {
            if (!isSortedDescendant(array))
                return false;
        }
        return true;
    }
}