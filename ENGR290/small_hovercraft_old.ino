
#include "I2Cdev.h"
#include<Servo.h>
#include "MPU6050_6Axis_MotionApps20.h"

// is used in I2Cdev.h
#if I2CDEV_IMPLEMENTATION == I2CDEV_ARDUINO_WIRE
#include "Wire.h"
#endif
#define echoPin1 8 // attach pin D2 Arduino to pin Echo of HC-SR04
#define trigPin1 12


Servo myservo;  // create servo object to control a servo
int val;    // variable to read the value from the analog pin
int degree;    // variable to read the value from the analog pin
int LiftFanPin = 6;    // LED connected to digital pin 9
int BackFanPin = 5;    // LED connected to digital pin 9
int dir=0;
int flag1=0;
int flag2=0;
int flag4=0;

int period = 100;
unsigned long time_now = 0;

long duration1; // variable for the duration of sound wave travel
int distance_front; 
int distance_front1;

MPU6050 mpu;


#define INTERRUPT_PIN 2  // use pin 2 on Arduino Uno & most boards
#define LED_PIN 13 // (Arduino is 13, Teensy is 11, Teensy++ is 6)


// MPU control/status vars
bool dmpReady = false;  // set true if DMP init was successful
uint8_t mpuIntStatus;   // holds actual interrupt status byte from MPU
uint8_t devStatus;      // return status after each device operation (0 = success, !0 = error)
uint16_t packetSize;    // expected DMP packet size (default is 42 bytes)
uint16_t fifoCount;     // count of all bytes currently in FIFO
uint8_t fifoBuffer[64]; // FIFO storage buffer

// orientation/motion vars
Quaternion q;           // [w, x, y, z]         quaternion container
VectorInt16 aa;         // [x, y, z]            accel sensor measurements
VectorInt16 aaReal;     // [x, y, z]            gravity-free accel sensor measurements
VectorInt16 aaWorld;    // [x, y, z]            world-frame accel sensor measurements
VectorFloat gravity;    // [x, y, z]            gravity vector
float euler[3];         // [psi, theta, phi]    Euler angle container
float ypr[3];           // [yaw, pitch, roll]   yaw/pitch/roll container and gravity vector
int flag=0;
int yaw;



// ================================================================
// ===               INTERRUPT DETECTION ROUTINE                ===
// ================================================================

volatile bool mpuInterrupt = false;     // indicates whether MPU interrupt pin has gone high
void dmpDataReady() {
    mpuInterrupt = true;
}


void setup() {

   
  
    // join I2C bus (I2Cdev library doesn't do this automatically)
    #if I2CDEV_IMPLEMENTATION == I2CDEV_ARDUINO_WIRE
        Wire.begin();
        Wire.setClock(400000); // 400kHz I2C clock. Comment this line if having compilation difficulties
    #elif I2CDEV_IMPLEMENTATION == I2CDEV_BUILTIN_FASTWIRE
        Fastwire::setup(400, true);
    #endif

    // initialize serial communication
    // (115200 chosen because it is required for Teapot Demo output, but it's
    // really up to you depending on your project)
    Serial.begin(9600);
    while (!Serial); 

    Serial.println(F("Initializing I2C devices..."));
    mpu.initialize();
    pinMode(INTERRUPT_PIN, INPUT);

    // verify connection
    Serial.println(F("Testing device connections..."));
    Serial.println(mpu.testConnection() ? F("MPU6050 connection successful") : F("MPU6050 connection failed"));


    // load and configure the DMP
    Serial.println(F("Initializing DMP..."));
    devStatus = mpu.dmpInitialize();

    // supply your own gyro offsets here, scaled for min sensitivity
    mpu.setXGyroOffset(4);
    mpu.setYGyroOffset(-3);
    mpu.setZGyroOffset(-24);
    mpu.setZAccelOffset(491); // 1688 factory default for my test chip

    // make sure it worked (returns 0 if so)
    if (devStatus == 0) {
        // Calibration Time: generate offsets and calibrate our MPU6050
        mpu.CalibrateAccel(6);
        mpu.CalibrateGyro(6);
        mpu.PrintActiveOffsets();
        // turn on the DMP, now that it's ready
        Serial.println(F("Enabling DMP..."));
        mpu.setDMPEnabled(true);

        // enable Arduino interrupt detection
        Serial.print(F("Enabling interrupt detection (Arduino external interrupt "));
        Serial.print(digitalPinToInterrupt(INTERRUPT_PIN));
        Serial.println(F(")..."));
        attachInterrupt(digitalPinToInterrupt(INTERRUPT_PIN), dmpDataReady, RISING);
        mpuIntStatus = mpu.getIntStatus();

        // set our DMP Ready flag so the main loop() function knows it's okay to use it
        Serial.println(F("DMP ready! Waiting for first interrupt..."));
        dmpReady = true;

        // get expected DMP packet size for later comparison
        packetSize = mpu.dmpGetFIFOPacketSize();
    } else {
        // ERROR!
        // 1 = initial memory load failed
        // 2 = DMP configuration updates failed
        // (if it's going to break, usually the code will be 1)
        Serial.print(F("DMP Initialization failed (code "));
        Serial.print(devStatus);
        Serial.println(F(")"));
    }

    Wire.setWireTimeout(3000, true);
     pinMode(trigPin1, OUTPUT); // Sets the trigPin as an OUTPUT
      pinMode(echoPin1, INPUT); // Sets the echoPin as an INPUT
    delay(1000);
   myservo.attach(9); 
}





void loop() {

    if(dir==0){yaw=ypr[0] * 180/M_PI;}          //straight
  
  else if(dir==1){
                  yaw=ypr[0] * 180/M_PI+90;
                  if(yaw>180){yaw=yaw-360;}
                 } //left
                  
  else if(dir==3){
                  yaw=ypr[0] * 180/M_PI-90;
                  if(yaw<-180){yaw=yaw+360;}
                  }  //right
                  
  else if(dir==2){
                  yaw=ypr[0] * 180/M_PI;
                  if(yaw<0){yaw=yaw+180;}
                  else{yaw=yaw-180;}
                 }  //back
                 
    degree=90-yaw;
    myservo.write(degree);
    
    if(flag2==1){delay(1000);flag2=0;} 

  
    if(millis() >= time_now + period){
        time_now += period;
         digitalWrite(trigPin1, LOW);
         delayMicroseconds(2);
         digitalWrite(trigPin1, HIGH);
         delayMicroseconds(10);
         digitalWrite(trigPin1, LOW);
         duration1 = pulseIn(echoPin1, HIGH);
         distance_front1 = duration1 * 0.034 / 2;
         if(distance_front1<51){
          digitalWrite(trigPin1, LOW);
         delayMicroseconds(2);
         digitalWrite(trigPin1, HIGH);
         delayMicroseconds(10);
         digitalWrite(trigPin1, LOW);
         duration1 = pulseIn(echoPin1, HIGH);
         distance_front = duration1 * 0.034 / 2;}else{distance_front=distance_front1;}
         }

      if(yaw<80 & yaw>-85){flag4=1;}else{flag4=0;}
      
      if(distance_front<=50&flag4==1){
           analogWrite(LiftFanPin, 0);
           analogWrite(BackFanPin,0);
            delay(3000);
            flag1=1;
        }
  
    if (!dmpReady) return;
    // read a packet from FIFO
    if (mpu.dmpGetCurrentFIFOPacket(fifoBuffer)) { // Get the Latest packet 

            mpu.dmpGetQuaternion(&q, fifoBuffer);
            mpu.dmpGetGravity(&gravity, &q);
            mpu.dmpGetYawPitchRoll(ypr, &q, &gravity);
             
    }
    

  if(dir==0){yaw=ypr[0] * 180/M_PI;}          //straight
  
  else if(dir==1){
                  yaw=ypr[0] * 180/M_PI+90;
                  if(yaw>180){yaw=yaw-360;}
                 } //left
                  
  else if(dir==3){
                  yaw=ypr[0] * 180/M_PI-90;
                  if(yaw<-180){yaw=yaw+360;}
                  }  //right
                  
  else if(dir==2){
                  yaw=ypr[0] * 180/M_PI;
                  if(yaw<0){yaw=yaw+180;}
                  else{yaw=yaw-180;}
                 }
  degree=90-yaw;
                

  if(flag==0){
              delay(1500);
              analogWrite(LiftFanPin, 250);  
              analogWrite(BackFanPin, 204);     
              flag=1;
             }
     
         

        
  if(distance_front<=50&flag1==1&flag4==1){

          if(yaw>=0){ myservo.write(degree+90);}
          else{myservo.write(degree-90);}
          delay(1500);

          digitalWrite(trigPin1, LOW);
          delayMicroseconds(2);
          digitalWrite(trigPin1, HIGH);
          delayMicroseconds(10);
          digitalWrite(trigPin1, LOW);
          duration1 = pulseIn(echoPin1, HIGH);
          distance_front = duration1 * 0.034 / 2;

         if(yaw>=0){    
                    if(distance_front>=50){dir=(dir-1+4);}
                    else{dir=dir+1;}
                  
        }else{   
                    if(distance_front<=50){dir=(dir-1+4);}
                    else{dir=dir+1;}
             }
             
        dir=dir%4;
        flag=0; 
        flag1=0; 
        flag2=1;  
        }
        
}
