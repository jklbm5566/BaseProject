byte ledPin = 2;
int lightLevel = 0;
char inputData[20];
byte i;
char tempChr;
byte maxDigit = 19;
byte maxAnalogOutput=255;
String dataString;

String NAME = "Door1";
bool STATE = false, prevState = false;

void setup() {
  Serial.begin(9600);
  Serial.print("LED ready.");
  pinMode(A2, OUTPUT);
  for (int i = 2; i < 14; i++) pinMode(i, OUTPUT);
  for (int i = 2; i < 14; i++) digitalWrite(i, HIGH);
  pinMode(13, INPUT);
  
}
 
void loop() {

 recieveHandler();
 checkState();
 delay(1000);
}

void checkState() {
  STATE = digitalRead(13);

//  if (prevState) { // 原本在內
//    if (STATE) {
//      // do nothing 
//    }
//    else {
//      Serial.print("CHECK Door1");
//    }
//  }
//  else { // 原本無人在內
//    if (STATE) {
//      Serial.print("CHECK Door1");
//    }
//    else {
//      // do nothing
//    }
//  }

  if (STATE != prevState) {
    Serial.print("CHECK Door1");
    prevState = STATE;
  }
}

void recieveHandler() {
   
  if (Serial.available()) {
    i = 0; //count reset;
    while ((tempChr = Serial.read()) != '\n') {
        inputData[i] = tempChr;
        i++;
    }
    inputData[i] = '\0';
    dataString = String(inputData);

    parseString(dataString);
    dataString = "";
  }
}

void parseString(String data) {
  
    if (data.indexOf("OPEN") != -1) {
      int pin = (int) (data.charAt(5) - '0');
      Serial.print("OPEN LED ");
      Serial.print(pin);
      digitalWrite(pin, LOW); // 共陽極因此LOW為LED亮
      STATE = true;
    }

    else if (data.indexOf("CLOSE") != -1) {
     int pin = (int) (data.charAt(6) - '0');
      Serial.print("CLOSE LED ");
      Serial.print(pin);
      digitalWrite(pin, HIGH);
      STATE = false;
    }
    else if (data.indexOf("BLINK") != -1) {
      int pin = (int) (data.charAt(6) - '0');
      for (int b = 0; b < 3; b++) {
        digitalWrite(pin, LOW);
        delay(200);
        digitalWrite(pin, HIGH);
        delay(200);
      }
    }else if (data.indexOf("ALERT") != -1) {
      int pin = (int) (data.charAt(6) - '0');
      for (int b = 0; b < 10; b++) {
        digitalWrite(pin, LOW);
        delay(200);
        digitalWrite(pin, HIGH);
        delay(200);
      }
    }
    else return;
}


