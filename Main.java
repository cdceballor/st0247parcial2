import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	
	static int result;
	public static void main(String[]args) throws Exception {
		List<Tortuga> list;
	 
// Donde se lee la entrada de las tortugas
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       list = new ArrayList<Tortuga>();
    String strLine;
    while ((strLine = br.readLine()) != null) {
        String[] str = strLine.split(" ");
        int p = Integer.parseInt(str[0]);
        int f = Integer.parseInt(str[1]) - p;
        list.add(new Tortuga(p, f));
    }
    // Aqui se encarga de Comparar si se pueden o no se pueden alinear las tortugas, y cuantas se pueden alinear
	Collections.sort(list);
    int[][] stack = new int[list.size()][list.size() + 1];
    for (int i = 0; i < list.size(); i++)
        for (int j = 0; j <= list.size(); j++)
            stack[i][j] = (j == 0 ? 0 : Integer.MAX_VALUE);
    stack[0][1] = list.get(0).peso;
    for (int i = 1; i < list.size(); i++) {
        for (int j = 1; j <= i + 1; j++) {
            stack[i][j] = Math.min(stack[i][j], stack[i - 1][j]);
            if (list.get(i).fuerza > stack[i - 1][j - 1]) {
                stack[i][j] = Math.min(stack[i][j],
                        stack[i - 1][j - 1] + list.get(i).peso);
            }
        }
    }
    for (int p = list.size(); p >= 0; p--) {
        if (stack[list.size() - 1][p] != Integer.MAX_VALUE) {
            result = p;
    		break;
        }
    }
    //Imprime la cantidad de tortugas que se pueden apilar
    System.out.println(result);
   

 }
	
	//Clase encargada de almacenar los datos de las tortugas
public static class Tortuga implements Comparable<Tortuga>{
	 public int peso, fuerza;
	 
	 
	 public Tortuga (int p, int f) {
		 this.peso = p;
		 this.fuerza = f;
	 }
	 

	 public int compareTo(Tortuga o) {
		 return (peso!=o.fuerza)? fuerza-o.fuerza : peso-o.peso;
	}



	}
}


