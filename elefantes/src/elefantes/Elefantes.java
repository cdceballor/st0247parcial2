package elefantes;

import static elefantes.leerFichero.getElefantesFromFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author YisuCrist
 */
public class Elefantes {

    void orderElephants() throws IOException {
        ArrayList<Elefante> elefantesFromFile = getElefantesFromFile("/D:/java/st0247parcial2/elefantes/src/elefantes/elefantitos_1.txt");
        //Traer los elefantes del fichero, ordenarlos con sorted (Timsort) y compararles su peso y guardarlos de nuevo en una lista
        List<Elefante> orderedElephants = elefantesFromFile.stream().sorted(Comparator.comparing(Elefante::getWeight)).collect(Collectors.toList());
        ArrayList<Elefante> result = new ArrayList();
        ArrayList<Elefante> temp = new ArrayList();
        for (int i = 0; i < orderedElephants.size() - 1; i++) {
            Elefante a = orderedElephants.get(i);
            temp.add(a);
            
            for (int j = i+1; j < orderedElephants.size(); j++) {
                Elefante b = orderedElephants.get(j);
                if (a.weight < b.weight && a.iq > b.iq){
                    temp.add(b);
                    a = b;
                }
            }
            
            if (result.size() < temp.size()){
                result = temp;
            }
            temp = new ArrayList<>();
        }
        
        //Print longitud elefantes
        System.out.println(result.size());
        // imprimir posicion elefantes
        for (Elefante elefantito : result) {
            System.out.println(elefantito.getPosition());
        }
        
    }

    public static void main(String[] args) {
        try {
            Elefantes yosito = new Elefantes();
            yosito.orderElephants();
        } catch (IOException ex) {
            Logger.getLogger(Elefantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
