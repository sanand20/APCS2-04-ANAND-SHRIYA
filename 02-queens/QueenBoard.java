public class QueenBoard{
  private int board[][];
  private int size;
  public QueenBoard(int size){
    board = new int [size][size];
    this.size=size;
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

  

  //public int countSolutions(){

  //}
}
