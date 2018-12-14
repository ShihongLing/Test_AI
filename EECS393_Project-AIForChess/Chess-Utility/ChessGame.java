

/*a interface represent all chess game*/
public interface ChessGame{
  
  /*method stubs for legalPieceToPlace*/
  public boolean legalPieceToPlace(Piece piece);
  
  /*method stubs for makeMove*/
  public boolean makeMove(Piece piece,int x, int y);
  
  /* a inner class to define two different player*/
  public enum Side { NORTH, SOUTH };

}