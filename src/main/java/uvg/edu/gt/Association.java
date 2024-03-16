package uvg.edu.gt;

/**
 * Clase que representa una asociación entre una clave y un valor.
 * @param <K> Tipo de la clave.
 * @param <V> Tipo del valor.
 */
public class Association<K, V> {
    private K key;
    private V value;


    /**
     * Constructor de la clase Association.
     * @param key La clave de la asociación.
     * @param value El valor asociado a la clave.
     */
    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Método para obtener la clave de la asociación.
     * @return La clave de la asociación.
     */
    public K getKey() {
        return key;
    }

    /**
     * Método para obtener el valor asociado a la clave.
     * @return El valor asociado a la clave.
     */
    public V getValue() {
        return value;
    }
}
