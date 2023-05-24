package puj.api.tool.toolapi.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BrandTests {

    @Test
    public void testNoArgsConstructor() {
        // Arrange
        Brand brand = new Brand();

        // Assert
        Assertions.assertNotNull(brand);
    }

    @Test
    public void testAllArgsConstructor() {
        // Arrange
        Integer brandId = 1;
        String name = "Brand 1";
        List<Tool> tools = new ArrayList<>();

        // Act
        Brand brand = new Brand(brandId, name, tools);

        // Assert
        Assertions.assertEquals(brandId, brand.getBrand_id());
        Assertions.assertEquals(name, brand.getName());
        Assertions.assertEquals(tools, brand.getTools());
    }

    @Test
    public void testGetterSetterBrandId() {
        // Arrange
        Brand brand = new Brand();
        Integer brandId = 1;

        // Act
        brand.setBrand_id(brandId);
        Integer retrievedBrandId = brand.getBrand_id();

        // Assert
        Assertions.assertEquals(brandId, retrievedBrandId);
    }

    @Test
    public void testGetterSetterName() {
        // Arrange
        Brand brand = new Brand();
        String name = "Brand 1";

        // Act
        brand.setName(name);
        String retrievedName = brand.getName();

        // Assert
        Assertions.assertEquals(name, retrievedName);
    }

    @Test
    public void testGetterSetterTools() {
        // Arrange
        Brand brand = new Brand();
        List<Tool> tools = new ArrayList<>();

        // Act
        brand.setTools(tools);
        List<Tool> retrievedTools = brand.getTools();

        // Assert
        Assertions.assertEquals(tools, retrievedTools);
    }
    @Test
    public void testHashCode() {
        // Arrange
        Brand brand1 = new Brand(1, "Brand 1", new ArrayList<>());
        Brand brand2 = new Brand(1, "Brand 1", new ArrayList<>());
        Brand brand3 = new Brand(2, "Brand 2", new ArrayList<>());

        // Act
        int hashCode1 = brand1.hashCode();
        int hashCode2 = brand2.hashCode();
        int hashCode3 = brand3.hashCode();

        // Assert
        Assertions.assertEquals(hashCode1, hashCode2);
        Assertions.assertNotEquals(hashCode1, hashCode3);
    }

    @Test
    public void testEquals() {
        // Arrange
        Brand brand1 = new Brand(1, "Brand 1", new ArrayList<>());
        Brand brand2 = new Brand(1, "Brand 1", new ArrayList<>());
        Brand brand3 = new Brand(2, "Brand 2", new ArrayList<>());
        Brand brand4 = null;
        String otherObject = "Not a Brand object";

        // Act & Assert
        Assertions.assertTrue(brand1.equals(brand1)); // Reflexive
        Assertions.assertTrue(brand1.equals(brand2) && brand2.equals(brand1)); // Symmetric
        Assertions.assertFalse(brand1.equals(brand2) && brand2.equals(brand3) && brand1.equals(brand3)); // Transitive
        Assertions.assertFalse(brand1.equals(brand4)); // Not equal to null
        Assertions.assertFalse(brand1.equals(otherObject)); // Not equal to different type
    }
    
    @Test
    public void testEquals_SameObject_ReturnsTrue() {
        // Arrange
        Brand brand = new Brand(1, "Brand", null);

        // Act & Assert
        Assertions.assertEquals(brand, brand);
    }

    @Test
    public void testEquals_NullObject_ReturnsFalse() {
        // Arrange
        Brand brand = new Brand(1, "Brand", null);

        // Act & Assert
        Assertions.assertNotEquals(brand, null);
    }

    @Test
    public void testEquals_DifferentClass_ReturnsFalse() {
        // Arrange
        Brand brand = new Brand(1, "Brand", null);
        String otherObject = "Not a Brand object";

        // Act & Assert
        Assertions.assertNotEquals(brand, otherObject);
    }

    @Test
    public void testEquals_SameFields_ReturnsTrue() {
        // Arrange
        Brand brand1 = new Brand(1, "Brand", null);
        Brand brand2 = new Brand(1, "Brand", null);

        // Act & Assert
        Assertions.assertEquals(brand1, brand2);
    }

    @Test
    public void testEquals_DifferentId_ReturnsFalse() {
        // Arrange
        Brand brand1 = new Brand(1, "Brand", null);
        Brand brand2 = new Brand(2, "Brand", null);

        // Act & Assert
        Assertions.assertNotEquals(brand1, brand2);
    }

    @Test
    public void testHashCode_SameFields_ReturnsSameValue() {
        // Arrange
        Brand brand1 = new Brand(1, "Brand", null);
        Brand brand2 = new Brand(1, "Brand", null);

        // Act & Assert
        Assertions.assertEquals(brand1.hashCode(), brand2.hashCode());
    }

    @Test
    public void testHashCode_DifferentId_ReturnsDifferentValue() {
        // Arrange
        Brand brand1 = new Brand(1, "Brand", null);
        Brand brand2 = new Brand(2, "Brand", null);

        // Act & Assert
        Assertions.assertNotEquals(brand1.hashCode(), brand2.hashCode());
    }

    @Test
    public void testToString_ReturnsFormattedString() {
        // Arrange
        Brand brand = new Brand(1, "Brand", null);
        String expectedString = "Brand(brand_id=1, name=Brand, tools=null)";

        // Act
        String actualString = brand.toString();

        // Assert
        Assertions.assertEquals(expectedString, actualString);
    }

    @Test
    public void testConstructorWithIdAndName() {
        // Arrange
        Integer id = 1;
        String name = "Brand";

        // Act
        Brand brand = new Brand(id, name);

        // Assert
        Assertions.assertEquals(id, brand.getBrand_id());
        Assertions.assertEquals(name, brand.getName());
        // Ensure tools list is initialized as null
        Assertions.assertNull(brand.getTools());
    }

    @Test
    public void testConstructorWithAllFields() {
        // Arrange
        Integer id = 1;
        String name = "Brand";
        List<Tool> tools = new ArrayList<>();

        // Act
        Brand brand = new Brand(id, name, tools);

        // Assert
        Assertions.assertEquals(id, brand.getBrand_id());
        Assertions.assertEquals(name, brand.getName());
        Assertions.assertEquals(tools, brand.getTools());
    }

}
