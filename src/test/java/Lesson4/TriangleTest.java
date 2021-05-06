package Lesson4;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TriangleTest {
    Triangle triangle = new Triangle();
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAll() {
        logger.info("Tehdään jokaisen koekokoelman ennen");
    }

    @BeforeEach
    void setUp() {
        logger.info("Tehdään jokaisen koen ennen");
    }

    @Test
    @DisplayName("Проверка функции calculateTrianglesAreaWithThreeSides тремя позитивными значениями 2, 3, 4")
    void testGivenThreePositiveSidesOfTriangleWhenCalculateTrianglesAreaWithThreeSides() {
        assertThat(triangle.calculateTrianglesAreaWithThreeSides(2, 3, 4)).isEqualTo(2.9047375096555625);
        logger.debug("Проверка функции calculateTrianglesAreaWithThreeSides тремя позитивными значениями 2, 3, 4");
    }

    @Test
    @RepeatedTest(10)
    void testGivenThreePositiveSidesOfTriangleWhenCalculateTrianglesAreaWithThreeSidesTenTimes() {
        assertThat(triangle.calculateTrianglesAreaWithThreeSides(2, 3, 4)).isEqualTo(2.9047375096555625);
        logger.debug("10-кратная проверка функции calculateTrianglesAreaWithThreeSides тремя позитивными значениями 2, 3, 4");
    }

    @Test
    @DisplayName("Позитивная проверка функции calculateTrianglesAreaWithThreeSides: ни одна из сторон не равна 0 " +
            "значениями 2, 3, 4")
    void testGivenThreeMoreThanNullSidesOfTriangleWhenCalculateTrianglesAreaWithThreeSides(){
        assertThat(triangle.calculateTrianglesAreaWithThreeSides(2, 3, 4)).hasNoNullFieldsOrProperties();
        logger.debug("Позитивная проверка функции calculateTrianglesAreaWithThreeSides: ни одна из сторон не равна 0 " +
        "значениями 2, 3, 4");
    }

//    @Test
//    @DisplayName("Негативная проверка функции calculateTrianglesAreaWithThreeSides: ни одна из сторон не равна 0 " +
//            "значениями 2, 3, 0")
//    void testGivenTwoMoreThanNullAndOneNullSidesOfTriangleWhenCalculateTrianglesAreaWithThreeSides(){
//        assertThat(triangle.calculateTrianglesAreaWithThreeSides(2, 3, 0)).hasNoNullFieldsOrProperties();
//        logger.debug("Негативная проверка функции calculateTrianglesAreaWithThreeSides: ни одна из сторон не равна 0 " +
//                "значениями 2, 3, 0");
//    }

//    @Test
//    @DisplayName("Тест вычисление площади треугольника с позитивными значениями 2, 3, 4 на появление NullPointerException. " +
//            "Тест должен упасть")
//    void testNullPointerExceptionNotEmergence(){
//        assertThatNullPointerException().isThrownBy(() -> Triangle.calculateTrianglesAreaWithThreeSides(2, 3, 4));
//        logger.debug("Тест вычисление площади треугольника с позитивными значениями 2, 3, 4 на появление NullPointerException. " +
//                "Тест должен упасть");
//    }

    @Test
    @DisplayName("Тест вычисление площади треугольника со значениями 2, 3, 0 на появление NullPointerException. " +
            "Тест должен быть выполнен")
    void testNullPointerExceptionEmergence(){
        assertThatNullPointerException().isThrownBy(() -> Triangle.calculateTrianglesAreaWithThreeSides(2, 3, 0));
        logger.debug("Тест вычисление площади треугольника со значениями 2, 3, 0 на появление NullPointerException. " +
                "Тест должен быть выполнен");
    }

    @AfterEach
    void tearDown() {
        logger.debug("Tehdään jokaisen koen jälkeen");
    }

    @AfterAll
    static void afterAll() {
        logger.debug("Tehdään jokaisen koekokoelman jälkeen");
    }

}
