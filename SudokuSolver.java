/**
 * Aclient program. It put model, view and controller 
 * together and have them communicate
 * @author Melbourne Lipardo
 */
public class SudokuSolver {
	
	public static void main(String args[])
	{
		Model model = new Model();
		ButtonView view = new ButtonView(model);
		
		view.build();
		model.attach(view);
		
		Runnable r = new Controller(model);
		Thread t = new Thread(r);
		
		
		t.start();
	}// end main
}// end SudokuSolver
