
import java.io.*;

public class Fruit implements Serializable {
    public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private String Name;
    private String Color;

    public Fruit(String name, String color) {
        this.Name = name;
        this.Color = color;
    }

    public Fruit() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public void input() {
        try {

            System.out.println("Enter fruit name: ");
            setName(br.readLine().toLowerCase());
            if (getName() != null && !getName().isEmpty())
                System.out.println("name add");
            else throw new IOException("string is empty");
            System.out.println("Enter fruit color: ");
            setColor(br.readLine().toLowerCase());
            if (getColor() != null && !getColor().isEmpty())
                System.out.println("color add");
            else throw new IOException("string is empty");
            System.out.println("new fruit add");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

            //return new Fruit();
        }

    }

    public void output() {
        System.out.print(this);
    }

    @Override
    public String toString() {
        return "\nFruit name: " + getName() + "\tfruit color: " + getColor();
    }

}



