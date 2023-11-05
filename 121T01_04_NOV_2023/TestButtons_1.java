// various buttons
// - JButton
// - JCheckBox
// - JRadioButton

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import java.awt.FlowLayout;

class VariousButtons extends JFrame
{
	public VariousButtons ()
	{
		setLayout (new FlowLayout ());
		
		add (new JButton ("JButton 1"));
		add (new JButton ("JButton 2"));
		
		add (new JCheckBox ("JCheckBox 1"));
		add (new JCheckBox ("JCheckBox 2"));
		
		add (new JRadioButton ("JRadioButton 1"));
		add (new JRadioButton ("JRadioButton 2"));
	}

}

class TestButtons_1
{
	public static void main (String [ ] args)
	{
		VariousButtons vb = new VariousButtons ();
		vb.setSize (200, 100);
		vb.setVisible (true);
		vb.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	}
}