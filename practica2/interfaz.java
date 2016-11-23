package practica2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.*;

public class interfaz extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] columnas = {"Tipo", "Fecha", "Nombre", "Descripción"};
	public boolean bandera = false;
	private JPopupMenu popupMenu = new JPopupMenu();
	JSpinner cont = new JSpinner();
	public int contador = 0;
	private JButton s = new JButton("Salir");
	private JTable tabla;
	private JLabel etiqueta;
	private static DefaultTableModel tipo;
	JPanel panel = new JPanel(new BorderLayout());
	JPanel panelTexto = new JPanel(new GridLayout(1, 1));
	JPanel panel1 = new JPanel(new GridLayout(3, 50));
	JPanel panel2 = new JPanel(new GridLayout(4, 5));
	JPanel panel3 = new JPanel(new GridLayout(3, 5));
	JPanel panel4 = new JPanel(new GridLayout(4, 5));
	JPanel panel5 = new JPanel(new GridLayout(1, 1));
	JPanel panel6 = new JPanel(new GridLayout(4, 5));
	JPanel panel8 = new JPanel(new GridLayout(5, 5));
	JPanel panel9 = new JPanel(new GridLayout(6, 5));
	JPanel panel10 = new JPanel(new GridLayout(2, 5));
	JPanel panel11 = new JPanel(new GridLayout(2, 5));
	JPanel panel12 = new JPanel(new GridLayout(1, 5));
	private JMenuItem menuItem1, menuItem2;
	//private JSlider re = new JSlider();
	Graphics p;
	
	private class CloseListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        //DO SOMETHING
	        System.exit(0);
	    }
	}
	
	private class CrearTareaListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        //DO SOMETHING
	    	createTask v = new createTask();
			v.setVisible(true);
	    }
	}
	
	public interfaz() throws ClassNotFoundException {
				
		this.setLocation(350, 50);
		panel.add(getPanelTexto(), BorderLayout.NORTH);
		panel.add(getPanelTabla(), BorderLayout.CENTER);
		
		setContentPane(panel);
		
		setVisible(true);
		pack();
		
	}
	
	private JScrollPane getPanelTabla() {
		String[][] datos = {};
		tipo = new DefaultTableModel(datos, columnas);
		tabla = new JTable(tipo);
		
		tabla.setComponentPopupMenu(popupMenu);
		
		JScrollPane scrol = new JScrollPane(tabla);
		return scrol;
	}
	
	private JPanel getPanelTexto() {
		etiqueta = new JLabel("0");
		etiqueta.setHorizontalAlignment(JLabel.CENTER);
		/*re.putClientProperty("JSlider.isFilled", Boolean.TRUE);
		re.setPaintLabels(true);
		re.setPaintTicks(true);
		re.setPaintTrack(true);
		re.setMajorTickSpacing(25);
		re.setMinorTickSpacing(5);
		
		if ((re).getValue() == 25) {
			panel11.setBackground(color.RED);
		}*/
		JMenuBar x = new JMenuBar();
		
		panel12.add(x);
		
		panel5.add(panel12);
		
		s.addActionListener(new CloseListener());
		panel5.add(s);
		
		
		JButton btnAgregar = new JButton("Nueva Tarea");
		btnAgregar.addActionListener(new CrearTareaListener());
		panelTexto.add(btnAgregar);
		
		
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(panel9);
		panel.add(panel5);
		panel.add(panel6);
		panel.add(panel2);
		panel.add(panelTexto);
		panel.add(panel1);
		panel.add(panel8);
		panel.add(panel11);
		panel.add(panel12);
		return panel;
	}
	
	public static void anadirDatos(Task tarea){
		tipo.addRow( new String[] {tarea.getType(), tarea.getDate(), tarea.getName(), tarea.getDescription()} );	
	}
}