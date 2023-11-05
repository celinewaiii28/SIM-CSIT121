// The use of label, text fields, images, JOptionPane ..
//
// How to drive an event?
//
// File name: MySecret.java
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Secret extends JFrame
{
	private final JTextField jtf;
	private final JLabel jl;
	private final Icon ic;
	
	public Secret ()
	{
		super ("What is my secret?");
		setLayout (new FlowLayout ());
		
		// Initialize each of the instance variables
		jtf = new JTextField (15);
		
		ic = new ImageIcon ("ic.gif");
		
		jl = new JLabel ("Hello Why!!");
		jl.setIcon (ic);
		
		// Add all componets to JFrame
		add (jl);
		add (jtf);
		
		// Register the event
		CSIT121 c121 = new CSIT121 ();
		jtf.addActionListener (c121);
	}
	
	// inner class
	private class CSIT121 implements ActionListener
	{
		@Override
		public void actionPerformed (ActionEvent e)
		{
			String s = "";
			
			if (e.getSource () == jtf)
				s = jtf.getText ();
	
			Icon icc = new ImageIcon ("clab.gif");
			
			JOptionPane.showMessageDialog (null, s, "Dont let UOW know", 
																				JOptionPane.ERROR_MESSAGE, icc);
		}
	}
}

class MySecret_a
{
	public static void main (String [ ] args)
	{
		Secret s = new Secret ();
		s.setSize (200, 300);
		s.setVisible (true);
		s.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	}
}