// Credit //
// Checks for a credit card's validity
// and reports which type of card it is
#include <cs50.h>
#include <stdio.h>
 
bool validate(long n);
   
int main(void)
{
    // Prompt the user for the credit card no
    long cardno = get_long("Number: ");
    // And then check if it's valid
    if (validate(cardno) == false)
    {
        printf("INVALID\n");
    }
    // If valid, check for type
    else
    {
        // Find length of card number
        int len = 0;
        for (long i = cardno; i > 0; i = i / 10)
        {
            len++;
        }
        // Determine the type of card
        switch (len)
        {
            case 15:
                cardno = cardno / 10000000000000;
                if (cardno == 34 || cardno == 37)
                {
                    printf("AMEX\n");
                }
                else
                {
                    printf("INVALID\n");
                }
                break;
            case 13:
                cardno = cardno / 1000000000000;
                if (cardno == 4)
                {
                    printf("VISA\n");
                }
                else
                {
                    printf("INVALID\n");
                }
                break;
            case 16:
                cardno = cardno / 100000000000000;
                if (cardno == 51 || cardno == 52 || cardno == 53 || cardno == 54 || cardno == 55)
                {
                    printf("MASTERCARD\n");
                }
                else if (39 < cardno && cardno < 50)
                {
                    printf("VISA\n");
                }
                else
                {
                    printf("INVALID\n");
                }
                break;
            default:
                printf("INVALID\n");
        }
    }
}
 
// Checks for validity of the card no
bool validate(long n)
{
    int parity = 0;
    int count_odd = 0;
    int count_even = 0;
   
    while(n != 0)
    {
        int last = n % 10;
        // First sweep
        if (parity % 2 == 0)
        {
            count_odd = count_odd + last;
            n = n / 10;
        }
        // Second sweep
        else
        {
            if (last < 5)
            {
                count_even = count_even + (last * 2);
                n = n / 10;
            }
            // Handles cases where multiplying the last digit by 2 becomes double digits
            else
            {
                last = last * 2;
                int second = last % 10;
                int first = last / 10;
                count_even = count_even + first + second;
                n = n /10;
            }
        }
        parity++;
    }
    // Final verification; returns true or false
    int sum = count_odd + count_even;
    if (sum % 10 == 0)
    {
        return true;
    }
    else
    {
        return false;
    }
}
