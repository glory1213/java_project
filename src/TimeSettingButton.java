import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TimeSettingButton extends JButton {
	public TimeSettingButton() {
		URL url = getClass().getResource("/Icon/TimeSettingButton.png");
		Icon icon = new ImageIcon(url);
		this.setIcon(icon);

		Dimension preferredSize = new Dimension(48, 48);
		this.setPreferredSize(preferredSize);

		this.setFocusPainted(false);
		this.setContentAreaFilled(false);

		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("设置时间");
			}
		});
	}
}
