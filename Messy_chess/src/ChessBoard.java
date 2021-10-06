class ChessBoard{
    private ChessPiece[][] board = new ChessPiece[8][8];
    
    public ChessBoard(){
        initialize();
    }
    public ChessBoard(ChessPiece[][] initChessBoard){
        board = initChessBoard;
    }

    public void initialize(){
        board[0][0] = new Rook(ChessPiece.Color.WHITE);
        board[0][1] = new Knight(ChessPiece.Color.WHITE);
        board[0][2] = new Bishop(ChessPiece.Color.WHITE);
        board[0][3] = new Queen(ChessPiece.Color.WHITE);
        board[0][4] = new King(ChessPiece.Color.WHITE);
        board[0][5] = new Bishop(ChessPiece.Color.WHITE);
        board[0][6] = new Knight(ChessPiece.Color.WHITE);
        board[0][7] = new Rook(ChessPiece.Color.WHITE);
        board[1][0] = new Pawn(ChessPiece.Color.WHITE);
        board[1][1] = new Pawn(ChessPiece.Color.WHITE);
        board[1][2] = new Pawn(ChessPiece.Color.WHITE);
        board[1][3] = new Pawn(ChessPiece.Color.WHITE);
        board[1][4] = new Pawn(ChessPiece.Color.WHITE);
        board[1][5] = new Pawn(ChessPiece.Color.WHITE);
        board[1][6] = new Pawn(ChessPiece.Color.WHITE);
        board[1][7] = new Pawn(ChessPiece.Color.WHITE);
        
//        board[2][1] = new Pawn(ChessPiece.Color.WHITE);
        
        board[7][0] = new Rook(ChessPiece.Color.BLACK);
        board[7][1] = new Knight(ChessPiece.Color.BLACK);
        board[7][2] = new Bishop(ChessPiece.Color.BLACK);
        board[7][3] = new Queen(ChessPiece.Color.BLACK);
        board[7][4] = new King(ChessPiece.Color.BLACK);
        board[7][5] = new Bishop(ChessPiece.Color.BLACK);
        board[7][6] = new Knight(ChessPiece.Color.BLACK);
        board[7][7] = new Rook(ChessPiece.Color.BLACK);
        board[6][0] = new Pawn(ChessPiece.Color.BLACK);
        board[6][1] = new Pawn(ChessPiece.Color.BLACK);
        board[6][2] = new Pawn(ChessPiece.Color.BLACK);
        board[6][3] = new Pawn(ChessPiece.Color.BLACK);
        board[6][4] = new Pawn(ChessPiece.Color.BLACK);
        board[6][5] = new Pawn(ChessPiece.Color.BLACK);
        board[6][6] = new Pawn(ChessPiece.Color.BLACK);
        board[6][7] = new Pawn(ChessPiece.Color.BLACK);
    }

    public ChessPiece getPiece(int row, int col){
    	ChessPiece current = board[row][col];
    	
    	return current;
    }
    public ChessPiece[][] getBoard(){
    	System.out.println("Inside getboard");
    	return board;
    }

    public boolean placePiece(ChessPiece piece, String position){return true;}

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
	        
	        
				if( (Future == null || current.color != Future.color) && current !=null && !(to[0] == from[0] && to[1] == from[1]) && current.isValidMove(from, to, this.board)) {
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
