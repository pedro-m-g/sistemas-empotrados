/**
 * @author Pedro Martín del Campo González <pedro.martin@uabc.edu.mx>
 * @date 25/08/2018
 *
 * Programa que acepta como entrada un número de máximo 255 dígitos y una base entre 2 y 37
 * y lo convierte a su equivalente en base 10
 *
 */

#include <stdio.h>
#include "base_to_decimal.h"

#define MIN_BASE 2
#define MAX_BASE 37

int main()
{
    char n[255];
    int base;
    long decimal;

    printf("Número: ");
    scanf("%s", n);

    printf("Base: ");
    scanf("%d", &base);

    if (base < MIN_BASE || base > MAX_BASE)
    {
        printf("Solo se aceptan bases entre 2 y 37 (inclusivo)");
    }

    decimal = base_to_decimal(n, base);
    if (decimal < 0)
    {
        printf("Solo se aceptan digitos de 0 al 9 y letras mayúsculas de la A a la Z (excluyendo la letra Ñ)\n");
    } else {
        printf("%s base %d = %ld base 10\n", n, base, decimal);
    }

    return 0;
}
