
package elefantes;

/**
 * This entity holds the data for an elephant, including the original position it came with
 * @author YisuCrist
 */
public class Elefante {
    int weight;
    int iq;
    int position;

    public Elefante(int weight, int iq, int position) {
        this.weight = weight;
        this.iq = iq;
        this.position = position;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    
    
}
