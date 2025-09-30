class GameOfLife {
    public int[][] tick(int[][] matrix){
        if(matrix.length != 0) {
            int[][] nextGeneration = new int[matrix.length][matrix[0].length];
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    int numberOfNeighboursAlive = findNumberOfAliveNeighbours(matrix, col, row);
                    if(numberOfNeighboursAlive == 3){
                        nextGeneration[col][row] = 1;
                    }
                    else if(numberOfNeighboursAlive == 2){
                        nextGeneration[col][row] = matrix[col][row];
                    }
                    else{ // > 3 or < 2
                        nextGeneration[col][row] = 0;
                    }
                }
            }
            return nextGeneration;
        }
        return new int[][]{};
    }

    int findNumberOfAliveNeighbours(int[][] matrix, int col, int row){
        if(row==0){ //première ligne
            if(col == 0) { //en haut à gauche
                return matrix[col+1][row] + matrix[col][row+1] + matrix[col+1][row+1];
            }
            else if(col == matrix[0].length-1) { //en haut à droite
                return matrix[col - 1][row] + matrix[col][row + 1] + matrix[col - 1][row+1];
            }
            else{
                return matrix[col-1][row] + matrix[col+1][row] + matrix[col-1][row+1] + matrix[col][row+1] + matrix[col+1][row+1];
            }
        }
        else if(row == matrix.length-1) { //dernière ligne
            if(col == 0) { //en bas à gauche
                return matrix[col][row-1] + matrix[col+1][row] + matrix[col+1][row-1];
            }
            else if(col == matrix[0].length-1) { //en bas à droite
                return matrix[col-1][row] + matrix[col][row-1] + matrix[col-1][row-1];
            }
            else{
                return matrix[col-1][row] + matrix[col+1][row] + matrix[col][row-1] + matrix[col-1][row-1] + matrix[col+1][row-1];
            }
        }
        else{
            if(col == 0) { //bord gauche
                return matrix[col][row-1] + matrix[col+1][row] + matrix[col][row+1] +  + matrix[col+1][row-1] + matrix[col+1][row+1];
            }
            else if(col == matrix[0].length-1) { //bord droit
                return matrix[col][row-1] + matrix[col-1][row]  + matrix[col][row+1] + matrix[col-1][row-1] + matrix[col-1][row+1];
            }
            else{
                return matrix[col-1][row] + matrix[col+1][row] + matrix[col][row-1] + matrix[col][row+1] + matrix[col-1][row-1] + matrix[col-1][row+1] + matrix[col+1][row-1] + matrix[col+1][row+1];
            }
        }
    }
}
