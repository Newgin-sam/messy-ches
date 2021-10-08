import java.util.ArrayList;

public class Pawn extends ChessPiece{

    public Pawn(ChessBoard board,Color color){
    	super(board,color);
    }

    //
    
    public boolean isValidMove(int [] initPos,int [] finalPos) {
    	
    	ChessPiece current = this.board.getPiece(initPos[0] , initPos[1]);
    	ChessPiece Future = this.board.getPiece(finalPos[0], finalPos[1]);
    	System.out.println("hello pawn"+""+Future );
    	
    		
    		if(Math.abs(initPos[0]-finalPos[0]) == 1 && Math.abs(initPos[1]-finalPos[1]) == 1 && Future != null) {
    			System.out.println("hello pawn007"+""+initPos[0] +""+ finalPos[0]);
    			if(current.color == ChessPiece.Color.WHITE && initPos[0] < finalPos[0] ) {
    				return true;
    			}
    			if(current.color == ChessPiece.Color.BLACK && initPos[0] > finalPos[0] ) {
    				return true;
    			}
    		}
    		
	    	if(initPos[0] == finalPos[0] && initPos[1] == finalPos[1]) {
	    		System.out.println("hello pawn1");
	    		return false;
	    	}
	    	if(Math.abs(initPos[0]-finalPos[0]) == 1 && Math.abs(initPos[1]-finalPos[1]) == 0) {
	    		System.out.println("hello pawn2");
	    		if(current.color == ChessPiece.Color.WHITE && initPos[0] < finalPos[0]) {
	    			return true;
	    		}
	    		if(current.color == ChessPiece.Color.BLACK && initPos[0] > finalPos[0]) {
	    			return true;

	    		}
	    	}
	    	if(Math.abs(initPos[0]-finalPos[0]) == 2 && Math.abs(initPos[1]-finalPos[1]) == 0 && (initPos[0] == 1 || initPos[0] == 6)) {
	    		
	    		if(this.board.getPiece(initPos[0] , initPos[1]).color == ChessPiece.Color.WHITE) {
	    			if(initPos[0] < finalPos[0]) {
	    				if(this.board.getPiece(finalPos[0] - 1, finalPos[1]) == null) {
	    					return true;	    					
	    				}
	    			}
	    		}
	    		if(this.board.getPiece(initPos[0] , initPos[1]).color == ChessPiece.Color.BLACK) {
	    			if(initPos[0] > finalPos[0]) {
	    				if(this.board.getPiece(finalPos[0] + 1 , finalPos[1]) == null) {
	    					return true;	    					
	    				}
	    			}
	    		}
	    	}
    	
    	return false;
    }
    
    public ArrayList<String> legalMoves(){
    	ArrayList moves = new ArrayList();
    	return moves;
    }

    public String toString(){
        if (this.color == color.WHITE) {
            return "\u2659";
        }
        else {
            return "\u265F";
        }
    }
}
