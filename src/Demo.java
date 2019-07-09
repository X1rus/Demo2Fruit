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

class Demo {
    public static void main(String[] args) {
        ArrayList<Fruit> fruitsList = new ArrayList<>();
        Fruit fruit = new Fruit();
        Fruit citrus = new Citrus();

        fruitsList.add(new Fruit("apple", "green"));
        fruitsList.add(new Fruit("pineapple", "yellow"));
        fruitsList.add(new Fruit("pear", "orange"));
        fruitsList.add(new Fruit("banan", "yellow"));
        fruitsList.add(new Fruit("mango", "red"));
        fruitsList.add(new Citrus("orange", "yellow",12));
        fruitsList.add(new Citrus("grapefruit", "red",19));
        fruitsList.add(new Citrus("lemon", "yellow",30));


        System.out.println("\n----------Input fruit-------------");
        fruit.input();
        citrus.input();

        System.out.println("\n----------Output fruit -------------");
        citrus.output();
        fruit.output();

        System.out.println("\n\n----------Add to colections-------------");
        try {
            fruitsList.add(fruit);
            fruitsList.add(citrus);
        }catch (NullPointerException ex)
        {
            System.out.println(ex.getStackTrace());
        }
        System.out.println("true");

        System.out.println("\n\n------Print fruit list------");
        //fruit.output();


        for (Fruit i : fruitsList) {

            System.out.print(i.toString());
        }

        System.out.println("\n\n------Serialazation/Deserialization fruit list------");
        Functional.serialization(fruitsList);
        Functional.deserialization();

        System.out.println("\n\n--------finde by color----------");

        ArrayList<Fruit> listFruitsByColor =Functional.getFruitsByColor(fruitsList, "Yellow");
        for (Fruit f : listFruitsByColor) {
            System.out.print(f.toString());
        }


        System.out.println("\n\n--------sort by name----------");
        Functional.sortFruitByName(fruitsList);
        for (Fruit f : fruitsList) {
            System.out.print(f.toString());
        }
        System.out.println("\n\n------Serialazation/Deserialization sorted list------");
        Functional.serialization(fruitsList,"sortedFruit.xml");
        Functional.deserialization("sortedFruit.xml");
    }
}

