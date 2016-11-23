package practica2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class createTask extends JFrame {

	private static final long serialVersionUID = 1L;

	private class CloseListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        //DO SOMETHING
	    	setVisible(false);
	    }
	}
	
	private class sendTask implements ActionListener {
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
			setVisible(false);
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
	
	public createTask() { 
		super("Añadir usuario");
		setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Panel de datos
        JPanel panelDatos = new JPanel();
        GridLayout gl = new GridLayout(4,2);
        panelDatos.setLayout(gl);
        JTextField type = new JTextField(10);
        JTextField date = new JTextField(10);
        JTextField name = new JTextField(10);
        JTextField description = new JTextField(10);
        panelDatos.add(new JLabel("Tipo:"));
        panelDatos.add(type);
        panelDatos.add(new JLabel("Fecha:"));
        panelDatos.add(date);
        panelDatos.add(new JLabel("Nombre:"));
        panelDatos.add(name);
        panelDatos.add(new JLabel("Descripción:"));
        panelDatos.add(description);
        
        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        
        JButton accept = new JButton("Aceptar");
        JButton cancel = new JButton("Cancelar");
        accept.addActionListener(new sendTask(type, date, name, description));
        cancel.addActionListener(new CloseListener());
        
        panelBotones.add(accept);
        panelBotones.add(cancel);
        
        Container cp = getContentPane();
        cp.add(panelDatos, BorderLayout.CENTER);
        cp.add(panelBotones, BorderLayout.SOUTH);
	}
}
