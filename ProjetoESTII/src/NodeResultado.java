public class NodeResultado extends Node{

    // Como não é possível igualar  NoResulado a Node, se faz necessario mais operações do que apenas utilizar o Node padrão e operações dir-
    //etamente com ele portanto não utilizamos na conta, mas a Herança se encontra feita e funcional.

    @Override public double visitar(){
        double  operacao=0;
        switch (getData()) {
            case "+": 
                return operacao = Double.parseDouble(getEsquerda().getData()) + Double.parseDouble(getDireita().getData());
            case "-":
                return operacao = Double.parseDouble(getEsquerda().getData()) - Double.parseDouble(getDireita().getData());
            case "/":
                if(Double.parseDouble(getDireita().getData())!=0){
                return operacao = Double.parseDouble(getEsquerda().getData()) / Double.parseDouble(getDireita().getData());
                }
                System.out.println("\nDivisão por 0!\n");
                return operacao = -999;
            case "*":
                return operacao = Float.parseFloat(getEsquerda().getData()) * Float.parseFloat(getDireita().getData());
            default:
                System.out.println("Operador desconhecido: " + getData());
                return operacao = -999;
            }
        }
            
    }
