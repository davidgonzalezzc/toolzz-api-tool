package puj.api.tool.toolapi.entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ToolTests {

    @Test
    public void testEquals() {
        // Arrange
        Tool tool1 = new Tool("image1", "Tool 1", "Description 1", null, 10.0, null, 5);
        Tool tool2 = new Tool("image1", "Tool 1", "Description 1", null, 10.0, null, 5);
        Tool tool3 = new Tool("image2", "Tool 2", "Description 2", null, 20.0, null, 10);
        
        Tool tool4 = new Tool(1,"image1", "Tool 1", "Description 1", null, 10.0, null, 5);
        Tool tool5 = new Tool(1,"image2", "Tool 2", "Description 2", null, 20.0, null, 10);
        
        // Act & Assert
        Assertions.assertEquals(tool1, tool2); // Equal objects
        Assertions.assertNotEquals(tool1, tool3); // Different objects
        Assertions.assertNotEquals(tool4, tool5);
    }

    @Test
    public void testHashCodeConsistency() {
        // Arrange
        Tool tool = new Tool("image1", "Tool 1", "Description 1", null, 10.0, null, 5);

        // Act & Assert
        Assertions.assertEquals(tool.hashCode(), tool.hashCode()); // Consistent hash code
    }

    @Test
    public void testHashCodeCollision() {
        // Arrange
        Tool tool1 = new Tool("image1", "Tool 1", "Description 1", null, 10.0, null, 5);
        Tool tool2 = new Tool("image2", "Tool 2", "Description 2", null, 20.0, null, 10);

        // Act & Assert
        Assertions.assertNotEquals(tool1.hashCode(), tool2.hashCode()); // Hash code collision
    }

    @Test
    public void testSetters() {
        // Arrange
        Tool tool = new Tool();

        // Act
        tool.setImage("image1");
        tool.setName("Tool 1");
        tool.setDescription("Description 1");
        tool.setBrand(null);
        tool.setPrice(10.0);
        tool.setCities(null);
        tool.setAmount(5);

        // Assert
        Assertions.assertEquals("image1", tool.getImage());
        Assertions.assertEquals("Tool 1", tool.getName());
        Assertions.assertEquals("Description 1", tool.getDescription());
        Assertions.assertNull(tool.getBrand());
        Assertions.assertEquals(10.0, tool.getPrice());
        Assertions.assertNull(tool.getCities());
        Assertions.assertEquals(5, tool.getAmount());
    }


    @Test
    public void testEquals_SameObject_ReturnsTrue() {
        // Arrange
        Tool tool = new Tool(1, "image", "name", "description", null, null, null, null);

        // Act & Assert
        Assertions.assertEquals(tool, tool);
    }

    @Test
    public void testEquals_NullObject_ReturnsFalse() {
        // Arrange
        Tool tool = new Tool(1, "image", "name", "description", null, null, null, null);

        // Act & Assert
        Assertions.assertNotEquals(tool, null);
    }

    @Test
    public void testEquals_DifferentClass_ReturnsFalse() {
        // Arrange
        Tool tool = new Tool(1, "image", "name", "description", null, null, null, null);
        String otherObject = "Not a Tool object";

        // Act & Assert
        Assertions.assertNotEquals(tool, otherObject);
    }

    @Test
    public void testEquals_SameFields_ReturnsTrue() {
        // Arrange
        Tool tool1 = new Tool(1, "image", "name", "description", null, null, null, null);
        Tool tool2 = new Tool(1, "image", "name", "description", null, null, null, null);

        // Act & Assert
        Assertions.assertEquals(tool1, tool2);
    }

    @Test
    public void testEquals_DifferentId_ReturnsFalse() {
        // Arrange
        Tool tool1 = new Tool(1, "image", "name", "description", null, null, null, null);
        Tool tool2 = new Tool(2, "image", "name", "description", null, null, null, null);

        // Act & Assert
        Assertions.assertNotEquals(tool1, tool2);
    }

    @Test
    public void testHashCode_SameFields_ReturnsSameValue() {
        // Arrange
        Tool tool1 = new Tool(1, "image", "name", "description", null, null, null, null);
        Tool tool2 = new Tool(1, "image", "name", "description", null, null, null, null);

        // Act & Assert
        Assertions.assertEquals(tool1.hashCode(), tool2.hashCode());
    }

    @Test
    public void testHashCode_DifferentId_ReturnsDifferentValue() {
        // Arrange
        Tool tool1 = new Tool(1, "image", "name", "description", null, null, null, null);
        Tool tool2 = new Tool(2, "image", "name", "description", null, null, null, null);

        // Act & Assert
        Assertions.assertNotEquals(tool1.hashCode(), tool2.hashCode());
    }

    @Test
    public void testToString_ReturnsFormattedString() {
        // Arrange
        Tool tool = new Tool(1, "image", "name", "description", null, null, null, null);
        String expectedString = "Tool(id=1, image=image, name=name, description=description, brand=null, price=null, cities=null, amount=null)";

        // Act
        String actualString = tool.toString();

        // Assert
        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void testConstructorWithIdAndName() {
        // Arrange
        Integer id = 1;
        String name = "Tool";

        // Act
        Tool tool = new Tool(id, name);

        // Assert
        Assertions.assertEquals(id, tool.getId());
        Assertions.assertEquals(name, tool.getName());
        // Ensure other fields are initialized as null
        Assertions.assertNull(tool.getImage());
        Assertions.assertNull(tool.getDescription());
        Assertions.assertNull(tool.getBrand());
        Assertions.assertNull(tool.getPrice());
        Assertions.assertNull(tool.getCities());
        Assertions.assertNull(tool.getAmount());
    }

    @Test
    public void testConstructorWithAllFields() {
        // Arrange
        Integer id = 1;
        String image = "image.jpg";
        String name = "Tool";
        String description = "Description";
        Brand brand = new Brand(1, "Brand");
        Double price = 9.99;
        List<City> cities = new ArrayList<>();
        Integer amount = 5;

        // Act
        Tool tool = new Tool(id, image, name, description, brand, price, cities, amount);

        // Assert
        Assertions.assertEquals(id, tool.getId());
        Assertions.assertEquals(image, tool.getImage());
        Assertions.assertEquals(name, tool.getName());
        Assertions.assertEquals(description, tool.getDescription());
        Assertions.assertEquals(brand, tool.getBrand());
        Assertions.assertEquals(price, tool.getPrice());
        Assertions.assertEquals(cities, tool.getCities());
        Assertions.assertEquals(amount, tool.getAmount());
    }

    // Add more test methods to cover other branches in the Tool class

}



