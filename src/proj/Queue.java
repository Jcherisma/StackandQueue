package src.proj;

public class Queue<T> {
    // A reference to the front and rear of the queue making it generic for reusability
    // and flexibility
    private Node<T> front;
    private Node<T> rear;
    private int size = 0;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    //Method to add an element to the end of the queue
    public void enqueue(T data)
    { 
        Node<T> newNode = new Node<>(data);

        if(rear == null) {
            front = rear = newNode;
        } else  {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    //Method to remove an element from the front of the queue
    public T dequeue() {
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        T data = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    //Return the front element of the queue without removing it
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty"); 
        } 

        return front.data;
    }

    //Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    //Return the size of the queue
    public int size() {
        return size;
    }

    //This display the current contents of the queue
    public void display() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        Node<T> current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
