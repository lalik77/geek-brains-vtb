package lecture8.homework;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task1Test {

  @Test
  void mostRepeatedWordTest() {

    //Arrange
    String [] words = {"Alex",
        "Heroku",
        "Amazon",
        "Alex",
        "Ivan"};
    String [] names = {"Sam", "james", "Selena", "JAMes", "Joe", "sam", "JamES"};

    String[] countries = { "China", "Australia", "India", "USA", "USSR", "UK", "China",
        "France", "Poland", "Austria", "India", "USA", "Egypt", "China" };

    // Act
    final long maxCountWords = Task1.mostRepeatedWord(words);
    final long maxCountNames = Task1.mostRepeatedWord(names);
    final long maxCountCountries= Task1.mostRepeatedWord(countries);

    //Assert
    //System.out.println(maxCcountWords);
    //System.out.println(maxCountNames);
    //System.out.println(maxCountCountries);
    Assertions.assertEquals(2,maxCountWords);
    Assertions.assertEquals(0,maxCountNames);
    Assertions.assertEquals(3,maxCountCountries);



  }
}