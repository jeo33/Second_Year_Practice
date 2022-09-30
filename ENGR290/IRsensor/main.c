//ADC6 defined in adc.h
/*
 * main.c
 *
 * Created: 9/30/2022 5:08:27 PM
 *  Author: zsy11
 */ 

#define F_CPU 1600000UL
#include "xc.h"
#include "stdint.h"
#include "stdio.h"
#include "stdlib.h"
#include "avr/io.h"
#include "util/delay.h"
#include "avr/interrupt.h"
#include "uart.h"
#include "pwm.h"
#include "adc.h"

uint8_t print_buffer[64] = {0};
uint8_t sample, dist, duty;
uint16_t acc, filter; 
float distance;

int main(void)
{

  uint8_t convert = 0;
  pwm_init_PD3();
  DDRB|=(1<<PB5);
  uart_tx_init();
  adc_init(ADC_pin);
  sample=0;

  sei();
  //uart_send_string((uint8_t*)start);
 
    while (1) 
    {
		convert = adc_read();
		if(sample==0){acc=0;sample++;}
		if(sample<=4)
		{
			acc+= (uint16_t)convert;
			sample++;
		}
		if(sample>4)
		{
			filter=acc/4;
			sample=0;
			distance=1/(((((float)filter/(float)255)*3.54)-0.19)/21.84);
			
			dist=distance;
			
			if(dist<15){duty=0; PORTB|=(1<<PB5);
			}
			else if(dist>40){duty=255; PORTB|=(1<<PB5);}
			else {duty=((dist-15)*10); PORTB&=~(1<<PB5);}
			pwm_PD3_write(duty);
			uart_send_byte('A');
			uart_print_uint8(filter);
			uart_send_byte(32);
			uart_send_byte('D');
			uart_print_uint8(dist);
			uart_send_byte(10);

		} 
    }
}
