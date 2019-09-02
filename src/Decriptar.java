import java.math.BigInteger;

import javax.swing.JOptionPane;

public class Decriptar {
	
	private String valores;
	private Integer n , d;
	public Decriptar() {

		
		this.valores = JOptionPane.showInputDialog(null, "Digite a mensagem criptografada");
		
		
		
		this.n = Integer.valueOf(JOptionPane.showInputDialog(null, "Digite o valor de N"));
		this.d = Integer.valueOf(JOptionPane.showInputDialog(null, "Digite o valor de D"));
	}
	
	
	public void Desencriptar() {
		String fraseAscii  = "";
		String temp = "3";
		
		
		String vetorAscii = "";
		
		
		
		int  i = 0;
		do{
				
				vetorAscii += valores.substring(0, n.toString().length()-1);
				vetorAscii+=";";
				valores  = valores.replace(valores.substring(0, n.toString().length()-1), "");
				
				i++;
			}	while(valores.length() >= n.toString().length()-1);
		
		
		System.out.println(vetorAscii);
		String[] vetorDividido = vetorAscii.split(";");
		
		System.out.println(vetorDividido[0]);
	}
	
	
}
