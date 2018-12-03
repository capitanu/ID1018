public class Chessboard {
	public static class Field

	{
		@SuppressWarnings("unused")
		private char row; 
		@SuppressWarnings("unused")
		private byte column; 
		private Chesspiece piece = null;
		private boolean marked = false;
		public Field (char row, byte column) {
			this.column = column;
			this.row = row;
		}
		public Chesspiece take() {
			this.piece = null;
			return piece;
		}
		public void put (Chesspiece piece) {
			this.piece = piece;
		}
		public void mark () {
			this.marked = true;
		}
		public void unmark () {
			this.marked = false;
		}
		public String toString () {
			String s = (marked)? "xx" : "--";
			return (piece == null) ? s : piece.toString (); 
		}
	}
	public static final int NUMBER_OF_ROWS = 8; 
	public static final int NUMBER_OF_COLUMNS = 8;
	public static final int FIRST_ROW = 'a';
	public static final int FIRST_COLUMN = 1;
	private Field[][] fields;
	public Chessboard () {
		fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS]; 
		char row = 0;
		byte column = 0; 
		for (int r = 0; r < NUMBER_OF_ROWS; r++) {
			row = (char) (FIRST_ROW + r); 
			column = FIRST_COLUMN;
			for (int c = 0; c < NUMBER_OF_COLUMNS; c++) { 
				fields[r][c] = new Field (row, column); 
				column++;
			}
		} 

	}
	public String toString () {
		StringBuilder rtn = new StringBuilder();
		for(int i = 0; i < 8; i++)
		{for(int j = 0; j < 8; j++)
			rtn.append(fields[i][j].toString() + " " );
		rtn.append(System.getProperty("line.separator"));
		}
		return rtn.toString();
	}
	public void setFields(Chesspiece piece) {
		this.fields[(int)(piece.getRow() - FIRST_ROW)][(int)piece.getColumn() - 1].piece = piece;
	}
	public boolean isValidField (char row, byte column) {
		boolean rtn;
		if ((int)(row - FIRST_ROW) <= NUMBER_OF_ROWS && 
				(int)column <= NUMBER_OF_COLUMNS )
			rtn = true;
		else rtn = false;

		return rtn;
	}
	public abstract class Chesspiece {
		private char color;
		// w - white , b - black
		private char name;
		// K - King , Q - Queen , R - Rook , B - Bishop , N - Knight , 
		// P Pawn
		protected char row = 0;
		protected byte column = -1;
		public char getRow()
		{
			return this.row;
		}
		public byte getColumn() {
			return this.column;
		}
		public void setRow(char c) {
			this.row = c;
		}
		public void setColumn(byte b)
		{
			this.column = b;
		}
		protected Chesspiece (char color , char name) {
			this.color = color;
			this.name = name;
		}
		public String toString () {
			return "" + color + name; 
		}
		public boolean isOnBoard () { 
			return Chessboard.this.isValidField (row, column); 
		}

		public void moveTo (char row, byte column) throws NotValidFieldException {
			if (!Chessboard.this.isValidField (row, column)) throw new NotValidFieldException ("bad field: " + row + column );
			char rtemp = this.row;
			byte ctemp = this.column;
			this.row = row; 
			this.column = column;
			int r = row - FIRST_ROW; 
			int c = column - FIRST_COLUMN; 
			Chessboard.this.fields[r][c].put(this);
			Chessboard.this.fields[rtemp - FIRST_ROW][ctemp - FIRST_COLUMN].piece = null;
			
			
			//TODO 
		}
		public void moveOut () {
			Chessboard.this.fields[this.row - FIRST_ROW][this.column - 1].piece = null;
		}
		public abstract void markReachableFields ();
		public abstract void unmarkReachableFields ();
	}
	public class Pawn extends Chesspiece { 
		public Pawn (char color , char name) { 
			super (color , name); 
		}
		public void markReachableFields () {
			byte col = (byte) (column + 1);
			if (Chessboard.this.isValidField (row, col)) {
				int r = row - FIRST_ROW;
				int c = col - FIRST_COLUMN; 
				Chessboard.this.fields[r][c].mark (); 
			} 
		}
		public void unmarkReachableFields () {
			byte col = (byte) (column + 1); 
			if (Chessboard.this.isValidField (row, col)) {
				int r = row - FIRST_ROW; 
				int c = col - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark (); 
			} 
		}
	}
	public class Rook extends Chesspiece {
		public Rook (char color, char name) {
			super (color, name);
		}
		public void markReachableFields() {
			int r = row - FIRST_ROW;
			int c = column - FIRST_COLUMN;
			for(int i = 0; i < c; i++)
				Chessboard.this.fields[r][i].mark();
			for(int i = c+1; i < NUMBER_OF_COLUMNS; i++) 
				Chessboard.this.fields[r][i].mark();
			for(int i = 0; i < r; i++)
				Chessboard.this.fields[i][c].mark();
			for(int i = r + 1; i < NUMBER_OF_ROWS; i++)
				Chessboard.this.fields[i][c].mark();
		}
		public void unmarkReachableFields() {
			int r = row - FIRST_ROW;
			int c = column - FIRST_COLUMN;
			for(int i = 0; i < c; i++)
				Chessboard.this.fields[r][i].unmark();
			for(int i = c+1; i < NUMBER_OF_COLUMNS; i++) 
				Chessboard.this.fields[r][i].unmark();
			for(int i = 0; i < r; i++)
				Chessboard.this.fields[i][c].unmark();
			for(int i = r + 1; i < NUMBER_OF_ROWS; i++)
				Chessboard.this.fields[i][c].unmark();

		}

	}
	public class Knight extends Chesspiece {
		public Knight (char color, char name) {
			super (color, name);
		}
		public void markReachableFields() {
			int r = row - FIRST_ROW;
			int c = column - FIRST_COLUMN;
			int i,j;
			i = r + 2;
			j = c + 1;
			if ( i < NUMBER_OF_ROWS && j < NUMBER_OF_COLUMNS)
				Chessboard.this.fields[i][j].mark();
			i = r + 2;
			j = c - 1;
			if ( i < NUMBER_OF_ROWS && j >= 0)
				Chessboard.this.fields[i][j].mark();
			i = r + 1;
			j = c + 2;
			if ( i < NUMBER_OF_ROWS && j < NUMBER_OF_COLUMNS)
				Chessboard.this.fields[i][j].mark();
			i = r + 1;
			j = c - 2;
			if ( i < NUMBER_OF_ROWS && j >= 0)
				Chessboard.this.fields[i][j].mark();
			i = r - 2;
			j = c + 1;
			if ( i >= 0 && j < NUMBER_OF_COLUMNS)
				Chessboard.this.fields[i][j].mark();
			i = r - 2;
			j = c - 1;
			if ( i >= 0 && j >= 0)
				Chessboard.this.fields[i][j].mark();
			i = r - 1;
			j = c + 2;
			if ( i >= 0 && j < NUMBER_OF_COLUMNS)
				Chessboard.this.fields[i][j].mark();
			i = r - 1;
			j = c - 2;
			if ( i >= 0 && j >= 0)
				Chessboard.this.fields[i][j].mark();


		}
		public void unmarkReachableFields() {
			int r = row - FIRST_ROW;
			int c = column - FIRST_COLUMN;
			int i,j;
			i = r + 2;
			j = c + 1;
			if ( i < NUMBER_OF_ROWS && j < NUMBER_OF_COLUMNS)
				Chessboard.this.fields[i][j].unmark();
			i = r + 2;
			j = c - 1;
			if ( i < NUMBER_OF_ROWS && j >= 0)
				Chessboard.this.fields[i][j].unmark();
			i = r + 1;
			j = c + 2;
			if ( i < NUMBER_OF_ROWS && j < NUMBER_OF_COLUMNS)
				Chessboard.this.fields[i][j].unmark();
			i = r + 1;
			j = c - 2;
			if ( i < NUMBER_OF_ROWS && j >= 0)
				Chessboard.this.fields[i][j].unmark();
			i = r - 2;
			j = c + 1;
			if ( i >= 0 && j < NUMBER_OF_COLUMNS)
				Chessboard.this.fields[i][j].unmark();
			i = r - 2;
			j = c - 1;
			if ( i >= 0 && j >= 0)
				Chessboard.this.fields[i][j].unmark();
			i = r - 1;
			j = c + 2;
			if ( i >= 0 && j < NUMBER_OF_COLUMNS)
				Chessboard.this.fields[i][j].unmark();
			i = r - 1;
			j = c - 2;
			if ( i >= 0 && j >= 0)
				Chessboard.this.fields[i][j].unmark();


		}
	}
	public class Bishop extends Chesspiece {
		public Bishop (char color, char name) {
			super (color, name);
		}
		public void markReachableFields() {
			int r = row - FIRST_ROW;
			int c = column - FIRST_COLUMN;
			int i = r-1, j = c-1;
			while(0 <= i && 0 <= j)
				Chessboard.this.fields[i--][j--].mark();
			i = r - 1;
			j = c + 1;
			while(i >= 0 && j < NUMBER_OF_COLUMNS)
				Chessboard.this.fields[i--][j++].mark();
			i = r + 1;
			j = c - 1;
			while(i < NUMBER_OF_ROWS && j >= 0)
				Chessboard.this.fields[i++][j--].mark();
			i = r + 1;
			j = c + 1;
			while(i < NUMBER_OF_ROWS && j < NUMBER_OF_COLUMNS)
				Chessboard.this.fields[i++][j++].mark();
		}
		public void unmarkReachableFields() {
			int r = row - FIRST_ROW;
			int c = column - FIRST_COLUMN;
			int i = r-1, j = c-1;
			while(0 <= i && 0 <= j)
				Chessboard.this.fields[i--][j--].unmark();
			i = r - 1;
			j = c + 1;
			while(i >= 0 && j < NUMBER_OF_COLUMNS)
				Chessboard.this.fields[i--][j++].unmark();
			i = r + 1;
			j = c - 1;
			while(i < NUMBER_OF_ROWS && j >= 0)
				Chessboard.this.fields[i++][j--].unmark();
			i = r + 1;
			j = c + 1;
			while(i < NUMBER_OF_ROWS && j < NUMBER_OF_COLUMNS)
				Chessboard.this.fields[i++][j++].unmark();
		}
	}
	public class Queen extends Chesspiece {
		public Queen (char color, char name) {
			super (color, name);
		}
		public void markReachableFields() {
			int r = row - FIRST_ROW;
			int c = column - FIRST_COLUMN;
			int i = r-1, j = c-1;
			while(0 <= i && 0 <= j)
				Chessboard.this.fields[i--][j--].mark();
			i = r - 1;
			j = c + 1;
			while(i >= 0 && j < NUMBER_OF_COLUMNS)
				Chessboard.this.fields[i--][j++].mark();
			i = r + 1;
			j = c - 1;
			while(i < NUMBER_OF_ROWS && j >= 0)
				Chessboard.this.fields[i++][j--].mark();
			i = r + 1;
			j = c + 1;
			while(i < NUMBER_OF_ROWS && j < NUMBER_OF_COLUMNS)
				Chessboard.this.fields[i++][j++].mark();
			for( i = 0; i < c; i++)
				Chessboard.this.fields[r][i].mark();
			for( i = c+1; i < NUMBER_OF_COLUMNS; i++) 
				Chessboard.this.fields[r][i].mark();
			for( i = 0; i < r; i++)
				Chessboard.this.fields[i][c].mark();
			for(i = r + 1; i < NUMBER_OF_ROWS; i++)
				Chessboard.this.fields[i][c].mark();
		}
		public void unmarkReachableFields() {


			int r = row - FIRST_ROW;
			int c = column - FIRST_COLUMN;
			int i = r-1, j = c-1;
			while(0 <= i && 0 <= j)
				Chessboard.this.fields[i--][j--].unmark();
			i = r - 1;
			j = c + 1;
			while(i >= 0 && j < NUMBER_OF_COLUMNS)
				Chessboard.this.fields[i--][j++].unmark();
			i = r + 1;
			j = c - 1;
			while(i < NUMBER_OF_ROWS && j >= 0)
				Chessboard.this.fields[i++][j--].unmark();
			i = r + 1;
			j = c + 1;
			while(i < NUMBER_OF_ROWS && j < NUMBER_OF_COLUMNS)
				Chessboard.this.fields[i++][j++].unmark();
			for(i = 0; i < c; i++)
				Chessboard.this.fields[r][i].unmark();
			for(i = c+1; i < NUMBER_OF_COLUMNS; i++) 
				Chessboard.this.fields[r][i].unmark();
			for(i = 0; i < r; i++)
				Chessboard.this.fields[i][c].unmark();
			for(i = r + 1; i < NUMBER_OF_ROWS; i++)
				Chessboard.this.fields[i][c].unmark();
		}

	}
	public class King extends Chesspiece {
		public King (char color, char name) {
			super (color, name);
		}
			public void markReachableFields() {
				int r = row - FIRST_ROW;
				int c = column - FIRST_COLUMN;
				if(r-1 >= 0 && c+1 < NUMBER_OF_COLUMNS)
					Chessboard.this.fields[r-1][c+1].mark();
				if( r + 1 < NUMBER_OF_ROWS && c - 1 >= 0 )
					Chessboard.this.fields[r+1][c-1].mark();
				if( r - 1 >= 0 && c - 1 > 0 )
					Chessboard.this.fields[r-1][c-1].mark();
				if( c -1 >= 0)
					Chessboard.this.fields[r][c-1].mark();
				if( r - 1 >= 0 )
					Chessboard.this.fields[r-1][c].mark();
				if( c + 1 < NUMBER_OF_COLUMNS )
					Chessboard.this.fields[r][c+1].mark();
				if( r + 1 < NUMBER_OF_ROWS)
					Chessboard.this.fields[r+1][c].mark();
				if( r + 1 < NUMBER_OF_ROWS && c + 1 < NUMBER_OF_COLUMNS)
					Chessboard.this.fields[r+1][c+1].mark();

			}
			public void unmarkReachableFields() {
				int r = row - FIRST_ROW;
				int c = column - FIRST_COLUMN;
				if(r-1 >= 0 && c+1 < NUMBER_OF_COLUMNS)
					Chessboard.this.fields[r-1][c+1].unmark();
				if( r + 1 < NUMBER_OF_ROWS && c - 1 >= 0 )
					Chessboard.this.fields[r+1][c-1].unmark();
				if( r - 1 >= 0 && c - 1 > 0 )
					Chessboard.this.fields[r-1][c-1].unmark();
				if( c -1 >= 0)
					Chessboard.this.fields[r][c-1].unmark();
				if( r - 1 >= 0 )
					Chessboard.this.fields[r-1][c].unmark();
				if( c + 1 < NUMBER_OF_COLUMNS )
					Chessboard.this.fields[r][c+1].unmark();
				if( r + 1 < NUMBER_OF_ROWS)
					Chessboard.this.fields[r+1][c].unmark();
				if( r + 1 < NUMBER_OF_ROWS && c + 1 < NUMBER_OF_COLUMNS)
					Chessboard.this.fields[r+1][c+1].unmark();

			}
		}
		public class NotValidFieldException extends Exception{
			public NotValidFieldException(String s)
			{
				System.err.println(s);
			}

		}
	}




