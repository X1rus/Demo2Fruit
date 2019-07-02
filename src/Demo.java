/*1) �������� ���� �����, ���� ������:
- ���� ����� �� ����,
- ��������� ����������� � �����������,
- ������ input() �� print(), ��� ���������� ����� � ������ �� ��������� ����� �� �������, � ����� ������������� ������� ��������-��������� � �����.
- ���������� ��� ����,
- ������������� ����� toString().

2) �������� �������� �� ����� ���� ������, ���� ��:
- ���� - ���� ������ � � ������,
- ����������� � �����������,
- ����������,
- ������������ ������ input() �� print().

3) �������� List ������ � ������ �� ����� 5 ����� ������ � �������.
- ����������� ��� ��� � ������, ���� ���� � '������'.
- ����������� ������ ������ �� ������ � ��������� ������� � ����
- ����������� ������������ ���������� ��������
- ������������-�������������� ������ � Xml ������
- �������� ���-����� �� ������ �����

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

class Demo {
    public static void main(String[] args) {
        ArrayList<Fruit> fruitsList = new ArrayList<>();
        Fruit fruit = new Fruit();
        Fruit citrus = new Citrus();

    fruitsList.add(new Fruit("Apple", "Green"));
    fruitsList.add(new Fruit("Pineapple", "yellow"));
    fruitsList.add(new Fruit("pear", "Orange"));
    fruitsList.add(new Fruit("Banan", "yellow"));
    fruitsList.add(new Fruit("pear", "Orange"));


        System.out.println("\n----------Input fruit-------------");
        fruit.input();
        citrus.input();

        System.out.println("\n----------Output fruit -------------");
        citrus.output();
        fruit.output();

        System.out.println("\n\n----------Add to colections-------------");
        fruitsList.add(fruit);//?
        fruitsList.add(citrus);

        System.out.println("\n\n------Print fruit list------");
        //fruit.output();


        for (Fruit i : fruitsList) {

            System.out.print(i.toString());
        }

        System.out.println("\n\n------Serialazation/Deserialization fruit list------");
        fruit.serialization(fruitsList);
        fruit.deserialization();

        System.out.println("\n\n--------finde by color----------");

        ArrayList<Fruit> listFruitsByColor = getFruitsByColor(fruitsList, "Yellow");
        for (Fruit f : listFruitsByColor) {
            System.out.print(f.toString());
        }


        System.out.println("\n\n--------sort by name----------");
        sortFruitByName(fruitsList);
        for (Fruit f : fruitsList) {
            System.out.print(f.toString());
        }
        System.out.println("\n\n------Serialazation/Deserialization sorted list------");
        fruit.serialization(fruitsList,"sortedFruit.xml");
        fruit.deserialization("sortedFruit.xml");


    }

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


}
