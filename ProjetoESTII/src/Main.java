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
        ArvoreBin arvore = new ArvoreBin();
        Node raiz = new Node("",null,null,null);
        while(opcao!=5){
            System.out.print("1. Entrada da expressão aritmética na notação infixa.\n2. Criação da árvore binária de expressão aritmética.\n3. Exibição da árvore binária de expressão aritmética.\n4. Cálculo da expressão (realizando o percurso da árvore).\n5. Encerramento do programa.\n" );
            System.out.println("Por favor, digite sua opcao: \n");
            opcao = input.nextInt();
            switch(opcao) {
                case 1:
                  System.out.println("\nDigite a expressão aritmética na notação infixa: \n");
                  input.nextLine();
                  expressao = input.nextLine();
                  if (ValidarExpressao.isValidInfixExpression(expressao)) {
                    System.out.println("\nA expressão é válida.\n");
                    flagCase1 = 1;
                } else {
                    System.out.println("\nA expressão é inválida.\n");
                }
                  break;
                case 2:
                if(flagCase1 == 1 ){
                  String posfixa = ArvoreBin.PassarPosfixa(expressao);
                  raiz = arvore.construirArvore(posfixa);
                  arvore.setRaiz(raiz);
                  System.out.println("\n Árvore criada com sucesso!! \n");
                  //Debug//
                  System.out.println("\n ***DEBUGING*** \n");
                  System.out.println("Expressao: ");
                  System.out.println(posfixa);
                  System.out.println(arvore);
                    flagCase2=1;
                  }else{
                    System.out.println("\nÉ necessário verificar a expressão antes, por favor, execute o case 1.\n");
                  }
                  break;
                case 3:
                if(flagCase2==1){
                  System.out.println("\nPercorrendo a àrvore pré-ordem: \n");
                  arvore.preOrderTraversal();
                  System.out.println("\n");
                  System.out.println("\nPercorrendo a àrvore em ordem: \n");
                  arvore.inOrder();
                  System.out.println("\n");
                  System.out.println("\nPercorrendo a àrvore pós-ordem: \n");
                  arvore.postOrderTraversal();
                  System.out.println("\n");
                }else{
                  System.out.println("\nÉ necessário criar a àrvore antes, por favor, execute o case 2.\n");
                }
                  break;
                case 4:
                if(flagCase2==1){
                  double resultado = arvore.calcularArvore(raiz);
                  System.out.println("\nO resultado percorrendo a àrvore em odem é: "+resultado+"\n");
                }else{
                  System.out.println("\nÉ necessário criar a àrvore antes, por favor, execute o case 2.\n");
                }
                  break;
                case 5:
                System.out.println("\nFim do progama.");
                  break;
                default:
                  System.out.println("\nOpção inválida!\n");
              }
        }
          
        input.close();
    }
  }
