public class NodeOperando extends Node{

    @Override public float visitar(){
        float dataFloat = Float.parseFloat(getData());
        return dataFloat;
    }
}
