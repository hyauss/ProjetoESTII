//Nomes:
//Vinicius Alves Marques RA: 10417880
//Gabriel Barros Albertini RA: 10419482
//Rafael de Menezes Rossi RA: 10417954
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int opcao =0;
        while(opcao!=5){
            System.out.println("1. Entrada da expressão aritmética na notação infixa.\n2. Criação da árvore binária de expressão aritmética.\n3. Exibição da árvore binária de expressão aritmética.\n4. Cálculo da expressão (realizando o percurso da árvore).\n 5. Encerramento do programa.\n" );
            System.out.println("Por favor, digite sua opcao.");
            opcao = input.nextInt();
            switch(opcao) {
                case 1:
                  System.out.println("Digite a expressão aritmética na notação infixa: ");
                  String expressao = input.nextLine();
                  //validar(expressao);
                  break;
                case 2:
                  // criacaoArvore();
                  break;
                case 3:
                  // exibeArvore();
                  break;
                case 4:
                  // calculaArvore();
                  break;
                default:
                  System.out.println("tem doença parece, tem 5 opcaoes parceirao!!!!!!");
              }
        }
          
    }
}
