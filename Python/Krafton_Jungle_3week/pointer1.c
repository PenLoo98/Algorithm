#include <stdio.h>

int plus(int a){
    a+=4;
    return 0;
}

int plus_ref(int *a) {
    *a+=3;
    plus(*a);
    printf("%d\n",*a);
    return 0;
}

int main() {
    int a=10;
    int arr[] = {1,2,3,4,5};
    plus_ref(&a);
    // printf("%d\n",a);
    return 0;
}