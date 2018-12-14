import org.junit.*;
import static org.junit.Assert.*;
import java.awt.*;

/*a test class for CannonPiece*/
public class CastleTest{
    /*test isLegalCaptureMove method*/
    @Test
    public void testIsLegalCaptureMove(){
        ChessBoard test = new ChessBoard(8,8,new Display(), new IChess());
        Piece a = new CastlePiece(test,Color.RED, "C", IChess.Side.NORTH,null);
        test.addPiece(a,3,3);
        test.addPiece(new BishopPiece(test, Color.WHITE, "C", IChess.Side.SOUTH,null),3,4);
        test.addPiece(new BishopPiece(test, Color.WHITE, "C", IChess.Side.SOUTH,null),2,2);
        assertFalse(a.isLegalCaptureMove(2,2));/*test 0*/
        assertTrue(a.isLegalCaptureMove(3,4));/*test 1*/
        test.addPiece(new BishopPiece(test, Color.WHITE, "C", IChess.Side.SOUTH,null),3,5);
        test.addPiece(new BishopPiece(test, Color.RED, "B", IChess.Side.NORTH,null),1,3);
        assertFalse(a.isLegalCaptureMove(3,5));
        assertFalse(a.isLegalCaptureMove(1,3));/*test many*/
    }

    @Test
    public void testIsLegalNonCaptureMove(){
        ChessBoard test = new ChessBoard(8,8,new Display(), new IChess());
        Piece a = new CastlePiece(test,Color.RED, "B", IChess.Side.NORTH,null);
        test.addPiece(a,3,3);;
        test.addPiece(new BishopPiece(test, Color.WHITE, "C", IChess.Side.SOUTH,null),3,1);
        assertFalse(a.isLegalNonCaptureMove(3,3));/*test 0*/
        assertTrue(a.isLegalNonCaptureMove(3,2));/*test 1*/
        assertTrue(a.isLegalNonCaptureMove(3,6));
        assertFalse(a.isLegalNonCaptureMove(6,6));/*test many*/
    }
}