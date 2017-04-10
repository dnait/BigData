#!/usr/bin/env python

import sys

# input comes from STDIN
for line in sys.stdin:
    #remove leading and trailing whitespace
    line = line.strip()
    words = line.split()
    # counte the words
    for word in words:
        #write the results to STDOUT
        #tab-delimited; the trivial word count is 1
        print('%s\t%s' % (word, 1))
