// various buttons
// - JButton
// arrange in GridLayout

import javax.swing.JFrame;
import javax.swing.JButton;


import java.awt.GridLayout;

class VariousButtons extends JFrame
{
	public VariousButtons ()
	{
		setLayout (new GridLayout (3, 4));
		
		for (int i = 1; i <= 12; i++)
			add (new JButton ("JButton " + i));
		
	}

}

class TestButtons_2
{
	public static void main (String [ ] args)
	{
		VariousButtons vb = new VariousButtons ();
		vb.setSize (200, 100);
		vb.setVisible (true);
		vb.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	}
}