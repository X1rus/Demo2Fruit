import org.testng.Assert;
import org.testng.annotations.Test;
import java.beans.XMLDecoder;
import java.io.*;
import java.util.ArrayList;

public class TestFruit {


    @Test
    public void SetAndGetTest() {
        //Arrange
        Fruit expected = new Fruit();
        Fruit actual = new Fruit("fruit", "color");

        //Act
        expected.setName("fruit");
        expected.setColor("color");
        //Assert
        Assert.assertEquals(actual.getName(), expected.getName());
        Assert.assertEquals(actual.getColor(), expected.getColor());
    }

    @Test
    public void serializationTest() throws FileNotFoundException {
        //Arrange
        ArrayList<Integer> expectedFruitsList = new ArrayList<>();
        ArrayList<Integer> actualFruitsList = new ArrayList<>();
        expectedFruitsList.add(1);

        //Act
        Functional.serialization(expectedFruitsList, "test.xml");

        XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream("test.xml"));
        actualFruitsList = (ArrayList<Integer>) xmlDecoder.readObject();

        //Assert
        Assert.assertEquals(expectedFruitsList, actualFruitsList);
    }

    @Test
    public void getFruitsByColorTest() {
        //Arrange
        ArrayList<Fruit> testList = new ArrayList<>();
        ArrayList<Fruit> actual = new ArrayList<>();
        ArrayList<Fruit> expected;
        ArrayList<String> expectedColor = new ArrayList<>();
        ArrayList<String> actualColor = new ArrayList<>();

        testList.add(new Fruit("apple", "green"));
        testList.add(new Fruit("pineapple", "yellow"));
        testList.add(new Fruit("pear", "orange"));
        testList.add(new Fruit("banan", "yellow"));
        testList.add(new Fruit("pear", "orange"));

        actual.add(new Fruit("pineapple", "yellow"));
        actual.add(new Fruit("banan", "yellow"));
        //Act
        expected = Functional.getFruitsByColor(testList, "yellow");
        for (Fruit f : expected) {
            expectedColor.add(f.getColor());
        }
        for (Fruit f : actual) {
            actualColor.add(f.getColor());
        }
        //Assert
        Assert.assertEquals(expectedColor,actualColor);
    }

    @Test
    public void sortFruitByNameTest() {
        ArrayList<String> expectedName = new ArrayList<>();
        ArrayList<String> actualName = new ArrayList<>();

        ArrayList<Fruit> fruits = new ArrayList<>();

        fruits.add(new Fruit("apple", "green"));
        fruits.add(new Fruit("mango", "red"));
        fruits.add(new Fruit("banan", "yellow"));


        ArrayList<Fruit> expected = new ArrayList<>();
        expected.add(new Fruit("apple", "green"));
        expected.add(new Fruit("banan", "yellow"));
        expected.add(new Fruit("mango", "red"));


        //Actual
        ArrayList<Fruit> actual = Functional.sortFruitByName(expected);

        for (Fruit f : expected) {
            expectedName.add(f.getName());
        }
        for (Fruit f : actual) {
            actualName.add(f.getName());
        }
        //Assert
        Assert.assertEquals(expectedName, actualName);
    }
}
