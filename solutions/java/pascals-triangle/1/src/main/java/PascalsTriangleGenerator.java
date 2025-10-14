class PascalsTriangleGenerator {

    int[][] generateTriangle(int rows) {
        int[][] result = new int[rows][rows];
        if(rows==0){ return result;}
        if(rows == 1){
            result[0][0] = 1;
            return result;
        }
        result[0] = new int[1];
        result[1] = new int[2];
        result[0][0] = 1;
        result[1][0] = 1;
        result[1][1] = 1;
        if(rows == 2){
            return result;
        }


        for(int i = 2; i < rows; i++) {
            int[] row = new int[i+1];
            row[0]=1;
            row[i]=1;
            for(int j = 0; j < i-1; j++){
                row[j+1] = result[i-1][j]+result[i-1][j+1];
            }
            result[i] = row;
        }
        return result;
    }
}