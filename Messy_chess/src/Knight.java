

public class Knight extends ChessPiece{

    public Knight(ChessBoard board,Color color){
    	super(board,color);
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
