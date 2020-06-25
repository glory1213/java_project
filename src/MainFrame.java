import java.awt.Container;
import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;

public class MainFrame extends JFrame {
	public static int today_mission;
	
	public MainFrame(String title) {
		super(title);

		JLabel jl1 = new JLabel();	
			
		JPanel root = new JPanel();
		this.setContentPane(root);
		this.setLayout(null);

		//root.setLayout(new BorderLayout());
		
		Random r = new Random();
		Date now = new Date();
		String pattern = "yyyy年MMMd日 E HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String nowtime = sdf.format(now);

		JOptionPane.showMessageDialog(null, String.format("现在时间：%n%s",nowtime), "欢迎回来~", JOptionPane.INFORMATION_MESSAGE);
		
		//Box toolbar=Box.createVerticalBox();
		StartButton startButton = new StartButton();
		TimeSettingButton timeSettingButton = new TimeSettingButton();
		ReminderSettingButton reminderSettingButton = new ReminderSettingButton();
		HistoryReviewingButton historyReviewingButton=new HistoryReviewingButton();
		FarmButton farmButton = new FarmButton();
		
		startButton.setBounds(228, 2, 48, 48);
		reminderSettingButton.setBounds(228+48, 2, 48, 48);
		historyReviewingButton.setBounds(228+48+48, 2, 48, 48);
		farmButton.setBounds(228+48+48+48, 2 ,48,48);
		
		today_mission = 5 + r.nextInt(25);
		
		jl1.setText(String.format("每日任务:%d分钟", today_mission));
		jl1.setBounds(48, 8, 100, 16);
		
		this.add(jl1);
	
		this.add(startButton);
		//this.add(timeSettingButton);
		this.add(reminderSettingButton);
		this.add(historyReviewingButton);
		this.add(farmButton);

		//root.add(startButton, BorderLayout.PAGE_START);
		//root.add(toolbar);
		
		
		
			
	}
	

}
