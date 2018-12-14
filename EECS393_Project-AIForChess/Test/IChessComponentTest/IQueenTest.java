import org.junit.*;
import static org.junit.Assert.*;
import java.awt.*;

/*a test class for CannonPiece*/
public class IQueenTest {
    /*test isLegalCaptureMove method*/
    @Test
    public void testIsLegalCaptureMoveDiag(){
        ChessBoard test = new ChessBoard(8,8,new Display(), new IChess());
        Piece a = new QueenPiece(test,Color.RED, "Q", IChess.Side.NORTH,null);
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
    public void testIsLegalCaptureMoveVerti(){
        ChessBoard test = new ChessBoard(8,8,new Display(), new IChess());
        Piece a = new QueenPiece(test,Color.RED, "Q", IChess.Side.NORTH,null);
        test.addPiece(a,3,3);
        test.addPiece(new BishopPiece(test, Color.WHITE, "C", IChess.Side.SOUTH,null),3,4);
        test.addPiece(new BishopPiece(test, Color.WHITE, "C", IChess.Side.SOUTH,null),2,2);
        assertTrue(a.isLegalCaptureMove(2,2));/*test 0*/
        assertTrue(a.isLegalCaptureMove(3,4));/*test 1*/
        test.addPiece(new BishopPiece(test, Color.WHITE, "C", IChess.Side.SOUTH,null),3,5);
        test.addPiece(new BishopPiece(test, Color.RED, "B", IChess.Side.NORTH,null),1,3);
        assertFalse(a.isLegalCaptureMove(3,5));
        assertFalse(a.isLegalCaptureMove(1,3));/*test many*/
    }

    @Test
    public void testIsLegalNonCaptureMoveDiag(){
        ChessBoard test = new ChessBoard(8,8,new Display(), new IChess());
        Piece a = new QueenPiece(test,Color.RED, "Q", IChess.Side.NORTH,null);
        test.addPiece(a,3,3);
        test.addPiece(new BishopPiece(test, Color.WHITE, "B", IChess.Side.SOUTH,null),2,2);
        assertFalse(a.isLegalNonCaptureMove(3,3));/*test 0*/
        assertTrue(a.isLegalNonCaptureMove(4,4));/*test 1*/
        assertTrue(a.isLegalNonCaptureMove(6,6));
        assertFalse(a.isLegalNonCaptureMove(1,1));
        assertTrue(a.isLegalNonCaptureMove(1,3));/*test 0*//*test many*/
    }

    @Test
    public void testIsLegalNonCaptureMoveVerti(){
        ChessBoard test = new ChessBoard(8,8,new Display(), new IChess());
        Piece a = new QueenPiece(test,Color.RED, "Q", IChess.Side.NORTH,null);
        test.addPiece(a,3,3);;
        test.addPiece(new BishopPiece(test, Color.WHITE, "C", IChess.Side.SOUTH,null),3,1);
        assertFalse(a.isLegalNonCaptureMove(3,3));/*test 0*/
        assertTrue(a.isLegalNonCaptureMove(3,2));/*test 1*/
        assertTrue(a.isLegalNonCaptureMove(3,6));
        assertTrue(a.isLegalNonCaptureMove(6,6));/*test many*/
    }
}