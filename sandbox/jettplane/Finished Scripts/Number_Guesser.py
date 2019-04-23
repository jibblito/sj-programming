import random
import time
import subprocess

max_guess = "string"
min_guess = "string"

while type(min_guess) != int:
    try:
        min_guess = input("What is the lowest number to guess from: ")
    except:
        TypeError

while type(max_guess) != int:
    try:
        max_guess = input("What is the highest number to guess from: ")
    except:
        TypeError

number_guesses = 0

number = random.randint(min_guess, max_guess)
user_guess = "string"

while number != user_guess:
    user_guess = "string"
    print("Enter a number from " + str(min_guess) + " to " + str(max_guess))
    while type(user_guess) != int:
        try:
            user_guess = input("Your guess: ")
        except:
            ValueError
    number_guesses = number_guesses + 1
    if number != user_guess:
        if number > user_guess:
            print("Too low!")
        else:
            print("Too high!")

print("Yay you got it right! It only took " + str(number_guesses) + " guesses!")
time.sleep(3)

