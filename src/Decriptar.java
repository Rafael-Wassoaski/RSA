import java.math.BigInteger;

import javax.swing.JOptionPane;

public class Decriptar {
	
	private String valores;
	private BigInteger n;
	private Integer d;
	public Decriptar() {

		
		this.valores = JOptionPane.showInputDialog(null, "Digite a mensagem criptografada");
		
		
		
		this.n = new BigInteger(JOptionPane.showInputDialog(null, "Digite o valor de N"));
		this.d = Integer.valueOf(JOptionPane.showInputDialog(null, "Digite o valor de D"));
	}
	
	
	public void Desencriptar() {
		String fraseAscii  = "";
		String temp = "";
		
		
		String vetorAscii = "";
		
		
		
		int  i = 0;
		do{
				
				vetorAscii += valores.substring(0, n.toString().length()-1);
				vetorAscii+=";";
				valores  = valores.replace(valores.substring(0, n.toString().length()-1), "");
				
				i++;
			}	while(valores.length() >= n.toString().length()-1);
		
		
	
		String[] vetorDividido = vetorAscii.split(";");
		
		
		
		
		
		BigInteger descri;
		Integer descri2;
		
		for(int j = 0; j < vetorDividido.length; j++) {
			
			if(vetorDividido[j]==null) {
				break;
			}
			
			
			descri = new BigInteger(vetorDividido[j]);
			
			descri= descri.pow(d).mod(n);
			
			temp+=descri;
		
		}
		
		
		
		String descriptografada = "";
		
		int conver;

	
		i=0;
		int guarda;
		while (i < temp.length()) {
			guarda = Integer.valueOf(temp.substring(i, Math.min(i+2,temp.length())));
			descriptografada+=Character.toString((char) guarda);
		      i+= 2;
		}
		
		JOptionPane.showConfirmDialog(null, "Sua mensagem: " + descriptografada);
	}
	
	
}
