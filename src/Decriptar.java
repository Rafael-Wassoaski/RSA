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
		String desc = "";
		int conver;
		System.out.println(temp);
		for(i = 0; i < temp.length(); i++) {
			desc+=temp.charAt(i);
			
			if(Integer.valueOf(desc) <= 122 && Integer.valueOf(desc) >= 65) {
				conver = Integer.valueOf(desc);
				desc = "";
				descriptografada+=Character.toString((char)conver);
				
			}
			

		}
		
		JOptionPane.showConfirmDialog(null, "Sua mensagem: " + descriptografada);
	}
	
	
}
