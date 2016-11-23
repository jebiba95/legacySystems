package practica2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class sendTask implements ActionListener {
	private JTextField typeTextField;
	private JTextField dateTextField;
	private JTextField nameTextField;
	private JTextField descriptionTextField;
	

	public sendTask(JTextField type, JTextField date, JTextField name, JTextField description) {
		this.typeTextField = type;
		this.dateTextField = date;
		this.nameTextField = name;
		this.descriptionTextField = description;
	}

	public void actionPerformed(ActionEvent e) {
		String type = this.typeTextField.getText();
		String date = this.dateTextField.getText();
		String name = this.nameTextField.getText();
		String description = this.descriptionTextField.getText();
		
		String text = "";
		Task task = new Task (type, date, name, description);
		
		if (_hasValueByType(type, date, name, description)) {
			text = task.toString();
		} else {
			text = "Error, Some elements haven't value!";
		}
		
		//Insert the conexion with legacySystem
		JOptionPane.showMessageDialog(null, text);
		//System.exit(0);
	}
	
	private boolean _hasValueByType(String type, String date, String name, String description) {
		boolean hasValueCommon = (type.compareTo("") != 0 
				&& date.compareTo("") != 0 && description.compareTo("") != 0);
		
		if ((type.toUpperCase()).compareTo("MAIN") == 0) {
			hasValueCommon &= name.compareTo("") != 0;
		}
		
		return hasValueCommon;
	}
}