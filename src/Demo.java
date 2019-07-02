/*1) Утворити клас Фрукт, який містить:
- поля назва та колір,
- визначити конструктор з параметрами,
- методи input() та print(), для зчитування даних з консолі та виведення даних на консоль, а також перевантажити варіанти введення-виведення з файлу.
- властивості для полів,
- перевизначити метод toString().

2) Утворити похідний від нього клас Цитрус, який має:
- поле - вміст вітаміну С в грамах,
- конструктор з параметрами,
- властивість,
- перевизначені методи input() та print().

3) Утворити List фруктів і додати до нього 5 різних фруктів і цитрусів.
- Видрукувати дані про ті фрукти, колір яких є 'жовтий'.
- Посортувати список фруктів за назвою і результат вивести у файл
- Передбачити перехоплення виняткових ситуацій
- Сериалізувати-десериалізувати список у Xml форматі
- Написати юніт-тести на методи класів

*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
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

        citrus.output();
        fruit.output();

        System.out.println("------");
        //fruit.output();


        for (Fruit i : fruitsList) {

            System.out.println(i.toString());
        }

        fruit.Serialization(fruitsList);
        fruit.Deserialization();

        System.out.println("--------finde----------");

       // for(Fruit i:fruitsList)
       // System.out.println(getFruitsColor(fruitsList, "Yellow"));
        ArrayList<Fruit> listFruitsByColor = getFruitsByColor( fruitsList, "Yellow");
        for (Fruit f : listFruitsByColor) {
            System.out.println(f.toString());
        }


        System.out.println("--------sort by name----------");
       sortFruitByName(fruitsList);
        for (Fruit f : fruitsList) {
            System.out.println(f.toString());
        }

    }

    public static ArrayList<Fruit> getFruitsByColor(ArrayList<Fruit> fruits, String color) {

        ArrayList<Fruit> newFruitsList = new ArrayList<>();

        for (Fruit fruit : fruits) {
            if (fruit.getColor().equals(color)) {
                newFruitsList.add(fruit);
            }
        }
        return newFruitsList;
    }

    public  static ArrayList<Fruit> sortFruitByName(ArrayList<Fruit> fruits)
    {
        Collections.sort(fruits, new SortFruit());
        return fruits;
    }


}
