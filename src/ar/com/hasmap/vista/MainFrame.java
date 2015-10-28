package ar.com.hasmap.vista;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
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
	private JCheckBox check;
	
	public MainFrame(HashMap<String, String> hash) {
		
		check = new JCheckBox("Buscar Por valor");
		map = hash;
		setSize(400, 400);
		setLocation(400, 400);
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new FlowLayout());
		campoTexto = new JTextField(20);
		campoTexto2 = new JTextField(20);
		campoTexto2.setEnabled(false);
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
					Entry<String, String> buscarPorValor = buscarPorValor(campoTexto.getText().trim());
					buscar(buscarPorValor);
				}
				
			}
		});
		
		panelPrincipal.add(campoTexto);
		panelPrincipal.add(buscar);
		panelPrincipal.add(campoTexto2);
		panelPrincipal.add(check);
		
		
		buscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Entry<String, String> buscarPorValor = buscarPorValor(campoTexto.getText().trim());
				buscar(buscarPorValor);
				
				
				
			}

		

		
		});
		add(panelPrincipal);

	}
	
	
	
	private void buscar(Entry<String, String> entry){
		
		if (entry == null){
			JOptionPane.showMessageDialog(null, "No se encontro abreviatura");
		}else {
			campoTexto.setText("");
			if(check.isSelected()){
			campoTexto2.setText(entry.getKey());
			}else{
			campoTexto2.setText(entry.getValue());
			}
			
		}
		
		
	}
	
	
	private Entry<String, String> buscarPorValor(String buscarPalabra) {
		
		
		Set<Entry<String, String>> entrySet = map.entrySet();
		
		for (Entry<String, String> entry : entrySet) {
			
			if(check.isSelected()){
				
				String value = entry.getValue();
				if(value.trim().toLowerCase().equals(buscarPalabra.trim().toLowerCase())){
					return entry;
				}
				
				
			}else{
				
				String key = entry.getKey();
				if(key.trim().toLowerCase().equals(buscarPalabra.trim().toLowerCase())){
					return entry;
				}
				
			}
			
		}
		return null;
		
		
		

		
	}
	
}
