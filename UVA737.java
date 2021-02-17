// A area e calculada atraves um cubo hipotetico, cujas coordenas sao uma combinacao das
// componentes "maiores", no caso do vertice inicial, e "menores" no caso do vertice+distancia

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while(true) {
      int nC = sc.nextInt();
      if(nC == 0 ) break;

      int x = Integer.MIN_VALUE;
      int y = Integer.MIN_VALUE;
      int z = Integer.MIN_VALUE;

      int xd = Integer.MAX_VALUE;
      int yd = Integer.MAX_VALUE;
      int zd = Integer.MAX_VALUE;

      for(int i = 0 ; i < nC ; i++) {

        int cx = sc.nextInt();
        int cy = sc.nextInt();
        int cz = sc.nextInt();
        int d = sc.nextInt();

        if(cx + d < xd) xd = cx+d;
        if(cy + d < yd) yd = cy+d;
        if(cz + d < zd) zd = cz+d;

	if(cx > x) x = cx;
	if(cy > y) y = cy;
	if(cz > z) z = cz;
      }
      System.out.println(Math.max(0,(xd-x)*(yd-y)*(zd-z)));
    }
  }
}
