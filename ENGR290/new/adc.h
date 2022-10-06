
#include <stdint.h>
#include <avr/io.h>
#include <util/delay.h>
#include <avr/interrupt.h>

#define ADC_pin 6


#ifdef __cplusplus //because c++ compile
 extern "C" {      // 
#endif             //until here


void adc_init(uint8_t pin);
uint8_t adc_read(void);

#ifdef __cplusplus    //end of c++ directive for C
}                     //
#endif                //until here
