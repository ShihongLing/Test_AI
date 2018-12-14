import org.junit.*;
import static org.junit.Assert.*;
import java.awt.*;

/*a class to test Xiangqi class*/
public class XiangqiTester{
  
  /*test makeMove method*/
  @Test
  public void testMakeMove(){
    Xiangqi X = new Xiangqi();
    ChessBoard test = new ChessBoard(10,9,new Display(), X);
    Piece a = new RookPiece(test,Color.RED, "R", Xiangqi.Side.NORTH,null);
    test.addPiece(a,0,0);
    X.makeMove(a,0,7);
    
    assertTrue(test.hasPiece(0,7));
    assertFalse(test.hasPiece(0,0));
  }
  
  /*test legalPieceToPlace method*/
  @Test
  public void testLegalPieceToPlace(){
   Xiangqi X = new Xiangqi();
   ChessBoard test = new ChessBoard(10,9,new Display(), X);
   Piece a = new RookPiece(test,Color.RED, "R", Xiangqi.Side.NORTH,null); 
   Piece b = new RookPiece(test,Color.WHITE, "R", Xiangqi.Side.SOUTH,null); 
   test.addPiece(a,0,0);
   test.addPiece(b,9,0);
   
   assertTrue(X.legalPieceToPlace(a));
   assertFalse(X.legalPieceToPlace(b));
   X.makeMove(a,0,7);
   assertTrue(X.legalPieceToPlace(b));
   assertFalse(X.legalPieceToPlace(a));
  }
}
