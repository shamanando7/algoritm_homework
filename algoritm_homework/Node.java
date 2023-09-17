package algoritm_homework;

public class Node<T extends Comparable<T>> {
    public T value;
    public Node<T> left;
    public Node<T> right;
    public boolean isRed;

    public Node(T value) {
        this.value = value;
        this.isRed = true;
    }
}
