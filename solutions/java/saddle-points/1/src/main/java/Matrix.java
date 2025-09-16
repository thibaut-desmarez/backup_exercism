import java.util.*;

public class Matrix {

    private List<List<Integer>> matrix;

    Matrix(List<List<Integer>> values) {
        this.matrix = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> saddlePoints = new HashSet<>();
        for (int row = 0 ; row < matrix.size(); row++) {
            Integer largestTreeOfRow = findLargest(matrix.get(row));
            for(int col = 0 ; col < matrix.get(row).size(); col++) {
                Integer smallestTreeOfCol = findSmallest(col);
                if(largestTreeOfRow.equals(smallestTreeOfCol)) {
                    saddlePoints.add(new MatrixCoordinate(row+1, col+1));
                }
            }
        }
        return saddlePoints;
    }

    Integer findLargest(List<Integer> row){
        return row.stream().max(Integer::compareTo).get();
    }

    Integer findSmallest(Integer col){
        Integer smallestTreeOfCol = Integer.MAX_VALUE;
        for (List<Integer> row : matrix) {
            if (smallestTreeOfCol > row.get(col)) {
                smallestTreeOfCol = row.get(col);
            }
        }
        return smallestTreeOfCol;
    }
}
