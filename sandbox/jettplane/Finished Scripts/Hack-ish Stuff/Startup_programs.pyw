from pynput.keyboard import Key, Controller
import time

keyboard = Controller()

keyboard.press(Key.cmd)
keyboard.press('r')
keyboard.release('r')
keyboard.release(Key.cmd)
time.sleep(.2)
keyboard.type('shell:startup')
keyboard.press(Key.enter)
keyboard.release(Key.enter)


