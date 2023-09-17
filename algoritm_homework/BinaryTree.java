package algoritm_homework;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public boolean contains(T value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node<T> current, T value) {
        if (current == null) {
            return false;
        }
        
        int compareResult = value.compareTo(current.value);
        
        if (compareResult < 0) {
            return containsRecursive(current.left, value);
        } else if (compareResult > 0) {
            return containsRecursive(current.right, value);
        } else {
            return true;
        }
    }

    public void add(T value) {
        root = insert(root, value);
        root.isRed = false; // Корень всегда черный
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }

        int compareResult = value.compareTo(node.value);

        if (compareResult < 0) {
            node.left = insert(node.left, value);
        } else if (compareResult > 0) {
            node.right = insert(node.right, value);
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    private boolean isRed(Node<T> node) {
        if (node == null) {
            return false;
        }
        return node.isRed;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> newNode = node.right;
        node.right = newNode.left;
        newNode.left = node;
        newNode.isRed = node.isRed;
        node.isRed = true;
        return newNode;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> newNode = node.left;
        node.left = newNode.right;
        newNode.right = node;
        newNode.isRed = node.isRed;
        node.isRed = true;
        return newNode;
    }

    private void flipColors(Node<T> node) {
        node.isRed = true;
        node.left.isRed = false;
        node.right.isRed = false;
    }

    private class Node<T extends Comparable<T>> {
        public T value;
        public Node<T> left;
        public Node<T> right;
        public boolean isRed;

        public Node(T value) {
            this.value = value;
            this.isRed = true;
        }
    }
}
