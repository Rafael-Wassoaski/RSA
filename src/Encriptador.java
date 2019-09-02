import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Encriptador {

	private Integer n, p, q, d, fator;
	private String frase;
	private double e;
	private ArrayList<String> ascii = new ArrayList<>();
	private BigInteger [] vetorAscii ;

	public Encriptador(String frase) {

		this.frase = frase;
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
			retorno = rand.nextInt(100);
			
					
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
	
		for(int i = 0; ; i++)

			if((this.e*i)% ((this.p - 1) * (this.q - 1)) == 1){
				this.d = i;
				break;
			}

		
	
	}
	
	public void tranformarAscii() {
		
		String fraseAscii = "";
		for(int i = 0; i < frase.length(); i++) {
			fraseAscii+=String.valueOf((int)frase.charAt(i));
		}
		int tamanhoN = n.toString().length();
		
		
		vetorAscii = new BigInteger[fraseAscii.length()];

		
		int  i = 0;
	do{
			
			vetorAscii[i] = new BigInteger(fraseAscii.substring(0, tamanhoN-1));
			fraseAscii  = fraseAscii.replace(fraseAscii.substring(0, tamanhoN-1), "");
			
			i++;
		}	while(fraseAscii.length() >= tamanhoN-1);
		
		
		if(!fraseAscii.isBlank() || !fraseAscii.isEmpty()) {
			for(i = fraseAscii.length(); i < tamanhoN-1; i++) {
				fraseAscii+="0";
			}
			vetorAscii[i] = new BigInteger(fraseAscii.substring(0, tamanhoN-1));
			fraseAscii  = fraseAscii.replace(fraseAscii.substring(0, tamanhoN-1), "");
		}
		
		
		

		
		
	}
	
	
	public void Criptografar() {
		
		
		BigInteger resultado, novoN, novoE;
		long eLong = (long) e;
		
		String resultadoCripto = "";
		novoE = BigInteger.valueOf(eLong);
		novoN = BigInteger.valueOf(n);
		for(int i = 0; i < vetorAscii.length; i++) {
			
			if(vetorAscii[i] == null) {
				break;
			}
			resultado = vetorAscii[i];
			
			
			resultado = resultado.modPow(novoE, novoN);
			
			
			//cripto
			
			vetorAscii[i] = resultado;
		
			resultadoCripto+= resultado;
		}
		JOptionPane.showConfirmDialog(null, "Sua mensagem: " + resultadoCripto);
	
		novoE = BigInteger.valueOf(d);
		resultadoCripto = "";
		for(int i = 0; i < vetorAscii.length; i++) {
			
			if(vetorAscii[i] == null) {
				break;
			}
			resultado = vetorAscii[i];
		
			resultado = resultado.modPow(novoE, novoN);
		
			
			
			
			
			vetorAscii[i] = resultado;
			resultadoCripto+= resultado;
			
		}
		JOptionPane.showConfirmDialog(null, "Sua mensagem de: " + resultadoCripto);
		
	
		
		
	}
	
	public void rodar() {
		
		n = Integer.valueOf(JOptionPane.showInputDialog(null, "Digite o valor de N"));
		e = Double.valueOf(JOptionPane.showInputDialog(null, "Digite o valor de E"));
		d = Integer.valueOf(JOptionPane.showInputDialog(null, "Digite o valor de D"));
		//LerPrimos();
		//n = p * q;
		//e = FatorDiferente();
		
		//calcularChaveD();
		
		tranformarAscii();
		
		Criptografar();
	
		
	}

}
