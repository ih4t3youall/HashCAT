package ar.com.hasmap.vista;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private JTextField campoTexto;
	private JTextField campoTexto2;
	private JButton buscar;
	private HashMap<String, String> map ;
	
	public MainFrame(HashMap<String, String> hash) {
		
		
		map = hash;
		setSize(400, 400);
		setLocation(400, 400);
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new FlowLayout());
		campoTexto = new JTextField(20);
		campoTexto2 = new JTextField(20);
		buscar = new JButton("Buscar");
		campoTexto.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				int keyCode = arg0.getKeyCode();
				if(keyCode == 10){
					buscar();
				}
				
			}
		});
		
		panelPrincipal.add(campoTexto);
		panelPrincipal.add(buscar);
		panelPrincipal.add(campoTexto2);
		
		
		buscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buscar();
				
				
				
				
			}

		
		});
		add(panelPrincipal);

	}
	
	
	
	private void buscar(){
		String buscarPalabra = buscarPalabra(campoTexto.getText().trim());
		
		if (buscarPalabra.equals("")){
			JOptionPane.showMessageDialog(null, "No se encontro abreviatura");
		}else {
			campoTexto.setText("");
			campoTexto2.setText(buscarPalabra);
			
		}
		
		
	}
	
	private String buscarPalabra(String text) {
		
		Set<String> keySet = map.keySet();
		
		for (String string : keySet) {
			if (string.trim().toLowerCase().equals(text.toLowerCase())){
				return map.get(string);
			}
		}
		return "";
	}
}
