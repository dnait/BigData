#!/usr/bin/env python


from operator import itemgetter
import sys

current_word = None
current_count = 0
word = None

#input comes from STDIN
for line in sys.stdin:
    line = line.strip()

    #parse the input we got from mapper.py
    word, count = line.split('\t', 1)

    #convert count into an int
    try:
        count = int(count)
    except ValueError:
        #Keep silent when count is not a number
        continue

    #This IF-Switch only works because Hadoop sorts map output by key(here: word)
    # before it is passed to the reducer
    if current_word == word:
        current_count += count
    else:
        if current_word:
            #write the result to output
            print('%s\t%s' % (current_word, current_count))
        current_count = count
        current_word = word

# Don't forget to output the last word if needed!
if current_word == word:
    print('%s\t%s') % (current_word, current_count)