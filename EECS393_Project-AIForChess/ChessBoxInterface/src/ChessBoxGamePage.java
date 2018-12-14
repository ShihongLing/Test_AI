
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class ChessBoxGamePage {

	private JFrame frame;
	private String enemy_type;
	private String game_type;

	/**
	 * Create the application.
	 */
	public ChessBoxGamePage(String enemy_type, String game_type) {
		this.game_type = game_type;
		this.enemy_type = enemy_type;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1063, 713);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		//Set back ground
		try {
			if(game_type.equals("International")) {
				BufferedImage myImage = ImageIO.read(ChessBoxGamePage.this.getClass().getResource("1.jpg"));
				frame.setContentPane(new ImagePanel(myImage));
			}
			else if(game_type.equals("Chinese")){
				BufferedImage myImage = ImageIO.read(ChessBoxGamePage.this.getClass().getResource("2.jpg"));
				frame.setContentPane(new ImagePanel(myImage));
			}
			else if(game_type.equals("Shogi")){
				BufferedImage myImage = ImageIO.read(ChessBoxGamePage.this.getClass().getResource("3.jpg"));
				frame.setContentPane(new ImagePanel(myImage));
			}else {
					
				BufferedImage myImage = ImageIO.read(ChessBoxGamePage.this.getClass().getResource("4.jpg"));
				frame.setContentPane(new ImagePanel(myImage));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Background picture lost");
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 42, 621, 621);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Menu");
		btnNewButton.setBounds(41, 11, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Record");
		btnNewButton_1.setBounds(193, 11, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		System.out.println(enemy_type);
		Icon enemy_icon = null;
		if(enemy_type.equals("AI")) {
			enemy_icon = new ImageIcon(ChessBoxGamePage.this.getClass().getResource("AI_icon.png"));	
		}else {
			enemy_icon = new ImageIcon(ChessBoxGamePage.this.getClass().getResource("enemy_icon.png"));
		}
		JLabel lblNewLabel = new JLabel(enemy_icon);
		lblNewLabel.setBounds(756, 42, 180, 180);
		frame.getContentPane().add(lblNewLabel);
		
		Icon player_icon = new ImageIcon(ChessBoxGamePage.this.getClass().getResource("player_icon.png"));	
		JLabel lblNewLabel_1 = new JLabel(player_icon);
		lblNewLabel_1.setBounds(756, 483, 180, 180);
		frame.getContentPane().add(lblNewLabel_1);
	    

	    JPanel panel_1 = new JPanel();
		panel_1.setBounds(756, 321, 180, 41);
		panel_1.add(setTimer(60));
		frame.getContentPane().add(panel_1);
		
	}
	
	public JLabel setTimer(int time) {
		long TIME = time * 1000;
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("mm : ss");
		JLabel clock = new JLabel(sdf.format(new Date(TIME)),JLabel.CENTER);
		ActionListener al = new ActionListener(){
		      long x = TIME - 1000;
		      public void actionPerformed(ActionEvent ae){
		        clock.setText(sdf.format(new Date(x)));
		        x -= 1000;}};
		    new javax.swing.Timer(1000, al).start();
			return clock;

	}
	
	public void setFrame(boolean display) {
		this.frame.setVisible(display);
	}
}
