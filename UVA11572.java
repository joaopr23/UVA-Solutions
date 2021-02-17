// Uso de um Hashset para manter o maior conjunto unico de flocos de neve
// A resposta corresponde ao tamanho do conjunto

import java.util.*;

class Main {
  public static void main(String[] args) {
    int p1=0;
    int p2=0;
    int max=0;
    Scanner sc = new Scanner(System.in);
    HashSet<Integer> hash_set = new HashSet<Integer>();
    int nC =  sc.nextInt();
    for(int i = 0 ; i < nC ; i++){
      p1=0;
      p2=0;
      max = 0;
      hash_set.clear();
      Integer nS = sc.nextInt();
      Integer[] array = new Integer[nS];
      for(int j = 0 ; j < nS ; j++){
        array[j] = sc.nextInt();
      }
      while(p2 < array.length) {
        if (!hash_set.contains(array[p2])){
          hash_set.add(array[p2]);
          p2++;
          max = Math.max(hash_set.size(), max);
        }
        else {
          hash_set.remove(array[p1]);
          p1++;
        }
      }
      System.out.println(max);
    }
  }
}
