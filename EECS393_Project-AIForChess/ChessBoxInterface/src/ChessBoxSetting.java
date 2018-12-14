import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;

public class ChessBoxSetting {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChessBoxSetting window = new ChessBoxSetting();
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
	public ChessBoxSetting() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Setting Page");
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.setBounds(100, 100, 333, 432);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		//Set back ground
		try {
			BufferedImage myImage = ImageIO.read(ChessBoxSetting.this.getClass().getResource("set.jpg"));
			frame.setContentPane(new ImagePanel(myImage));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Background picture lost");
		}
		
		JLabel lblNewLabel = new JLabel("Settings");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(125, 11, 78, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Volume:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(44, 89, 58, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Light:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(44, 157, 58, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		JSlider slider = new JSlider();
		slider.setBounds(112, 89, 200, 26);
		frame.getContentPane().add(slider);
		slider.setOpaque(false);
	
		JSlider slider_1 = new JSlider();
		slider_1.setBounds(112, 157, 200, 26);
		frame.getContentPane().add(slider_1);
		slider_1.setOpaque(false);
		
		
		
		
	}
}
