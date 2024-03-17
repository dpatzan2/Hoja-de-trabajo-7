package uvg.edu.gt;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) {

        File dictionaryFile = new File("src/main/java/uvg/edu/gt/diccionario.txt");
        File textFile = new File("src/main/java/uvg/edu/gt/texto.txt");

        BinaryTree<Association<String, String>> dictionary = new BinaryTree<>();

        // Lectura del archivo de diccionario
        try {
            Scanner scanner = new Scanner(dictionaryFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.replace("(", "");
                line = line.replace(")", "");
                String[] parts = line.split(", ");
                Association<String, String> association = new Association<>(parts[0], parts[1]);
                dictionary.insert(association);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: archivo diccionario.txt no encontrado");
            e.printStackTrace();
        }

        // Imprimir el diccionario ordenado en inglés
        System.out.println("Diccionario en orden inglés:");
        dictionary.inOrderTraversal(dictionary.root);
        System.out.println();

        // Procesamiento del archivo de texto
        try {
            Scanner scanner = new Scanner(textFile);
            int count = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.print(count + ". ");
                print(line, dictionary);
                count++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: archivo texto.txt no encontrado");
            e.printStackTrace();
        }
    }

    // Método para buscar una palabra en el diccionario
    public static String searchDictionary(Node<Association<String, String>> root, String word) {
        if (root == null) {
            return null;
        }

        if (word.compareTo(root.data.getKey().toLowerCase()) < 0) {
            return searchDictionary(root.left, word);
        } else if (word.compareTo(root.data.getKey().toLowerCase()) > 0) {
            return searchDictionary(root.right, word);
        } else {
            return root.data.getValue();
        }
    }

    // Método para imprimir una línea del archivo de texto traducida
    public static void print(String line, BinaryTree<Association<String, String>> dictionary) {
        Scanner scanner = new Scanner(line);
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            String translation = searchDictionary(dictionary.root, word);
            if (translation != null) {
                System.out.print(translation + " ");
            } else {
                System.out.print("*" + word + "* ");
            }
        }
        scanner.close();
        System.out.println(); // Agregar un salto de línea después de imprimir una línea traducida
    }
}
