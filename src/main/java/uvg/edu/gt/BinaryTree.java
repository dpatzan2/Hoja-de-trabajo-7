package uvg.edu.gt;

/**
 * Clase que implementa un árbol binario de búsqueda (BST).
 * @param <E> Tipo de dato que se almacenará en el árbol y que debe ser comparable.
 */
public class BinaryTree<E extends Comparable<E>> {
    public Node<E> root;

    /**
     * Constructor de la clase BinaryTree.
     * Inicializa el árbol con un nodo raíz nulo.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Método para insertar un nuevo dato en el árbol.
     * @param data El dato a insertar en el árbol.
     */
    public void insert(E data) {
        root = insertRecursively(root, data);
    }

    /**
     * Método recursivo para insertar un nuevo dato en el árbol.
     * @param root El nodo raíz del subárbol actual.
     * @param data El dato a insertar.
     * @return El nodo raíz del subárbol actualizado con el nuevo dato.
     */
    private Node<E> insertRecursively(Node<E> root, E data) {
        if (root == null) {
            return new Node<E>(data);
        }

        if (data.compareTo(root.data) < 0) {
            root.left = insertRecursively(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRecursively(root.right, data);
        }

        return root;
    }

    /**
     * Método para realizar un recorrido en orden del árbol e imprimir sus elementos.
     * @param root El nodo raíz del subárbol a recorrer.
     */
    public void inOrderTraversal(Node<E> root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }
}
