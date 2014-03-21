import webiopi  #import de la librairie webiopi
import datetime #import de l'heure

GPIO = webiopi.GPIO

CAFETIEREPI = 24 # GPIO pin using BCM numbering

HOUR_ON  = 8  # Turn CafetierePi ON at 08:00
HOUR_OFF = 18 # Turn CafetierePi OFF at 18:00

MINUTE_ON = 8
MINUTE_OFF = 18

# setup function is automatically called at WebIOPi startup
def setup():
    # set the GPIO used by the CafetierePi to output
    GPIO.setFunction(CAFETIEREPI, GPIO.OUT)

    # retrieve current datetime
    now = datetime.datetime.now()

    # test if we are between ON time and tun the CafetierePi ON
    if ((now.hour >= HOUR_ON) and (now.hour < HOUR_OFF)):
        if((now.minute >= MINUTE_ON) and (now.minute < MINUTE_OFF)):
            GPIO.digitalWrite(CAFETIEREPI, GPIO.HIGH) 

# loop function is repeatedly called by WebIOPi 
def loop():
    # retrieve current datetime
    now = datetime.datetime.now()

    # toggle CafetierePi ON all days at the correct time
    if ((now.hour == HOUR_ON) and (now.minute == MINUTE_ON ) and (now.second == 0)):
        if (GPIO.digitalRead(CAFETIEREPI) == GPIO.LOW):
            GPIO.digitalWrite(CAFETIEREPI, GPIO.HIGH)

    # toggle CafetierePi OFF
    if ((now.hour == HOUR_OFF) and (now.minute == MINUTE_OFF) and (now.second == 0)):
        if (GPIO.digitalRead(CAFETIEREPI) == GPIO.HIGH):
            GPIO.digitalWrite(CAFETIEREPI, GPIO.LOW)

    # gives CPU some time before looping again
    webiopi.sleep(1)

# destroy function is called at WebIOPi shutdown
def destroy():
    GPIO.digitalWrite(CAFETIEREPI, GPIO.LOW)

@webiopi.macro
def getCafetierePiHours():
    return "%d;%d" % (HOUR_ON, HOUR_OFF)
    
@webiopi.macro
def getCafetierePiMinutes():
    return "%d;%d" % (MINUTE_ON, MINUTE_OFF)

@webiopi.macro
def setCafetierePiHours(on, off):
    global HOUR_ON, HOUR_OFF
    HOUR_ON = int(on)
    HOUR_OFF = int(off)
    return getCafetierePiHours()
    
@webiopi.macro
def setCafetierePiMinutes(on, off):
    global MINUTE_ON, MINUTE_OFF
    MINUTE_ON = int(on)
    MINUTE_OFF = int(off)
    return getCafetierePiMinutes()    
