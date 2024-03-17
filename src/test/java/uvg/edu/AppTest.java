package uvg.edu;

import junit.framework.TestCase;
import junit.framework.TestResult;
import org.junit.jupiter.api.Test;
import uvg.edu.gt.App;
import uvg.edu.gt.Association;
import uvg.edu.gt.BinaryTree;

public class AppTest extends TestCase {

    @Override
    protected TestResult createResult() {
        return super.createResult();
    }

    @Test
    public void testInsert() {
        BinaryTree<Association<String, String>> dictionary = new BinaryTree<>();

        // Insertar una asociación en el árbol
        Association<String, String> association = new Association<>("house", "casa");
        dictionary.insert(association);

        // Verificar que el árbol contiene la asociación insertada
        assertEquals("casa", App.searchDictionary(((BinaryTree<Association<String, String>>) dictionary).root, "house"));
    }

    @Test
    public void testSearchDictionary() {
        BinaryTree<Association<String, String>> dictionary = new BinaryTree<>();

        // Insertar algunas asociaciones en el árbol
        dictionary.insert(new Association<>("house", "casa"));
        dictionary.insert(new Association<>("dog", "perro"));
        dictionary.insert(new Association<>("cat", "gato"));

        // Buscar asociaciones existentes en el árbol
        assertEquals("casa", App.searchDictionary(dictionary.root, "house"));
        assertEquals("perro", App.searchDictionary(dictionary.root, "dog"));
        assertEquals("gato", App.searchDictionary(dictionary.root, "cat"));

        // Buscar una asociación inexistente en el árbol
        assertEquals(null, App.searchDictionary(dictionary.root, "car"));
    }

}