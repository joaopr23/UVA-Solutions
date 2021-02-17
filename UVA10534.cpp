// Calcular a maior sequencia crescente a terminar
// e a maior sequencia decrescente a comecar em cada posicao

// verificar qual a posicao com maior valor combinado

#include <bits/stdc++.h>
using namespace std;

int lis (int arr[], int n, int soFar[]) {
  vector<int> seq;
  seq.push_back(arr[0]);
  soFar[0] = 1;
  for(int i = 1 ; i < n ; i++) {
    //printf("%d\n",arr[i]);

    if(seq.back() < arr[i]) {
      seq.push_back(arr[i]);
    }
    else {
      int ind = lower_bound(seq.begin(),seq.end(),arr[i])-seq.begin();
      seq[ind] = arr[i];
    }
    //soFar[i] = seq.size();
    soFar[i] = seq.size();
  }

return seq.size();

}

int main () {

  int n;
  while(scanf("%d", &n) != EOF ) {
    int array[n];
    for(int i = 0 ; i <n ; i++) {
  		scanf("%d",&array[i]);
	}


  	int soFar1[n];
  	int soFar2[n];



   	lis(array, n, soFar1);

   	reverse(array,array+n);

/*  for(int i = 0 ; i < n ; i++) printf("%d ",array[i]);
  printf("\n");*/


//  cout << ("-----------\n");

 	lis(array, n, soFar2);

//  cout << ("-----------\n");
/*  for(int i = 0 ; i < n ; i++) printf("%d ",soFar1[i]);
  printf("\n");
  for(int i = 1 ; i <= n ; i++) printf("%d ",soFar2[n-i]);*/

  	int ans = 0 ;
  	for(int i = 0 ; i < n ; i++) {
    	ans = max(ans, 2* min(soFar1[i], soFar2[n-(i+1)]));
  	}

	printf ("%d\n", ans-1);
	}
  return 0;
}
