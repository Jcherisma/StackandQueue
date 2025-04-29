                         ----- Stack and Queue Project-----

- This project explores the Stack, Queue, and LinkedList data structures, while also touching on inheritance between classes and providing insight into the JUnit testing framework.

- Rather than using Java’s built-in Stack and Queue classes, we create our own custom implementations. We then apply these structures to solve simple problems in the Main class.

-Reversestring function;
    -A simple function that takes a string and reverses it using a stack.
    --Ex: Input: "Hello" --> Output: "olleH"

-EvaluatePrefix, EvaluatePostfix and EvaluateInfix;
    -These three functions take in a string parameter containing an arithmetic expression and return the correct result.

    -Infix (Standard Notation)
        -The natural way arithmetic expressions are read, requiring parentheses and operator precedence.

        -Operators are placed between operands.

        -Example:
            Expression: 3 + 4 → Result: 7

    -Prefix (Polish Notation)
        -No need for parentheses; precedence is handled automatically.

        -Operators come before operands.

        -Example:
            Expression: + 3 4 → Result: 7

    -Postfix (Reverse Polish Notation)
        -No need for parentheses; precedence is handled automatically.

        -Operators come after operands.

        -Example:
            Expression: 3 4 + → Result: 7

-Joinline and Exitline;
    - A simple program that simulates how a line (queue) works, highlighting the FIFO (First In, First Out) principle.

    - Customers are added to a queue and served in the order they joined.

    -Example:
        Join line in the order → Bob, Juli, Mike, John
        Serving order: Bob will exit the line first, followed by Juli, then Mike, and finally John.

--Running/Installation
    -This project is primarily run through the Main and MainTest classes.

    -The Main class handles the various functions described above.

    -The MainTest class is used to unit test these functions and ensure they are working correctly.

Note:

-- Make sure JUnit testing is enabled in VSCode under the Testing tab.

-- This triggers a JAR file that allows the JUnit library to be used for testing.    
