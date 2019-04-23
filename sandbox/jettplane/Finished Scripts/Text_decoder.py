import random
import time
import os

lines_read = 0
char_counter = 0
number_message = ""
read_through = 0
letter_message = ""

num_to_letter = {'0':' ', '1':'a', '2':'b', '3':'c', '4':'d', '5':'e', '6':'f', '7':'g', '8':'h', '9':'i', '10':'j', '11':'k', '12':'l', '13':'m', '14':'n', '15':'o', '16':'p', '17':'q', '18':'r', '19':'s', '20':'t', '21':'u', '22':'v', '23':'w', '24':'x', '25':'y', '26':'z'}

try:
    key_file_reader = open("key_file.txt", "r")
except:
        print("Cannot find file. Make sure it is titled 'key_file' and is in the folder with the script.")
        time.sleep(10)
        exit()
print("\nKey File Found...\n")
time.sleep(1)
try:
    coded_message_reader = open("coded_message.txt", "r")
except:
        print("Cannot find file. Make sure it is titled 'codede_messsage' and is in the folder with the script.")
        time.sleep(10)
        exit()
print("Message Found...\n")
time.sleep(1)
print("Starting De-encryption...\n")
key_list = {}

read = key_file_reader.readlines()

while lines_read < 10:
    key_list[int(read[lines_read][:1])] = int(read[lines_read][1:3])
    lines_read = lines_read + 1
while lines_read < 27:
    key_list[int(read[lines_read][:2])] = int(read[lines_read][2:4])
    lines_read = lines_read + 1

key_file_reader.close()

coded_message = coded_message_reader.read()

while (len(coded_message) / 2) > ((char_counter / 2) - 2):
    while read_through < 28:
        letter = (coded_message[char_counter:(char_counter + 2)])
        try:
            letter = int(letter)
        except:
            break
        if int(letter) == key_list[read_through]:
            number_message = number_message + str(read_through) + ","
            break
        else:
            read_through = read_through + 1
    read_through = 0
    char_counter = char_counter + 2

number_message = number_message[:(len(number_message) - 1)]

number_message = number_message.split(',')

for num in number_message:
    letter_message = letter_message + num_to_letter[num]

decoded_message_writer = open("decoded_message.txt", "w")

decoded_message_writer.write(letter_message)

decoded_message_writer.close()

print("De-encryption complete! Your message is in decoded_message.txt")
time.sleep(3)

os.system("decoded_message.txt")



