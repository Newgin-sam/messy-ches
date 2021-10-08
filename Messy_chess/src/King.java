

public class King extends ChessPiece{

    public King(ChessBoard board,Color color){
    	super(board,color);
    }
    public boolean isValidMove(int [] initPos,int [] finalPos) {
    	
    	System.out.println("hello king"+""+initPos[0] +" "+finalPos[0] + initPos[1] +" "+finalPos[1] );
    	
    	ChessPiece current = this.board.getPiece(initPos[0] , initPos[1]);
    	ChessPiece Future = this.board.getPiece(finalPos[0], finalPos[1]);
    	
    	System.out.println(current.name);
    	

		if(Math.abs(initPos[0]-finalPos[0]) < 2 && Math.abs(initPos[1]-finalPos[1]) < 2 ) {
			return true;
    	}
    	return false;
    }
    
//    public void setPosition(String position) {
//    	this.column = position.charAt(1)- 49;
//        this.row = position.charAt(0) - 97;
//    }
    public String toString(){
        if (this.color == color.WHITE) {
            return "\u2654";
        }
        else {
            return "\u265A";
        }
    }
}
