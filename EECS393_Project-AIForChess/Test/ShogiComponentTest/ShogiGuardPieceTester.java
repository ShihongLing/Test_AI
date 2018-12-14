import org.junit.*;
import static org.junit.Assert.*;
import java.awt.*;

/*a test class for GuardPiece*/
public class ShogiGuardPieceTester{
  
  
  /*test IsLegalNonCaptureMove method*/
  @Test
  public void testIsLegalNonCaptureMove(){
    ChessBoard test = new ChessBoard(10,9,new Display(), new Shogi());
    Piece a = new GuardPiece(test,Color.RED,"G",Shogi.Side.NORTH,null);
    
    test.addPiece(a,0,3);
    assertFalse(a.isLegalNonCaptureMove(1,3));
    assertTrue(a.isLegalNonCaptureMove(1,4));
    
    test.addPiece(a,2,3);
    assertFalse(a.isLegalNonCaptureMove(3,2));
  }
  
}
    
  