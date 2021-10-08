abstract class ChessPiece {
    protected ChessBoard board;
    public enum Color {WHITE, BLACK}
    protected int row;
    protected int column;
    public String name;
    protected Color color;
    public ChessPiece(){
//    	board = this.get\\\
    }

    public ChessPiece(ChessBoard board, Color color){
    	this.board = board;
    	this.color = color;
    }

    public ChessPiece getPiece(String position) {
        return null;
    }
    public abstract boolean isValidMove(int [] initPos,int [] finalPos);

    public String getPosition(){return null;}


    public Color getColor(){ return  this.color;}

    public void setPosition(String position) throws IllegalPositionException {
    	try {
    		int rows = position.charAt(1)- 49;
    		int cols = position.charAt(0) - 97;
			if(0<rows && rows<8 && 0<cols && cols<8) {
				this.row = position.charAt(1)- 49;
	    		this.column = position.charAt(0) - 97;
			} else {
				throw new IllegalPositionException();
			}  		
    	} catch(IllegalPositionException e) {
    		
    	}
    }

    abstract public String toString();

}
