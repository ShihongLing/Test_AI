import org.junit.*;
import static org.junit.Assert.*;
import java.awt.*;

/*a test class for GuardPiece*/
public class GuardPieceTester{
  
  
  /*test IsLegalNonCaptureMove method*/
  @Test
  public void testIsLegalNonCaptureMove(){
    ChessBoard test = new ChessBoard(10,9,new Display(), new Xiangqi());
    Piece a = new GuardPiece(test,Color.RED,"G",Xiangqi.Side.NORTH,null);
    
    test.addPiece(a,0,3);
    assertFalse(a.isLegalNonCaptureMove(1,3));
    assertTrue(a.isLegalNonCaptureMove(1,4));
    
    test.addPiece(a,2,3);
    assertFalse(a.isLegalNonCaptureMove(3,2));
  }
  
}
    
  