package Lesson4;

public class Triangle {
    int a;
    int b;
    int c;

    public Triangle() {
    }


    public Triangle(int a, int b, int c) {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }
    public void setC(int c) {
        this.c = c;
    }

    public static double calculateTrianglesAreaWithThreeSides (int a, int b, int c){
        if (a > 0 & b > 0 & c > 0) {
            double p = ((double) a + (double) b + (double) c) / 2;
            return (Math.sqrt(p * (p - a) * (p - b) * (p - c)));
        }else throw new NullPointerException("Стороны треугольника должны быть больше 0");
    }

    public static void main(String[] args) {
        System.out.println(calculateTrianglesAreaWithThreeSides(2, 3, 4));
    }
}

//1 Напишите функцию, вычисляющую площадь треугольника по трём сторонам (int a, int b, int c).
// Разместите класс с функцией в src/main/java.
//2 Разместите тесты на эту функцию в классе src/test/java/.../TriangleTest.java.
//3 Настройте генерацию отчёта и по желанию — логирование.
