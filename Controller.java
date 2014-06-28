/**
 * initiates problem solving by calling model.solve 
 * and then a thread solves the puzzle.
 * @author Melbourne Lipardo
 */
public class Controller implements Runnable
{  
	private Model model ;
	
	public Controller (Model m){  model = m; }
	
	public void run()
	{  
		try
		{  
			Thread.sleep( 1000 ) ; // delay to see the initial position
			model.solve(0,0); // to solve the puzzle in the top left corner
		}
		catch( Exception e ){ }	
	}
	
}// end class