import java.util.Stack;

public class ValidarExpressao {
    
    // Função para verificar se o caractere é um operador válido
    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Função para verificar se o caractere é um dígito (número)
    public static boolean isOperand(char c) {
        return Character.isDigit(c);
    }

    // Função para validar parênteses equilibrados
    public static boolean areParenthesesBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // Função para validar a expressão aritmética infixa
    public static boolean isValidInfixExpression(String expression) {
        
        
        if (!areParenthesesBalanced(expression)) {
            return false;  // Verifica se os parênteses estão equilibrados
        }

        char prevChar = ' ';  // Armazena o caractere anterior
        boolean expectOperand = true;  // Inicialmente espera-se um operando
        boolean inNumber = false;      // Para controlar se estamos no meio de um número
        boolean decimalPointUsed = false;  // Para verificar se o ponto decimal foi usado

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (currentChar == ' ') {
                continue;  // Ignora espaços em branco
            }

            if (isOperand(currentChar)) {
                if (!expectOperand && !inNumber) {
                    return false;  // Se um operando ocorre quando se esperava um operador
                }
                inNumber = true;
                expectOperand = false;  // Agora espera-se um operador após o operando
            } else if (currentChar == '.') {
                if (!inNumber || decimalPointUsed) {
                    return false;  // Um ponto decimal inválido (ou já foi usado ou fora de um número)
                }
                decimalPointUsed = true;  // Marca que o ponto decimal foi usado
            } else if (isOperator(currentChar)) {
                if (expectOperand) {
                    return false;  // Se um operador ocorre quando se esperava um operando
                }
                expectOperand = true;  // Após o operador, espera-se um operando
                inNumber = false;  // Termina o número atual
                decimalPointUsed = false;  // Reseta o ponto decimal para o próximo número
            } else if (currentChar == '(') {
                if (!expectOperand) {
                    return false;  // Um parêntese de abertura não pode ocorrer após um operando
                }
                expectOperand = true;  // Após o '(', espera-se um operando
            } else if (currentChar == ')') {
                if (expectOperand) {
                    return false;  // Um parêntese de fechamento não pode ocorrer quando se espera um operando
                }
                // Após o ')', esperamos um operador, não um operando ou número diretamente
                expectOperand = false;  
                inNumber = false;  // Termina o número atual
                decimalPointUsed = false;  // Reseta o ponto decimal para o próximo número
            } else {
                return false;  // Caractere inválido encontrado
            }

            // Verificar se há um número logo após um parêntese de fechamento
            if (prevChar == ')' && (isOperand(currentChar) || currentChar == '(')) {
                return false;  // Inválido: número ou parêntese diretamente após ')'
            }

            prevChar = currentChar;
        }

        return !expectOperand;  // Verifica se a expressão termina com um operando
    }

}
