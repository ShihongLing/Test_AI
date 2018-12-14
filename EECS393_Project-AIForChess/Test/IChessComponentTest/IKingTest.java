import org.junit.*;
import static org.junit.Assert.*;
import java.awt.*;

/*a test class for CannonPiece*/
public class IKingTest{
    /*test isLegalCaptureMove method*/
    @Test
    public void testIsLegalCaptureMove(){
        ChessBoard test = new ChessBoard(8,8,new Display(), new IChess());
        Piece a = new IKingPiece(test,Color.RED, "Ki", IChess.Side.NORTH,null);
        test.addPiece(a,3,3);
        test.addPiece(new BishopPiece(test, Color.WHITE, "C", IChess.Side.SOUTH,null),3,4);
        test.addPiece(new BishopPiece(test, Color.WHITE, "C", IChess.Side.SOUTH,null),2,2);
        test.addPiece(new BishopPiece(test, Color.RED, "B", IChess.Side.NORTH,null),2,3);
        test.addPiece(new BishopPiece(test, Color.WHITE, "C", IChess.Side.SOUTH,null),3,5);
        assertFalse(a.isLegalCaptureMove(2,3));/*test 0*/
        assertTrue(a.isLegalCaptureMove(3,4));/*test 1*/
        assertFalse(a.isLegalCaptureMove(3,5));
        assertTrue(a.isLegalCaptureMove(2,2));/*test many*/
    }

    @Test
    public void testIsLegalNonCaptureMove(){
        ChessBoard test = new ChessBoard(8,8,new Display(), new IChess());
        Piece a = new IKingPiece(test,Color.RED, "Ki", IChess.Side.NORTH,null);
        test.addPiece(a,3,3);;
        test.addPiece(new BishopPiece(test, Color.WHITE, "C", IChess.Side.SOUTH,null),3,2);
        assertFalse(a.isLegalNonCaptureMove(3,3));/*test 0*/
        assertTrue(a.isLegalNonCaptureMove(3,4));/*test 1*/
        assertTrue(a.isLegalNonCaptureMove(4,4));
        assertFalse(a.isLegalNonCaptureMove(3,6));
        assertTrue(a.isLegalNonCaptureMove(2,2));/*test many*/
    }
}
          