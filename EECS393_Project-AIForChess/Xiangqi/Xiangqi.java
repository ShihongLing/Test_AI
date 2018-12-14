import java.awt.*;

/*a class represent chess game, Xiangqi!*/
public class Xiangqi implements ChessGame{
  /*check whether game starts*/
  private boolean start = true;
  /*store the side which will start game(click firstly)*/
  private Side firstSide = null;
  /*store the current side which has moved its piece*/
  private Side currentSide = null;
  
  /*create a Xiangqi board and add all the pieces needed into it*/
  public Xiangqi(){
  firstSide = Side.NORTH;
  
  /*create the board*/
  ChessBoard game = new ChessBoard(10,9,new Display(), this);
  
  /*add RookPiece*/
  game.addPiece(new RookPiece(game,Color.RED, "R", Xiangqi.Side.NORTH,null),0,0);
  game.addPiece(new RookPiece(game,Color.RED, "R", Xiangqi.Side.NORTH,null),0,8);
  game.addPiece(new RookPiece(game,Color.WHITE, "R", Xiangqi.Side.SOUTH,null),9,0);
  game.addPiece(new RookPiece(game,Color.WHITE, "R", Xiangqi.Side.SOUTH,null),9,8);
  
  /*add Cannon Piece*/
  game.addPiece(new CannonPiece(game,Color.RED, "C", Xiangqi.Side.NORTH,null),2,1);
  game.addPiece(new CannonPiece(game,Color.RED, "C", Xiangqi.Side.NORTH,null),2,7);
  game.addPiece(new CannonPiece(game,Color.WHITE, "C", Xiangqi.Side.SOUTH,null),7,1);
  game.addPiece(new CannonPiece(game,Color.WHITE, "C", Xiangqi.Side.SOUTH,null),7,7);
  
  /*add KingPiece*/
  game.addPiece(new KingPiece(game,Color.RED,"K",Xiangqi.Side.NORTH,null),0,4);
  game.addPiece(new KingPiece(game,Color.WHITE,"K",Xiangqi.Side.SOUTH,null),9,4);
  
  /*add GuardPiece*/
  game.addPiece(new GuardPiece(game,Color.RED,"G",Xiangqi.Side.NORTH,null),0,3);
  game.addPiece(new GuardPiece(game,Color.RED,"G",Xiangqi.Side.NORTH,null),0,5);
  game.addPiece(new GuardPiece(game,Color.WHITE,"G",Xiangqi.Side.SOUTH,null),9,3);
  game.addPiece(new GuardPiece(game,Color.WHITE,"G",Xiangqi.Side.SOUTH,null),9,5);
  
  /*add ElephantPiece*/
  game.addPiece(new ElephantPiece(game,Color.RED,"E",Xiangqi.Side.NORTH,null),0,2);
  game.addPiece(new ElephantPiece(game,Color.RED,"E",Xiangqi.Side.NORTH,null),0,6);
  game.addPiece(new ElephantPiece(game,Color.WHITE,"E",Xiangqi.Side.SOUTH,null),9,2);
  game.addPiece(new ElephantPiece(game,Color.WHITE,"E",Xiangqi.Side.SOUTH,null),9,6);    
  
  /*add KnightPiece*/
  game.addPiece(new KnightPiece(game,Color.RED,"N",Xiangqi.Side.NORTH,null),0,1);
  game.addPiece(new KnightPiece(game,Color.RED,"N",Xiangqi.Side.NORTH,null),0,7);
  game.addPiece(new KnightPiece(game,Color.WHITE,"N",Xiangqi.Side.SOUTH,null),9,1);
  game.addPiece(new KnightPiece(game,Color.WHITE,"N",Xiangqi.Side.SOUTH,null),9,7);    
  
  /*add PawnPiece*/
  game.addPiece(new PawnPiece(game,Color.RED,"P",Xiangqi.Side.NORTH,null),3,0);
  game.addPiece(new PawnPiece(game,Color.RED,"P",Xiangqi.Side.NORTH,null),3,2);
  game.addPiece(new PawnPiece(game,Color.RED,"P",Xiangqi.Side.NORTH,null),3,4);
  game.addPiece(new PawnPiece(game,Color.RED,"P",Xiangqi.Side.NORTH,null),3,6);
  game.addPiece(new PawnPiece(game,Color.RED,"P",Xiangqi.Side.NORTH,null),3,8);
  game.addPiece(new PawnPiece(game,Color.WHITE,"P",Xiangqi.Side.SOUTH,null),6,0);
  game.addPiece(new PawnPiece(game,Color.WHITE,"P",Xiangqi.Side.SOUTH,null),6,2);
  game.addPiece(new PawnPiece(game,Color.WHITE,"P",Xiangqi.Side.SOUTH,null),6,4);
  game.addPiece(new PawnPiece(game,Color.WHITE,"P",Xiangqi.Side.SOUTH,null),6,6);
  game.addPiece(new PawnPiece(game,Color.WHITE,"P",Xiangqi.Side.SOUTH,null),6,8);
  
  }
  
  /*check whether it is the right side to play*/
  @Override
  public boolean legalPieceToPlace(Piece piece){
    if(start==true&&piece.getSide()==firstSide){
      return true;
    }
    else if(start==true&&piece.getSide()!=firstSide){
      return false;
    }
    else if(start==false&&piece.getSide()!=currentSide){
      return true;
    }
    else{
      return false;
    }
  }
  
  /*check whether it is legal to move and then move the piece*/
  public boolean makeMove(Piece piece,int x, int y){
    
    if(piece.isLegalMove(x,y)==true){
      piece.getChessBoard().removePiece(piece.getRow(),piece.getColumn());
      piece.getChessBoard().addPiece(piece,x,y);
      piece.moveDone();
      
      if(start==true){
        currentSide=firstSide;
        start=false;
      }
      else if(start==false){
        currentSide=piece.getSide();
      }
      return true;
      }
    else{
      return false;
    }
  }
  
  /*decide where to start when you click RUN*/
  public static void main(String[] args){
    new Xiangqi();
  }
    
}
   