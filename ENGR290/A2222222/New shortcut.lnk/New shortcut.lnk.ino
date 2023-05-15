
#define F_CPU 8000000UL									/* Define CPU clock Frequency e.g. here its 8MHz */
#include <avr/io.h>										/* Include AVR std. library file */
#include <util/delay.h>									/* Include delay header file */
#include <inttypes.h>									/* Include integer type header file */
#include <stdlib.h>										/* Include standard library file */
#include <stdio.h>		
 #include <MPU6050_light.h>								/* Include standard library file */
#include "MPU6050_res_define.h"							/* Include MPU6050 register define file */
#include "I2C_Master_H_file.h"							/* Include I2C Master header file */
volatile double count;
 float ag[6] = {0,0,0,0,0,0}; 
 float dt_temp =0;
float Xa,Ya,Za,t;
float Xg=0,Yg=0,Zg=0;
float preInterval , Tnew;
float accXoffset ;
float accYoffset ;
float accZoffset ;
float gyroXoffset;
float gyroYoffset ;
float gyroZoffset ;
float rollangle_init,pitchangle_init,yawangle_init;
float rollangle_different,pitchangle_different,yawangle_different;
float rollangle_offset,pitchangle_offset,yawangle_offset;
float rollangle,pitchangle,yawangle;
float roll,pitch,yaw;
int16_t  Acc_x,Acc_y,Acc_z,Temperature,Gyro_x,Gyro_y,Gyro_z;
double dt;
  double P = 0.0;
  double Q = 0.001;
  double R = 0.03;
  double Pp, K;
void MPU6050_Init()										/* Gyro initialization function */
{
	_delay_ms(150);										/* Power up time >100ms */
	I2C_Start_Wait(0xD0);								/* Start with device write address */
	I2C_Write(SMPLRT_DIV);								/* Write to sample rate register */
	I2C_Write(0x07);									/* 1KHz sample rate */
	I2C_Stop();

	I2C_Start_Wait(0xD0);
	I2C_Write(PWR_MGMT_1);								/* Write to power management register */
	I2C_Write(0x01);									/* X axis gyroscope reference frequency */
	I2C_Stop();

	I2C_Start_Wait(0xD0);
	I2C_Write(CONFIG);									/* Write to Configuration register */
	I2C_Write(0x00);									/* Fs = 8KHz */
	I2C_Stop();

	I2C_Start_Wait(0xD0);
	I2C_Write(GYRO_CONFIG);								/* Write to Gyro configuration register */
	I2C_Write(0x18);									/* Full scale range +/- 2000 degree/C */
	I2C_Stop();

	I2C_Start_Wait(0xD0);
	I2C_Write(INT_ENABLE);								/* Write to interrupt enable register */
	I2C_Write(0x01);
	I2C_Stop();
}

void MPU_Start_Loc()
{
	I2C_Start_Wait(0xD0);								/* I2C start with device write address */
	I2C_Write(ACCEL_XOUT_H);							/* Write start location address from where to read */ 
	I2C_Repeated_Start(0xD1);							/* I2C start with device read address */
}

void Read_RawValue()
{ 
  
	MPU_Start_Loc();
/*
  uint8_t temp[2];	

  temp[0]=	I2C_Read_Ack();		
  temp[1]=	I2C_Read_Ack();						// Read Gyro values 
	Acc_x = (temp[0]<<8)|(temp[1]);

  temp[0]=	I2C_Read_Ack();		
  temp[1]=	I2C_Read_Ack();	
	Acc_y = (temp[0]<<8)|(temp[1]);

  temp[0]=	I2C_Read_Ack();		
  temp[1]=	I2C_Read_Ack();	
	Acc_z = (temp[0]<<8)|(temp[1]);

  temp[0]=	I2C_Read_Ack();		
  temp[1]=	I2C_Read_Ack();	
	Temperature = (temp[0]<<8)|(temp[1]);

  temp[0]=	I2C_Read_Ack();		
  temp[1]=	I2C_Read_Ack();	
	Gyro_x = (temp[0]<<8)|(temp[1]);

  temp[0]=	I2C_Read_Ack();		
  temp[1]=	I2C_Read_Ack();	
	Gyro_y = (temp[0]<<8)|(temp[1]);

  temp[0]=	I2C_Read_Ack();		
  temp[1]=	I2C_Read_Ack();	
	Gyro_z = (temp[0]<<8)|(temp[1]);
*/
  Acc_x = (((int)I2C_Read_Ack()<<8) | (int)I2C_Read_Ack());
	Acc_y = (((int)I2C_Read_Ack()<<8) | (int)I2C_Read_Ack());
	Acc_z = (((int)I2C_Read_Ack()<<8) | (int)I2C_Read_Ack());
	Temperature = (((int)I2C_Read_Ack()<<8) | (int)I2C_Read_Ack());
	Gyro_x = (((int)I2C_Read_Ack()<<8) | (int)I2C_Read_Ack());
	Gyro_y = (((int)I2C_Read_Ack()<<8) | (int)I2C_Read_Ack());
	Gyro_z = (((int)I2C_Read_Ack()<<8) | (int)I2C_Read_Nack());
  Serial.print("  read doen ");
	I2C_Stop();
}

int main()
{
	

  Serial.begin(9600);
	I2C_Init();											/* Initialize I2C */
	MPU6050_Init();										/* Initialize MPU6050 */
	timer_setup();




  void offSet();
  yawangle=0;
	while(1)
	{

    get_time(&dt);
		Read_RawValue();
 
		Xa = Acc_x/16384.0;								/* Divide raw value by sensitivity scale factor to get real values */
		Ya = Acc_y/16384.0;
		Za = Acc_z/16384.0;
		
		Xg = Gyro_x/16.4;
		Yg = Gyro_y/16.4;
		Zg = Gyro_z/16.4;

		t = (Temperature/340.00)+36.53;					/* Convert temperature in ?c using formula */
    rollangle_init=atan2(Ya,Za)*180/PI; // FORMULA FOUND ON INTERNET
    pitchangle_init=atan2(Xa,sqrt(Ya*Ya+Za*Za))*180/PI; //FORMULA FOUND ON INTERNET

    yawangle= atan2(Xa,Ya)*180/PI;
  
    //yawangle=yawangle+Zg*(dt);
    
    rollangle_offset = rollangle_init + dt*(Xg - gyroXoffset);
    pitchangle_offset = pitchangle_init + dt*(Yg - gyroYoffset);
    Pp = P+Q;
    
    rollangle=atan2(Ya,Za)*180/PI; // FORMULA FOUND ON INTERNET
    rollangle_different = rollangle - rollangle_offset;  
    pitchangle=atan2(Xa,sqrt(Ya*Ya+Za*Za))*180/PI; //FORMULA FOUND ON INTERNET
    pitchangle_different = pitchangle - pitchangle_offset;  

    K = Pp/(Pp+R);

    rollangle_init = rollangle_init + K*rollangle_different;
    pitchangle_init = pitchangle_init + K*pitchangle_different;
    P = (1-K)*Pp;

    

    Serial.println();
    Serial.print(" ROLL=");
    Serial.print(rollangle_init);
    Serial.print(" angle");
    Serial.print("    PITCH=");
    Serial.print(pitchangle_init);
    Serial.print("    Yaw=");
    Serial.print(yawangle);
    Serial.print("  Xa: ");
    Serial.print(Xa);
    Serial.print("    Ya: ");
    Serial.print(Ya);
    Serial.print("   Za: ");
    Serial.print(Za);
    Serial.print("   t: ");
    Serial.print(t);
    Serial.print("   Xg: ");
    Serial.print(Xg);
    Serial.print("   Yg: ");
    Serial.print(Yg);
    Serial.print("   Zg: ");
    Serial.print(Zg);
		
	}
}




void offSet()
{
  for(int i = 0; i < 20; i++){
    Read_RawValue();
   // 3*acc, 3*gyro
		Xa = Acc_x/16384.0;								/* Divide raw value by sensitivity scale factor to get real values */
		Ya = Acc_y/16384.0;
		Za = Acc_z/16384.0;
		
		Xg = Gyro_x/16.4;
		Yg = Gyro_y/16.4;
		Zg = Gyro_z/16.4;
    
    ag[0] += Xa;
    ag[1] += Ya;
    ag[2] += (Za-1.0);
    ag[3] += Xg;
    ag[4] += Yg;
    ag[5] += Zg;
	delay(1); // wait a little bit between 2 measurements
  }
  
  
    accXoffset = ag[0] / 20;
    accYoffset = ag[1] / 20;
    accZoffset = ag[2] / 20;

  

    gyroXoffset = ag[3] / 20;
    gyroYoffset = ag[4] / 20;
    gyroZoffset = ag[5] / 20;
  



}

void timer_setup(){
	TCCR1A = 0x00;
	TIMSK1 |= _BV(TOIE1);
	TCCR1B |= _BV(CS11);  
	TCCR1B &= ~( _BV(CS12)  | _BV(CS10)); // prescaler=8

}



void get_time(double * dt){
	cli();
		uint8_t l = TCNT1L;
		uint8_t h = TCNT1H;
		uint16_t step = h<<8 | l;
		*dt = (double)step*5e-7 + count*0.032768;
		count = 0;
	sei();
}


// timer 1 overflow interrupt handler
SIGNAL(TIMER1_OVF_vect){
	count += 1;
	//TCNT1H = 0x00;
	//TCNT1L = 0x00;

}
