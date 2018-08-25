/**
 * @author Pedro Martín del Campo González <pedro.martin@uabc.edu.mx>
 * @date 25/08/2018
 */

#include <stdbool.h>
#include <string.h>
#include "base_to_decimal.h"

long base_to_decimal(char* n, int base)
{
    long result = 0;
    int k = strlen(n) - 1;
    long d;
    int counter;
    for (counter = 0; counter <= k; counter++)
    {
        d = digit_value(n, counter);
        if (d < 0)
        {
            return -1;
        }
        result = d + base * result;
    }
    return result;
}

long digit_value(char* n, int index)
{
    char d = n[index];
    if (is_digit(d))
    {
        return parse_digit(d);
    }
    if (is_alpha(d))
    {
        return parse_alpha(d);
    }
    return -1;
}

bool is_digit(char d)
{
    return d >= ZERO_CHAR && d <= NINE_CHAR;
}
bool is_alpha(char d)
{
    return d >= A_LETTER && d <= Z_LETTER;
}

int parse_digit(char d)
{
    return d - ZERO_CHAR;
}
int parse_alpha(char d)
{
    return d - A_LETTER + 10;
}
