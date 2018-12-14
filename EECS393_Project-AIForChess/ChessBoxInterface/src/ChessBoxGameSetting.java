import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChessBoxGameSetting {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChessBoxGameSetting window = new ChessBoxGameSetting();
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
	public ChessBoxGameSetting() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Game Setting Page");
		frame.setBounds(100, 100, 594, 348);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		
		//Set back ground
		try {
			BufferedImage myImage = ImageIO.read(ChessBoxGameSetting.this.getClass().getResource("game_set.jpg"));
			frame.setContentPane(new ImagePanel(myImage));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Background picture lost");
		}
		
		JLabel lblNewLabel = new JLabel("Choose Your Game Model");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(171, 11, 233, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Choose Player Type:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(151, 76, 151, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		Choice choice = new Choice();
		choice.setBounds(320, 77, 89, 20);
		frame.getContentPane().add(choice);
		choice.addItem("AI");
		choice.addItem("Player");

		
		JLabel lblNewLabel_2 = new JLabel("Choose Game Type:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(151, 143, 151, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(320, 143, 130, 20);
		frame.getContentPane().add(choice_1);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(choice.getSelectedItem());
				System.out.println(choice_1.getSelectedItem());
				ChessBoxGamePage new_game = new ChessBoxGamePage(choice.getSelectedItem(),choice_1.getSelectedItem());
				new_game.setFrame(true);
			}
		});
		btnNewButton.setBounds(259, 191, 89, 23);
		frame.getContentPane().add(btnNewButton);
		choice_1.addItem("International");
		choice_1.addItem("Chinese");
		choice_1.addItem("Shogi");
		choice_1.addItem("Jungle");
		

	
	
	
	
	
	}
}
