#include <SoftwareSerial.h>

SoftwareSerial mySerial(7, 8); // RX, TX

// Connect HM10 Arduino Uno

// Pin 1/TXD Pin 7

// Pin 2/RXD Pin 8

void setup() {

Serial.begin(9600);
pinMode(10, INPUT); // Setup for leads off detection LO +
pinMode(11, INPUT); // Setup for leads off detection LO -

// If the baudrate of the HM-10 module has been updated,

// you may need to change 9600 by another value

// Once you have found the correct baudrate,

// you can update it using AT+BAUDx command

// e.g. AT+BAUD0 for 9600 bauds

mySerial.begin(9600);

}

void loop() {
  
if((digitalRead(10) == 1)||(digitalRead(11) == 1)){
Serial.println('!');
}
else{
// send the value of analog input 0:
Serial.println(analogRead(A0));
mySerial.print(analogRead(A0));

}
//Wait for a bit to keep serial data from saturating
delay(1);

char c;


if (Serial.available()) {

c = Serial.read();

mySerial.print(c);

}
/*
if (mySerial.available()) {

c = mySerial.read();

Serial.print(c);

}*/

mySerial.print(analogRead(A0));

delay(50);

}
