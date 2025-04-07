import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IllegalAccessException {

		Scanner scan= new Scanner(System.in);

		ArrayList<Contato> contatos=new ArrayList<>();

		Contato c = new Contato();

		boolean entrada=true;
		int opcao=-1;

		do {
			System.out.println("Digite o número que deseja no menu");
			System.out.println("1: Adiciona contato no final do vetor");
			System.out.println("2: Adiciona contato em uma posição específica");
			System.out.println("3: Obtém contato de uma posição específica");
			System.out.println("4: Consulta contato");
			System.out.println("5: Consulta último índice do contato");
			System.out.println("6: Verifica se contato existe");
			System.out.println("7: Excluir por posição");
			System.out.println("8: Excluir contato");
			System.out.println("9: Verifica tamanho do vetor");
			System.out.println("10: Excluir todos os contatos do vetor");
			System.out.println("11: Imprime vetor");
			System.out.println("0: Sair");

			try {
				String saida= scan.nextLine();
				opcao =Integer.parseInt(saida);
			} catch(Exception e) {
				System.out.println("Dados inválidos!Digite novamente");
				entrada=true;
			}

			switch(opcao) {
			case 1:
				c =new Contato();

				System.out.println("Digite o nome");
				String nome= scan.nextLine();
				c.setNome(nome);

				System.out.println("Digite o telefone");
				String telefone=scan.nextLine();
				c.setTelefone(telefone);

				System.out.println("Digite o email");
				String email=scan.nextLine();
				c.setEmail(email);

				contatos.add(c);

				entrada=true;
				break;

			case 2:
				c =new Contato();

				System.out.println("Digite o nome");
				nome= scan.nextLine();
				c.setNome(nome);

				System.out.println("Digite o telefone");
				telefone=scan.nextLine();
				c.setTelefone(telefone);

				System.out.println("Digite o email");
				email=scan.nextLine();
				c.setEmail(email);

				System.out.println("Digite a posição do vetor que deseja adicionar");
				try {
					int pos= scan.nextInt();
					contatos.add(pos, c);
					System.out.println("Contato alterado com sucesso!");
				}catch (Exception e) {
					System.out.println("Posição inserida invalida");
				}

				entrada=true;
				break;

			case 3:
				System.out.println("Digite a posição que deseja");
				try {
					int posicao =scan.nextInt();
					System.out.println(contatos.get(posicao).toString());

				}catch(Exception  e) {
					e.getMessage();
				}
				entrada=true;
				break;

			case 4:
				System.out.println("Digite o nome para ver se existe no contato");
				nome= scan.nextLine();
				try {
					for (int i=0;i<contatos.size();i++) {
						if (contatos.get(i).getNome().equals(nome)) {
							System.out.println("O indice desse contato é:"+i);
							break;
						}
					}
				}catch(Exception e) {
					System.out.println("Contato nao existe");
				}
				entrada=true;
				break;
			case 5: 
				int ultimoindice = (contatos.size()-1);
				System.out.println(contatos.get(ultimoindice).toString());
				entrada=true;
				break;
			case 6:
				System.out.println("Digite o que deseja saber");
				nome= scan.nextLine();
				boolean existe=false;
				for (int i=0;i<contatos.size();i++) {
					c=contatos.get(i);
					if (c.getNome().equals(nome)) {
						existe=true;
						System.out.println("o contato existe "+c.toString());
						break;
					}
				}if(!existe) {
					System.out.println("Contato não existe");
				}
				break;
			case 7:
				System.out.println("Digite o indice:");
				try {
					int posicao=scan.nextInt();
					if(posicao>=0 && posicao<contatos.size())
						contatos.remove(posicao);
					System.out.println("Contato removido com sucesso!");
				}catch (Exception e) {
					System.out.println();
				}
				entrada=true;
				break;
			case 8: 
				System.out.println("Digite o contato do nome que deseja remover");
				existe=false;
				nome=scan.nextLine();
				for (int i=0;i<contatos.size();i++) {
					c=contatos.get(i);
					if(c.getNome().equals(nome)) {
						contatos.remove(i);
						System.out.println("Contato removido!");
						existe=true;
					}
				}if(!existe) {
					System.out.println("Contato inexistente!");
				}
				entrada=true;
				break;
			case 9:
				System.out.println("O numero de contataos é: "+contatos.size());
				break;
			case 10: 
				boolean decisao= false;
				while(!false) {
					System.out.println("Tem certeza que deseja remover todos os seus contatos? Digite sim, ou nao");
					String exclui=scan.nextLine();

					if(exclui.equalsIgnoreCase("sim")) {
						contatos.clear();
						decisao=true;
					}else if (exclui.equalsIgnoreCase("nao")|| exclui.equalsIgnoreCase("não")) {
						System.out.println("Dados mantidos");
						decisao=true;
					}else {
						System.out.println("Dados invalidos.Digite sim ou não");
						decisao=false;
					}
					entrada=true;
				}
			case 11:
				System.out.println("Os contatos são");
				for(int i=0;i<contatos.size();i++) {
					System.out.println(contatos.get(i).toString());
				}
				entrada=true;
				break;
			default :
				if(opcao==0) {
					System.out.println("Usuario apertou 0. Programa finalizado!");
					entrada=false;
				}else if(opcao>11 && opcao<0) {
					System.out.println("Dados invalidos!Digite novamente!");
					entrada=true;
				}
			}


		}while(entrada);
	}
}