import java.util.*;

public class DM_EA7{

     /*
      4) 
        1- On parle d'opposé lorsque l'on verifie dans a case "-" du switch de EvalRpn la nature de l'opérateur "-", que l'on autorise qu'une expression
        donné en entrée commence par un - et surtout s'il est un opérateur unaire (donc passage à l'opposé) ou binaire (donc une soustraction) 
        2) Oui, on peut le garder
      */
    
    public static int CalculusRPN (String expression) {
        Stack<Integer> pile = new Stack<Integer>() ; 

        if (expression.charAt(0) < '0' || expression.charAt(0) > '9') { // si l'expression commence par autre chose qu'un entier, notamment un opérateur ou une lettre
            System.out.println("Expression Incorrecte, réesayez");
            System.exit(0);
        }    
        for (int i = 0 ; i<expression.length() ; i++) {
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                pile.push(Integer.valueOf(expression.charAt(i)+"")) ; 
                continue ; 
            }


            try { //Dans le cas d'une expression complexe à n opérateur, on utilse un switch afin de permettre un traitement complet de l'expressionession
                switch (expression.charAt(i)+"") {
                    case "+" :
                        pile.push(pile.pop() + pile.pop()) ; 
                        break ; 
                    case "-" :
                        int a1 = pile.pop() ; 
                        pile.push(pile.pop()-a1) ; 
                        break ; 
                    case "*" :
                        pile.push(pile.pop() * pile.pop()) ; 
                        break ; 
                    case "/" :
                        int a2 = pile.pop() ; 
                        pile.push(pile.pop() / a2) ; 
                        break ;             
                    case "%" :
                        int a3 = pile.pop() ; 
                        pile.push(pile.pop() % a3) ; 
                        break ;
                    default :
                        System.out.println("expression Incorrecte, réesayez");
                        System.exit(0);         
                }
            } catch (EmptyStackException e) {
                System.out.println("expression Incorrecte, réesayez");
                System.exit(0);
            }
        }

        int pb = pile.pop() ; 
        if (!pile.isEmpty()) {
            System.out.println("expression Incorrecte, réesayez");
            System.exit(0);
        }
        return pb ; 
    }

    public static void main(String[] args) {
        System.out.println(CalculusRPN("544*78+65*89e26"));
    }
}