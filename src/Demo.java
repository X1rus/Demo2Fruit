import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

class Demo {
    public static void main(String[] args) throws IOException {
        ArrayList<Fruit> fruitsList = new ArrayList<>();
        Fruit fruit = new Fruit();
        Fruit citrus = new Citrus();

        fruitsList.add(new Fruit("Apple", "Green"));
        fruitsList.add(new Fruit("Pineapple", "Yellow"));
        fruitsList.add(new Fruit("pear", "Orange"));

        fruit.input();
        citrus.input();

        fruitsList.add(fruit);//?
        fruitsList.add(citrus);


        //citrus.input(fruitsList);

        System.out.println(citrus.output(citrus));
        System.out.println(fruit.output(fruit));

        System.out.println("------");
        fruit.output();


        for (Fruit i : fruitsList) {

            System.out.println(i.toString());

        }

        fruit.input(fruitsList);
        fruit.output();
    }
}
