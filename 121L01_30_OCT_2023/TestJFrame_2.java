// A JFrame
//
// File name: TestJFrame_2.java
//
// Put in two labels inside the JFrame and explore a layout known as FlowLayout

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.FlowLayout;

class TestJFrame_2
{
	public static void main (String [ ] args)
	{
		JFrame aFrame = new JFrame ("This is my 2nd frame");
		aFrame.setLayout (new FlowLayout ());
		
		// Create two labels
		JLabel label1 = new JLabel ("Welcome to 121");
		JLabel label2 = new JLabel ("All the best");
		
		// Add the labels to the frame
		aFrame.add (label1);
		aFrame.add (label2);
		
		aFrame.setSize (200, 300);
		aFrame.setVisible (true);
		aFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	}
}