public class Rook extends ChessPiece{

    public Rook(Color color){
        this.color = color;
        this.name = "rook";
//        this.board = board;
    }

    public boolean isValidMove(){
        this.getPosition();
        return true;
    }
    public boolean isValidMove(int [] initPos,int [] finalPos , ChessPiece[][] initboard) {
    	
    	ChessBoard board = new ChessBoard(initboard);
    	System.out.println("hello rook"+""+initPos[0] +" "+finalPos[0] + initPos[1] +" "+finalPos[1] );
    	
    	ChessPiece current = board.getPiece(initPos[0] , initPos[1]);
    	ChessPiece Future = board.getPiece(finalPos[0], finalPos[1]);
    	
		if(initPos[0] == finalPos[0] ) {
			if(initPos[1]<finalPos[1]) {
				for(int i=initPos[1] + 1; i < finalPos[1];i++) {
					if(board.getPiece(initPos[0], i) != null) {
						return false;
					}
				}
				return true;
			}
			else if(initPos[1] > finalPos[1]) {
				
				for(int i=initPos[1] - 1; i > finalPos[1];i--) {
					if(board.getPiece(initPos[0], i) != null) {
						return false;
					}
				}
				return true;
			}
		}
		else if(initPos[1] == finalPos[1]) {
			if(initPos[0]<finalPos[0]) {
				for(int i=initPos[0] + 1; i<finalPos[0]; i++) {
					if(board.getPiece(i, initPos[0]) != null) {
						return false;
					}
				}
				return true;
			}
			else if(initPos[0] > finalPos[0]) {
				for(int i=initPos[0] - 1; i > finalPos[0]; i--) {
					if(board.getPiece(i, initPos[0]) != null) {
						return false;
					}
				}
				return true;
			}
		}
    	
    	return false;
    }

    public String toString(){
        if (this.color == Color.WHITE) {
            return "\u2656";
        }
        else {
            return "\u265C";
        }
    }
}
