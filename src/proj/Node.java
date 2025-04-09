package src.proj;

class Node<T> {
    // A generic node class to hold data and a reference to the next node
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}
