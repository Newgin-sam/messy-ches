public class Knight extends ChessPiece{

    public Knight(Color color){
        this.color = color;
        this.name = "knight";
    }

    public boolean isValidMove(int [] initPos,int [] finalPos , ChessPiece[][] board) {
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
