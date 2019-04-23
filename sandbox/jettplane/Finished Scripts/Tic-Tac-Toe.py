

import time

class player():
    symbol = " "

    def play(self):
        global turn
        global places_list
        a = True
        while a:
            placement = input("Where would you like to go: ")
            if placement.lower() == "exit":
                exit()
            try:
                if int(placement) == int(placement):
                    a = False
            except:
                print("Please Enter a Number")
                time.sleep(3)
        counter = -1
        if int(placement) < 10 and int(placement) > 0:
            for place in places_list:
                counter += 1
                if placement == place:
                    places_list[counter] = self.symbol
                    turn += 1
        else:
            print("Please enter a number 1-9")
            time.sleep(3)

    def check_win(self):
        global place_1
        global place_2
        global place_3
        global place_4
        global place_5
        global place_6
        global place_7
        global place_8
        global place_9
        global places_list
        if  player.check_row(place_1, place_2, place_3):
            print(place_1 + "'s Wins!")
            player.win_end()
        elif  player.check_row(place_4, place_5, place_6):
            print(place_4 + "'s Wins!")
            player.win_end()
        elif  player.check_row(place_7, place_8, place_9):
            print(place_7 + "'s Wins!")
            player.win_end()
        elif  player.check_row(place_1, place_5, place_9):
            print(place_1 + "'s Wins!")
            player.win_end()
        elif  player.check_row(place_1, place_4, place_7):
            print(place_1 + "'s Wins!")
            player.win_end()
        elif  player.check_row(place_7, place_5, place_3):
            print(place_7 + "'s Wins!")
            player.win_end()
        elif  player.check_row(place_2, place_5, place_8):
            print(place_2 + "'s Wins!")
            player.win_end()
        elif  player.check_row(place_3, place_6, place_9):
            print(place_3 + "'s Wins!")
            player.win_end()

    def check_row(p1, p2, p3):
        if p1 == p2 and p1 == p3:
            return True

    def win_end():
        global winner
        #time.sleep(3)
        winner = True


class Board():
    def print_board(self):
        print("\n\n\n\n\n\n\n\n\n\n " + place_1 + " | " + place_2 + " | " + place_3 + " ")
        print("-----------")
        print(" " + place_4 + " | " + place_5 + " | " + place_6 + " ")
        print("-----------")
        print(" " + place_7 + " | " + place_8 + " | " + place_9 + " \n\n")

    def set_board(self):
        global place_1
        global place_2
        global place_3
        global place_4
        global place_5
        global place_6
        global place_7
        global place_8
        global place_9
        global places_list
        place_1 = str(places_list[0:1])[2:3]
        place_2 = str(places_list[1:2])[2:3]
        place_3 = str(places_list[2:3])[2:3]
        place_4 = str(places_list[3:4])[2:3]
        place_5 = str(places_list[4:5])[2:3]
        place_6 = str(places_list[5:6])[2:3]
        place_7 = str(places_list[6:7])[2:3]
        place_8 = str(places_list[7:8])[2:3]
        place_9 = str(places_list[8:9])[2:3]




board = Board()

player_1 = player()
player_1.symbol = "O"
player_2 = player()
player_2.symbol = "X"

places_list = ['1', '2', '3', '4', '5', '6', '7', '8', '9']

new_game_list = ['1', '2', '3', '4', '5', '6', '7', '8', '9']

place_1 = str(places_list[0:1])[2:3]
place_2 = str(places_list[1:2])[2:3]
place_3 = str(places_list[2:3])[2:3]
place_4 = str(places_list[3:4])[2:3]
place_5 = str(places_list[4:5])[2:3]
place_6 = str(places_list[5:6])[2:3]
place_7 = str(places_list[6:7])[2:3]
place_8 = str(places_list[7:8])[2:3]
place_9 = str(places_list[8:9])[2:3]

turn = 1

winner = False



while turn < 10:
    while turn < 10 and winner == False:
        board.set_board()
        board.print_board()
        player_1.check_win()

        if winner == False:
            if turn % 2 == 1:
                print("It Is Player One's Turn! ")
                player_1.play()

            else:
                print("It Is Player Two's Turn! ")
                player_2.play()

    board.set_board()
    board.print_board()
    player_1.check_win()

    if winner == False:
        print("It's A Draw! Good Game!")

    play_again = input("Would you like to play again? [y/n]: ")
    if play_again.lower() == "y":
        turn = 1
        winner = False
        places_list = new_game_list
    else:
        print("Thank you for playing!")
        time.sleep(3)
        exit()

