package puj.api.tool.toolapi.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CityTests {

    @Test
    public void testNoArgsConstructor() {
        // Arrange
        City city = new City();

        // Assert
        Assertions.assertNotNull(city);
    }

    @Test
    public void testAllArgsConstructor() {
        // Arrange
        Integer cityId = 1;
        String name = "City 1";
        List<Tool> tools = new ArrayList<>();

        // Act
        City city = new City(cityId, name, tools);

        // Assert
        Assertions.assertEquals(cityId, city.getId());
        Assertions.assertEquals(name, city.getName());
        Assertions.assertEquals(tools, city.getTools());
    }

    @Test
    public void testGetterSetterId() {
        // Arrange
        City city = new City();
        Integer cityId = 1;

        // Act
        city.setId(cityId);
        Integer retrievedCityId = city.getId();

        // Assert
        Assertions.assertEquals(cityId, retrievedCityId);
    }

    @Test
    public void testGetterSetterName() {
        // Arrange
        City city = new City();
        String name = "City 1";

        // Act
        city.setName(name);
        String retrievedName = city.getName();

        // Assert
        Assertions.assertEquals(name, retrievedName);
    }

    @Test
    public void testGetterSetterTools() {
        // Arrange
        City city = new City();
        List<Tool> tools = new ArrayList<>();

        // Act
        city.setTools(tools);
        List<Tool> retrievedTools = city.getTools();

        // Assert
        Assertions.assertEquals(tools, retrievedTools);
    }
    @Test
    public void testHashCode() {
        // Arrange
        City city1 = new City(1, "City 1", new ArrayList<>());
        City city2 = new City(1, "City 1", new ArrayList<>());
        City city3 = new City(2, "City 2", new ArrayList<>());

        // Act
        int hashCode1 = city1.hashCode();
        int hashCode2 = city2.hashCode();
        int hashCode3 = city3.hashCode();

        // Assert
        Assertions.assertEquals(hashCode1, hashCode2);
        Assertions.assertNotEquals(hashCode1, hashCode3);
    }

    @Test
    public void testEquals() {
        // Arrange
        City city1 = new City(1, "City 1", new ArrayList<>());
        City city2 = new City(1, "City 1", new ArrayList<>());
        City city3 = new City(2, "City 2", new ArrayList<>());
        City city4 = null;
        String otherObject = "Not a City object";

        // Act & Assert
        Assertions.assertTrue(city1.equals(city1)); // Reflexive
        Assertions.assertTrue(city1.equals(city2) && city2.equals(city1)); // Symmetric
        Assertions.assertFalse(city1.equals(city2) && city2.equals(city3) && city1.equals(city3)); // Transitive
        Assertions.assertFalse(city1.equals(city4)); // Not equal to null
        Assertions.assertFalse(city1.equals(otherObject)); // Not equal to different type
    }

    @Test
    public void testEquals_SameObject_ReturnsTrue() {
        // Arrange
        City city = new City(1, "City", null);

        // Act & Assert
        Assertions.assertEquals(city, city);
    }

    @Test
    public void testEquals_NullObject_ReturnsFalse() {
        // Arrange
        City city = new City(1, "City", null);

        // Act & Assert
        Assertions.assertNotEquals(city, null);
    }

    @Test
    public void testEquals_DifferentClass_ReturnsFalse() {
        // Arrange
        City city = new City(1, "City", null);
        String otherObject = "Not a City object";

        // Act & Assert
        Assertions.assertNotEquals(city, otherObject);
    }

    @Test
    public void testEquals_SameFields_ReturnsTrue() {
        // Arrange
        City city1 = new City(1, "City", null);
        City city2 = new City(1, "City", null);

        // Act & Assert
        Assertions.assertEquals(city1, city2);
    }

    @Test
    public void testEquals_DifferentId_ReturnsFalse() {
        // Arrange
        City city1 = new City(1, "City", null);
        City city2 = new City(2, "City", null);

        // Act & Assert
        Assertions.assertNotEquals(city1, city2);
    }

    @Test
    public void testHashCode_SameFields_ReturnsSameValue() {
        // Arrange
        City city1 = new City(1, "City", null);
        City city2 = new City(1, "City", null);

        // Act & Assert
        Assertions.assertEquals(city1.hashCode(), city2.hashCode());
    }

    @Test
    public void testHashCode_DifferentId_ReturnsDifferentValue() {
        // Arrange
        City city1 = new City(1, "City", null);
        City city2 = new City(2, "City", null);

        // Act & Assert
        Assertions.assertNotEquals(city1.hashCode(), city2.hashCode());
    }

    @Test
    public void testToString_ReturnsFormattedString() {
        // Arrange
        City city = new City(1, "City", null);
        String expectedString = "City(id=1, name=City, tools=null)";

        // Act
        String actualString = city.toString();

        // Assert
        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void testConstructorWithIdAndName() {
        // Arrange
        Integer id = 1;
        String name = "City";

        // Act
        City city = new City(id, name);

        // Assert
        Assertions.assertEquals(id, city.getId());
        Assertions.assertEquals(name, city.getName());
        // Ensure tools list is initialized as null
        Assertions.assertNull(city.getTools());
    }

    @Test
    public void testConstructorWithAllFields() {
        // Arrange
        Integer id = 1;
        String name = "City";
        List<Tool> tools = new ArrayList<>();

        // Act
        City city = new City(id, name, tools);

        // Assert
        Assertions.assertEquals(id, city.getId());
        Assertions.assertEquals(name, city.getName());
        Assertions.assertEquals(tools, city.getTools());
    }

}
