import java.util.ArrayList;

public class Knight extends ChessPiece{

    public Knight(ChessBoard board,Color color){
    	super(board,color);
    }
    public ArrayList<String> legalMoves(){
    	ArrayList moves = new ArrayList();
    	return moves;
    }
    public boolean isValidMove(int [] initPos,int [] finalPos) {
    	return false;
    }
    public String toString(){
        if (this.color == color.WHITE) {
            return "\u2658";
        }
        else {
            return "\u265E";
        }
    }
}
