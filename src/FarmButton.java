import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class FarmButton extends JButton{

    public FarmButton() {
        URL url = getClass().getResource("/Icon/Chicken.png");
        Icon icon = new ImageIcon(url);
        this.setIcon(icon);

        Dimension preferredSize = new Dimension(48, 48);
        this.setPreferredSize(preferredSize);

        this.setFocusPainted(false);
        this.setContentAreaFilled(false);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FarmDialog farmDialog = new FarmDialog();
            }
        });
    }
}
