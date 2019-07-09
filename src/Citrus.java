import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.InputMismatchException;

public class Citrus extends Fruit implements Serializable {
    public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
            //super.input();
            System.out.println("Enter citrus name: ");
            setName(br.readLine().toLowerCase());
            if (getName() != null && !getName().isEmpty())
                System.out.println("name add");
            else throw new IOException("string is empty");
            System.out.println("Enter citrus color: ");
            setColor(br.readLine().toLowerCase());
            if (getColor() != null && !getColor().isEmpty())
                System.out.println("color add");
            else throw new IOException("string is empty");
            do {
                System.out.println("Enter vitamin C for citrus >0: ");
                setVitaminC(Integer.parseInt((br.readLine())));
            } while (getVitaminC() <= 0);

            System.out.println("new citrus add");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        } catch (InputMismatchException ex) {
            System.out.println("enter only number" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }
    }


    @Override
    public void output() {
        System.out.print(this);
    }

    @Override
    public String toString() {
        return "\nFruit name: " + getName() + "\tfruit color: " + getColor() + "\tvitamin C: " + getVitaminC() + " Gr";
    }

}

