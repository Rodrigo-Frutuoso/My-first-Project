This was my first Introduction to Programming (IP) project at the Faculty of Sciences of the University of Lisbon (FCUL), and it was done with my colleague Tiago Leite.

It consists of creating a version of the Wordle game within the scope of IP (hence the name Ipurdle). This project is divided into two parts (projeto1 and projeto2). The game is the same, but in projeto2, there is a graphical component (IpurdleGUI.java). The code is organized into several classes, and more advanced concepts were used than in part1.

The objective of the game is to guess a secret word with a certain size (wordSize, which by default is 5) within a maximum number of attempts (maxGuesses, which by default is 6). After each attempt, a clue is given. The game ends if the player guesses the secret word or if the attempts run out.

In part1, the clue given consists of the word entered by the player, with each letter in a color indicating whether the letter is in the correct position (GREEN), if it is in the wrong position (YELLOW), or if it is not part of the word (RED).

In part2, the given clue is represented by the symbols * (correct position), 0 (wrong position), and _ (letter does not belong to the word to be discovered), or if the graphical interface is used, it is the same as in part1.
