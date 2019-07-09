import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Functional {
    //-----finde by color-----
    public static ArrayList<Fruit> getFruitsByColor(ArrayList<Fruit> fruits, String color) {


        ArrayList<Fruit> newFruitsList = new ArrayList<>();

        for (Fruit fruit : fruits) {
            if (fruit.getColor().equals(color.toLowerCase())) {
                newFruitsList.add(fruit);
            }
        }
        return newFruitsList;
    }

    // -----Sort by Name-----
    public static ArrayList<Fruit> sortFruitByName(ArrayList<Fruit> fruits) {
        Collections.sort(fruits, new SortFruit());
        return fruits;
    }

    public static void serialization(ArrayList<Fruit> arrayList) {
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

    public static void deserialization() {
        try (XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream("fruits.xml"))) {
            ArrayList<Fruit> arrayList = (ArrayList<Fruit>) xmlDecoder.readObject();
            System.out.printf(arrayList.toString());
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }


    public static void serialization(ArrayList arrayList, String path) {
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

    public static void deserialization(String path) {
        try (XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(path))) {
            ArrayList<Fruit> arrayList = (ArrayList<Fruit>) xmlDecoder.readObject();
            System.out.printf(arrayList.toString());
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }
}
