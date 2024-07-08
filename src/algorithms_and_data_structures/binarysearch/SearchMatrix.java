package algorithms_and_data_structures.binarysearch;

/**
 * return true if the target exists in the matrix. False otherwise:
 * Here is a propert of the matrix:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * //time: O(log(m * n))
 * space: O(1)
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix.length == 0 || matrix[0].length == 0 || matrix == null){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = row * col - 1;

        while(left <= right){
            int midVal = (left + right) / 2;
            if(target == matrix[midVal/ col][midVal % col]){
                return true;
            }else if(target > matrix[midVal/ col][midVal % col]){
                left = midVal + 1;
            }else{
                right = midVal - 1;
            }
        }
        return  false;

    }

    public boolean binarySearchII(int[][] matrix, int target){
        if(matrix.length == 0 || matrix[0].length == 0 || matrix == null){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0, bottom = row - 1;

        while(top <= bottom){
            int midRow = (top + bottom)  / 2;
            if(target < matrix[midRow][0]){
                bottom = midRow - 1;
            }else if(target >  matrix[midRow][col - 1]){
                top = midRow + 1;
            }else{
                break;
            }
        }
        if(top > bottom){
            return false;
        }else{
            int midRow = (top + bottom) / 2;
            int right = col - 1;
            int left = 0;
            while(left <= right){
                int mid = (left + right) / 2;
                if(target == matrix[midRow][mid]){
                    return true;
                }else if(target > matrix[midRow][mid]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchMatrix solution = new SearchMatrix();

        // Test cases
        int[][] matrix1 = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target1 = 3;
        System.out.println("Target 3 in matrix1 using method 1: " + solution.searchMatrix(matrix1, target1)); // Should return true
        System.out.println("Target 3 in matrix1 using method 2: " + solution.binarySearchII(matrix1, target1)); // Should return true

        int[][] matrix2 = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target2 = 13;
        System.out.println("Target 13 in matrix2 using method 1: " + solution.searchMatrix(matrix2, target2)); // Should return false
        System.out.println("Target 13 in matrix2 using method 2: " + solution.binarySearchII(matrix2, target2)); // Should return false
    }
}
