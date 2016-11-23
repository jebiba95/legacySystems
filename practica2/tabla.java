package practica2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class tabla extends JFrame{
    /**
     * 
     */
	private static final long serialVersionUID = 210601883990408438L;
    private JTable tabla = null;
    DefaultTableModel modelo = null;
    JScrollPane desplazamiento = null;
     
    
    public tabla() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,800);
		//Esto permite que la ventana aparezca al centro
		this.setLocationRelativeTo(null);
		//
		//Para que el JFrame no tenga ningún formato
		//se coloca el Layout del JFrame en null 
		//no hay que olvidarse de colocarle tamaño y posición
		//a los elementos que se agregan
		 this.setLayout(new BorderLayout()); 	
        // Nombre de las columnas como apareceran en la tabla
        String[] columnas = {"Tipo", "Fecha", "Nombre", "Descripción"};
        tabla = new JTable();
        modelo = new DefaultTableModel();
        desplazamiento = new JScrollPane(tabla);
        int fecha;
        String tipo, nombre, descripcion;
         
        
        // Modelo de la tabla
        modelo.setColumnIdentifiers(columnas);
        
        // Barras de desplazamiento
        desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        // Propiedades de la tabla
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setFillsViewportHeight(true);        
        
        tabla.setModel(modelo);
        
        // Agregando elementos a la ventana
        this.getContentPane().add(desplazamiento, BorderLayout.NORTH);    
        this.pack();
        
        // Ponemos los datos en la tabla
        
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
        add(tabla);
        
        JButton boton1=new JButton("Nueva Tarea");
        boton1.setBounds(600,30,150,30);
        add(boton1);
    }
}
