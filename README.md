# Prabhjot-AOC-3

## Overview of the problem

For my Advent of Code assignment- 3 I decided to solve the Advent of Code- 2017, Day- 16th problem. The problem here states that a group of sixteen programs are dancing and they start by standing in a line from a to p. Therefore, there are 15 positions from 0 to 15, beginning from a to p. 
The problem mainly contains three conditions or the dance moves as stated in the problem i.e. Spin, Exchange and Partner. Problem says that you watch the dance for a while and record their dance moves (the input). We have to find that in what order are the programs standing after their dance i.e. it asks us to run out the positions of the dancing programs after each run through the dance. Below are the dance moves

•	Spin dance move can be written as ```sX``` in which programs move from end to front. Like ```s3``` on abcde makes cdeab or ```s1``` on ```abcde``` makes ```eabcd```.

•	Exchange dance move can be written as ```xA/B``` in which programs at positions ```A``` and ```B``` will swap places like ```x3/4``` on ```abcde``` produces ```eabdc```.

•	Partner dance move can be written as ```pA/B``` in which programs ```A``` and ```B``` will swap places like ```pe/b``` on ```abcde``` produces ```baedc```.

Under these dance moves, the problem should be solved.

## First Solution


