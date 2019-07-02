import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.InputMismatchException;

public class Citrus extends Fruit implements Serializable {

    private int vitaminC;

    public Citrus() {

    }

    public Citrus(String name, String color, int vitaminC) {
        super(name, color);
        this.vitaminC = vitaminC;
    }


    public int getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(int vitaminC) {
        this.vitaminC = vitaminC;
    }

    @Override
    public void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //super.input();
            System.out.println("Enter fruit name: ");
            setName(br.readLine());
            System.out.println("Enter fruit color: ");
            setColor(br.readLine());
            System.out.println("Enter vitamin C for citrus: ");
            setVitaminC(Integer.parseInt((br.readLine())));

            System.out.println("new citrus add");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (InputMismatchException ex) {
            System.out.println("enter only number"+ex.getMessage());
        }
    }

    @Override
    public void output() {
        System.out.print( this);
    }

    @Override
    public String toString() {
        return "\nFruit name: " + getName() + "\tfruit color: " + getColor() + "\tvitamin C: " + getVitaminC() + " Gr";
    }

}

