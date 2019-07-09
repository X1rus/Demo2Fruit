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

