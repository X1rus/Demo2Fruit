import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Fruit implements Serializable {


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
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter fruit name: ");
            setName(br.readLine().toLowerCase());
            System.out.println("Enter fruit color: ");
            setColor(br.readLine().toLowerCase());
            System.out.println("new fruit add");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        //return new Fruit();
    }

    public void output() {
        System.out.print(this);
    }

    public void serialization(ArrayList<Fruit> arrayList) {
        try {
            FileOutputStream fos = new FileOutputStream("fruits.xml");
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(arrayList);
            encoder.close();
            fos.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deserialization() {
        try (XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream("fruits.xml"))) {
            ArrayList<Fruit> arrayList = (ArrayList<Fruit>) xmlDecoder.readObject();
            System.out.printf(arrayList.toString());
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }


    }


    @Override
    public String toString() {
        return "\nFruit name: " + getName() + "\tfruit color: " + getColor();
    }

    public void serialization(ArrayList<Fruit> arrayList, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(arrayList);
            encoder.close();
            fos.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deserialization(String path) {
        try (XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(path))) {
            ArrayList<Fruit> arrayList = (ArrayList<Fruit>) xmlDecoder.readObject();
            System.out.printf(arrayList.toString());
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }
}



