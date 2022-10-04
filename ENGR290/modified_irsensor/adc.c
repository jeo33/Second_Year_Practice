#include "adc.h"

volatile static uint8_t adc_read_done = 1;
uint8_t adch = 0;

ISR(ADC_vect){
  adc_read_done = 1;
}

void adc_init(uint8_t pin){
  ADMUX |= 0b00 << REFS0;      //setting to external internal(01)/external(00)reference
  ADMUX|=(1<<ADLAR);           //Left Adjusted Result for 8 bit resolution
  ADCSRA |= 1 << ADEN | 1 << ADIE | 0b111 << ADPS0;  //enable ADC, ADC interrupt, set division factor to 128
  DIDR0 |= 1 << pin;           //disable digital input on ADC pin to be read
  ADMUX |= pin;                
}




uint8_t adc_read(void){
  
  adc_read_done = 0;
  ADCSRA |= 1 << ADSC;
  while(adc_read_done == 0);
  
  adch = ADCH;
  
  return (adch);
  
  
}
