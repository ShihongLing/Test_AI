import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


/*represent a KnightPiece*/
public class IKnightPiece extends Piece{
  private ChessBoard chessBoard = getChessBoard();
  /*create a KnightPiece*/
  public IKnightPiece(ChessBoard board, Color color, String label, IChess.Side side, Icon icon){
    super(board, color, label, side, icon);
  }

  public IKnightPiece getClone(Piece[][] s){
    Color newc = getColor();
    String news = getLabel();
    IChess.Side newsi = getSide();
    return new IKnightPiece(new ChessBoard(s),newc,news,newsi,null);
  }
  
  /*check whether the piece can move to input position
   * while there is an empty square*/
  public boolean isLegalNonCaptureMove(int x, int y){
    if((x < 8 && y < 8)  &&(x >= 0 && y >= 0)) {
      if ((Math.abs(x - this.getRow()) == 2 && Math.abs(y - this.getColumn()) == 1) || (Math.abs(x - this.getRow()) == 1 && Math.abs(y - this.getColumn()) == 2)) {
        return true;
      } else {
        return false;
      }
    }
    else{
      return false;
    }
  }

  public ArrayList<Move> getMoves(){
    ArrayList<Move> moves = new ArrayList<Move>();

    if(chessBoard.hasPiece(this.getRow() + 2,this.getColumn() + 1)){
      if(isLegalCaptureMove(this.getRow() + 2,this.getColumn() + 1)){
        moves.add(new Move(this.getRow(), this.getColumn(), this.getRow()+2, this.getColumn() + 1, false));
      }
    }
    else{
      if(isLegalNonCaptureMove(this.getRow()+2,this.getColumn() + 1)){
        moves.add(new Move(this.getRow(), this.getColumn(), this.getRow()+2, this.getColumn() + 1, false));
      }
    }

    if(chessBoard.hasPiece(this.getRow() - 2,this.getColumn() - 1)){
      if(isLegalCaptureMove(this.getRow() - 2,this.getColumn() - 1)){
        moves.add(new Move(this.getRow(), this.getColumn(), this.getRow()-2, this.getColumn() - 1, false));
      }
    }
    else{
      if(isLegalNonCaptureMove(this.getRow()-2,this.getColumn() - 1)){
        moves.add(new Move(this.getRow(), this.getColumn(), this.getRow()-2, this.getColumn() - 1, false));
      }
    }

    if(chessBoard.hasPiece(this.getRow() + 2,this.getColumn() - 1)){
      if(isLegalCaptureMove(this.getRow() + 2,this.getColumn() - 1)){
        moves.add(new Move(this.getRow(), this.getColumn(), this.getRow()+2, this.getColumn() - 1, false));
      }
    }
    else{
      if(isLegalNonCaptureMove(this.getRow()+2,this.getColumn() - 1)){
        moves.add(new Move(this.getRow(), this.getColumn(), this.getRow()+2, this.getColumn() - 1, false));
      }
    }

    if(chessBoard.hasPiece(this.getRow() - 2,this.getColumn() + 1)){
      if(isLegalCaptureMove(this.getRow() - 2,this.getColumn() + 1)){
        moves.add(new Move(this.getRow(), this.getColumn(), this.getRow()-2, this.getColumn() + 1, false));
      }
    }
    else{
      if(isLegalNonCaptureMove(this.getRow()-2,this.getColumn() + 1)){
        moves.add(new Move(this.getRow(), this.getColumn(), this.getRow()-2, this.getColumn() + 1, false));
      }
    }

    if(chessBoard.hasPiece(this.getRow() - 1,this.getColumn() + 2)){
      if(isLegalCaptureMove(this.getRow() - 1,this.getColumn() + 2)){
        moves.add(new Move(this.getRow(), this.getColumn(), this.getRow()-1, this.getColumn() + 2, false));
      }
    }
    else{
      if(isLegalNonCaptureMove(this.getRow()-1,this.getColumn() + 2)){
        moves.add(new Move(this.getRow(), this.getColumn(), this.getRow()-1, this.getColumn() + 2, false));
      }
    }


    if(chessBoard.hasPiece(this.getRow() + 1 ,this.getColumn() - 2)){
      if(isLegalCaptureMove(this.getRow() + 1,this.getColumn() - 2)){
        moves.add(new Move(this.getRow(), this.getColumn(), this.getRow()+1, this.getColumn() - 2, false));
      }
    }
    else{
      if(isLegalNonCaptureMove(this.getRow()+1,this.getColumn() - 2)){
        moves.add(new Move(this.getRow(), this.getColumn(), this.getRow()+1, this.getColumn() - 2, false));
      }
    }

    if(chessBoard.hasPiece(this.getRow() - 1,this.getColumn() - 2)){
      if(isLegalCaptureMove(this.getRow() - 1,this.getColumn() - 2)){
        moves.add(new Move(this.getRow(), this.getColumn(), this.getRow()-1, this.getColumn() - 2, false));
      }
    }
    else{
      if(isLegalNonCaptureMove(this.getRow()-1,this.getColumn() - 2)){
        moves.add(new Move(this.getRow(), this.getColumn(), this.getRow()-1, this.getColumn() - 2, false));
      }
    }

    if(chessBoard.hasPiece(this.getRow() + 1,this.getColumn() + 2)){
      if(isLegalCaptureMove(this.getRow() + 1,this.getColumn() + 2)){
        moves.add(new Move(this.getRow(), this.getColumn(), this.getRow()+1, this.getColumn() + 2, false));
      }
    }
    else{
      if(isLegalNonCaptureMove(this.getRow()+1,this.getColumn() + 2)){
        moves.add(new Move(this.getRow(), this.getColumn(), this.getRow()+1, this.getColumn() + 2, false));
      }
    }

    return moves;
  }

  public static void main(String[] args){
    ChessBoard test = new ChessBoard(8,8,new Display(), new IChess());
    Piece a = new IKnightPiece(test,Color.RED, "K", IChess.Side.NORTH,null);
    test.addPiece(a,3,3);;
    test.addPiece(new BishopPiece(test, Color.RED, "Z", IChess.Side.NORTH,null),1,2);
    ArrayList<Move> moves= a.getMoves();
    for(int i = 0; i < moves.size();i++){
      System.out.print(moves.get(i).getX0() +" " + moves.get(i).getX1() +" " + moves.get(i).getY0() +" "+  moves.get(i).getY1() + "\n");
    }
  }
}
    