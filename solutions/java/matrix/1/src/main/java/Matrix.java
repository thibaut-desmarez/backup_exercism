import java.util.ArrayList;
import java.util.List;

class Matrix {

    private final String matrix;
    Matrix(String matrixAsString) {
        this.matrix = matrixAsString;
    }

    int[] getRow(int rowNumber) {
        String[] row = this.matrix.split("\n")[rowNumber-1].split(" ");
        int[] result = new int[row.length];
        for(int i = 0 ; i < row.length ; i++){
            result[i] = Integer.parseInt(row[i]);
        }
        return result;
    }

    int[] getColumn(int columnNumber) {
        String[] rows = this.matrix.split("\n");
        int[] result = new int[rows.length];
        String[] row;
        for(int i = 0 ; i < rows.length ; i++){
            row = rows[i].split(" ");
            result[i] = Integer.parseInt(row[columnNumber-1]);
        }
        return result;
    }
}
