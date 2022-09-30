/*
 * main.c
 *
 * Created: 9/30/2022 5:49:08 PM
 *  Author: zsy11
 */ 
#define F_CPU 16000000UL

#include <xc.h>
#include "stdint.h"
#include "stdio.h"
#include "stdlib.h"
#include "avr/io.h"
#include "util/delay.h"
#include "avr/interrupt.h"
//PWM LED PD3/D3:   US echo PD2/D2 and trigger PB3/D11
#include "pwm.h"
#include "uart.h"

volatile unsigned short impulse;


// Port Initialization
void Port_Init()
{

	
	DDRB|=(1<<DDB3)|(1<<DDB5); //set trigger pin
	
	EIMSK |= (1<<INT0); //enable external interrupt
	EICRA |= (1<<ISC00); // Any logical change on INT0 generates an interrupt request.

	//Config and enable Timer1
	TCCR1B = (0<<CS12)|(1<<CS11)|(1<<CS10);
}

ISR( INT0_vect )
{
	
	if(PIND & (1 << 2)) {TCNT1 = 0;}/* Clear Timer counter */
	else  {impulse = TCNT1;}
	

}

unsigned char us_read( void )
{
	
	impulse = 0;
	
	// transmit at least 10 us trigger pulse to the HC-SR04 Trig Pin.
	PORTB |=  (1<<DDB3);
	_delay_us( 10 );
	PORTB &= ~(1<<DDB3);


	while( impulse == 0 );
	
	if (impulse<3700) {return 0.000004 * impulse/2 * 34300;} else {return 255;}
	
}


int main(void){
	uint8_t dist, duty,a,b,c;
	pwm_init_PD3();
	Port_Init();
	uart_tx_init();
	sei();
	
	while(true){
		dist = us_read();
		_delay_ms(10);
		if(dist<15){duty=0; PORTB|=(1<<DDB5);}
		else if(dist>40){duty=255; PORTB|=(1<<DDB5);}
		else {duty=((dist-15)*10); PORTB&=~(1<<DDB5);}
		pwm_PD3_write(duty);




		if(dist>=100)
		{
			a=dist/100;
			b=dist/10-10*a;
			c=dist%10;
			uart_send_byte(a+48);
			uart_send_byte(b+48);
			uart_send_byte(c+48);
			uart_send_byte(10);
		}
		else if(dist>=10)
		{
			b=dist/10;
			c=dist%10;
			uart_send_byte(b+48);
			uart_send_byte(c+48);
			uart_send_byte(10);
		}
		else
		{
			c=dist;
			uart_send_byte(c+48);
			uart_send_byte(10);
		}

		
	}

	
}
