import java.util.Stack;
import java.util.Scanner;

public class verificadorExpressoes {

    public static void main(String[] args) {
        Scanner verifi = new Scanner(System.in);
        System.out.println("Digite uma expressao matematica: ");
        String expressao = verifi.nextLine();

        if (verifPar(expressao)) {
            System.out.println("Expressão correta");
        } else {
            System.out.println("Expressao incorreta");
        }
    }

    public static boolean verifPar(String expressao) {
        Stack<Character> pilha = new Stack<>();

        for (char caractere : expressao.toCharArray()) {
            if (caractere== '(' || caractere == '[' ||caractere == '{') {
                pilha.push(caractere);
            } else if (caractere == ')' || caractere== ']' || caractere== '}') {
                if (pilha.isEmpty() ||!parCorresp(pilha.pop(), caractere)) {
                    return false;
                }
            }
        }
        return pilha.isEmpty();
    }
    public static boolean parCorresp(char abre, char fecha) {
        return (abre =='(' && fecha == ')')|| (abre == '[' && fecha == ']') || (abre == '{' && fecha == '}');
    }
}
