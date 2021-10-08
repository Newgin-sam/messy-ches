

public class Queen extends ChessPiece{

    public Queen(ChessBoard board,Color color){
    	super(board,color);
    }
    public boolean isValidMove(int [] initPos,int [] finalPos ) {
    	return false;
    }

    public String toString(){
        if (this.color == Color.WHITE) {
            return "\u2655";
        }
        else {
            return "\u265B";
        }
    }
}
