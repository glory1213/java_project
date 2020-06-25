import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.SourceDataLine;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Time extends JPanel {
	JLabel label1 = new JLabel("时");
	JLabel label2 = new JLabel("分");
	JLabel label3 = new JLabel("秒");

	NewJTextField text1 = new NewJTextField("00", 3);
	NewJTextField text2 = new NewJTextField("25", 3);
	NewJTextField text3 = new NewJTextField("00", 3);

	JButton button2 = new JButton("开始/暂停");
	JButton button3 = new JButton("重置");

	int hours = 0, minutes = 0, seconds = 0;
	int stop = 1;
	public static int cout = 0;
	int once_sec = 0;
	public static int total_sec = 0;
	public static int flag = 0;
	static boolean flag2 = true;

	Timer timer = new Timer();
	TimerTask timerTask = null;
	
	String filepath = "C:\\Users\\王晨硕\\Desktop\\TomatoClock\\music.wav";//绝对路径根据下载个人的具体路径进行更改


	public Time() {
		//重置按钮默认25分钟
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (timerTask != null) {
					stop = 1;
					timerTask.cancel();
				}
				text1.setText("0");
				text2.setText("25");
				text3.setText("0");
			}
		});
		
		//开始暂停按钮
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				//checkTime();

				hours = Integer.parseInt(text1.getText());
				minutes = Integer.parseInt(text2.getText());
				seconds = Integer.parseInt(text3.getText());
				
				once_sec = hours*60*60 + minutes*60 + seconds;

				if (1 == stop) {
					stop = 0;
				} else {
					stop = 1;
				}
				//动态显示倒计时
				timer.schedule(timerTask = new TimerTask() {
					@Override
					public void run() {
						if (1 == stop) {

							text1.setText(hours + "");
							text2.setText(minutes + "");
							text3.setText(seconds + "");

							this.cancel();
						} else {
							if (0 != seconds) {
								seconds -= 1;
								text3.setText(seconds + "");
							} else if (0 != minutes) {
								minutes -= 1;
								once_sec += 1;
								text2.setText(minutes + "");
								seconds = 59;
								text3.setText(seconds + "");
							} else if (0 != hours) {
								hours -= 1;
								text1.setText(hours + "");
								minutes = 59;
								text2.setText(minutes + "");
								seconds = 59;
								text3.setText(seconds + "");
							} else {
								this.cancel();
								playMusic(filepath);
								cout++;
								total_sec += once_sec;
								JOptionPane.showMessageDialog(null, String.format("时间到了!!!%n本次专注时长%d秒",once_sec), "提示", JOptionPane.INFORMATION_MESSAGE);
								
								stop = 1;
								
								if(total_sec >= MainFrame.today_mission*60 && flag ==0) {
									flag = 1;
									JOptionPane.showMessageDialog(null, "每日任务完成！","提示", JOptionPane.INFORMATION_MESSAGE);			
								}
							}
						}
					}
				}, 0, 1000);

			}
		});

		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(new GridLayout(1, 6, 10, 10));
		jPanel1.add(text1);
		jPanel1.add(label1);
		jPanel1.add(text2);
		jPanel1.add(label2);
		jPanel1.add(text3);
		jPanel1.add(label3);

		JPanel jPanel2 = new JPanel();
		jPanel2.setLayout(new GridLayout(1, 2, 20, 20));

		jPanel2.add(button2);
		jPanel2.add(button3);

		setLayout(new GridLayout(8, 1, 10, 20));

		add(jPanel1);
		add(jPanel2);

	}
	//检查时间是否正确输入
	private void checkTime() {
		if (!isDigit(text1.getText()) || !isDigit(text2.getText()) || !isDigit(text3.getText())
				|| Integer.parseInt(text2.getText()) < 0 || Integer.parseInt(text2.getText()) > 59
				|| Integer.parseInt(text2.getText()) < 0 || Integer.parseInt(text3.getText()) > 59
				|| Integer.parseInt(text3.getText()) < 0) {
			JOptionPane.showMessageDialog(null, "请输入合法范围的时间!", "提示", JOptionPane.INFORMATION_MESSAGE);
			button3.doClick();
		}
	}

	private boolean isDigit(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i)))
				return false;
		}
		return true;
	}
	
	


	 
	void playMusic(String musicLocation)
	{
		try
		{
			File musicPath = new File(musicLocation);
			
			if(musicPath.exists())
			{
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
			
			}
			else
			{
				
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
	
