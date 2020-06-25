import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StartButton extends JButton {
	public StartButton() {
		/*this.setText("");
		
		/*Font f=new Font("宋体",Font.BOLD,64);
		this.setFont(f);*/
		Dimension preferredSize = new Dimension(48,48);
		this.setPreferredSize(preferredSize);
		
		URL url = getClass().getResource("/Icon/Start.png");
		Icon icon = new ImageIcon(url);
		this.setIcon(icon);
		
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		//this.setBackground(Color.CYAN);
		
		this.addActionListener(new ActionListener() {
			UI ui=new UI();
			@Override
			public void actionPerformed(ActionEvent e) {
				ui.setVisible(true);
			}});
	}
}
