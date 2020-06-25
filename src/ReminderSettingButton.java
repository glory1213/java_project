import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ReminderSettingButton extends JButton {
	public ReminderSettingButton() {

		URL url = getClass().getResource("/Icon/ReminderSettingButton.png");
		Icon icon = new ImageIcon(url);
		this.setIcon(icon);

		Dimension preferredSize = new Dimension(48, 48);
		this.setPreferredSize(preferredSize);

		this.setFocusPainted(false);
		this.setContentAreaFilled(false);

		this.addActionListener(new ActionListener() {
			Remarks remark = new Remarks();
			@Override
			public void actionPerformed(ActionEvent e) {
				remark.setVisible(true);
			}
		});
	}
}
