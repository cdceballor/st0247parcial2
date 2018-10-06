package elefantes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author YisuCrist
 */
public class leerFichero {

    public static ArrayList<Elefante> getElefantesFromFile(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        ArrayList<Elefante> misElefantes = new ArrayList<>();
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        int contador = 1;
        //BufferedReader b = new BufferedReader(new FileReader(new File("elefantitos.txt")));
        while ((cadena = b.readLine()) != null) {
            String[] split = cadena.split(" ");
            misElefantes.add(
                    new Elefante(
                            Integer.parseInt(split[0]),
                            Integer.parseInt(split[1]),
                            contador));

            contador++;
        }
        b.close();
        
        return misElefantes;
    }

    public static void main(String[] args) throws IOException {
        
    }
}
