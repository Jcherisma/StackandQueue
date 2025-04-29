package src.proj;
import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    //This method takes a string and reverses it using a stack
    //we use a StrinBuilder rather than a String because String is immutable
    //and StringBuilder is mutable
    public static StringBuilder reverseString(String str) {
        StringBuilder reversed = new StringBuilder();

        Stack<Character> myStack = new Stack<>();
        for (char c : str.toCharArray()) {
            myStack.push(c);
        }
        while (!myStack.isEmpty()) {
            reversed.append(myStack.pop());
        }
        return reversed;
    }

    //The purpose of this method is to evaluate an arithmetic expression
    //The method takes a string and an expression type (infix, prefix, postfix)
    //and returns the result of the expression
    public static double solveArithmeticExpr(String str, String expression) {
        double solution = 0;

        switch(expression) 
        {
            case "Infix":
               solution = evaluateInfix(str);
                break;
            case "Prefix":
                solution = evaluatePrefix(str);
                break;
            case "Postfix":
                solution = evaluatePostfix(str);
                break;
            default:
                throw new IllegalArgumentException("Invalid expression type");
         }

        return solution;
    }

    //Takes a string and returns a list of tokens, in our cae the tokens are the numbers and operators
    public static List<String> tokenizeString(String str)
        {
            List<String> tokens = new ArrayList<>();
            int i = 0;
            while (i < str.length()) {
                char ch = str.charAt(i);
    
                if (Character.isDigit(ch) || ch == '.') {
                    StringBuilder num = new StringBuilder();
                    while (i < str.length() && 
                          (Character.isDigit(str.charAt(i)) || str.charAt(i) == '.')) {
                        num.append(str.charAt(i++));
                    }
                    tokens.add(num.toString());
                } else if ("+-*/()".indexOf(ch) != -1) {
                    tokens.add(Character.toString(ch));
                    i++;
                } else if (Character.isWhitespace(ch)) {
                    i++;
                } else {
                    throw new IllegalArgumentException("Invalid character: " + ch);
                }
            }

            return tokens;
        }


    //This methods set set and get the precedence of the operators
    public static int precedence(char operator) {
        if(operator == '+' || operator == '-') 
        {
            return 1;
        } else if(operator == '*' || operator == '/') {
            return 2;
        } else if(operator == '^') {
            return 3;
        }
        return -1;
    } 

    //This method applies the operator to the operand and returns the result
    public static double applyOperator(double a, double b, char operator) 
    {
        if (operator == '+') 
        { 
            return (a + b);
        }
        else if (operator == '-') 
        {
            return (a-b);
        }
        else if (operator == '*')
        {
            return (a*b);
        }
        else if (operator == '/')
        {
            if (b == 0) 
            {
                throw new UnsupportedOperationException("Cannot divide by zero");
            }
            return (a/b);
        }
        else if (operator == '^')
        {
            return (int) Math.pow(a, b);
        }
        else
        {
            System.out.println("Invalid operator");
        }
        
        return 0;
    }

    //This method evaluates the infix expression and returns the result
    //The method uses two stacks, one for the operands and one for the operators
    public static  double evaluateInfix(String expression)
    {
        Stack<Double> operandsStack = new Stack<>();
        Stack<Character> operatorsStack = new Stack<>();
        List<String> str = tokenizeString(expression);

        for (String s : str) 
        {
            if (s.matches("\\d+(\\.\\d+)?"))
            {
                operandsStack.push(Double.valueOf(Double.parseDouble(s)));
            } else if (s.equals("(")) 
            {
                operatorsStack.push('(');
            } else if (s.equals(")")) 
            {
                while (operatorsStack.peek() != '(') 
                { 
                    double b = operandsStack.pop();
                    double a = operandsStack.pop();
                    char operator = operatorsStack.pop();
                    operandsStack.push(applyOperator(a,b,operator));                
                }
                operatorsStack.pop();
            } else if (s.equals(")"))
            {
                while (operatorsStack.peek() != '(') 
                { 
                    double b = operandsStack.pop();
                    double a = operandsStack.pop();
                    char operator = operatorsStack.pop();
                    operandsStack.push(applyOperator(a,b,operator));                
                }
                operatorsStack.pop();
            } else if ( s.charAt(0) == '+' || s.charAt(0) == '-' || s.charAt(0) == '*' || s.charAt(0) == '/' || s.charAt(0) == '^')
            {
                while (!operatorsStack.isEmpty() && precedence(operatorsStack.peek()) >= precedence(s.charAt(0)))
                {
                    double b = operandsStack.pop();
                    double a = operandsStack.pop();
                    char operator = operatorsStack.pop();
                    operandsStack.push(applyOperator(a,b,operator)); 
                }
                operatorsStack.push(s.charAt(0));
            }
        }
        
        while (!operatorsStack.isEmpty())
        {
            double b = operandsStack.pop();
            double a = operandsStack.pop();
            char operator = operatorsStack.pop();
            operandsStack.push(applyOperator(a,b,operator));
        }
        
        return operandsStack.pop();       
    }

     //This method evaluates the Postfix expression and returns the result
    //The method uses a stack, holding the operands while applying the operators at a time
    public static  double evaluatePostfix(String expression)
    {
        Stack<Double> operandsStack = new Stack<>();
        List<String> str = tokenizeString(expression);
      
        for (String s : str) 
        {
            if (s.matches("\\d+(\\.\\d+)?"))
            {
                operandsStack.push(Double.valueOf(Double.parseDouble(s)));
            } else if (s.charAt(0) == '+' || s.charAt(0) == '-' || s.charAt(0) == '*' || s.charAt(0) == '/' || s.charAt(0) == '^')
            {
                double b = operandsStack.pop();
                double a = operandsStack.pop();
                operandsStack.push(applyOperator(a,b,s.charAt(0)));
            }
        }
        return operandsStack.pop(); 
    }

    //This method evaluates the Prefix expression and returns the result
    //The method uses a stack, holding the operands while applying the operators at a time
    public static  double evaluatePrefix(String expression)
    {
        Stack<Double> operandsStack = new Stack<>();
        List<String> str = tokenizeString(expression);


        for (int i = str.size()-1; i >= 0; i--) {
            String s = str.get(i);

            if (s.matches("\\d+(\\.\\d+)?")) {
                operandsStack.push(Double.valueOf(Double.parseDouble(s)));
            } else {
                double a = operandsStack.pop();
                double b = operandsStack.pop();
                double result = applyOperator(a, b,s.charAt(0));
                operandsStack.push(result);
            }
        }

        return operandsStack.pop(); 
    }

    /*  
     * FUNCTIONS BELOW WILL HELP IMPLEMET AND SIMULATE A TICKET BOOTH SYSTEM USING A QUEUE
     */

     //This method creates a list of customers
     //The method takes a string array of names and returns a list of customers
     public static ArrayList<Customer> createCustomers()
     {
        ArrayList<Customer> customers = new ArrayList<>();
        Random random = new Random();
        
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve", "Jeff", "Rose", "Audresha"};

        for (int i = 0; i < names.length; i++)
        {
            String firstname = names[random.nextInt(names.length)];

            customers.add(new Customer(firstname, i + 1));
        }

        return customers;
     }

     //This method simulates a customer joining a line by adding them to the queue
     public static void joinLine(Queue<Customer> queue, Customer customer) 
     {
        queue.enqueue(customer);
     }  

     //This method simulates a customer leaving a line by removing them from the queue
     //which should be the first customer in the queue and the first who joined the line
     public static void exitLine(Queue<Customer> queue) 
    {
        if(queue.isEmpty())
        {
            throw new RuntimeException("Stack is empty");
        }
         queue.dequeue();
    }
}
