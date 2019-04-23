
import random
import time
import os


message = raw_input("Enter your message: ")
message = message.lower()
final_message = ""
lines_read = 0
replace = {' ':0, 'a':1, 'b':2, 'c':3, 'd':4, 'e':5, 'f':6, 'g':7, 'h':8, 'i':9, 'j':10, 'k':11, 'l':12, 'm':13, 'n':14, 'o':15, 'p':16, 'q':17, 'r':18, 's':19, 't':20, 'u':21, 'v':22, 'w':23, 'x':24, 'y':25, 'z':26}

have_code = raw_input("Do you have a key file that you would like to use? [y/n]")

if have_code.lower() == 'n':
    keys_made = 0

    key_list = {0:0}
    while keys_made < 27:
        key = random.randint(10,99)
        for value in key_list.values():
            if key == value:
                key += 1
        key_list[keys_made] = key
        keys_made += 1

    for char in message:
            temp = replace[char]
            final_message = final_message + str(key_list[temp])

    key_file = open("key_file.txt", "w")
    key_file.close()
    key_file = open("key_file.txt", "a")
    for key in key_list:
        key_file.write(str(key) + "" + str(key_list[key]) + "\n")
    key_file.close()
    output = open("coded_message.txt", "w")
    output.write(final_message)
    output.close()
    print("Your coded message is in the file 'coded_message.txt'! Thank you for using Jett's Encoder")
    time.sleep(3)

elif have_code.lower() == 'y':
        try:
            key_file = open("key_file.txt", "r")
        except:
            print("Cannot find file. Make sure it is titled 'key_file' and is in the folder with the script.")
            time.sleep(10)
            exit()
        key_list = {}

        read = key_file.readlines()

        while lines_read < 9:
            key_list[int(read[lines_read][:1])] = int(read[lines_read][1:3])
            lines_read = lines_read + 1
        while lines_read < 27:
            key_list[int(read[lines_read][:2])] = int(read[lines_read][2:4])
            lines_read = lines_read + 1

        key_file.close()
        print(key_list)
        for char in message:
            temp = replace[char]
            final_message = final_message + str(key_list[temp])
        output = open("coded_message.txt", "w")
        output.write(final_message)
        output.close()
        print("Your coded message is in the file 'coded_message.txt'! Thank you for using Jett's Encoder")
        time.sleep(3)

os.system("coded_message.txt")