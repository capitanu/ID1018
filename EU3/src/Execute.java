import java.util.Scanner;
// 2) Field is a Nested Class because 
public class Execute {
	public static void main(String[] args) throws InterruptedException, Chessboard.NotValidFieldException {
		Chessboard tx = new Chessboard();	
		Chessboard.Pawn pw = tx.new Pawn('w','P');
		System.out.println(tx.toString());
		Scanner in = new Scanner(System.in);
		System.out.print("Input Pawn row: ");
		pw.setRow(in.next().charAt(0));
		System.out.print("And column: ");
		pw.setColumn(in.nextByte());
		tx.setFields(pw);
		pw.markReachableFields();
		System.out.println(tx.toString());
		pw.unmarkReachableFields();
		System.out.println(tx.toString());
		pw.moveOut();
		System.out.println(tx.toString());
		Chessboard.Rook rk = tx.new Rook('b','R');
		System.out.print("Input Rook row: ");
		rk.setRow(in.next().charAt(0));
		System.out.print("And column: ");
		rk.setColumn(in.nextByte());
		tx.setFields(rk);
		rk.markReachableFields();
		System.out.println(tx.toString());
		rk.unmarkReachableFields();
		System.out.println(tx.toString());
		rk.moveTo('d', (byte) 3);
		System.out.println(tx.toString());
		rk.markReachableFields();
		System.out.println(tx.toString());
		rk.unmarkReachableFields();
		System.out.println(tx.toString());
		Chessboard.Knight kn = tx.new Knight('w' , 'N');
		System.out.print("Input knight row: ");
		kn.setRow(in.next().charAt(0));
		System.out.print("And column: ");
		kn.setColumn(in.nextByte());
		tx.setFields(kn);
		kn.markReachableFields();
		System.out.println(tx.toString());
		kn.unmarkReachableFields();
		System.out.println(tx.toString());
		in.close();
		ReachableFieldsOnChessboard.probablySecondMain();
	}
}
