import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class TestFruit {


    @Test
    public void inputTest() {
        //Arrange
        Fruit actual = new Fruit();
        Fruit expected = new Fruit("fruit", "color");
        //Act
        actual.setName("fruit");
        actual.setColor("color");
        //Assert
        Assert.assertEquals(actual.getName(),expected.getName());
        Assert.assertEquals(actual.getColor(),expected.getColor());
    }

    @Test
    public void otputTest()
    {
        //Arrange
        Fruit expected = new Fruit("fruit", "color");
        //Act
         expected.output();
        //Assert
        Assert.assertTrue(true,expected.getName());
        Assert.assertTrue(true,expected.getColor());


    }


    @Test
    public void serializationTest()
    {
        //Arrange
        ArrayList<Integer> expectedFruitsList = new ArrayList<>();
        ArrayList<Integer> actualFruitsList = new ArrayList<>();
        expectedFruitsList .add(1);

        //Act
        try {
            FileOutputStream fos = new FileOutputStream("test.xml");
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(expectedFruitsList);
            encoder.close();
            fos.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream("test.xml"));
            actualFruitsList = (ArrayList<Integer>) xmlDecoder.readObject();
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        //Assert
        Assert.assertEquals(expectedFruitsList,actualFruitsList);

    }

    @Test
    public void getFruitsByColorTest()
    {
        //Arrange
        ArrayList<Fruit> newFruitsList = new ArrayList<>();
        ArrayList<Fruit> fruitsList = new ArrayList<>();
        String color = "yellow";
        fruitsList.add(new Fruit("Pineapple", "yellow"));

        String expected=null;
        String actual = null;

        //Act

        newFruitsList=Demo.getFruitsByColor(fruitsList,color);

        for (Fruit i:newFruitsList)
            expected=i.getColor();
        for (Fruit i:fruitsList)
            actual=i.getColor();
        //Assert

        Assert.assertEquals(expected,actual);
    }

    @Test
    public  void sortFruitByNameTest()
    {
        //Arrange
        ArrayList<Fruit> fruitsList = new ArrayList<>();
        fruitsList.add(new Fruit("Apple", "Green"));
        fruitsList.add(new Fruit("Pineapple", "yellow"));
        fruitsList.add(new Fruit("pear", "Orange"));
        fruitsList.add(new Fruit("Banan", "yellow"));
        fruitsList.add(new Fruit("pear", "Orange"));

        //Act
         ArrayList<Fruit> actual= Demo.sortFruitByName(fruitsList);

        //Assert
        Assert.assertEquals(actual,fruitsList);

    }

}
