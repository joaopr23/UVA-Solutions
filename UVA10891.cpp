// Estrategia baseada em https://algorithmist.com/wiki/UVa_10891_-_Game_of_Sum

// reposta calculada recursivamente com memorizacao

// para cada instancia, calcular a maior diferenca entre se escolher a esquerda ou a
// direita combinado com o numero de numeros a remover

#include <bits/stdc++.h>

using namespace std;
long n;
long dp[110][110];

long cumSum (long i , long j , long sumArray[]) {
  if(i==0) return sumArray[j];
  return (sumArray[j] - sumArray[i-1]);
}

long best (long i, int j, long array[], long sumArray[]){

  if(i>j) return 0;

  if(dp[i][j]!=INT_MIN) return dp[i][j];

  long max = INT_MIN;

  for (long k = i; k <= j; k++) {
    max=std::max(max,cumSum(i,k,sumArray) - best(k+1,j,array,sumArray));
  }

  for (long k = j; k >= i; k--) {
    max = std::max(max, cumSum(k,j,sumArray) - best(i,k-1,array,sumArray));
  }

  dp[i][j] = max;

  return max;
}

int main () {


  while(true) {
    scanf("%ld",&n);
    if(n==0) return 0;

    long array[n];
    long sumArray[n];

    for(int i = 0 ; i < 110 ; i++) {
      for(int j = 0 ; j < 110 ; j++) {
        dp[i][j] = INT_MIN ;
      }
    }

    long element;
    long sum=0;

    for(int i = 0 ; i < n ; i++) {
      scanf("%ld\n",&element);
      array[i] = element;
      sum = sum + element;
      sumArray[i] = sum;
    }
    printf("%ld\n",best(0,n-1,array,sumArray));
  }
  return 0;
}
