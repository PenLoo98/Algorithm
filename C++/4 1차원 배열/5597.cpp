// https://www.acmicpc.net/problem/5597

#include <stdio.h>

int main()
{
    int arr[30];
    for (int i = 0; i < 28; i++)
    {
        int n;
        scanf("%d", &n);
        arr[n - 1] = 1;
    }

    int cnt=0;
    for (int i = 0; i < 30; i++)
    {
        if (arr[i] != 1)
        {   if (cnt == 0)
                printf("%d\n", i + 1);
            else
                printf("%d", i + 1);
            cnt++;
        }   
    }
}

