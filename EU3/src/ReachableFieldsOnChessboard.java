import java.util.Random;
// 2) Pieces are actually not of a different type
// They are all of type Chesspiece
// However, they take part in one subclass of that,
// but they still inherit the properties from the superclass, so they can be stored in the same array
// Otherwise, the whole program would be a mess of declaring
// and instantiating new objects that are similar but of different subclass

// 3) Pieces are presented in a loop because there is an array
// that stores all the pieces, so you can go through the array
// Otherwise, you had to call the specific class for each object.
public class ReachableFieldsOnChessboard {
	public static void probablySecondMain() throws InterruptedException{
		System.out.println("____________________________");
		System.out.println("____________________________");
		System.out.println("____________________________");
		System.out.println("____________________________");
		System.out.println("PART TWO: ");
		Chessboard chessBoard = new Chessboard ();
		System.out.println (chessBoard + "\n");
		Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[6];
		pieces[0] = chessBoard.new Pawn('w', 'P');
		pieces[1] = chessBoard.new Rook('b', 'R');
		pieces[2] = chessBoard.new Queen('w', 'Q');
		pieces[3] = chessBoard.new Bishop('w', 'B');
		pieces[4] = chessBoard.new King('b', 'K');
		pieces[5] = chessBoard.new Knight('w', 'N');
		final int FIRST_ROW = 'a';
		final int FIRST_COLUMN = 1;
		Random rand = new Random();
		
		for(int i = 0 ; i < 6; i++) {
			pieces[i].setColumn((byte)(FIRST_COLUMN + rand.nextInt(7)));
			pieces[i].setRow((char)(FIRST_ROW + rand.nextInt(7)));
			chessBoard.setFields(pieces[i]);
			System.out.println(chessBoard.toString());
			pieces[i].markReachableFields();
			System.out.println(chessBoard.toString());
			Thread.sleep(3000);
			pieces[i].unmarkReachableFields();
			System.out.println(chessBoard.toString());
			pieces[i].moveOut();
			System.out.println(chessBoard.toString());
			Thread.sleep(1000);
		}
	}
}
