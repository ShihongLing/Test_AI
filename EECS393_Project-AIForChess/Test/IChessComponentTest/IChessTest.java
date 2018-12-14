import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*a class to test Xiangqi class*/
public class IChessTest{

    /*test makeMove method*/
    @Test
    public void testMakeMove(){
        IChess X = new IChess();
        ChessBoard test = new ChessBoard(8,8,new Display(), X);
        Piece a = new CastlePiece(test, Color.RED, "C", IChess.Side.NORTH,null);
        test.addPiece(a,0,0);
        X.makeMove(a,0,7);

        assertTrue(test.hasPiece(0,7));
        assertFalse(test.hasPiece(0,0));
    }

    /*test legalPieceToPlace method*/
    @Test
    public void testLegalPieceToPlace(){
        IChess X = new IChess();
        ChessBoard test = new ChessBoard(8,8,new Display(), X);
        Piece a = new CastlePiece(test,Color.RED, "C", IChess.Side.NORTH,null);
        Piece b = new CastlePiece(test,Color.WHITE, "C", IChess.Side.SOUTH,null);
        test.addPiece(a,0,0);
        test.addPiece(b,7,0);

        assertTrue(X.legalPieceToPlace(a));
        assertFalse(X.legalPieceToPlace(b));
        X.makeMove(a,0,7);
        assertTrue(X.legalPieceToPlace(b));
        assertFalse(X.legalPieceToPlace(a));
    }
}
