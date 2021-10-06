public class Bishop extends ChessPiece{

    public Bishop(Color color){
        this.color = color;
        this.name = "bishop";
    }

    public boolean isValidMove(int [] initPos,int [] finalPos , ChessPiece[][] initboard) {
    	
    	ChessBoard board = new ChessBoard(initboard);
    	System.out.println("hello bishop"+""+initPos[0] +" "+finalPos[0] + initPos[1] +" "+finalPos[1] );
    	
    	ChessPiece current = board.getPiece(initPos[0] , initPos[1]);
    	ChessPiece Future = board.getPiece(finalPos[0], finalPos[1]);
    	
    	if(Math.abs(initPos[0]-finalPos[0]) == Math.abs(initPos[1]-finalPos[1])) {
    		System.out.println("bishop entered");
    		if(initPos[0]<finalPos[0]) {
    			System.out.println("bishop entered up");
    			int j= initPos[1];
    			for(int i=initPos[0]+1; i<=finalPos[0]; i++) {
    				if(initPos[1]<finalPos[1]) {
    					j=j+1;
    					System.out.println("bishop entered"+i+j);
    					if(board.getPiece(i, j) != null) {
    						return false;
    					}
    					return true;
    					    					
    				}
    				else if(initPos[1]>=finalPos[1]) {
    					j=j-1;
						System.out.println("bishop entered"+i+j);
						if(board.getPiece(i, j) != null) {
							return false;
						}
						return true;
    				}
    			}
    		}else if(initPos[0]>finalPos[0]) {
    			System.out.println("bishop entered down"+initPos[0]+finalPos[0]+initPos[1]+finalPos[1]);
    			int j= initPos[1];
    			for(int i=initPos[0]-1; i>=finalPos[0]; i--) {
    				if(initPos[1]<finalPos[1]) {
    					j=j+1;    					
						System.out.println("bishop entered"+i+j);
						if(board.getPiece(i, j) != null) {
							return false;
						}
						return true;
    					
    				}
    				else if(initPos[1]>=finalPos[1]) {
    					j=j-1;
						System.out.println("bishop entered"+i+j);
						if(board.getPiece(i, j) != null) {
							return false;
						}
						return true;	
    				}
    			}
    			
    		}
    	}
    	
    	return false;
    }
    public String toString(){
        if (this.color == color.WHITE) {
            return "\u2657";
        }
        else {
            return "\u265D";
        }
    }
}
