package uvg.edu.gt;

/**
 * Clase que representa una asociación entre una clave y un valor.
 * @param <K> Tipo de la clave.
 * @param <V> Tipo del valor.
 */
public class Association<K extends Comparable<K>, V> implements Comparable<Association<K, V>> {
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

    /**
     * Método para comparar esta asociación con otra basada en las claves.
     * @param other La otra asociación a comparar.
     * @return Un valor negativo si esta asociación es menor, un valor positivo si es mayor, o cero si son iguales.
     */
    @Override
    public int compareTo(Association<K, V> other) {
        if (this.key == null && other.key == null) {
            return 0;
        } else if (this.key == null) {
            return -1;
        } else if (other.key == null) {
            return 1;
        } else {
            return this.key.compareTo(other.getKey());
        }
    }
}
