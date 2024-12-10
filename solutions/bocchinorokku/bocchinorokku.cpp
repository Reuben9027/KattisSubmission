#include <stdio.h>
#include <stdlib.h>
//#include <unordered_map>
//#include <unordered_map>
#include <iostream>
#include<algorithm>
#include <unordered_map>
using namespace std;

// Comparison function
int compare(const void* a, const void* b)
{
    return (*(int*)a - *(int*)b);
}


int main(){
    int n ;
    cin>>n;
    long arr[n];
    long arr2[n];
    for(int i = 0; i< n; i++){
        long temp;
        cin >> temp;
        arr[i] = temp;
        arr2[i] =temp;
    }
    std::sort(arr2, arr2+n);
    //qsort(arr2, n, sizeof(int), compare);

    unordered_map<long, int> umap;
    // for(int i = 0; i< n; i++){
    //     printf("%d ", arr2[i]);
    // }

    for(int i = 0; i< n; i++){
        long t = arr2[i];
        umap[t] = i;
    }

    for(int i = 0; i< n; i++){
        int r = umap[arr[i]];
        printf("%d ", r);
    }

    return 0;
}