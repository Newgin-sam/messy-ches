import java.util.ArrayList;

public class Queen extends ChessPiece{

    public Queen(ChessBoard board,Color color){
    	super(board,color);
    }
    public boolean isValidMove(int [] initPos,int [] finalPos ) {
    	return false;
    }
    public ArrayList<String> legalMoves(){
    	ArrayList moves = new ArrayList();
    	return moves;
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
