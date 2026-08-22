#include <stdio.h>

int main()
{
    int number, originalNumber, reversedNumber = 0, digit;

    printf("Enter a number: ");
    scanf("%d", &number);

    originalNumber = number;

    while(number != 0)
    {
        digit = number % 10;
        reversedNumber = reversedNumber * 10 + digit;
        number = number / 10;
    }

    if(reversedNumber == originalNumber)
        printf("Is the number %d a Palindrome? Yes", originalNumber);
    else
        printf("Is the number %d a Palindrome? No", originalNumber);

    return 0;
}
