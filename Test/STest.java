import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;



public class STest {

    @Test
    public void testAll() throws Exception{
        List<Person> testList = Arrays.asList(new Person("Ricky", 18), new Person("Lola", 21),
                new Person("Jack", 40), new Person("Harry", 16));

        Map<String,Person> sorted = Streams.of(testList)
                .filter(p -> p.getAge() > 20)
                .transform(p -> new Person(p.getName(), p.getAge() + 20))
                .toMap(Person::getName, p -> p);

        assertEquals(2, sorted.size());
        assertEquals(41, sorted.get("Lola").getAge());
        assertEquals(60, sorted.get("Jack").getAge());
    }

}