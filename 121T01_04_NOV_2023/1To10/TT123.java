// Using an array of JTextField to teach 123

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Teach123 extends JFrame implements ActionListener
{
	private final JTextField [] jtfArray;
	private final JLabel [] labelArray;
	private final String [] numberArray = {"One", "Two", "Three", "Four", "Five", "Six",
																	"Seven", "Eight", "Nine", "Ten"};
	
	public Teach123()
	{
		super ("Teach123");
		setLayout(new FlowLayout());
		
		// Construct Arrays
		jtfArray = new JTextField [numberArray.length];
		labelArray = new JLabel [numberArray.length];
		
		// Initialize the 2 arrays
		for (int i = 0; i < jtfArray.length; i++)
		{
			jtfArray [i] = new JTextField (10);
		}
		
		for (int i = 0; i < labelArray.length; i++)
		{
			labelArray [i] = new JLabel();
			
			String imageFile = "" + (i + 1) + ".jpg";
			Icon ic = new ImageIcon (imageFile);
			labelArray [i].setIcon (ic);
		}
		
		// Add GUI component to JFrame
		for (int i = 0; i < jtfArray.length; i++)
		{
			add(labelArray [i]);
			add(jtfArray [i]);
		}
		
		// Register event to each text field
		for (JTextField jtf : jtfArray)
		{
			jtf.addActionListener(this);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String s;
		boolean ok;
		
		for (int i = 0; i < jtfArray.length; i++)
		{
			if (e.getSource() == jtfArray [i])
			{
				s = jtfArray [i].getText();
				
				if (s.equalsIgnoreCase (numberArray [i]))
					ok = true;
				else
					ok = false;
			
				if (ok == true)
					s = "I am " + numberArray[i] + ". Well done! You are right.";
				else
					s = "I am " + numberArray[i] + ". You are wrong, try again!";
				
				Icon ic = labelArray [i].getIcon();
				JOptionPane.showMessageDialog(null, s, "Teach123", JOptionPane.PLAIN_MESSAGE, ic);
			}
		}
	}
}

class TT123
{
	public static void main (String [ ] args)
	{
		Teach123 t123 = new Teach123();
		t123.setSize(200, 300);
		t123.setVisible(true);
		t123.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
