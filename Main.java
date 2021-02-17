// Verificar se todos os vertices do poligono "viram" para o mesmo
// lado, se isto nao se verificar,
// e porque se trata de um poligono concavo e consequentemente contem um ponto critico

import java.util.*;

 class Main {

	static class Point implements Comparable<Point> {
		int x;
		int y;

		Point () {
			x=0;
			y=0;
		}

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
	    	public int compareTo (Point p) {
			if (x > p.x) return +1;
			if (x < p.x) return -1;
			if (y > p.y) return +1;
			if (y < p.y) return -1;
			return +1;
		}
	}

	static int turnDirection (Point p1, Point p2, Point p3) {

		return (p2.x-p1.x)*(p3.y-p1.y)-(p2.y-p1.y)*(p3.x-p1.x);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int nP = sc.nextInt();
			if(nP == 0) break;

			Point[] pArray = new Point[nP+5];

			for(int i = 0 ; i < nP ; i++) {
				pArray[i] = new Point(sc.nextInt(), sc.nextInt());
			}

			//Arrays.sort(pArray);

			/*for(int i = 0 ; i < nP ; i++) {
				System.out.println(pArray[i].x + " " + pArray[i].y);
			}*/

			// ver 3 a 3
			int tempDirection;
			int direction = 0;
			int flag = 0;


      			pArray[nP] = pArray[0];
      			pArray[nP+1] = pArray[1];

			for(int i = 0 ; i < nP ; i++) {

				tempDirection = turnDirection(pArray[i],pArray[i+1],pArray[i+2]);

				if(i>0) {
					if((direction<0) && (tempDirection>0)) {
						flag = 1;
						break;

					}

					if((direction>0) && (tempDirection<0)) {
						flag = 1;
						break;
					}
				}

				direction = tempDirection;
			}

			if(flag==1) System.out.println("Yes");
			else System.out.println("No");

		}
	}
}
