public class King extends ChessPiece{

    public King(Color color){
        this.color = color;
        this.name = "king";
    }

    public boolean isValidMove(int [] initPos,int [] finalPos , ChessPiece[][] initboard) {
    	
    	ChessBoard board = new ChessBoard(initboard);
    	System.out.println("hello king"+""+initPos[0] +" "+finalPos[0] + initPos[1] +" "+finalPos[1] );
    	
    	ChessPiece current = board.getPiece(initPos[0] , initPos[1]);
    	ChessPiece Future = board.getPiece(finalPos[0], finalPos[1]);
    	
    	System.out.println(current.name);
    	

		if(Math.abs(initPos[0]-finalPos[0]) < 2 && Math.abs(initPos[1]-finalPos[1]) < 2 ) {
			return true;
    	}
    	return false;
    }
    public String toString(){
        if (this.color == color.WHITE) {
            return "\u2654";
        }
        else {
            return "\u265A";
        }
    }
}
