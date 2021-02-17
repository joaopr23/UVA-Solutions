// Uso de um Hashmap para guardar a frequencia de diversas combinacoes unicas
// de modo ordenado

import java.util.*;

class Main {

  public static void main(String[] args) {
    Scanner sc =  new Scanner (System.in);
    int[] Array = new int[5];
    String Key;
    HashMap <String, Integer> cMap = new HashMap<String, Integer>();
    int n = sc.nextInt();

    while(n!=0){
      cMap.clear();
      //Processamento do input e conversao em String (Key)
      for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j < 5 ; j++){
          Array[j]=sc.nextInt();
        }
        Arrays.sort(Array);
        Key = Arrays.toString(Array);
        //criacao ou incremento de cada combinacao
        if(cMap.containsKey(Key)){
          cMap.replace(Key,((cMap.get(Key))+1));
        }
        else {
          cMap.put(Key,1);
        }
      }
    //caso de varias combinacoes com igual frequencia
    int max = (Collections.max(cMap.values()));
    int maxcount=0;

    for (Map.Entry<String,Integer> entry : cMap.entrySet())
      if(entry.getValue()==max) maxcount++;

    if(maxcount==1) System.out.println(max);
    else System.out.println(maxcount*max);

    n = sc.nextInt();
    }
  }
}
