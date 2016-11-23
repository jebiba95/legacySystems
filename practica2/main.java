package practica2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

import javax.swing.JFrame;

public class main {
	
	public static void main(String[] args) {
		try {
			String comando = "C:\\Program Files\\wc3270\\wc3270.exe";
			String[] argumentos = {"C:\\Users\\sam\\Documents\\wc3270\\SL.wc3270"};
			Process process = Runtime.getRuntime().exec(comando,argumentos);
			InputStream in = process.getInputStream();
			OutputStream out = process.getOutputStream();
			InputStreamReader entrada = new InputStreamReader(in);
			BufferedReader teclado = new BufferedReader (entrada);
			String cadena = teclado.readLine();
			while (cadena!="Press the ENTER key to view next page when you see this message --->  More..."){
				System.out.println(cadena);
				cadena = teclado.readLine();
			}
			System.out.println("hecho");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		interfaz i;
		try {
			i = new interfaz();
			i.anadirDatos(new Task("General", "1562", "Prueba", "Hola"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
