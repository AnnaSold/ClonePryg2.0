import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        askCoordinateFrog();
        askPathKuznechika();
    }
    public static Frog askCoordinateFrog(){
        System.out.println("Введите координаты, где на ходится лягушка, и длину языка ");
        Scanner scan = new Scanner(System.in);
        Point coordFrog = new Point(0,0);
        coordFrog.x = scan.nextInt();
        coordFrog.y = scan.nextInt();
        int tongueLength = scan.nextInt();
        Frog frog = new Frog(coordFrog, tongueLength);

        return frog;
    }
    public static Point[] askPathKuznechika() {
        System.out.println("Введите количество точек для кузнечика и их координаты");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();// количество точек для кузнечика
        Point[] coordinatKuznechika = new Point[n];
        for (int i = 1; i <= n; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int j = 1;
            coordinatKuznechika[j] = new Point(x, y);
            j++;
        }
            return coordinatKuznechika;


    }

    public static void test1 ()
    {
        Frog testFrog = new Frog(new Point(0, 0), 1);
        Frog testFrog2 = new Frog(0, 0, 100);
        int n = 3;
        Point[] route = new Point[n];   //создался массив, НО не точек
        //а указателей на точки
        route[0] = new Point(2, 0);
        route[1] = new Point(1, 1);
        route[2] = new Point(0, 1);

        for (int i = 0; i < route.length; i++) {
            double d = Point.calcDistance(testFrog.place, route[i]);
            if( d<= testFrog.tongueLength)
            {
                System.out.println("кузнечек съеден в "+(i+1) +" точке");
                break;
            }
        }
    }

    //TODO:
    //1 сделать функцию, которая спрашивает у пользователя координаты и длину языка и выдает в
    //  качестве результата новую Лягушку
    //2 сделать функцию, которая спрашивает у пользователя длину маршрута, затем запраивает
    //  много точек в виде пар координат
    //  результат этой функции - массив Точек
    //3 сделать функцию, которая проверяет проверяет работу вышеописанных функций
    //  и запускает проверку выживания кузнечика
}

class Point{
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("вызван конструктор точки с параметрами "+x+"; "+y);
    }

    public static double calcDistance(Point p1, Point p2){
        return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
    }
}

class Frog{
    Point place;
    int tongueLength;

    public Frog(Point place, int tongueLength) {
        this.place = place;
        this.tongueLength = tongueLength;
        System.out.println("вызван конструктор Frog с 2 параметрами");
    }

    public Frog(int x, int y, int len){
        place = new Point(x, y);
        tongueLength = len;
        System.out.println("вызван конструктор Frog с 3 параметрами");
    }
}