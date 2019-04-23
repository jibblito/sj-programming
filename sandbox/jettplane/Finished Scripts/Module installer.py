import subprocess
import time
from pynput.keyboard import Key, Controller

keyboard = Controller()

module = input('What module do you want: ')

subprocess.Popen("cmd")
time.sleep(.5)
keyboard.type('python -m pip install ' + module)
keyboard.press(Key.enter)
keyboard.release(Key.enter)
time.sleep(10)
keyboard.type('exit')
keyboard.press(Key.enter)
keyboard.release(Key.enter)
print("\n\nYou have installed " + module)
time.sleep(3)
