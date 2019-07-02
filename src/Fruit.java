import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Fruit implements Serializable{


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

    public Fruit input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter fruit name: ");
        setName(br.readLine());
        System.out.println("Enter fruit color: ");
        setColor(br.readLine());
        System.out.println("new fruit add");
        return new Fruit();
    }

    public void output() {
        System.out.println("new fruit add\n"+this);
    }

    public void Serialization(ArrayList arrayList) throws IOException {
        FileOutputStream fos = new FileOutputStream("fruits.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.writeObject(arrayList);
        encoder.close();
        fos.close();
    }

    public void Deserialization() {
        try (XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream("fruits.xml"))) {
            ArrayList<Fruit> arrayList = (ArrayList<Fruit>) xmlDecoder.readObject();
            System.out.printf(arrayList.toString());
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }


    @Override
    public String toString() {
        return "\nFruit name: " + getName() + "\tfruit color: " + getColor() + "\n";
    }



}