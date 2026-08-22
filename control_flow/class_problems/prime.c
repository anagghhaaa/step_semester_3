#include <stdio.h>

int main()
{
    int number, i, isPrime = 1;

    printf("Enter a number: ");
    scanf("%d", &number);

    for(i = 2; i < number; i++)
    {
        if(number % i == 0)
        {
            isPrime = 0;
            break;
        }
    }

    if(isPrime)
        printf("Is the number %d a Prime number? Yes", number);
    else
        printf("Is the number %d a Prime number? No", number);

    return 0;
}
