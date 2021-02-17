// Solucao determinada recursivamente com memorizacao

// estrategia para cada instancia:
// se nao houver mais cortes a fazer o custo e 0
// para cada corte da lista: custo do corte + minimo entre dois paus criados pelo corte

#include <bits/stdc++.h>

using namespace std;

int dp[55][55];

int minCost(int i, int j, int cuts[]) {

  if(dp[i][j]!=-1) return dp[i][j];

  if((i+1)==j) {
    dp[i][j] = 0;
    return 0;
  }

  int min = INT_MAX;
  for(int k = (i+1) ; k < j; k++){
    min = std::min(min, (cuts[j]-cuts[i]) + minCost(i,k,cuts) + minCost(k,j,cuts));
  }

  dp[i][j] = min;
  return min;
}

int main () {
  int n, length, nCuts;

  while (true) {
    scanf("%d\n",&n);
    if(n==0) return 0;

    scanf("%d\n",&nCuts);

    length = nCuts+2;

    int cuts[length];

    memset(dp, -1, sizeof dp);

    cuts[0] = 0;
    cuts[length-1] = n;

    for(int i = 1 ; i <= nCuts ; i++) {
      scanf("%d\n",&cuts[i]);
    }

    printf("The minimum cutting is %d.\n",minCost(0,nCuts+1,cuts));
  }
  return 0;
}
