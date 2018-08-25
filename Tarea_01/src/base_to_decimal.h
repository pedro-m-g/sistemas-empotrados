#ifndef BASE_TO_DECIMAL_H

#define BASE_TO_DECIMAL_H

#include <stdbool.h>

/*
Definición de códigos ASCII
 */

#define ZERO_CHAR 48
#define NINE_CHAR 57

#define A_LETTER 65
#define Z_LETTER 90

/**
 * Convierte un número de cualquier base entre 2 y 37 a decimal
 * @param  n    Número a convertir
 * @param  base Base del número ingresado
 * @return      Número en base 10
 */
long base_to_decimal(char* n, int base);

/**
 * Valor de un dígito
 * @param  n     Número completo
 * @param  index Posición del dígito, empezando por el más significativo
 * @return       Valor del dígito index para el número n
 */
long digit_value(char* n, int index);

/**
 * Detecta si un caracter es dígito numérico
 * @param  d Caracter a probar
 * @return   true sólo si el caracter es un dígito entre 0 y 9 (inclusivo)
 */
bool is_digit(char d);

/**
 * Detecta si un caracter es una letra mayúscula de la A a la Z
 * @param  d Caracter
 * @return   true solo si el caracter es una letra mayúscula de la A a la Z
 */
bool is_alpha(char d);

/**
 * Convierte un caracter numérico a su equivalente decimal
 * @param  d Caracter
 * @return   Caracter convertido a decimal. Ejemplos: '0' => 0
 */
int parse_digit(char d);

/**
 * Convierte una letra a su equivalente decimal
 * @param  d Caracter
 * @return   Caracter convertido a decimal. Ejemplos: 'A' => 10
 */
int parse_alpha(char d);

#endif
