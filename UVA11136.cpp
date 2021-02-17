// Uso de um multiset para simular um conjunto de contas, com a operacao de remover
// a maior/menor

#include<iostream>
#include<set>
using namespace std;

int nCases, key;
long long soma;
long long nBills;

int main(){
  cin >> nCases;
  while(nCases != 0) {
    soma = 0;
    multiset <int> bills;
    for (int i = 0 ; i < nCases ; i++){
      cin >> nBills;
      if(nBills!=0){

        for(long long j = 0 ; j < nBills ; j++){
          cin >> key;
          bills.insert(key);
        }
      }
      multiset<int>::iterator lowest = bills.begin();
      multiset<int>::iterator highest = --bills.end();
      soma += *highest - *lowest;
      bills.erase(lowest);
      bills.erase(highest);

    }
    cout << soma << '\n';
    cin >> nCases;
  }
  return 0;
}
