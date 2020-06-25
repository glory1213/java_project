import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class NewJTextField extends JTextField{
	
	public NewJTextField(String string, int i) {
		super(string,i);
	}
	
    public String getText() {
    	if(super.getText().trim().equals(""))
    		return "0";
    	else
    		return super.getText();

    }
}
