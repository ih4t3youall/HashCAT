package ar.com.hasmap;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import ar.com.hasmap.vista.MainFrame;

public class Inicio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Inicio() {
		

	
		
		
		HashMap<String, String> hash = getHash();
		for( Map.Entry<String, String> entry :hash.entrySet()){
			System.out.println("clave: "+entry.getKey());
			System.out.println("valor: "+entry.getValue());
		}
		MainFrame mainFrame = new MainFrame(hash);
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		

	}

	public HashMap<String, String> getHash(){
		HashMap<String, String> hash = new HashMap<String, String>();
		String primera = "";
		String ultima = "";

		try {
			

			// Cargamos el buffer con el contenido del archivo
			BufferedReader br;
			InputStream in = getClass().getResourceAsStream("clave_valor.txt"); 
			
			br = new BufferedReader(new InputStreamReader(in));

			// Leemos la primera linea
			
		        

			
			String line = br.readLine();
			int blanco = 0;
			String palabra="";
			int caracter = 0;
			while (line != null) {
				
				char[] charArray = line.toCharArray();
				
				
				for (char c : charArray) {
					if(c == ' '){
					blanco++;
					palabra+= " ";
					}else{
						blanco = 0;
						palabra +=c;
						caracter++;
						
					}
					if (blanco == 2){
						if(caracter >2){
						primera = palabra;
						caracter =0;
						}
						palabra ="";
						blanco = 0;
						
					}
				}
				ultima = palabra;
				hash.put(primera, ultima);
				primera = "";
				ultima ="";
				palabra ="";
				caracter =0;
				blanco =0;
				line = br.readLine();
				
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		return hash;
	}
	

}
