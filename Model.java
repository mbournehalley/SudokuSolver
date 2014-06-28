/**
 * Solves a sudoku puzzle by recursion and backtracking
 * @author Melbourne Lipardo
 */
public class Model {
	
	public Model()
	{
		model = new int[9][9] ;
		
		//Clean cells
		for( int row = 0; row < 9; row++ )
			for( int col = 0; col < 9; col++ )
				model[row][col] = 0 ;
		
		// Create the initial situation
	      model[0][0] = 9 ;
	      model[0][4] = 2 ;
	      model[0][6] = 7 ;
	      model[0][7] = 5 ;

	      model[1][0] = 6 ;
	      model[1][4] = 5 ;
	      model[1][7] = 4 ;

	      model[2][1] = 2 ;
	      model[2][3] = 4 ;
	      model[2][7] = 1 ;

	      model[3][0] = 2 ;
	      model[3][2] = 8 ;

	      model[4][1] = 7 ;
	      model[4][3] = 5 ;
	      model[4][5] = 9 ;
	      model[4][7] = 6 ;

	      model[5][6] = 4 ;
	      model[5][8] = 1 ;

	      model[6][1] = 1 ;
	      model[6][5] = 5 ;
	      model[6][7] = 8 ;

	      model[7][1] = 9 ;
	      model[7][4] = 7 ;
	      model[7][8] = 4 ;

	      model[8][1] = 8 ;
	      model[8][2] = 2 ;
	      model[8][4] = 4 ;
	      model[8][8] = 6 ;
	}
	
	/** Recursive function to find a valid number for one single cell */
	public void solve( int row, int col ) throws Exception
	{
		
		if( row > 8 ) // Throw an exception to stop the process if the puzzle is solved
			throw new Exception( "Solution found" ) ;
		
		if( model[row][col] != 0 ) // If the cell is not empty, continue with the next cell
			next( row, col ) ;
		else
		{
			for( int num = 1; num < 10; num++ )  // Find a valid number for the empty cell
	         {
	            if( checkRow(row,num) && checkCol(col,num) && checkBox(row,col,num) )
	            {
	            	model[row][col] = num ;
	            	button.updateView() ;
	               
	            	Thread.sleep( 1000 ) ;
	            	
	            	next( row, col ) ;  
	            }
	         }

	         // No valid number was found, clean up and return to caller
	         model[row][col] = 0 ;
	         button.updateView() ;
	      }
	   }
	
	/** Checks if num is an acceptable value for the given row */
	protected boolean checkRow( int row, int num )
	{
		for( int col = 0; col < 9; col++ )
			if( model[row][col] == num )
	            return false ;

	    return true ;
	}
	
	/** Checks if num is an acceptable value for the given column */
	protected boolean checkCol( int col, int num )
	{
		for( int row = 0; row < 9; row++ )
			if( model[row][col] == num )
				return false ;
		return true ;
	}
	
	/** Checks if num is an acceptable value for the box around row and col */
	protected boolean checkBox( int row, int col, int num )
	{
		row = (row / 3) * 3 ;
		col = (col / 3) * 3 ;
		
		for( int r = 0; r < 3; r++ )
			for( int c = 0; c < 3; c++ )
				if( model[row+r][col+c] == num )
					return false ;
		return true ;
	}
	
	/** Calls solve for the next cell */
	public void next( int row, int col ) throws Exception
	{
		if( col < 8 )
			solve( row, col + 1 ) ;
		else
			solve( row + 1, 0 ) ;
	}
	
	/** plug in multiple views */
	public void attach(ButtonView view)
	{
		button = view;
	}
	
	/** getters for data */
	public int[][] getnum(){ return model;}
	
	private int model[][];
	private ButtonView button;
	
} //end Model
