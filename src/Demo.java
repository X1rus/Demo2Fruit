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

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Demo {
    public static void main(String[] args) throws IOException {
        ArrayList<Fruit> fruitsList = new ArrayList<>();
        Fruit fruit = new Fruit();
        Fruit citrus = new Citrus();

        fruitsList.add(new Fruit("Apple", "Green"));
        fruitsList.add(new Fruit("Pineapple", "Yellow"));
        fruitsList.add(new Fruit("pear", "Orange"));
        fruitsList.add(new Fruit("Banan", "Yellow"));
        fruitsList.add(new Fruit("pear", "Orange"));

        fruit.input();
        citrus.input();

        fruitsList.add(fruit);//?
        fruitsList.add(citrus);


        //citrus.input(fruitsList);

       //System.out.println(citrus.output(citrus));
        //System.out.println(fruit.output(fruit));

        System.out.println("------");
        //fruit.output();


        for (Fruit i : fruitsList) {

            System.out.println(i.toString());
        }

       // fruit.input(fruitsList);
       // fruit.output();

        System.out.println("--------finde----------");

       // for(Fruit i:fruitsList)
       // System.out.println(getFruitsColor(fruitsList, "Yellow"));
        ArrayList<Fruit> listFruitsByColor = getFruitsColor( fruitsList, "Yellow");
        for (Fruit f : listFruitsByColor) {
            System.out.println(f.toString());
        }

    }

    public static ArrayList<Fruit> getFruitsColor(ArrayList<Fruit> fruits, String color) {

        ArrayList<Fruit> newFruitsList = new ArrayList<>();

        for (Fruit fruit : fruits) {
            if (fruit.getColor().equals(color)) {
                newFruitsList.add(fruit);
            }
        }
        return newFruitsList;
    }


}
