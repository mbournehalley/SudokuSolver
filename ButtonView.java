import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Creates the View
 * @author Melbourne Lipardo
 */

public class ButtonView extends JFrame{
	
	public ButtonView(Model model)
	{
		themodel = model;
		a = themodel.getnum();
	}
	
	/** Creates an empty view */
	public void build()
	{
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(640, 480));
		panel.setLayout( new GridLayout(9,9) ) ;
		view = new JButton[9][9] ;
		
	      for( int row = 0; row < 9; row++ )
	      {
	         for( int col = 0; col < 9; col++ )
	         {
	            view[row][col]  = new JButton() ;
	            panel.add( view[row][col] ) ;
	         }
	      }
	      
	      add(panel);
	      
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      pack();
	      setVisible(true);
	}

	/** Updates the view of the button*/
	public void updateView()
	{
		a = themodel.getnum();
		for( int row = 0; row < 9; row++ )
			for( int col = 0; col < 9; col++ )
				if( a[row][col] != 0 )
					view[row][col].setText( String.valueOf(a[row][col]) ) ;
				else
					view[row][col].setText("");
	}
	
	private JButton view[][];
	private Model themodel;
	private int a [][];
}
