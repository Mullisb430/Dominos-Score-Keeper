import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTextField;

public class DominosGame 
{

	private JFrame frame;
	public static JTextField BrandonsScore = new JTextField();
	public static JTextField PhillysScore = new JTextField();
	public static JLabel lblBrandonsScore = new JLabel("Brandon's Score");
	public static JLabel lblPhillysScore = new JLabel("Philly's Score");
	public static JLabel lblBrandosScore = new JLabel("Brandon's Score");
	public static JLabel lblPhillysPoints = new JLabel("");
	public static JLabel lblBrandonsPoints = new JLabel("");
	public static JLabel lblLastScore = new JLabel("");
	public static JLabel lblSecondScore = new JLabel("");
	public static JLabel lblThirdScore = new JLabel("");
	public static JLabel lblFourthScore = new JLabel("");
	public static JLabel lblFifthScore = new JLabel("");
	public static JLabel lblSixthScore = new JLabel("");
	public static JLabel lblSeventhScore = new JLabel("");
	public static JLabel lblEighthScore = new JLabel("");
	public static JButton btnAddBrandon = new JButton("Add");
	public static JButton btnAddPhilly = new JButton("Add");
	public static JButton btnReset = new JButton("RESET");
	public static ArrayList<Integer> BrandonsList = new ArrayList<>();
	public static ArrayList<Integer> PhillysList = new ArrayList<>();
	public static ArrayList<String> LoggedList = new ArrayList<>();
	
	
	// This method adds points entered into the textfields, into the appropriate labels.
	
	public static void addPoints()
		{
			int phillies  = 0, brandons = 0;
			
			// This try and catch combo only lets users enter in numerics. If letters or special characters are entered, they will not be added into the ArrayLists.
			try 
			{
				if(PhillysScore.getText().isEmpty() && !BrandonsScore.getText().isEmpty())
				{
					PhillysList.add(0);
					BrandonsList.add(Integer.parseInt(BrandonsScore.getText()));
					LoggedList.add("BRANDON: " + Integer.toString(Integer.parseInt(BrandonsScore.getText())));
					;
				} else if(!PhillysScore.getText().isEmpty() && BrandonsScore.getText().isEmpty())
				{
					BrandonsList.add(0);
					PhillysList.add(Integer.parseInt(PhillysScore.getText()));
					LoggedList.add("PHILLY: " + Integer.toString(Integer.parseInt(PhillysScore.getText())));
				} else if(BrandonsScore.getText().isEmpty() && PhillysScore.getText().isEmpty())
				{
					;
				} else if(!BrandonsScore.getText().isEmpty() && !PhillysScore.getText().isEmpty())
				{
					PhillysList.add(Integer.parseInt(PhillysScore.getText()));
					LoggedList.add("PHILLY: " + Integer.toString(Integer.parseInt(PhillysScore.getText())));
					BrandonsList.add(Integer.parseInt(BrandonsScore.getText()));
					LoggedList.add("BRANDON: " + Integer.toString(Integer.parseInt(BrandonsScore.getText())));
				}
				PhillysScore.setText("");
				BrandonsScore.setText("");
				
			}
			catch (Exception e1)
			{
				PhillysScore.setText("");
				BrandonsScore.setText("");
			}
			
			for(int i = 0; i < PhillysList.size(); i++)
			{
				phillies += PhillysList.get(i);
			}
			
			for(int i = 0; i < BrandonsList.size(); i++)
			{
				brandons += BrandonsList.get(i);
			}
			
			lblBrandonsPoints.setText(Integer.toString(brandons));
			lblPhillysPoints.setText(Integer.toString(phillies));
			
			if(phillies > brandons)
			{
				lblPhillysScore.setForeground(Color.GREEN);
				lblBrandonsScore.setForeground(Color.RED);
			} else if(phillies < brandons)
			{
				lblPhillysScore.setForeground(Color.RED);
				lblBrandonsScore.setForeground(Color.GREEN);
			} else if(phillies == brandons)
			{
				lblPhillysScore.setForeground(Color.WHITE);
				lblBrandonsScore.setForeground(Color.WHITE);
			}
			
			// Populates the last eight scores to keep track of the previous actions. If you do not remember if you entered in a certain score, take a look at this log to verify.
			lblLastScore.setText(LoggedList.get(LoggedList.size()-1));
			lblSecondScore.setText(LoggedList.get(LoggedList.size()-2));
			lblThirdScore.setText(LoggedList.get(LoggedList.size()-3));
			lblFourthScore.setText(LoggedList.get(LoggedList.size()-4));
			lblFifthScore.setText(LoggedList.get(LoggedList.size()-5));
			lblSixthScore.setText(LoggedList.get(LoggedList.size()-6));
			lblSeventhScore.setText(LoggedList.get(LoggedList.size()-7));
			lblEighthScore.setText(LoggedList.get(LoggedList.size()-8));
		
			PhillysScore.setText("");
			BrandonsScore.setText("");
		}
	
	// Resets the entire game. Clears labels, and clears ArrayLists.
	public static void reset()
		{
			BrandonsList.clear();
			PhillysList.clear();
			LoggedList.clear();
			lblBrandonsPoints.setText("");
			lblPhillysPoints.setText("");
			lblLastScore.setText("");
			lblSecondScore.setText("");
			lblThirdScore.setText("");
			lblFourthScore.setText("");
			lblFifthScore.setText("");
			lblSixthScore.setText("");
			lblSeventhScore.setText("");
			lblEighthScore.setText("");
			LoggedList.add("");
			LoggedList.add("");
			LoggedList.add("");
			LoggedList.add("");
			LoggedList.add("");
			LoggedList.add("");
			LoggedList.add("");
			LoggedList.add("");
			LoggedList.add("");
			LoggedList.add("");
		}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
		{
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						DominosGame window = new DominosGame();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

	/**
	 * Create the application.
	 */
	public DominosGame() 
	{
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() 
	{
		LoggedList.add("");
		LoggedList.add("");
		LoggedList.add("");
		LoggedList.add("");
		LoggedList.add("");
		LoggedList.add("");
		LoggedList.add("");
		LoggedList.add("");
		LoggedList.add("");
		LoggedList.add("");
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(85, 107, 47));
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblBrandonsScore.setForeground(new Color(245, 245, 220));
		lblBrandonsScore.setFont(new Font("Avenir", Font.PLAIN, 28));
		lblBrandonsScore.setBounds(20, 25, 212, 67);
		frame.getContentPane().add(lblBrandonsScore);
		
		lblPhillysScore.setForeground(new Color(245, 245, 220));
		lblPhillysScore.setFont(new Font("Avenir", Font.PLAIN, 28));
		lblPhillysScore.setBounds(273, 25, 212, 67);
		frame.getContentPane().add(lblPhillysScore);
		
		lblBrandonsPoints.setForeground(Color.WHITE);
		lblBrandonsPoints.setFont(new Font("Avenir", Font.PLAIN, 28));
		lblBrandonsPoints.setBounds(20, 104, 161, 113);
		frame.getContentPane().add(lblBrandonsPoints);
		
		lblPhillysPoints.setForeground(Color.WHITE);
		lblPhillysPoints.setFont(new Font("Avenir", Font.PLAIN, 28));
		lblPhillysPoints.setBounds(273, 104, 161, 113);
		frame.getContentPane().add(lblPhillysPoints);
		lblLastScore.setForeground(new Color(189, 183, 107));
		
		lblLastScore.setFont(new Font("Avenir", Font.BOLD | Font.ITALIC, 28));
		lblLastScore.setBounds(502, 6, 292, 58);
		frame.getContentPane().add(lblLastScore);
		lblSecondScore.setForeground(new Color(189, 183, 107));
		
		lblSecondScore.setFont(new Font("Avenir", Font.BOLD | Font.ITALIC, 28));
		lblSecondScore.setBounds(502, 76, 292, 58);
		frame.getContentPane().add(lblSecondScore);
		lblThirdScore.setForeground(new Color(189, 183, 107));
		
		lblThirdScore.setFont(new Font("Avenir", Font.BOLD | Font.ITALIC, 28));
		lblThirdScore.setBounds(502, 141, 292, 58);
		frame.getContentPane().add(lblThirdScore);
		lblFourthScore.setForeground(new Color(189, 183, 107));
		
		lblFourthScore.setFont(new Font("Avenir", Font.BOLD | Font.ITALIC, 28));
		lblFourthScore.setBounds(502, 211, 292, 58);
		frame.getContentPane().add(lblFourthScore);
		lblFifthScore.setForeground(new Color(189, 183, 107));
		
		lblFifthScore.setFont(new Font("Avenir", Font.BOLD | Font.ITALIC, 28));
		lblFifthScore.setBounds(502, 281, 292, 58);
		frame.getContentPane().add(lblFifthScore);
		lblSixthScore.setForeground(new Color(189, 183, 107));
		
		lblSixthScore.setFont(new Font("Avenir", Font.BOLD | Font.ITALIC, 28));
		lblSixthScore.setBounds(502, 351, 292, 58);
		frame.getContentPane().add(lblSixthScore);
		lblSeventhScore.setForeground(new Color(189, 183, 107));
		
		lblSeventhScore.setFont(new Font("Avenir", Font.BOLD | Font.ITALIC, 28));
		lblSeventhScore.setBounds(502, 419, 292, 58);
		frame.getContentPane().add(lblSeventhScore);
		lblEighthScore.setForeground(new Color(189, 183, 107));
		
		lblEighthScore.setFont(new Font("Avenir", Font.BOLD | Font.ITALIC, 28));
		lblEighthScore.setBounds(502, 489, 292, 58);
		frame.getContentPane().add(lblEighthScore);
		btnAddBrandon.setFont(new Font("Avenir", Font.PLAIN, 20));
		btnAddBrandon.setBackground(UIManager.getColor("Button.background"));
		
		btnAddBrandon.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {addPoints();}});
		btnAddBrandon.setBounds(65, 291, 135, 53);
		frame.getContentPane().add(btnAddBrandon);
		btnAddPhilly.setFont(new Font("Avenir", Font.PLAIN, 20));
		btnAddPhilly.setBackground(UIManager.getColor("Button.background"));
		
		btnAddPhilly.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {addPoints();}});
		btnAddPhilly.setBounds(310, 291, 135, 53);
		frame.getContentPane().add(btnAddPhilly);
		btnReset.setForeground(new Color(255, 0, 0));
		btnReset.setFont(new Font("Avenir", Font.PLAIN, 30));
		
		btnReset.setBackground(UIManager.getColor("Button.select"));
		btnReset.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { reset(); }});
		btnReset.setBounds(32, 420, 212, 113);
		frame.getContentPane().add(btnReset);
		BrandonsScore.setBackground(new Color(189, 183, 107));
		
		BrandonsScore.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {addPoints();}});
		BrandonsScore.setFont(new Font("Avenir", Font.PLAIN, 24));
		BrandonsScore.setBounds(30, 221, 170, 58);
		frame.getContentPane().add(BrandonsScore);
		BrandonsScore.setColumns(10);
		PhillysScore.setBackground(new Color(189, 183, 107));
		
		PhillysScore.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {addPoints();}});
		PhillysScore.setFont(new Font("Avenir", Font.PLAIN, 24));
		PhillysScore.setBounds(283, 221, 162, 58);
		frame.getContentPane().add(PhillysScore);
		PhillysScore.setColumns(10);	
	}
}


