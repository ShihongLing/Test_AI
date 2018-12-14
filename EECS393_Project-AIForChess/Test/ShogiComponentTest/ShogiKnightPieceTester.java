import org.junit.*;
import static org.junit.Assert.*;
import java.awt.*;


/*a test class for KnightPiece*/
public class ShogiKnightPieceTester{
  
  /*test isLegalNonCaptureMove method*/
  @Test
  public void testIsLegalNonCaptureMove(){
    ChessBoard test = new ChessBoard(10,9,new Display(), new Shogi());
    Piece a = new KnightPiece(test,Color.RED,"N",Shogi.Side.NORTH,null);
    
    test.addPiece(a,0,1);
    assertTrue(a.isLegalNonCaptureMove(2,2));
    assertTrue(a.isLegalNonCaptureMove(1,3));
    test.addPiece(new KnightPiece(test,Color.RED,"N",Shogi.Side.NORTH,null),1,1);
    assertFalse(a.isLegalNonCaptureMove(2,2));
    assertTrue(a.isLegalNonCaptureMove(1,3));
  }
}