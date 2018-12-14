import org.junit.*;
import static org.junit.Assert.*;
import java.awt.*;

/*a test class for CannonPiece*/
public class BishopTest{
    /*test isLegalCaptureMove method*/
    @Test
    public void testIsLegalCaptureMove(){
        ChessBoard test = new ChessBoard(8,8,new Display(), new IChess());
        Piece a = new BishopPiece(test,Color.RED, "B", IChess.Side.NORTH,null);
        test.addPiece(a,3,3);
        test.addPiece(new BishopPiece(test, Color.WHITE, "B", IChess.Side.SOUTH,null),2,2);
        test.addPiece(new BishopPiece(test, Color.WHITE, "B", IChess.Side.SOUTH,null),0,1);
        assertFalse(a.isLegalCaptureMove(0,1));/*test 0*/
        assertTrue(a.isLegalCaptureMove(2,2));/*test 1*/
        test.addPiece(new BishopPiece(test, Color.WHITE, "B", IChess.Side.SOUTH,null),4,4);
        test.addPiece(new BishopPiece(test, Color.WHITE, "B", IChess.Side.SOUTH,null),5,5);
        test.addPiece(new BishopPiece(test, Color.RED, "B", IChess.Side.NORTH,null),4,2);
        assertFalse(a.isLegalCaptureMove(5,5));
        assertFalse(a.isLegalCaptureMove(4,2));/*test many*/
    }

    @Test
    public void testIsLegalNonCaptureMove(){
        ChessBoard test = new ChessBoard(8,8,new Display(), new IChess());
        Piece a = new BishopPiece(test,Color.RED, "B", IChess.Side.NORTH,null);
        test.addPiece(a,3,3);;
        test.addPiece(new BishopPiece(test, Color.WHITE, "B", IChess.Side.SOUTH,null),2,2);
        assertFalse(a.isLegalNonCaptureMove(3,3));/*test 0*/
        assertTrue(a.isLegalNonCaptureMove(4,4));/*test 1*/
        assertTrue(a.isLegalNonCaptureMove(6,6));
        assertFalse(a.isLegalNonCaptureMove(1,1));
        assertFalse(a.isLegalNonCaptureMove(1,3));/*test 0*//*test many*/
    }
}
          