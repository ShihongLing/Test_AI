import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.Future;

/*a class represent chess game, Xiangqi!*/
public class IChess implements ChessGame{
  /*check whether game starts*/
  private boolean isAI = false;
  public MinMaxAI AI = new MinMaxAI(3,121);
  private Side playerSide = Side.SOUTH;
  private Side AISide = Side.NORTH;
  /*store the current side which has moved its piece*/
  private Side currentSide = null;
  private ChessBoard game;
  private Display display;
  
  /*create a Xiangqi board and add all the pieces needed into it*/

  public IChess(){
  currentSide = Side.NORTH;
  display = new Display();
  /*create the board*/
  this.game = new ChessBoard(8,8,display, this);
  this.isAI = true;
  
  /*add RookPiece*/
  game.addPiece(new CastlePiece(game,Color.RED, "C", IChess.Side.NORTH,null),0,0);
  game.addPiece(new CastlePiece(game,Color.RED, "C", IChess.Side.NORTH,null),0,7);
  game.addPiece(new CastlePiece(game,Color.WHITE, "C", IChess.Side.SOUTH,null),7,0);
  game.addPiece(new CastlePiece(game,Color.WHITE, "C", IChess.Side.SOUTH,null),7,7);

  /*add KingPiece*/
  game.addPiece(new IKingPiece(game,Color.RED,"Ki", IChess.Side.NORTH,null),0,4);
  game.addPiece(new IKingPiece(game,Color.WHITE,"Ki", IChess.Side.SOUTH,null),7,4);
  
  /*add GuardPiece*/
  game.addPiece(new QueenPiece(game,Color.RED,"Q", IChess.Side.NORTH,null),0,3);
  game.addPiece(new QueenPiece(game,Color.WHITE,"Q", IChess.Side.SOUTH,null),7,3);
  
  /*add ElephantPiece*/
  game.addPiece(new BishopPiece(game,Color.RED,"B", IChess.Side.NORTH,null),0,2);
  game.addPiece(new BishopPiece(game,Color.RED,"B", IChess.Side.NORTH,null),0,5);
  game.addPiece(new BishopPiece(game,Color.WHITE,"B", IChess.Side.SOUTH,null),7,2);
  game.addPiece(new BishopPiece(game,Color.WHITE,"B", IChess.Side.SOUTH,null),7,5);
  
  /*add KnightPiece*/
  game.addPiece(new IKnightPiece(game,Color.RED,"K", IChess.Side.NORTH,null),0,1);
  game.addPiece(new IKnightPiece(game,Color.RED,"K", IChess.Side.NORTH,null),0,6);
  game.addPiece(new IKnightPiece(game,Color.WHITE,"K", IChess.Side.SOUTH,null),7,1);
  game.addPiece(new IKnightPiece(game,Color.WHITE,"K", IChess.Side.SOUTH,null),7,6);

  /*add PawnPiece*/
  game.addPiece(new IPawnPiece(game,Color.RED,"P", IChess.Side.NORTH,null),1,0);
  game.addPiece(new IPawnPiece(game,Color.RED,"P", IChess.Side.NORTH,null),1,1);
  game.addPiece(new IPawnPiece(game,Color.RED,"P", IChess.Side.NORTH,null),1,2);
  game.addPiece(new IPawnPiece(game,Color.RED,"P", IChess.Side.NORTH,null),1,3);
  game.addPiece(new IPawnPiece(game,Color.RED,"P", IChess.Side.NORTH,null),1,4);
  game.addPiece(new IPawnPiece(game,Color.RED,"P", IChess.Side.NORTH,null),1,5);
  game.addPiece(new IPawnPiece(game,Color.RED,"P", IChess.Side.NORTH,null),1,6);
  game.addPiece(new IPawnPiece(game,Color.RED,"P", IChess.Side.NORTH,null),1,7);

  game.addPiece(new IPawnPiece(game,Color.WHITE,"P", IChess.Side.SOUTH,null),6,0);
  game.addPiece(new IPawnPiece(game,Color.WHITE,"P", IChess.Side.SOUTH,null),6,1);
  game.addPiece(new IPawnPiece(game,Color.WHITE,"P", IChess.Side.SOUTH,null),6,2);
  game.addPiece(new IPawnPiece(game,Color.WHITE,"P", IChess.Side.SOUTH,null),6,3);
  game.addPiece(new IPawnPiece(game,Color.WHITE,"P", IChess.Side.SOUTH,null),6,4);
  game.addPiece(new IPawnPiece(game,Color.WHITE,"P", IChess.Side.SOUTH,null),6,5);
  game.addPiece(new IPawnPiece(game,Color.WHITE,"P", IChess.Side.SOUTH,null),6,6);
  game.addPiece(new IPawnPiece(game,Color.WHITE,"P", IChess.Side.SOUTH,null),6,7);
  
  }


  public IChess(Piece[][] state){
    this.game = new ChessBoard(state);
  }

  public ChessBoard getBoard(){
    return this.game;
  }
  
  /*check whether it is the right side to play*/
  @Override
  public boolean legalPieceToPlace(Piece piece){
    if(piece.getSide()==currentSide){
      return true;
    }
    else{
      return false;
    }
  }

  /*check whether it is legal to move and then move the piece*/
  public boolean makeMove(Piece piece,int x, int y){
    if(!isAI) {
      if (piece.isLegalMove(x, y) == true) {
        piece.getChessBoard().removePiece(piece.getRow(), piece.getColumn());
        piece.getChessBoard().addPiece(piece, x, y);
        piece.moveDone();
        if (currentSide == Side.NORTH) {
          currentSide = Side.SOUTH;
        } else {
          currentSide = Side.NORTH;
        }
        return true;
      } else {
        return false;
      }
    }
    else {
      if (piece.isLegalMove(x, y) == true && currentSide == playerSide) {
        piece.getChessBoard().removePiece(piece.getRow(), piece.getColumn());
        piece.getChessBoard().addPiece(piece, x, y);
        piece.moveDone();
        if (currentSide == Side.NORTH) {
          currentSide = Side.SOUTH;
        } else {
          currentSide = Side.NORTH;
        }
        Move next = AI.getDecision(this);
        AI.makeMove(this,next);
        System.out.println("AI move " + next.getX0() + " " + next.getY0() + " " + next.getX1() + " " + next.getY1());
        return true;
      } else {
        return false;
      }
    }
  }

  public boolean makeMoveAI(int x0,int y0,int x1,int y1){
    Piece[][] state = this.getState();
    Piece target = state[x0][y0];
    if(target.isLegalMove(x1, y1) == true && currentSide == AISide) {
      target.getChessBoard().removePiece(target.getRow(), target.getColumn());
      target.getChessBoard().addPiece(target, x1, y1);
      target.moveDone();
      if (currentSide == Side.NORTH) {
        currentSide = Side.SOUTH;
      } else {
        currentSide = Side.NORTH;
      }
      return true;
    } else {
      return false;
    }
  }


  public ArrayList<Move> getMoves(IChess.Side currentSide){
    ArrayList<Move> moves = new ArrayList<Move>();
    for(int i = 0; i < 8; i ++){
      for(int j =0; j < 8; j ++){
        if(this.game.hasPiece(i,j) && this.game.getPiece(i,j).getSide() == currentSide){
          moves.addAll(this.game.getPiece(i,j).getMoves());
        }
      }
    }

    return moves;
  }


  public Piece[][] getState(){
    return this.game.getPieces();
  }


  public static void main(String[] args){
    IChess a = new IChess();
    a.currentSide = Side.SOUTH;

  }

}
   