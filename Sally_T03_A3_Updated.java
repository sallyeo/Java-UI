// Name: Sally
//
// UOW ID: 4603229
//
// Full time
//
// Tutorial group: T03
//
// Declaration: This is my work and I have not passed my program to anyone.
//				Otherwise, I am willing to be penalized.

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import java.util.Scanner;
import java.util.ArrayList;

class Qna extends JFrame
{
	private final JTextArea sMessageArea;
	private final JTextArea hMessageArea;
	private final JLabel hostLabel;
	private final JButton [] sjbArray; // Student buttons
	private final JButton [] hjbArray; // Host buttons
	private final String [] sNameArray = {"Student 1", "Student 2", "Student 3", 
											"Student 4"}; 
	private final String [] hNameArray = {"Host", "Clear"};
	private final String [] sImageArray1 = {"1.jpg", "2.jpg", "3.jpg", "4.jpg"};
	private final String [] sImageArray2 = {"1a.jpg", "2a.jpg", "3a.jpg", "4a.jpg"};
	private final String [] hImageArray1 = {"host.jpg", "clear.jpg"};
	private final String [] hImageArray2 = {"host2.jpg", "clear2.jpg"};
	private final String [] aImageArray = {"shinchan.gif", "nene.gif", "kazama.gif", "tai.gif"};
	private final ArrayList <Participants> alist;	/* Added */
	
	public Qna ()
	{
		super ("Q & A Room");
		setLayout (new FlowLayout());
		
		// Student text area
		sMessageArea = new JTextArea ("Write your question here", 10, 110);
		sMessageArea.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		sMessageArea.setBackground(Color.black);
		sMessageArea.setForeground(Color.white);
		
		// Host text area and label with font & color customization
		hMessageArea = new JTextArea ("Answer the question here", 10, 110);
		hMessageArea.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		hMessageArea.setBackground(Color.black);
		hMessageArea.setForeground(Color.white);
		
		hostLabel = new JLabel("Host Area", SwingConstants.CENTER);
		hostLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		add(sMessageArea);
		add(hostLabel);
		add(hMessageArea);
		
		// Initialize student button arrays
		sjbArray = new JButton [sNameArray.length];
		
		for (int i = 0; i<sjbArray.length; i++)
		{
			Icon sIcon1 = new ImageIcon (sImageArray1 [i]);
			Icon sIcon2 = new ImageIcon (sImageArray2 [i]);
			sjbArray [i] = new JButton (String.valueOf(sNameArray [i]), sIcon1);
			sjbArray [i].setRolloverIcon(sIcon2);
			add (sjbArray [i]);
			
			// Button font, size, and color customization
			sjbArray [i].setSize (50, 50);
			sjbArray [i].setFont(new Font("Century Gothic", Font.BOLD, 20));
			sjbArray [i].setBackground(Color.pink);
		}
		
		hjbArray = new JButton [hNameArray.length];
		
		for (int i = 0; i<hjbArray.length; i++)
		{
			Icon hIcon1 = new ImageIcon (hImageArray1 [i]);
			Icon hIcon2 = new ImageIcon (hImageArray2 [i]);
			hjbArray [i] = new JButton (String.valueOf(hNameArray [i]), hIcon1);
			hjbArray [i].setRolloverIcon(hIcon2);
			add (hjbArray [i]);
			
			// Button font, size, and color customization
			hjbArray [i].setSize (50, 50);
			hjbArray [i].setFont(new Font("Century Gothic", Font.BOLD, 20));
			hjbArray [i].setBackground(Color.pink);
		}
		
		alist = new ArrayList <Participants> ();
		 
		 /* I copied and pasted here */
		Participants s1 = new Participants ("Student 1", "Shinchan Nohara", "T03");
		Participants s2 = new Participants ("Student 2", "Nene Sakurada", "T02");
		Participants s3 = new Participants ("Student 3", "Toru Kazama", "T01");
		Participants s4 = new Participants ("Student 4", "Bo Suzuki", "T04");
	
		alist.add (s1);
		alist.add (s2);
		alist.add (s3);
		alist.add (s4);
		

		// Register the events to each student button!!!!!!!!!!
		
		/* I copied part of your design and update here */
		for (int i = 0; i < sjbArray.length; i++)
		{
			sjbArray [i].addActionListener (e -> {
				
				String text = sMessageArea.getText();
				
				for (int k = 0; k < sjbArray.length; k++)
				{
				
					if (e.getSource() == sjbArray[k])
					{
						String finalText = (alist.get (k).toString () + text);
						Icon ic = new ImageIcon (aImageArray[0]);
						JOptionPane.showMessageDialog (null, finalText, "Welcome to Chat Room",
													JOptionPane.INFORMATION_MESSAGE, ic);
					}
				}
				
			});	
		}
		
	
	
		// Register events to host button!!!!!!!!!!!!!!!!!!!
		hjbArray[0].addActionListener (e->{String text = hMessageArea.getText();
											Icon ic = new ImageIcon ("miss.jpg");
											JOptionPane.showMessageDialog (null, text, 
																			"I am the host",
																			JOptionPane.INFORMATION_MESSAGE, ic);
										  });
		
		// Register events to clear button!!!!!!!!!!!!!!!!!!!
		//ClearButtonEvent cbe = new ClearButtonEvent ();
		hjbArray[1].addActionListener (e->{sMessageArea.setText ("");
											hMessageArea.setText ("");
										  });
										  
	}
	
	/*
	// private inner class
	private class SButtonEvent implements ActionListener
	{
		private String word;
		
		public SButtonEvent ()
		{
			
		}
		
		public String getParticipant (Participants p)
		{
			return p.toString();
		}
		
		@Override
		public void actionPerformed (ActionEvent e)
		{
		
			Participants s1 = new Participants ("Student 1", "Shinchan Nohara", "T03");
			Participants s2 = new Participants ("Student 2", "Nene Sakurada", "T02");
			Participants s3 = new Participants ("Student 3", "Toru Kazama", "T01");
			Participants s4 = new Participants ("Student 4", "Bo Suzuki", "T04");
		
			// Need to check who pressed the button!!!!!!!!!!!!!!!!!!!!!!
			String text = sMessageArea.getText();
			
			
			if (e.getSource() == sjbArray[0])
			{
				String finalText = (getParticipant (s1) + text);
				Icon ic = new ImageIcon (aImageArray[0]);
				JOptionPane.showMessageDialog (null, finalText, "Welcome to Chat Room",
											JOptionPane.INFORMATION_MESSAGE, ic);
			}
			
			else if (e.getSource() == sjbArray[1])
			{
				String finalText = (getParticipant (s2) + text);
				Icon ic = new ImageIcon (aImageArray[1]);
				JOptionPane.showMessageDialog (null, finalText, "Welcome to Chat Room",
											JOptionPane.INFORMATION_MESSAGE, ic);
			}
			
			else if (e.getSource() == sjbArray[2])
			{
				String finalText = (getParticipant (s3) + text);
				Icon ic = new ImageIcon (aImageArray[2]);
				JOptionPane.showMessageDialog (null, finalText, "Welcome to Chat Room",
											JOptionPane.INFORMATION_MESSAGE, ic);
			}
			
			else
			{
				String finalText = (getParticipant (s4) + text);
				Icon ic = new ImageIcon (aImageArray[3]);
				JOptionPane.showMessageDialog (null, finalText, "Welcome to Chat Room",
											JOptionPane.INFORMATION_MESSAGE, ic);
			}	
		}
	}
	
	private class HButtonEvent implements ActionListener
	{
		@Override
		public void actionPerformed (ActionEvent e)
		{
			
		}
	}
	
	private class ClearButtonEvent implements ActionListener
	{	
		@Override
		public void actionPerformed (ActionEvent e)
		{
			
		}
	}
	*/
}// End of class Qna

class Participants
{
	private String pGreeting;
	private String pName;
	private String pTGrp;
	
	// Default constructor
	public Participants ()
	{
		
	}
	
	// Other constructor
	public Participants (String pGreeting, String pName, String pTGrp)
	{
		this.pGreeting = pGreeting;
		this.pName = pName;
		this.pTGrp = pTGrp;
	}
	
	// Copy Constructor
	public Participants (Participants p)
	{
		this(p.pGreeting, p.pName, p.pTGrp);
	}
	
	// Accessor and Mutator methods
	public String getPGreeting ()
	{
		return pGreeting;
	}
	
	public String getPName ()
	{
		return pName;
	}
	
	public String getTGrp ()
	{
		return pTGrp;
	}
	
	public void setPGreeting (String pGreeting)
	{
		this.pGreeting = pGreeting;
	}
	
	public void setPName (String pName)
	{
		this.pName = pName;
	}
	
	public void setTGrp (String pTGrp)
	{
		this.pTGrp = pTGrp;
	}
	
	public String toString ()
	{
		return String.format ("Hi I am participant %s%n" + 
						"My name is %s%n" + 
						"I am from tutorial group: %s%n", 
						pGreeting, pName, pTGrp);
	}
	
	
}// End of class Participants

class Sally_T03_A3_Updated
{
	private static void dialogCustomization (Color cf, Color cb)
	{
		UIManager UI = new UIManager();
		UI.put("OptionPane.messageForeground", cf);
		UI.put("Panel.background", cb);
		UI.put("OptionPane.minimumSize",new Dimension(600,280));
		UI.put("OptionPane.messageFont", new FontUIResource(new Font(  
				"Century Gothic", Font.BOLD, 18)));
	}
	
	public static void main (String [] args)
	{
		// Creating JFrame
		Qna qna = new Qna ();
		qna.setSize (1700, 1150); // width, height
		qna.setVisible (true);
		qna.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		// Customize JOptionePane
		Color cf = new Color (255, 255, 255);
		Color cb = new Color (0, 0, 0);
		dialogCustomization (cf, cb);	
	}
}// End of class Sally_T03_A3