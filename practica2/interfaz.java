package practica2;

import java.awt.*;
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
	public String car, modelo, col;
	private JTextField tipe, fecha, nombre, descripcion;
	private JButton s = new JButton("Salir");
	private JTable tabla;
	private JLabel etiqueta;
	private static DefaultTableModel tipo;
	JPanel panel = new JPanel(new BorderLayout());
	JPanel panelTexto = new JPanel(new GridLayout(2, 5));
	JPanel panel1 = new JPanel(new GridLayout(3, 50));
	JPanel panel2 = new JPanel(new GridLayout(4, 5));
	JPanel panel3 = new JPanel(new GridLayout(3, 5));
	JPanel panel4 = new JPanel(new GridLayout(4, 5));
	JPanel panel5 = new JPanel(new GridLayout(4, 5));
	JPanel panel6 = new JPanel(new GridLayout(4, 5));
	JPanel panel8 = new JPanel(new GridLayout(5, 5));
	JPanel panel9 = new JPanel(new GridLayout(6, 5));
	JPanel panel10 = new JPanel(new GridLayout(2, 5));
	JPanel panel11 = new JPanel(new GridLayout(2, 5));
	JPanel panel12 = new JPanel(new GridLayout(1, 5));
	private JMenuItem menuItem1, menuItem2;
	//private JSlider re = new JSlider();
	Graphics p;
	
	public interfaz() throws ClassNotFoundException {
		
		setTitle(car);
		
		this.setLocation(350, 50);
		panel.add(getPanelTexto(), BorderLayout.NORTH);
		panel.add(getPanelTabla(), BorderLayout.CENTER);
		
		setContentPane(panel);
		
		setVisible(true);
		pack();
		
	}
	
	private JScrollPane getPanelTabla() {
		Object[][] datos = {};
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
		
		panel5.add(s);
		
		JLabel Tipo = new JLabel("Tipo");
		tipe = new JTextField("");
		
		JLabel Fecha = new JLabel("Fecha");
		fecha = new JTextField("");
		JLabel Nombre = new JLabel("Nombre");
		nombre = new JTextField("");
		JLabel Desc = new JLabel("Descripción");
		descripcion = new JTextField("");
		JButton btnAgregar = new JButton("Agregar");
		
		JButton btnQuitar = new JButton("Quitar");
		
		menuItem1 = new JMenuItem("ELIMINAR");
		popupMenu.add(menuItem1);
		
		popupMenu.addSeparator();
		menuItem2 = new JMenuItem("ORDENAR");
		popupMenu.add(menuItem2);
		panel2.add(Tipo);
		panel2.add(tipe);
		panel2.add(Nombre);
		panel2.add(nombre);
		panel2.add(Fecha);
		panel2.add(fecha);
		panel2.add(Desc);
		panel2.add(descripcion);
		
		panelTexto.add(btnAgregar);
		panelTexto.add(btnQuitar);
		
		
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
	
	public static void anadirDatos(DefaultTableModel modelo, int fecha, String descripcion, String tipo, String nombre){
		for (int i=0; i<50; i++){
        	fecha=i*1000+i;
        	descripcion = "Descripcion " + i;
        	if (i%2==0){
        		tipo="General"; 
        		nombre="";
        	}
        	else{
        		tipo="Específico";
        		nombre = "Tarea "+ i;
        	}
        	modelo.addRow( new Object[] {tipo, fecha, nombre, descripcion} );	
        }
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new interfaz();
		anadirDatos(tipo, 0,null,null,null);
	}
}