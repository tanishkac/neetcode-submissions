class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        //rows
        for(int i=0; i<9; i++){
            HashSet<Character> row = new HashSet<>();
            for(int j=0; j<9; j++){
                char current = board[i][j];
                if(current == '.'){
                    continue;
                }
                if(row.contains(current)){
                    return false;
                } else { 
                    row.add(current);
                }
            }
        }

        //columns
        for(int i=0; i<9; i++){
            HashSet<Character> column = new HashSet<>();
            for(int j=0; j<9; j++){
                char current = board[j][i];
                if(current == '.'){
                    continue;
                }
                if(column.contains(current)){
                    return false;
                } else { 
                    column.add(current);
                }
            }
        }

        //grid
        for (int row = 0; row < 9; row += 3) {

            for (int col = 0; col < 9; col += 3) {

                HashSet<Character> grid = new HashSet<>();

                for (int i = row; i < row + 3; i++) {

                    for (int j = col; j < col + 3; j++) {

                        char current = board[i][j];

                        if (current == '.') {
                            continue;
                        }

                        if (grid.contains(current)) {
                            return false;
                        }

                        grid.add(current);
                    }
                }
            }
}
        

        return true;
        
    }
}
