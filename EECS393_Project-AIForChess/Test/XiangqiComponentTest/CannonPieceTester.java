import org.junit.*;
import static org.junit.Assert.*;
import java.awt.*;

/*a test class for CannonPiece*/
public class CannonPieceTester{
  
  /*test isLegalCaptureMove method*/
  @Test
  public void testIsLegalCaptureMove(){
    ChessBoard test = new ChessBoard(10,9,new Display(), new Xiangqi());
    Piece a = new CannonPiece(test,Color.RED, "R", Xiangqi.Side.NORTH,null);
    test.addPiece(a,2,1);
    
    test.addPiece(new RookPiece(test, Color.WHITE, "R",Xiangqi.Side.SOUTH,null),2,7);
    assertFalse(a.isLegalCaptureMove(2,7));/*test 0*/
    test.addPiece(new RookPiece(test, Color.WHITE, "R",Xiangqi.Side.SOUTH,null),2,6);
    assertTrue(a.isLegalCaptureMove(2,7));/*test 1*/
    test.addPiece(new RookPiece(test, Color.WHITE, "R",Xiangqi.Side.SOUTH,null),2,5);
    assertFalse(a.isLegalCaptureMove(2,7));/*test many*/
    
    test.addPiece(new RookPiece(test, Color.RED, "R",Xiangqi.Side.NORTH,null),2,4);
    assertFalse(a.isLegalCaptureMove(2,4));/*test first*/
    test.addPiece(new RookPiece(test, Color.WHITE, "R",Xiangqi.Side.SOUTH,null),2,3);
    assertFalse(a.isLegalCaptureMove(2,4));/*test middle*/
    test.addPiece(new RookPiece(test, Color.WHITE, "R",Xiangqi.Side.SOUTH,null),2,2);
    assertFalse(a.isLegalCaptureMove(2,4));/*test last*/
  }
}
                