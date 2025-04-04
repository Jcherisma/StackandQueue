class Node<T> {
    //Node class to represent each element 
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
