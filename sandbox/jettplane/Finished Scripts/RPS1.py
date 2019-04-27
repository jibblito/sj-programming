import random
import time

player_score = 0
computer_score = 0
games_played = 0
player_guess_number = 0

print("Welcom to RPS! You know how to play...\n")

while True:
    print("\n\nGames Played: " + str(games_played))

    print("Player: " + str(player_score) + " Computer: " + str(computer_score) + "\n\n")

    player_guess = input("Enter your guess. Type 'exit' to quit: ")

    if player_guess == "rock" or player_guess == "r":
        player_guess_number = 1


    elif player_guess == "paper" or player_guess == "p":
        player_guess_number = 2


    elif player_guess == "scissors" or player_guess == "scissor" or player_guess == "s":
        player_guess_number = 3

    elif player_guess == "exit":
        break

    else:
        print("Command not found. Please try again")

    if player_guess_number != 0:
        computer_guess = random.randint(1,3)
        if computer_guess == player_guess_number:
            print("Tie!")
            player_guess_number = 0
            games_played += 1
        elif computer_guess == 3 and player_guess_number == 1:
            print("You win!")
            player_guess_number = 0
            games_played += 1
            player_score += 1
        elif computer_guess == 3 and player_guess_number == 2:
            print("You lose...")
            player_guess_number = 0
            games_played += 1
            computer_score += 1
        elif computer_guess == 2 and player_guess_number == 1:
            print("You lose...")
            player_guess_number = 0
            games_played += 1
            computer_score += 1
        elif computer_guess == 2 and player_guess_number == 3:
            print("You win!")
            player_guess_number = 0
            games_played += 1
            player_score += 1
        elif computer_guess == 1 and player_guess_number == 2:
            print("You win!")
            player_guess_number = 0
            games_played += 1
            player_score += 1
        elif computer_guess == 1 and player_guess_number == 3:
            print("You lose...")
            player_guess_number = 0
            games_played += 1
            computer_score += 1