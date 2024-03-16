package uvg.edu.gt;

/**
 * Clase que representa un nodo de un árbol binario.
 * @param <E> Tipo de dato almacenado en el nodo.
 */
public class Node<E extends Comparable<E>> {
    E data;
    Node<E> left;
    Node<E> right;

    /**
     * Constructor de la clase Node.
     * @param data El dato a almacenar en el nodo.
     */
    public Node(E data) {
        this.data = data;
        left = null;
        right = null;
    }
}
