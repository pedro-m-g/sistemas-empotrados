#include <Servo.h>

/*
 * Configuración de los pins.
 * LED_PIN: Puede ser cualquier puerto digital que soporte potenciómetro
 * BUTTON_PIN: Puede ser cualquier puerto digital
 * ANGLE_PIN: Puerto del sensor de rotación. Puede ser ccualquier puerto anáogo
 */
#define LED_PIN 3
#define SERVO_PIN 7
#define BUTTON_PIN 8
#define ANGLE_PIN A0

/**
 * Constantes para calibrar el sensor de rotación.
 */
#define MIN_ANGLE_INPUT 0
#define MAX_ANGLE_INPUT 1023
#define MIN_ANGLE 20
#define MAX_ANGLE 160

/**
 * Constantes para controlarel tiempo de espera después de cada disparo
 * y entre lecturas
 */
#define DELAY_TIME 100
#define BREATH_DELAY 1

int previousAngle = 0;
// Servo servo;

/**
 * Configurar puertos
 * 
 * LED: Salida
 * Button: Entrada
 * Sensor de rotación: Entrada
 * Servo: Salida
 * 
 * Preparar programa para imprimir en puerto serial
 * 
 */
void setup() {
  pinMode(LED_PIN, OUTPUT);
  pinMode(BUTTON_PIN, INPUT);
  pinMode(ANGLE_PIN, INPUT);
  // servo.attach(SERVO_PIN);
  Serial.begin(9600);
}

void loop() {
  angleAction();
  buttonAction();
  delay(DELAY_TIME);
}

/**
 * Detecta si hay rotación en el sensor. De se asi, gira el servo
 * según el nuevo ángulo y envia el comando ROTATE con el nuevo ángulo
 * al puerto serial
 */
void angleAction() {
  int value = analogRead(ANGLE_PIN);
  int angle = toDegrees(value);
  if (angle != previousAngle) {
    Serial.print("ROTATE ");
    Serial.println(angle);
    // servo.write(angle);
    previousAngle = angle;
  }
}

/**
 * Converte el valor del sensor de rotación en grados de rotación (0 - 180)
 * 
 * @param value Valor a convertir (0 - 1023)
 * @return Ángulo de rotación (0 - 180)
 */
int toDegrees(int value) {
  int angle = map(value, MIN_ANGLE_INPUT, MAX_ANGLE_INPUT, MIN_ANGLE, MAX_ANGLE);
  return 180 - angle;
}

/**
 * Detecta si el botón está siendo presionado. De ser así, envia el
 * comando SHOOT al puerto serial y enciende el LED
 */
void buttonAction() {
  if(digitalRead(BUTTON_PIN)) {
        Serial.println("SHOOT");
        light();
    } else {
        digitalWrite(LED_PIN, LOW);
    }
}

/**
 * Enciende el LED de manera progresiva. Esto evita realizar
 * múltiples disparos al mismo tiempo, y tiene fines estéticos.
 */
void light()
{
  for(int i=0; i<256; i++)
  {
      analogWrite(LED_PIN, i);
      delay(BREATH_DELAY);
  }
  delay(BREATH_DELAY);
  for(int i=255; i>=0; i--)
  {
      analogWrite(LED_PIN, i);
      delay(BREATH_DELAY);
  }
}

