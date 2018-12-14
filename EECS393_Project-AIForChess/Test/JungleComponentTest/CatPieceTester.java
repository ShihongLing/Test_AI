import org.junit.*;
import static org.junit.Assert.*;
import java.awt.*;

/*a test class for CannonPiece*/
public class CatPieceTester{
  
  /*test isLegalCaptureMove method*/
  @Test
  public void testIsLegalCaptureMove(){
    JungleChessBoard test = new JungleChessBoard(10,9,new JungleDisplay(), new Jungle());
    JunglePiece a = new CatPiece(test,Color.RED, "R", Jungle.Side.NORTH,null);
    test.addPiece(a,2,1);
    
    test.addPiece(new CatPiece(test, Color.WHITE, "R",Jungle.Side.SOUTH,null),2,7);
    assertFalse(a.isLegalCaptureMove(2,7));/*test 0*/
    test.addPiece(new CatPiece(test, Color.WHITE, "R",Jungle.Side.SOUTH,null),2,6);
    assertTrue(a.isLegalCaptureMove(2,7));/*test 1*/
    test.addPiece(new CatPiece(test, Color.WHITE, "R", Jungle.Side.SOUTH,null),2,5);
    assertFalse(a.isLegalCaptureMove(2,7));/*test many*/
    
    test.addPiece(new CatPiece(test, Color.RED, "R",Jungle.Side.NORTH,null),2,4);
    assertFalse(a.isLegalCaptureMove(2,4));/*test first*/
    test.addPiece(new CatPiece(test, Color.WHITE, "R", Jungle.Side.SOUTH,null),2,3);
    assertFalse(a.isLegalCaptureMove(2,4));/*test middle*/
    test.addPiece(new CatPiece(test, Color.WHITE, "R",Jungle.Side.SOUTH,null),2,2);
    assertFalse(a.isLegalCaptureMove(2,4));/*test last*/
  }
}
                