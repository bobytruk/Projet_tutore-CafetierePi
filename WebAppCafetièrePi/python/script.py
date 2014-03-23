import webiopi  #import de la librairie webiopi
import datetime #import de l'heure

GPIO = webiopi.GPIO

CAFETIEREPI = 24 # broche GPIO utilisant la numerotation BCM

HOUR_ON  = 0 # Heure d'allumage de la CafetierePi
HOUR_OFF = 0 # Heure d'extinction de la CafetierePi 

MINUTE_ON  = 0 # Minute d'allumage de la CafetierePi
MINUTE_OFF = 0 # Minute d'extinction de la CafetierePi

# Fonction de parametrage automatiquement applée au démarage de WebIOPi
def setup():
    # Configuration du GPIO utilisé par la CafetierePi en sortie
    GPIO.setFunction(CAFETIEREPI, GPIO.OUT)

    # Récupération de l'heure courante
    #now = datetime.datetime.now()

# La fonction loop est appellée répétitivement pae WebIOPi 
def loop():
    # Récupération de l'heure courante
    now = datetime.datetime.now()

    # Allumer la CafetierePi tous les jours à l'heure correcte
    if ((now.hour == HOUR_ON) and (now.minute == MINUTE_ON ) and (now.second == 0)):
        if (GPIO.digitalRead(CAFETIEREPI) == GPIO.LOW):
            GPIO.digitalWrite(CAFETIEREPI, GPIO.HIGH)

    # Eteindre la CafetierePi tous les jours à l'heure correcte
    if ((now.hour == HOUR_OFF) and (now.minute == MINUTE_OFF) and (now.second == 0)):
        if (GPIO.digitalRead(CAFETIEREPI) == GPIO.HIGH):
            GPIO.digitalWrite(CAFETIEREPI, GPIO.LOW)

    # Donne au CPU du temps avant de boucler à nouveau
    webiopi.sleep(1)

# La fonction destroy est appelée lors de l'arret de WebIOPi
def destroy():
    GPIO.digitalWrite(CAFETIEREPI, GPIO.LOW)

# Fonction macro permettant d'extraire les heures paramétrées et de les placer dans des variables
@webiopi.macro
def getCafetierePiHours():
    return "%d;%d" % (HOUR_ON, HOUR_OFF)
    
# Même chose pour les minutes    
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
