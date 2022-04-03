# Sibyl
developed by Ayush, Josh, Jakeb, and Ruth for ***CITRUS HACK 2022***

### Problem:
How can we get a good measure of a community's reaction?

### Solution:
By tracking keywords in a chat log, we can roughly calculate the positivity/negativity of a community's interactions.

## Implementation
Using sample Zoom chat logs it is observed that the messages are saved in the following format:

HR:MIN:SEC From FIRSTNAME LASTNAME to TARGET: <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MESSAGE

By reading in the chat log file, we can skip the header and simply read the message. The program searches the message for particular keywords. In this program, there are two kinds of keywords: positive, and negative.

If a keyword is found, the keyword is saved to an array. Positive and negative keywords are saved to separate arrays.

At the end of the file, the program compares the lengths of the positive keyword array and the negative keyword array. From this comparison it returns some feedback: 
