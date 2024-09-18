public class NodeResultado extends Node{

    // Essa implementação do visitar supoe que ele está sendo chamado em um node que contenha a operacao a ser feita.
    @Override public float visitar(){
        float operacao=0;
        switch (getData()) {
            case "+": 
                operacao = Float.parseFloat(getEsquerda().getData()) + Float.parseFloat(getDireita().getData()); 
                break;
            case "-":
                operacao = Float.parseFloat(getEsquerda().getData()) - Float.parseFloat(getDireita().getData());                break;
            case "/":
                operacao = Float.parseFloat(getEsquerda().getData()) / Float.parseFloat(getDireita().getData());                break;
            case "*":
                operacao = Float.parseFloat(getEsquerda().getData()) * Float.parseFloat(getDireita().getData());                break;
            default:
                System.out.println("Operador inválido!!");
                break;
        }
        return operacao;
    }
}
