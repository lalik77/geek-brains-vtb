package lecture5.homework.task2;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TelephoneRepertoryTest {

  @Test
  public void addTelephoneNumberSuccessTest() {

    TelephoneRepertory telephoneRepertory = new TelephoneRepertory();

    final boolean isAddSuccess1 = telephoneRepertory
        .addTelephoneNumber("Alex", "+12309555858");
    final boolean isAddSuccess2 = telephoneRepertory
        .addTelephoneNumber("Alex", "+13246632567");
    telephoneRepertory.addTelephoneNumber("Ivanov", "+21311411541");
    telephoneRepertory.addTelephoneNumber("Petrov", "+54671315161");
    telephoneRepertory.addTelephoneNumber("Ivanov", "+23896448997");

    final boolean isAddSuccess3 = telephoneRepertory
        .addTelephoneNumber(null,null);

    final List alex = telephoneRepertory.getTelephoneNumberByName("Alex");
    final List ivanov = telephoneRepertory.getTelephoneNumberByName("Ivanov");
    final List petrov = telephoneRepertory.getTelephoneNumberByName("Petrov");
    final List notExisted = telephoneRepertory.getTelephoneNumberByName("asd");

    Assertions.assertTrue(isAddSuccess1);
    Assertions.assertTrue(isAddSuccess2);
    Assertions.assertFalse(isAddSuccess3);
    Assertions.assertEquals(2,alex.size());
    Assertions.assertEquals(1,petrov.size());
    Assertions.assertEquals(0,notExisted.size());

  }
}