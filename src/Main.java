import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {
	
		
		Object[] opcoes = {"Gerar Chaves", "Encriptar mensagem", "Decriptar mensagem"};
		
		
		
		Object selecionado = JOptionPane.showInputDialog(null, "Esclha uma opção", "Opções", JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
		
	
		
		String selecao = selecionado.toString();
		
		switch (selecao) {
		case "Gerar Chaves":
			//gerar chaves
			Chaves novo2 = new Chaves();
			novo2.rodar();
			
			
			break;
		case "Encriptar mensagem":
			//encriptar
			Encriptador novo = new Encriptador(JOptionPane.showInputDialog(null, "Digite a palavra a ser encriptada"));
		
			novo.rodar();
			
			break;
		case "Decriptar mensagem":
			//decriptar
			Decriptar novo3 = new Decriptar();
			novo3.Desencriptar();
			break;
		
		default:
			//dizer adeus
			break;
		}
		
		
	

	}

}
