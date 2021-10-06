public class Queen extends ChessPiece{

    public Queen(Color color){
        this.color = color;
        this.name = "queen";
    }
    public boolean isValidMove(int [] initPos,int [] finalPos , ChessPiece[][] board) {
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
