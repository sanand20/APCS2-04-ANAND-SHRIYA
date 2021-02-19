public class QueenBoard{
  private int board[][];
  private int size;
  public QueenBoard(int size){
    board = new int [size][size];
    this.size=size;
    for (int i = 0; i<size; i++){
      for (int j = 0; j<size; j++){
        board[i][j]=0;
      }
    }
  }
  private boolean addQueen(int r, int c){
    if (board[r][c]==0){

      for (int i = 0; r+i < this.size && c+i <this.size; i++){
        board[r+i][c+i] = board[r+i][c+i] +1;
      }
      for (int i = 0; r-i >= 0 && c-i >= 0; i++){
        board[r-i][c-i] = board[r-i][c-i] +1;
      }
      for (int i = 0; r+i < this.size && c-i >= 0; i++){
        board[r+i][c-i] = board[r+i][c-i] +1;
      }
      for (int i = 0; c+i < this.size && r-i >= 0; i++){
        board[r-i][c+i] = board[r-i][c+i] +1;
      }

      for (int i = 0; i< this.size && i>=0; i++){
        board[r][i] = board[r][i] +1;
        board[i][c] = board[i][c] +1;
      }
      board[r][c]=-1;
      return true;
    }
  else{return false;}
}

private void removeQueen(int r, int c) {
  if(board[r][c]==-1){
    for (int i = 0; r+i < this.size && c+i <this.size; i++){
      board[r+i][c+i] = board[r+i][c+i] -1;
    }
    for (int i = 0; r-i >= 0 && c-i >= 0; i++){
      board[r-i][c-i] = board[r-i][c-i] -1;
    }
    for (int i = 0; r+i < this.size && c-i >= 0; i++){
      board[r+i][c-i] = board[r+i][c-i] -1;
    }
    for (int i = 0; c+i < this.size && r-i >= 0; i++){
      board[r-i][c+i] = board[r-i][c+i] -1;
    }
  }

    for (int i = 0; i< this.size && i>=0; i++){
      board[r][i] = board[r][i] -1;
      board[i][c] = board[i][c] -1;
    }
    board[r][c] = 0;
}

public String toString(){
  String result = "";
  for (int i = 0; i<size; i++){
    for (int j = 0; j<size; j++){
      if (board[i][j]== -1){
        result += "Q ";
      }
      else{
        result += "_ ";
      }
    }
    result += "\n";
  }
  return result;
}

public boolean solve(){
  return solve(0);
}

public boolean solve(int col){
  if (col == size){
    return true;
  }
  for (int row = 1; row < size; row++){
    if(addQueen(row,col)){
      if(solve(col+1)){
        return true;
      }
      removeQueen(row,col);
    }
  }
  return false;
}

  public int countSolutions(){
    return countSolutions(0,0);
  }
}
