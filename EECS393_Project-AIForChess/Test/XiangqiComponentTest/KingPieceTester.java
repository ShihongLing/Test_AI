import org.junit.*;
import static org.junit.Assert.*;
import java.awt.*;

/*a test class for KingPiece*/
public class KingPieceTester{
  
  
  /*test isLegalNonCaptureMove method*/
  @Test
  public void testIsLegalNonCaptureMove(){
    ChessBoard test = new ChessBoard(10,9,new Display(), new Xiangqi());
    Piece a = new KingPiece(test,Color.RED,"K",Xiangqi.Side.NORTH,null);
    
    test.addPiece(a,2,4);
    assertFalse(a.isLegalNonCaptureMove(1,3));
    assertTrue(a.isLegalNonCaptureMove(2,3));
    assertTrue(a.isLegalNonCaptureMove(1,4));
    assertFalse(a.isLegalNonCaptureMove(3,4));
  }
  
}
    
                