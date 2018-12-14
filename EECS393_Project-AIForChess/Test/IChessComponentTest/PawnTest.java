import org.junit.*;
import static org.junit.Assert.*;
import java.awt.*;

/*a test class for CannonPiece*/
public class PawnTest {
    /*test isLegalCaptureMove method*/
    @Test
    public void testIsLegalCaptureMove(){
        IChess X = new IChess();
        ChessBoard test = new ChessBoard(8,8,new Display(), X);
        Piece a = new IPawnPiece(test,Color.RED, "P", IChess.Side.NORTH,null);
        Piece b = new IPawnPiece(test,Color.RED, "P", IChess.Side.NORTH,null);
        Piece c = new IPawnPiece(test,Color.RED, "P", IChess.Side.NORTH,null);
        test.addPiece(a,3,3);
        test.addPiece(b,3,4);
        test.addPiece(c,3,5);
        test.addPiece(new BishopPiece(test, Color.WHITE, "C", IChess.Side.SOUTH,null),4,3);
        test.addPiece(new BishopPiece(test, Color.WHITE, "C", IChess.Side.SOUTH,null),3,6);
        test.addPiece(new BishopPiece(test, Color.RED, "C", IChess.Side.NORTH,null),4,4);
        assertFalse(a.isLegalCaptureMove(4,3));/*test 0*/
        assertTrue(b.isLegalCaptureMove(4,3));/*test 1*/
        assertFalse(c.isLegalCaptureMove(4,4));

        X.makeMove(c,4,6);
        assertTrue(test.hasPiece(3,6) == false);/*test many*/
    }

    @Test
    public void testIsLegalNonCaptureMove(){
        ChessBoard test = new ChessBoard(8,8,new Display(), new IChess());
        Piece a = new IPawnPiece(test,Color.RED, "P", IChess.Side.NORTH,null);
        Piece b = new IPawnPiece(test,Color.RED, "P", IChess.Side.NORTH,null);
        test.addPiece(a,3,3);
        test.addPiece(b,1,0);;

        test.addPiece(new BishopPiece(test, Color.WHITE, "C", IChess.Side.SOUTH,null),3,2);
        assertTrue(a.isLegalNonCaptureMove(4,3));/*test 0*/
        assertTrue(b.isLegalNonCaptureMove(3,0));/*test 1*/
        assertFalse(a.isLegalNonCaptureMove(4,4));
        assertFalse(a.isLegalNonCaptureMove(3,6));
        assertFalse(a.isLegalNonCaptureMove(2,3));/*test many*/
    }
}
          