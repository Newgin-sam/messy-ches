class ChessBoard{
    private ChessPiece[][] board = new ChessPiece[8][8];
    
    public ChessBoard(){
        initialize();
    }
    public ChessBoard(ChessPiece[][] initChessBoard){
        board = initChessBoard;
    }

    public void initialize(){
    	this.placePiece(new Rook(this,ChessPiece.Color.WHITE), "a1");
    	this.placePiece(new Rook(this,ChessPiece.Color.WHITE), "h1");
    	this.placePiece(new Knight(this,ChessPiece.Color.WHITE), "b1");
    	this.placePiece(new Knight(this,ChessPiece.Color.WHITE), "g1");
    	this.placePiece(new Bishop(this,ChessPiece.Color.WHITE), "c1");
    	this.placePiece(new Bishop(this,ChessPiece.Color.WHITE), "f1");
    	this.placePiece(new Queen(this,ChessPiece.Color.WHITE), "d1");
    	this.placePiece(new King(this,ChessPiece.Color.WHITE), "e1");
    	this.placePiece(new Pawn(this,ChessPiece.Color.WHITE), "a2");
    	this.placePiece(new Pawn(this,ChessPiece.Color.WHITE), "b2");
    	this.placePiece(new Pawn(this,ChessPiece.Color.WHITE), "c2");
    	this.placePiece(new Pawn(this,ChessPiece.Color.WHITE), "d2");
    	this.placePiece(new Pawn(this,ChessPiece.Color.WHITE), "e2");
    	this.placePiece(new Pawn(this,ChessPiece.Color.WHITE), "f2");
    	this.placePiece(new Pawn(this,ChessPiece.Color.WHITE), "g2");
    	this.placePiece(new Pawn(this,ChessPiece.Color.WHITE), "h2");

        
        this.placePiece(new Rook(this,ChessPiece.Color.BLACK), "a8");
        this.placePiece(new Rook(this,ChessPiece.Color.BLACK), "h8");
        this.placePiece(new Knight(this,ChessPiece.Color.BLACK), "b8");
        this.placePiece(new Knight(this,ChessPiece.Color.BLACK), "g8");
        this.placePiece(new Bishop(this,ChessPiece.Color.BLACK), "c8");
        this.placePiece(new Bishop(this,ChessPiece.Color.BLACK), "f8");
        this.placePiece(new Queen(this,ChessPiece.Color.BLACK), "d8");
        this.placePiece(new King(this,ChessPiece.Color.BLACK), "e8");
        this.placePiece(new Pawn(this,ChessPiece.Color.BLACK), "a7");
        this.placePiece(new Pawn(this,ChessPiece.Color.BLACK), "b7");
        this.placePiece(new Pawn(this,ChessPiece.Color.BLACK), "c7");
        this.placePiece(new Pawn(this,ChessPiece.Color.BLACK), "d7");
        this.placePiece(new Pawn(this,ChessPiece.Color.BLACK), "e7");
        this.placePiece(new Pawn(this,ChessPiece.Color.BLACK), "f7");
        this.placePiece(new Pawn(this,ChessPiece.Color.BLACK), "g7");
        this.placePiece(new Pawn(this,ChessPiece.Color.BLACK), "h7");
        
    }

    public ChessPiece getPiece(int row, int col){
    	ChessPiece current = board[row][col];
    	
    	return current;
    }
    
    public ChessPiece getPiece(String position){
    	try {
    		ChessPiece current;
    		int row = position.charAt(1)- 49;
    		int col = position.charAt(0) - 97;
    		if(0<row && row<8 && 0<col && col<8 && board[row][col] != null) {
    			current = board[row][col];
    		}
    		else {
    			throw new IllegalPositionException();
    		}
    		return current;	    	
    	}
    	catch (IllegalPositionException e) {
    		System.out.println(e);
    	}
		return null;
	}
    public ChessPiece[][] getBoard(){
    	System.out.println("Inside getboard");
    	return board;
    }

    public boolean placePiece(ChessPiece piece, String position){
    	try {
    		piece.setPosition(position);
    		if(board[piece.row][piece.column] == null) {    	
    			board[piece.row][piece.column] = piece;
    			return true;
    		}
    	}
    	catch(IllegalPositionException e){
    		System.out.println(e);
    	}
    	return false;	
    }

    public void move(String fromPosition, String toPosition) throws IllegalMoveException {
        int[] from = new int[2];
        int[] to = new int[2];
        
        from[0] = fromPosition.charAt(1)- 49;
        from[1] = fromPosition.charAt(0) - 97;
        
        to[0] = toPosition.charAt(1)- 49;
        to[1] = toPosition.charAt(0) - 97;
        
        try {
	        System.out.println(fromPosition.charAt(0) +" "+ from[0]+ "  " + from[1] +" "+to[0]+" "+to[1]);
	        
	        if(from[0]>=0 && from[0]<8 && from[1]>=0 && from[1]<8 && to[0]>=0 && to[0]<8 && to[1]>=0 && to[1]<8 ) {
	        	
	        
		        ChessPiece current = board[from[0]][from[1]];
		        ChessPiece Future = board[to[0]][to[1]];
		 
		        System.out.println(Future);
	        
	        
				if( current != null && (Future == null || current.color != Future.color) && current !=null && !(to[0] == from[0] && to[1] == from[1]) && current.isValidMove(from, to)) {
					System.out.println(true);
					board[from[0]][from[1]] = null;
					board[to[0]][to[1]] = current;
				}
				else {
					throw new IllegalMoveException();
				}   
	        }
	        else {
	        	System.out.println("Out of Bound");
	        	throw new IllegalMoveException();
	        }
        	
        	
        }catch (IllegalMoveException e) {
        	System.out.println(e);
        }
        
//        if(board[toPosition.charAt(1) - 49][toPosition.charAt(0) - 97].getColor() == board[index1 - 49][index0 - 97].getColor()) {
//            board[toPosition.charAt(1) - 49][toPosition.charAt(0) - 97] = board[index1 - 49][index0 - 97];
//            board[index1 - 49][index0 - 97] = null;
//        }else {
//            throw new IllegalMoveException();
//        }
    }
    
    

    @Override
    public String toString(){
        String chess="";
        String upperLeft = "\u250C";
        String upperRight = "\u2510";
        String horizontalLine = "\u2500";
        String horizontal3 = horizontalLine + "\u3000" + horizontalLine;
        String verticalLine = "\u2502";
        String upperT = "\u252C";
        String bottomLeft = "\u2514";
        String bottomRight = "\u2518";
        String bottomT = "\u2534";
        String plus = "\u253C";
        String leftT = "\u251C";
        String rightT = "\u2524";

        String topLine = upperLeft;
        for (int i = 0; i<7; i++){
            topLine += horizontal3 + upperT;
        }
        topLine += horizontal3 + upperRight;

        String bottomLine = bottomLeft;
        for (int i = 0; i<7; i++){
            bottomLine += horizontal3 + bottomT;
        }
        bottomLine += horizontal3 + bottomRight;
        chess+=topLine + "\n";

        for (int row = 7; row >=0; row--){
            String midLine = "";
            for (int col = 0; col < 8; col++){
                if(board[row][col]==null) {
                    midLine += verticalLine + " \u3000 ";
                } else {midLine += verticalLine + " "+board[row][col]+" ";}
            }
            midLine += verticalLine;
            String midLine2 = leftT;
            for (int i = 0; i<7; i++){
                midLine2 += horizontal3 + plus;
            }
            midLine2 += horizontal3 + rightT;
            chess+=midLine+ "\n";
            if(row>=1)
                chess+=midLine2+ "\n";
        }

        chess+=bottomLine;
        return chess;
    }


}
