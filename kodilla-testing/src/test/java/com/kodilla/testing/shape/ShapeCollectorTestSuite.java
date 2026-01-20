package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;
import java.util.*;

@DisplayName("Shape Collector Test Suite")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for removing Shape")
    class TestRemoveShape {
        @Test
        void testRemoveShape() {
            //Given
            List<IShape> shapesList = new ArrayList<>(List.of(new Triangle(4, 2), new Square(5), new Circle(10)));
            ShapeCollector SC = new ShapeCollector(shapesList);
            //When
            SC.removeFigure(shapesList.get(2));
            //Then
            System.out.println(" wynik testu: "+SC.showFigures());
            Assertions.assertEquals("triangle, square, ", SC.showFigures());
        }

        @Test
        void testRemoveShapeNotExisting() {
            //Given
            List<IShape> shapesList = new ArrayList<IShape>(List.of(new Triangle(4, 2), new Square(5), new Circle(10)));
            ShapeCollector SC = new ShapeCollector(shapesList);
            //When
            SC.removeFigure(new Triangle(10,2));
            //Then
            Assertions.assertEquals("triangle, square, circle, ", SC.showFigures());
        }
    }

    @Nested
    @DisplayName("Tests for getting Shape")
    class TestGetShape {
        @Test
        void testGetShape() {
            //Given
            List<IShape> shapesList = new ArrayList<IShape>(List.of(new Triangle(4, 2), new Square(5), new Circle(10)));
            ShapeCollector SC = new ShapeCollector(shapesList);
            //When
            IShape shape = SC.getFigure(2);
            //Then
            Assertions.assertEquals(new Circle(10), shape);
        }
    }

    @Nested
    @DisplayName("Tests for displaying shapes")
    class TestDisplayShape {
        @Test
        void testDisplayShape() {
            //Given
            List<IShape> shapesList = new ArrayList<IShape>(List.of(new Triangle(4, 2), new Square(5), new Circle(10)));
            ShapeCollector SC = new ShapeCollector(shapesList);
            //When
            String result = SC.showFigures();
            //Then
            Assertions.assertEquals("triangle, square, circle, ", result);
        }

        @Test
        void testDisplayEmptyShape() {
            //Given
            ShapeCollector SC = new ShapeCollector(new ArrayList<IShape>());
            //When
            String result = SC.showFigures();
            //Then
            Assertions.assertEquals("No shapes in collection.", result);
        }
    }

    @Nested
    @DisplayName("Tests for adding Shape")
    class TestAddShape {
        @Test
        void testAddShape() {
            //Given
            List<IShape> shapesList = new ArrayList<IShape>(List.of(new Triangle(4, 2), new Square(5)));
            ShapeCollector SC = new ShapeCollector(shapesList);
            //When
            SC.addFigure(new Circle(3));
            //Then
            Assertions.assertEquals(new Circle(3), SC.getFigure(2));
        }
    }
}
