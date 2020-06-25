import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class HistoryReviewingButton extends JButton {
	public HistoryReviewingButton() {
		URL url = getClass().getResource("/Icon/HistoryReviewingButton.png");
		Icon icon = new ImageIcon(url);
		this.setIcon(icon);

		Dimension preferredSize = new Dimension(48, 48);
		this.setPreferredSize(preferredSize);

		this.setFocusPainted(false);
		this.setContentAreaFilled(false);

		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {			
				JOptionPane.showMessageDialog(null, String.format("今日你已坚持完成%d次!%n总计有效专注时长%d秒", Time.cout,Time.total_sec), "今日统计", JOptionPane.INFORMATION_MESSAGE);
			
			}
		});
	}
	
	
}
