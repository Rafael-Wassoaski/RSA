import java.util.Random;

import javax.swing.JOptionPane;

public class Chaves {
	
	public Chaves() {
		// TODO Auto-generated constructor stub
	}
	private Integer p, q, n, e, d;
	
	private double retorno;
	
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

	public void FatorDiferente() {
	

		this.n = p * q;

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

	

	}

	public void calcularChaveD() {
		
		for(int i = 0; ; i++) {

			if((retorno*i)% ((p-1) * (q-1)) == 1){
				d = i;
				break;
			}
		}
	
		JOptionPane.showConfirmDialog(null, "CHAVE PÚBLICA(e "+ (int)retorno + ", n " + n + 
				")\n CHAVE PRIVADA(d "+ d + ", n "+n+")");
	
	}
	
	
	public void rodar() {
		LerPrimos();
		FatorDiferente();
	
		calcularChaveD();
	}
}
