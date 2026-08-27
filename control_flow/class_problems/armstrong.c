#include <stdio.h>

int main()
{
    int number, originalNumber, sum = 0, digit;

    printf("Enter a number: ");
    scanf("%d", &number);

    originalNumber = number;

    while(number != 0)
    {
        digit = number % 10;
        sum = sum + digit * digit * digit;
        number = number / 10;
    }

    if(sum == originalNumber)
        printf("Is the number %d an Armstrong number? Yes", originalNumber);
    else
        printf("Is the number %d an Armstrong number? No", originalNumber);

    return 0;
}
