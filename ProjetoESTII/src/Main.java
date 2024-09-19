//Nomes:
//Vinicius Alves Marques RA: 10417880
//Gabriel Barros Albertini RA: 10419482
//Rafael de Menezes Rossi RA: 10417954
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        //Variaveis de Ambiente:
        int opcao =0;
        String expressao="";
        int flagCase1 =0;
        int flagCase2 =0;
        while(opcao!=5){
            System.out.println("1. Entrada da expressão aritmética na notação infixa.\n2. Criação da árvore binária de expressão aritmética.\n3. Exibição da árvore binária de expressão aritmética.\n4. Cálculo da expressão (realizando o percurso da árvore).\n5. Encerramento do programa.\n" );
            System.out.println("Por favor, digite sua opcao: \n");
            opcao = input.nextInt();
            switch(opcao) {
                case 1:
                  System.out.println("\nDigite a expressão aritmética na notação infixa: \n");
                  input.nextLine();
                  expressao = input.nextLine();
                  if (ValidarExpressao.isValidInfixExpression(expressao)) {
                    System.out.println("\nA expressão é válida.\n");
                } else {
                    System.out.println("\nA expressão é inválida.\n");
                }
                flagCase1 = 1;
                  break;
                case 2:
                if(flagCase1 == 1 ){
                  String posfixa = ArvoreBin.PassarPosfixa(expressao);
                  //ArvoreBin.CriarArvore(ArvoreBin.colocarPilha(posfixa));
                  
                  //Debug
                  System.out.println(posfixa);
                  //Debug

                  // criacaoArvore();
                    flagCase2=1;
                  }else{
                    System.out.println("É necessário verificar a expressão antes, por favor, execute o case 1.");
                  }
                  break;
                case 3:
                if(flagCase2==1){
                  // exibeArvore();
                }else{
                  System.out.println("É necessário criar a àrvore antes, por favor, execute o case 2.");
                }
                  break;
                case 4:
                if(flagCase2==1){
                  // calculaArvore();
                }else{
                  System.out.println("É necessário criar a àrvore antes, por favor, execute o case 2.");
                }
                  break;
                case 5:
                System.out.println("\nFim do progama.");
                  break;
                default:
                  System.out.println("tem doença parece, tem 5 opcaoes parceirao!!!!!!");
              }
        }
          
    }
}
