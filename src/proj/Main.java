package src.proj;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public String methodToTest() {
        // This is the method we want to test
        return "Expected Result";
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
}
