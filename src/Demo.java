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
