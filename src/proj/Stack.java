package src.proj;

public class Stack<T> {
   // A reference to the top of the stack making it generic for reusability
   // and flexibility
   private Node<T> top;
   private int size = 0;

   public Stack() {
       this.top = null;
   }

   //Method to push an element onto the stack
   // It creates a new node with the given data and sets it as the new top
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }


    //Method to pop an element from the stack which is the top element
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }


    //Return the top element of the stack without removing it
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }


    //This display the current contents of the stack
    public void display() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }


        Node<T> current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    //Method to clear the stack by setting the top to null
    public void clear() {
        top = null;
    }


    //This method returns the size of the stack
    public int size() {
        return size;
    }


    //Check to see if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

}

