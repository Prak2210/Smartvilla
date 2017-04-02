import paho.mqtt.client as mqtt
import RPi.GPIO as GPIO ## Import GPIO library
from threading import Thread
from gpiozero import LED
import os
import glob
import time
l=LED(21)
k=LED(10)
v=LED(11)
fan=LED(17)
buzz=LED(16)
P_LED = 21
fPWM = 50
os.system('modprobe w1-gpio')
os.system('modprobe w1-therm')
 
base_dir = '/sys/bus/w1/devices/'
device_folder = glob.glob(base_dir + '28*')[0]
device_file = device_folder + '/w1_slave'
 

global pwm
pwm = GPIO.PWM(P_LED, fPWM)
pwm1 = GPIO.PWM(17, fPWM)
pwm.start(0)
pwm1.start(0)

def setup():
    print(" ")
    
def read_temp_raw():
    f = open(device_file, 'r')
    lines = f.readlines()
    f.close()
    return lines
 
def read_temp():
    lines = read_temp_raw()
    while lines[0].strip()[-3:] != 'YES':
        time.sleep(0.2)
        lines = read_temp_raw()
    equals_pos = lines[1].find('t=')
    if equals_pos != -1:
        temp_string = lines[1][equals_pos+2:]
        temp_c = float(temp_string) / 1000.0
        client.publish("temp1",temp_c);
        if(temp_c>25):
            '''buzz.on()
            time.sleep(5)
            buzz.off()
            time.sleep(5)
            buzz.on()
            time.sleep(5)'''
            buzz.off()
        return temp_c
    
            







ledstate = None

      
def on_message(client, userdata, msg):
    print(msg.topic+" "+str(msg.payload))
    ledstate = str(msg.payload)  
    if ledstate == 'fon':
        pwm.ChangeDutyCycle(100)
        k.on()
    elif ledstate =='foff':
        pwm.ChangeDutyCycle(0)
        k.off()
    elif ledstate=='on':
        pwm1.ChangeDutyCycle(100)
        v.on()
    elif ledstate=='off':
        pwm1.ChangeDutyCycle(0)
        v.off()
    elif ledstate=='beam1':
        pwm1.ChangeDutyCycle(50)
    elif ledstate=='beam':
        print(read_temp())
    elif ledstate=='f10':
        pwm.ChangeDutyCycle(10)
    elif ledstate=='f40':
        pwm.ChangeDutyCycle(40)
    elif ledstate=='f70':
        pwm.ChangeDutyCycle(70)
 
def click():
    os.system("fswebcam event.jpg")
    f = open("event.jpg","rb")
    imagestring = f.read()
    byteArray = bytearray(imagestring)
    client.publish("imagesub", byteArray ,0)
    os.system("rm event.jpg")
    print("Published")        
    
        
    
def on_connect(client, userdata, flags, rc):
    print("Connected with result code "+str(rc))
    client.subscribe("fan",0);
    client.subscribe("light",1);
    client.subscribe("temp",2);
    
    
    
client = mqtt.Client("intelsmartparkinghhfkhsjdfjsgdhghhfh")
client.publish("Hi","hello");
client.on_connect = on_connect
client.on_message = on_message

client.connect("iot.eclipse.org", 1883, 6000)   # MQTT Connection to the broker at iot.eclipse.org

def temploop():
    while 1:
        print(read_temp())
        time.sleep(3)


bt=Thread(target=temploop,args=())
bt.start()
client.loop_forever()





