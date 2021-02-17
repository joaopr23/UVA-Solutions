// Criacao de cada uma das estruturas de dados propostas, de forma a simular as operacoes
// do encunciado e poder ser assim comparar e averiguar de qual se trata

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(sc.hasNextInt()){
      int n = sc.nextInt();
      Boolean isstack = true;
      Boolean isqueue = true;
      Boolean ispqueue = true;
      Stack<Integer> stack = new Stack<Integer> ();
      LinkedList<Integer> queue = new LinkedList<Integer> ();
      PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(Collections.reverseOrder());
      for(int i = 0 ; i < n ; i++) {
        int type = sc.nextInt();
        int value = sc.nextInt();
        if(type==1){
          stack.push(value);
          queue.add(value);
          pqueue.add(value);
        }
        else if (type == 2){
          //ver se algum tem size 0
          if(!stack.empty()){
            if(value!=stack.pop()) isstack=false;}
          else isstack=false;
          if(!queue.isEmpty()){
            if(value!=queue.remove()) isqueue = false;}
          else isqueue=false;
          if(!pqueue.isEmpty()){
            if(value!=pqueue.remove()) ispqueue = false;}
          else ispqueue=false;

        }
      }
  //    System.out.println("is stack: " + isstack + " is queue: " + isqueue + " is pqueue: " + ispqueue);
      if(isstack==false && isqueue==false && ispqueue==false) System.out.println("impossible");
      else if(isstack==true && isqueue ==false && ispqueue ==false) System.out.println("stack");
      else if(isstack==false && isqueue == true && ispqueue == false) System.out.println("queue");
      else if(isstack==false && isqueue == false && ispqueue == true) System.out.println("priority queue");
      else System.out.println("not sure");
    }
  }
}
