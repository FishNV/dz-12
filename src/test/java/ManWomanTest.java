import org.example.Man;
import org.example.Woman;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ManWomanTest {

    private enum PersonType {
        MAN,
        WOMAN
    }

    @DataProvider
    public Object[][] isPersonRetiredData() {
        return new Object[][] {
                {PersonType.MAN, "Карл", "Карленко", 64, false},
                {PersonType.MAN, "Григорій", "Сковорода", 65, true},
                {PersonType.WOMAN, "Клара", "Кораленко", 59, false},
                {PersonType.WOMAN, "Леся", "Українка", 60, true}
        };
    }

    @DataProvider
    public Object[][] isReturnedToMaidenName() {
        return new Object[][] {
                {new Man("Карл", "Карленко", 64), new Woman("Клара", "Кораленко", 59), true, "Кораленко"},
                {new Man("Карл", "Карленко", 64), new Woman("Клара", "Кораленко", 59), false, "Кораленко"}
        };
    }

    @Test (dataProvider = "isPersonRetiredData")
    public void isRetired(PersonType type, String firstName, String lastName, int age, Boolean isRetired) {
        if (type == PersonType.MAN){
            Man man = new Man(firstName, lastName, age);
            Assert.assertEquals(man.isRetired(), isRetired);
        } else if (type == PersonType.WOMAN){
            Woman woman = new Woman(firstName, lastName, age);
            Assert.assertEquals(woman.isRetired(), isRetired);
        }
    }

    @Test (dataProvider = "isReturnedToMaidenName")
    public void isReturnedToMaidenName (Man man, Woman woman, Boolean isReturnedToMaidenName, String womanMaidenName) {
        man.registerPartnership(woman);
        Assert.assertEquals(man.getLastName(), woman.getLastName());
        woman.deregisterPartnership(isReturnedToMaidenName);
        if (isReturnedToMaidenName) {
            Assert.assertEquals(woman.getLastName(), womanMaidenName);
        } else {
            Assert.assertEquals(man.getLastName(), woman.getLastName());
        }

    }
}
