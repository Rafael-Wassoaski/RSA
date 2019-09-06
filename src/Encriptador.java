import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

public class Encriptador {

	private Integer n, p, q, d, fator;
	private String frase;
	private Integer e;
	private ArrayList<String> ascii = new ArrayList<>();
	private BigInteger [] vetorAscii ;

	public Encriptador(String frase) {

		this.frase = frase.toUpperCase();
	}

	public void LerPrimos() {
		boolean continuar = true;

		while (continuar) {
			continuar = false;

			try {
				p = Integer.valueOf(JOptionPane.showInputDialog(null, "Digite um valor primo para P"));

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				continuar = false;
			}
			for (int i = 2; i < p; i++) {
				if (p % i == 0) {

					JOptionPane.showMessageDialog(null, p + " não é primo, digite outro valor");
					continuar = true;
					break;

				}
			}
		}

		continuar = true;
		while (continuar) {
			continuar = false;
			try {
				q = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um valor primo para Q"));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				continuar = false;
			}

			for (int i = 2; i < q; i++) {
				if (q % i == 0) {

					JOptionPane.showMessageDialog(null, q + " não é primo, digite outro valor");
					continuar = true;
					break;

				}
			}
		}
	}

	public double FatorDiferente() {
		double retorno = 0, fatorDiferente;

		this.fator = (p - 1) * (q - 1);

		boolean continuar = true;
		Random rand = new Random();
		while (continuar) {
			continuar = false;
			retorno = rand.nextInt(1000);
			
					
			if(retorno < 2) {
				continuar = true;
				continue;
			}
			for (int i = 2; i < retorno; i++) {
				if (retorno % i == 0) {
					continuar = true;
					break;
				}
			}

		}

		return retorno;

	}

	
	public void calcularChaveD() {
	
		for(int i = 0; ; i++) {

			if((this.e*i) % ((this.p - 1) * (this.q - 1)) == 1){
				this.d = i;
				break;
			}
		}
		
	
	}
	
	public void tranformarAscii() {
		
		String fraseAscii = "";
		for(int i = 0; i < frase.length(); i++) {
			fraseAscii+=String.valueOf((int)frase.charAt(i));
			
		}
		
		
		int tamanhoN = n.toString().length();
		
		
		vetorAscii = new BigInteger[fraseAscii.length()];

		int  i = 0, d=0;

		
		String aux;
		do {
			aux = fraseAscii.substring(i, Math.min(i+tamanhoN-1,fraseAscii.length()));
			
			if(aux.length() < tamanhoN-1) {
				for(int j = aux.length(); j < tamanhoN-1; j++) {
					aux+="0";
				}
			}
			
		      vetorAscii[d] =new BigInteger(aux);
		    
		      
		      i+= tamanhoN-1;
		      d++;
		}while (i < fraseAscii.length() );
		
				
		
	}
	
	
	public void Criptografar() {
		
		
		BigInteger novoN = BigInteger.valueOf(n);
		
		String resultadoCripto = "";

		for(int i = 0; i < vetorAscii.length; i++) {
			
			if(vetorAscii[i] == null) {
				break;
			}
	
			vetorAscii[i] = vetorAscii[i].pow(e).mod(novoN);
		
			
			
			//cripto
			
			
			
		
			
		}
		
		
		String temp;
		
		for(int i = 0; i < vetorAscii.length; i++) {
			if(vetorAscii[i] == null) {
				break;
			}
			temp = vetorAscii[i].toString();
			//System.out.println(temp);
			if(temp.length() < n.toString().length()) {
				
				for(int j = temp.length(); j < n.toString().length()-1; j++) {
					temp = "0" + temp;
				}
			}
			
			
			
		}
		
		
		for( int i = 0; i < vetorAscii.length; i++) {
			if(vetorAscii[i] == null) {
				break;
			}
			temp = vetorAscii[i].toString();
			
			if(temp.length() < n.toString().length()-1) {
				for(int j = temp.length(); j < n.toString().length()-1; j++) {
					temp+="0";
				}
			}
			
			//System.out.println(temp);
			if(temp.length() >= n.toString().length()) {
				
				for(int j = temp.length(); j < (n.toString().length()*2)-2; j++) {
					temp = temp+"0";
				}
			}
		System.out.println(temp);
		
		//System.out.println(temp);
		
		resultadoCripto+=temp;
		
		
	}
		JOptionPane.showConfirmDialog(null, "Sua mensagem: " + resultadoCripto);
	
		
		
	
		
		
	}
	
	public void rodar() {
		
		n = Integer.valueOf(JOptionPane.showInputDialog(null, "Digite o valor de N"));
		e = Integer.valueOf(JOptionPane.showInputDialog(null, "Digite o valor de E"));
		d = Integer.valueOf(JOptionPane.showInputDialog(null, "Digite o valor de D"));
		//LerPrimos();
		//n = p * q;
		//e = FatorDiferente();
		
		//calcularChaveD();
		
		tranformarAscii();
		
		Criptografar();
	
		
	}

}
