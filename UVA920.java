// A componente vertical de cada face virada para o sol, e usada como forma de calcular a
// porção de face exposta ao sol, e com base no comprimento total desta,
// calcular a verdadeira distancia exposta de forma simples

import java.util.*;

class Main {

  static class Point implements Comparable<Point> {
    public double x;
    public double y;

    Point () {
      x = 0.0;
      y = 0.0;
    }

    Point (Double x, Double y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Point b) {
      if(x > b.x) return +1;
      if(x < b.x) return -1;
      return +1;
    }
  }

    static double getLength (Point a, Point b) {
    return Math.sqrt((b.x-a.x)*(b.x-a.x)+(b.y-a.y)*(b.y-a.y));
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int c = sc.nextInt();

    for (int i = 0 ; i < c ; i++) {
      double totalLength = 0.0;
      double maxY = 0.0;
      int N = sc.nextInt();
      Point[] Parray = new Point[N];
      for(int j = 0 ; j < N ; j++) {
        Parray[j] = new Point((double)sc.nextInt(),(double)sc.nextInt());
      }
      Arrays.sort(Parray);

    /*  for(int j = 0 ; j < N ; j++) {
        System.out.println(Parray[j].x + " " + Parray[j].y);
      } */

      for(int j = N-1 ; j >= 0 ; j--) {
        if (Parray[j].y > maxY) {
          //System.out.println("Parray[j]: " + Parray[j].x + ", Parray[j+1]: " + Parray[j+1].x + ", maxY: " +maxY);
          totalLength += getLength(Parray[j],Parray[j+1]) * ((Parray[j].y - maxY) / (Parray[j].y - Parray[j+1].y));
          maxY = Parray[j].y;
        }
      }
    System.out.println((double)Math.round(totalLength * 100d) / 100d);
    }
  }
}
