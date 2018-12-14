import org.junit.*;
import static org.junit.Assert.*;
import java.awt.*;

/*a test class for RookPiece*/
public class ShogiRookPieceTester{
  
  /*test getChessBoard method*/
  @Test
  public void testGetChessBoard(){
   ChessBoard test = new ChessBoard(10,9,new Display(), new Shogi());
   test.addPiece(new RookPiece(test,Color.RED, "R", Shogi.Side.NORTH,null),0,0);
   assertEquals(test.getPiece(0,0).getChessBoard(),test);
  }
  
  /*test getColor method*/
  @Test
  public void testGetColor(){
   ChessBoard test = new ChessBoard(10,9,new Display(), new Shogi());
   test.addPiece(new RookPiece(test,Color.RED, "R", Shogi.Side.NORTH,null),0,0);
   assertEquals(test.getPiece(0,0).getColor(),Color.RED);
  }
  
  /*test getLabel method*/
  @Test
  public void testGetLabel(){
   ChessBoard test = new ChessBoard(10,9,new Display(), new Shogi());
   test.addPiece(new RookPiece(test,Color.RED, "R", Shogi.Side.NORTH,null),0,0);
   assertEquals(test.getPiece(0,0).getLabel(),"R");
  }
  
  /*test getSide method*/
  @Test
  public void testGetSide(){
   ChessBoard test = new ChessBoard(10,9,new Display(), new Shogi());
   test.addPiece(new RookPiece(test,Color.RED, "R", Shogi.Side.NORTH,null),0,0);
   assertEquals(test.getPiece(0,0).getSide(),Shogi.Side.NORTH);
  }
  
  /*test getIcon method*/
  @Test
  public void testGetIcon(){
   ChessBoard test = new ChessBoard(10,9,new Display(), new Shogi());
   test.addPiece(new RookPiece(test,Color.RED, "R", Shogi.Side.NORTH,null),0,0);
   assertEquals(test.getPiece(0,0).getIcon(),null);
  }
  /*test getRow method*/
  @Test
  public void testGetRow(){
   ChessBoard test = new ChessBoard(10,9,new Display(), new Shogi());
   test.addPiece(new RookPiece(test,Color.RED, "R", Shogi.Side.NORTH,null),0,0);
   assertEquals(test.getPiece(0,0).getRow(),0);
  }
  
   /*test getColumn method*/
  @Test
  public void testGetColumn(){
   ChessBoard test = new ChessBoard(10,9,new Display(), new Shogi());
   test.addPiece(new RookPiece(test,Color.RED, "R", Shogi.Side.NORTH,null),0,0);
   assertEquals(test.getPiece(0,0).getColumn(),0);
  }
  
  /*test isLegalNonCaptureMove method*/
  @Test
  public void testIsLegalNonCaptureMove(){
    ChessBoard test = new ChessBoard(10,9,new Display(), new Shogi());
    Piece a = new RookPiece(test,Color.RED, "R", Shogi.Side.NORTH,null);
    test.addPiece(a,0,0);
    
    assertFalse(a.isLegalNonCaptureMove(1,1));
    assertTrue(a.isLegalNonCaptureMove(0,8));
    
    test.addPiece(new RookPiece(test, Color.RED, "R",Shogi.Side.NORTH,null),0,2);
    assertFalse(a.isLegalNonCaptureMove(0,8));
  }
  
  /*test isLegalCaptureMove method*/
  @Test
  public void testIsLegalCaptureMove(){
    ChessBoard test = new ChessBoard(10,9,new Display(), new Shogi());
    Piece a = new RookPiece(test,Color.RED, "R", Shogi.Side.NORTH,null);
    test.addPiece(a,0,0);
    
    test.addPiece(new RookPiece(test, Color.RED, "R",Shogi.Side.NORTH,null),0,2);
    assertFalse(a.isLegalCaptureMove(0,2));
    
    test.addPiece(new RookPiece(test, Color.WHITE, "R",Shogi.Side.SOUTH,null),0,1);
    assertTrue(a.isLegalCaptureMove(0,1));
  }
}
  
  