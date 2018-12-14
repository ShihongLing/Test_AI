import org.junit.*;
import static org.junit.Assert.*;
import java.awt.*;

/*a test class for ChessBoard*/  
public class ChessBoardTester{
  
  /*need test for constructor*/
  
  
  /*test addPiece method*/
  @Test
  public void testAddPiece(){
    ChessBoard test = new ChessBoard(9,10,new Display(), new Xiangqi());
    test.addPiece(new RookPiece(test,Color.RED, "R", Xiangqi.Side.NORTH,null),0,0);
    assertTrue(test.hasPiece(0,0));
  }
  
  /*test removePiece method*/
  @Test
  public void testRemovePiece(){
    ChessBoard test = new ChessBoard(9,10,new Display(), new Xiangqi());
    test.addPiece(new RookPiece(test,Color.RED, "R", Xiangqi.Side.NORTH,null),0,0);
    assertTrue(test.hasPiece(0,0));
    
    test.removePiece(0,0);
    assertFalse(test.hasPiece(0,0));
  }
  
  /*test getPiece method*/
  @Test
  public void testGetPiece(){
    ChessBoard test = new ChessBoard(9,10,new Display(), new Xiangqi());
    assertEquals(null,test.getPiece(0,0));
  }
  
  /*test hasPiece method*/
  @Test
  public void testHasPiece(){
    ChessBoard test = new ChessBoard(9,10,new Display(), new Xiangqi());
    assertFalse(test.hasPiece(0,0));
  }
}