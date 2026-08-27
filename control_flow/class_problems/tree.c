#include <stdio.h>

int main()
{
    int rows, i, j;

    printf("Enter number of rows: ");
    scanf("%d", &rows);

    printf("The right-angled triangle pattern for %d rows is:\n", rows);

    for(i = 1; i <= rows; i++)
    {
        for(j = 1; j <= i; j++)
        {
            printf("* ");
        }

        printf("\n");
    }

    return 0;
}
