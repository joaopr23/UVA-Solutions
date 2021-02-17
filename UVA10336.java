// Aplicacao da estrategia flood fill atraves de DFS de modo a contar o numero de estados
// em que cada linguagem e falada, e usado um mapa de modo a contabilizar o numero total de
// estados de uma linguagem, que podem nao ser adjacentes (mesmo DFS)

import java.util.*;

class Main {

  public static int lines;
  public static int cols;

  static class Language implements Comparable<Language> {
    char letter;
    int number;

    Language(char letter, int number) {
      this.letter = letter;
      this.number = number;
    }

    @Override
    public int compareTo(Language language) {
      if(language.number > number) return +1;
      if(language.number < number) return -1;
      return +1;
    }
  }

  static void DFS (char[][] matrix, boolean[][] visited, int l, int c, char letter) {
    //System.out.println("here");
    if(l<0 || l>=lines || c<0 || c>= cols) return;

    if(visited[l][c] || matrix[l][c]!=letter) return;

    visited[l][c] =  true;

    DFS(matrix,visited,l-1,c,letter);
    DFS(matrix,visited,l+1,c,letter);
    DFS(matrix,visited,l,c-1,letter);
    DFS(matrix,visited,l,c+1,letter);

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int nC = sc.nextInt();
    int l,c;

    for(int z = 0 ; z < nC ; z++) {
      lines = sc.nextInt();
      cols = sc.nextInt();

      HashMap<Character, Integer> map = new HashMap<Character, Integer>();
      char matrix[][] = new char[lines][cols];
      boolean visited[][] = new boolean[lines][cols];

      for(int j = 0 ; j < lines ; j++) {
        matrix[j] = sc.next().toCharArray();
      }

      for(int i = 0 ; i < lines ; i++) {
        for(int j = 0 ; j < cols ; j++) {
          if(!visited[i][j]) {
            DFS(matrix,visited,i,j,matrix[i][j]);
            if(!map.containsKey(matrix[i][j])) map.put( matrix[i][j], 1);
            else map.put( matrix[i][j], map.get(matrix[i][j])+1);
          }
        }
      }
      //colocar os elementos do mapa numa linkedlist
      LinkedList<Language> list = new LinkedList<Language>();

      for (Map.Entry Entry : map.entrySet()) {
        char letter = (char) Entry.getKey();
        int number = (int) Entry.getValue();
        Language thisLanguage = new Language(letter,number);
        list.add(thisLanguage);
      }
      Collections.sort(list);
      System.out.println("World #" + (z+1));
      for(int i = 0 ; i < list.size() ; i++) {
        System.out.println(list.get(i).letter+ ": " +list.get(i).number);
      }
    }
  }
}
