// Resposta obtida recursivamente com memorizacao

// para cada instancia
// se as letras forem diferentes	
// 1 + custo da sequencia 'interior' OU remover a letra esquerda ou a direita
// se forem iguais
// 0 + custo da sequencia 'interior' OU remover a letra esquerda Ou a direita

// 0 no caso de ser a letra do meio

#include <bits/stdc++.h>
using namespace std;

int dp[1001][1001];

int func(char string[], int i, int j) {

  if(dp[i][j]!=-1) return dp[i][j];

  else if(i>=j) {
    dp[i][j] = 0;
    return 0;
  }

  else if(string[i]==string[j]) {
    dp[i][j]  = func(string,i+1,j-1);
    dp[i+1][j-1] = dp[i][j];
    return dp[i][j] ;
  }

  else {
   dp[i][j] =  1 + min(func(string,i+1,j-1),min(func(string,i,j-1),func(string,i+1,j)));
   return dp[i][j];
  }
}

int main () {
  int t;
  char string[1005];

  scanf("%d",&t);
  for(int i = 1 ; i <=t ; i++) {
    for(int i = 0 ; i < 1001 ; i++) {
      for(int j = 0 ; j < 1001 ; j++) {
        dp[i][j]=-1;
      }
    }
    scanf("%s", string);
    printf("Case %d: %d\n",i,func(string,0,strlen(string)-1));
  }
  return 0;
}
