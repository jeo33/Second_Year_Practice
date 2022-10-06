#include "pwm.h"
void pwm_init_PD3(){
  DDRB |= (1 << DDB3);

  TCCR2A |= (1<<WGM20)|(1<<WGM21)|(0<<COM2A0)|(1<<COM2A1);
  TCCR2B |=(1<<CS20)|(0<<CS21)|(0<<CS22);
  
  }
void pwm_PD3_write(uint8_t val){
  OCR2A = val;        //set value into timer register
  }
