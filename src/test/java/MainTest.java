import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MainTest {

    Person person = new Person("Василий", "Пупкин", 16, Sex.MAN, Education.SECONDARY);
    Main main = new Main();

    @BeforeAll
    static void StartMessage() {
        System.out.println("Тестирование успешно запущено");
    }

    @AfterEach
    void EachMessage() {
        System.out.println("Тест завершен без ошибок");
    }

    @Test
    void PersonSexTest() {
        Assert.assertNotNull("Пол заполнен неверно", person.getAge());
    }

    @Test
    void PersonAgecheck() {
        Assert.assertNotSame("Возраст указан неверно", person.getAge(), person.age);
    }

    @Test
    void ListDifCheck() {
        int ageFine = 16;
        Assertions.assertEquals(ageFine, person.age, "Возраст не соответствует");
    }

    @Test
    void NameCheck() {
        Assertions.assertNotNull(person.getName(), "Имя отсутствует!");
    }

    @Test
    void NameandFamcheck() {
        Assertions.assertNotSame(person.getName(), person.getFamily(), "Имя и фамилия одинаковы!");
    }

}