import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class ArvoreBin {
    private Node raiz;

    // Construtor sem parametros
    public ArvoreBin() {
        this.raiz = null;
    }

    // Construtor com parametro
    public  ArvoreBin(Node raiz) {
        this.raiz = raiz;
    }

    // Get e set raiz;
    public Node getRaiz() {
        return raiz;
    }

    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    // getDegree
    public int getDegree() {
        if (isEmpty()) {
            return 0;
        }
        return raiz.getHeight();
    }

    // getHeight
    public int getHeight() {
        if (isEmpty()) {
            return -1;
        }
        return raiz.getHeight();
    }

    // Percurso em ordem
    public void inOrder() {
        inOrderSuporte(raiz);
    }

    private void inOrderSuporte(Node node) {
        if (node != null) {
            inOrderSuporte(node.getEsquerda());
            System.out.print(node.getData() + " ");
            inOrderSuporte(node.getDireita());
        }
    }

    // Percurso em pré-ordem
    public void preOrderTraversal() {
        preOrderSuporte(raiz);
    }

    private void preOrderSuporte(Node node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preOrderSuporte(node.getEsquerda());
            preOrderSuporte(node.getDireita());
        }
    }

    // Percurso em pós-ordem
    public void postOrderTraversal() {
        postOrderSuporte(raiz);
    }

    private void postOrderSuporte(Node node) {
        if (node != null) {
            postOrderSuporte(node.getEsquerda());
            postOrderSuporte(node.getDireita());
            System.out.print(node.getData() + " ");
        }
    }

    // Percurso por nível
    public void levelOrderTraversal() {
        if (raiz == null) {
            return;
        }

        Queue<Node> fila = new LinkedList<>();
        fila.add(raiz);
        StringBuilder sb = new StringBuilder();
        

        while (!fila.isEmpty()) {
            Node nodeAtual = fila.poll();
            sb.append(nodeAtual.getData() + " ");

            if (nodeAtual.getEsquerda() != null) {
                fila.add(nodeAtual.getEsquerda());
            }

            if (nodeAtual.getDireita() != null) {
                fila.add(nodeAtual.getDireita());
            }
        }
        
    sb.toString();
    System.out.println(sb);
    }
    

//Metodo adicionais

// Inserir
public void comecaInserir(String data) {
    setRaiz(inserir(getRaiz(), data));
}

private Node inserir(Node node, String data) {
    // Se o nó é null, criamos um novo nó com o valor de data
    if (node == null) {
        return new Node(data, null, null, null);
        //Já tem raiz
    }else if(node.getDireita()==null){
        Node novoDireita = new Node(data,null,null,null);
        node.setDireita(novoDireita);
        novoDireita.setPai(node);
        return node;
        //Ja tem raiz e direita não é nula.
    }else if(ValidarExpressao.isOperator(node.getDireita().getData().charAt(0))){
        inserir(node.getDireita(),data);
        //Ja tem raiz, direita não é nula e é um número.
    }else if(node.getEsquerda()==null){
        Node novoEsquerda =  new Node(data,null,null,null);
        node.setEsquerda(novoEsquerda);
        novoEsquerda.setPai(node);
        return node;
        //Ja tem raiz, direita não é nula e é um número e esquerda não está vazia.
    } else if(ValidarExpressao.isOperator(node.getEsquerda().getData().charAt(0))){
        inserir(node.getEsquerda(),data);
        
        //Ja tem raiz, direita não é nula e é um número e esquerda não está vazia e é um número
    }

    return node;  // Retorna o nó atualizado
}



// Método para converter uma expressão infixa para pós-fixa
public static String PassarPosfixa(String expressao) {
    Stack<Character> stack = new Stack<>();
    StringBuilder posfix = new StringBuilder();
    
    // Remover espaços em branco da expressão
    expressao = expressao.replaceAll("\\s+", "");

    int i = 0;
    while (i < expressao.length()) {
        char token = expressao.charAt(i);

        // Se o caractere é um número ou um ponto (para decimais)
        if (isNumber(token)) {
            posfix.append(token);

            // Verifica se há mais dígitos (números ou ponto) para compor o número completo
            while (i + 1 < expressao.length() && isNumber(expressao.charAt(i + 1))) {
                posfix.append(expressao.charAt(++i));
            }
            posfix.append(" ");  // Adiciona um espaço após o número completo
        }
        // Se for um parêntese esquerdo, empilhe-o
        else if (token == '(') {
            stack.push(token);
        }
        // Se for um parêntese direito, desenpilhe até encontrar o parêntese esquerdo
        else if (token == ')') {
            while (!stack.isEmpty() && stack.peek() != '(') {
                posfix.append(stack.pop()).append(" ");
            }
            stack.pop();  // Remove o '(' da pilha
        }
        // Se for um operador
        else if (isOperator(token)) {
            while (!stack.isEmpty() && precedence(token) <= precedence(stack.peek())) {
                posfix.append(stack.pop()).append(" ");
            }
            stack.push(token);
        }
        i++;
    }

    // Após processar todos os caracteres, esvazie a pilha
    while (!stack.isEmpty()) {
        posfix.append(stack.pop()).append(" ");
    }

    return posfix.toString().trim(); // Retorna a expressão pós-fixa sem espaços extras
}

// Função para verificar se o caractere é um operador
private static boolean isOperator(char token) {
    return token == '+' || token == '-' || token == '*' || token == '/';
}

// Função para definir a precedência dos operadores
private static int precedence(char operator) {
    switch (operator) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        default:
            return 0;
    }
}

// Função para verificar se um caractere é um dígito ou um ponto decimal
private static boolean isNumber(char c) {
    return Character.isDigit(c) || c == '.';
}

    public static Stack<String> colocarPilha(String posfixa){
        Stack<String> pilha = new Stack<>();
        
        // Divide a expressão em tokens
        String[] tokens = posfixa.split(" ");
        
        for (String token : tokens) {
            // Adiciona cada token à pilha
            pilha.push(token);
        }
        
        // Exibe os elementos da pilha
        return pilha;
    }

    public void criacaoArvore(Stack<String> pilha){
        while (!pilha.isEmpty()) {
            String data =pilha.pop();
            comecaInserir(data);
        }

    }

    //Percorre e calcula

    public int calcularExpressao(Node node) {
        // Se o nó for null, retornamos 0 (caso base)
        if (node == null) {
            return 0;
        }
    
        // Se o nó não é operador (é um número), convertemos a string em número e retornamos
        if (!ValidarExpressao.isOperator(node.getData().charAt(0))) {
            return Integer.parseInt(node.getData());
        }
    
        // Recursivamente calculamos o valor da subárvore esquerda e direita
        int esquerda = calcularExpressao(node.getEsquerda());
        int direita = calcularExpressao(node.getDireita());
    
        // Agora aplicamos o operador armazenado no nó atual aos operandos
        char operador = node.getData().charAt(0);
        switch (operador) {
            case '+':
                return esquerda + direita;
            case '-':
                return esquerda - direita;
            case '*':
                return esquerda * direita;
            case '/':
                return esquerda / direita;  // Assumimos que divisão por zero já foi tratada
            default:
                throw new IllegalArgumentException("Operador inválido: " + operador);
        }
    }

    @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    printTree(getRaiz(), sb, "", "");
    return sb.toString();
}

// Método auxiliar para construir a árvore no formato visual
private void printTree(Node node, StringBuilder sb, String padding, String pointer) {
    if (node != null) {
        // Adiciona a linha correspondente ao nó atual
        sb.append(padding);
        sb.append(pointer);
        sb.append(node.getData()).append("\n");

        // Preparando para os filhos (esquerda e direita)
        StringBuilder paddingBuilder = new StringBuilder(padding);
        paddingBuilder.append("│  "); // Adiciona um "tronco" visual para os filhos
        String paddingForBoth = paddingBuilder.toString();
        
        // Definindo os ponteiros para os filhos
        String pointerLeft = "├──";
        String pointerRight = "└──";

        // Recursão para filhos esquerdo e direito
        if (node.getDireita() != null) {
            printTree(node.getEsquerda(), sb, paddingForBoth, pointerLeft);
            printTree(node.getDireita(), sb, paddingForBoth, pointerRight);
        } else {
            printTree(node.getEsquerda(), sb, paddingForBoth, pointerLeft);
            sb.append(paddingForBoth).append(pointerRight).append("null\n");
        }
    } else {
        // Se o nó for null, imprime null
        sb.append(padding).append(pointer).append("null\n");
    }
}






}
