import org.junit.*;
import static org.junit.Assert.*;
import java.awt.*;

/*a test class for ElephantPiece*/
public class ElephantPieceTester{
  
  /*test IsLegalNonCaptureMove method*/
  @Test
  public void testIsLegalNonCaptureMove(){
    ChessBoard test = new ChessBoard(10,9,new Display(), new Xiangqi());
    Piece a = new ElephantPiece(test,Color.RED,"E",Xiangqi.Side.NORTH,null);
    
    test.addPiece(a,0,2);
    assertFalse(a.isLegalNonCaptureMove(1,3));
    assertTrue(a.isLegalNonCaptureMove(2,4));
    test.addPiece(new ElephantPiece(test,Color.RED,"E",Xiangqi.Side.NORTH,null),1,3);
    assertFalse(a.isLegalNonCaptureMove(2,4));
    
    test.addPiece(a,4,1);
    assertFalse(a.isLegalNonCaptureMove(6,3));
    
  }
  
}
    