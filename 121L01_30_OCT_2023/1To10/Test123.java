// An educational app using an array of labels
//
// File name: Test123.java
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;

class Teach123 extends JFrame
{
	private JLabel [ ] labelArray;
	
	public Teach123 ()
	{
		super ("Teach 123");
		setLayout (new FlowLayout ());
		
		// Construct our array
		labelArray = new JLabel [10];
		
		// Initialize our array
		for (int k = 0; k < labelArray.length; k++)
		{
			labelArray [k] = new JLabel ();
			labelArray [k].setText ("Label " + (k + 1));
			
			// We wish to put images on the labels
			String imageFile = String.valueOf  (k + 1) + ".jpg";
			Icon ic = new ImageIcon (imageFile);
			labelArray [k].setIcon (ic);
			
			labelArray [k].setToolTipText ("This is " + (k + 1));
		}
		
		// Add all labels to JFrame
		for (JLabel aLabel : labelArray)
			add (aLabel);
	}	
}

class Test123
{
	public static void main (String [ ] args)
	{
		Teach123 t123 = new Teach123 ();
		t123.setVisible (true);
		t123.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		t123.setSize (200, 300);
	}
}