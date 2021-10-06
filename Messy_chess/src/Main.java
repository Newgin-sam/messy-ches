public class Main {


    public static void main(String[] args) throws IllegalMoveException {
        ChessBoard board = new ChessBoard();
        board.initialize();
        board.toString();
        System.out.println(board.toString());
        System.out.println(board.getPiece(0,1).color == ChessPiece.Color.WHITE);
        board.move("e2", "e4");
        System.out.println(board.toString());
        board.move("e1", "e2");
        board.move("f7", "f5");
        board.move("f5", "e4");
        board.move("e2", "e3");
        board.move("e3", "e4");
        board.move("a2", "a4");
        board.move("a1", "a3");
        board.move("a3", "e3");
        board.move("d7", "d5");
        board.move("c8", "d7");
//        board.move("e3", "e2");
//        System.out.println(board.getPiece(2,4).name);
        System.out.println(board.toString());
//        board.move("a7", "a6");
//        System.out.println(board.toString());
//        board.move("a1", "a2");
//        System.out.println(board);
//        board.move("a2", "a7");
//        System.out.println(board);
    }
}
