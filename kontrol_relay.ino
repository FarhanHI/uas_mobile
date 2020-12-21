#include <ESP8266WiFi.h>
#include <FirebaseArduino.h>

#define FIREBASE_HOST "kontrolrelay-f7a7e-default-rtdb.firebaseio.com"
#define FIREBASE_AUTH "D1smX6RXTxS3Yun4yNCEFt5If1a6cvKZZ4C8ngMF"
#define WIFI_SSID "Wifi.id"
#define WIFI_PASSWORD "cappucino"

int relay = 5;//D1
int relay2 = 4;//D2
int relay3 = 0;//D3

void setup() {
  Serial.begin(9600);

  //Menyambungkan ke wifi
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("Menghubungkan...");
  while (WiFi.status()!=WL_CONNECTED){
    Serial.print(".");
    delay(500);
  }
  Serial.println();
  Serial.print("Tersambung ke:");
  Serial.print(WiFi.localIP());

 pinMode(relay, OUTPUT);
 pinMode(relay2, OUTPUT);
 pinMode(relay3, OUTPUT);

  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
  Firebase.set("STATUS_LAMPU",0);
  Firebase.set("STATUS_AC",0);
  Firebase.set("STATUS_DESKTOP",0);
}
int n = 0;
int a = 0;
int c = 0;

void loop() {
  n = Firebase.getInt("STATUS_LAMPU");
  a = Firebase.getInt("STATUS_AC");
  c = Firebase.getInt("STATUS_DESKTOP");

  //KONDISI
  if(n==1){
    Serial.print("Lampu Menyala");
    digitalWrite(relay, HIGH);
    delay(1000);
  }else{
    Serial.print("Lampu Padam");
    digitalWrite(relay, LOW);
  }
  if(a==1){
    Serial.print("AC Menyala");
    digitalWrite(relay, HIGH);
    delay(2000);
  }else{
    Serial.print("AC Padam");
    digitalWrite(relay2, LOW);
  }

    if(c==1){
    Serial.print("Komputer Menyala");
    digitalWrite(relay, HIGH);
    delay(3000);
  }else{
    Serial.print("Komputer Padam");
    digitalWrite(relay2, LOW);
  }

}
