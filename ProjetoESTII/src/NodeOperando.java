public class NodeOperando extends Node{
    
    // Como não é possível igualar  NoResulado a Node, se faz necessario mais operações do que apenas utilizar o Node padrão e operações dir-
    //etamente com ele portanto não utilizamos na conta, mas a Herança se encontra feita e funcional.

    @Override public double visitar(){
        double dataDouble = Double.parseDouble(getData());
        return dataDouble;
    }
}
