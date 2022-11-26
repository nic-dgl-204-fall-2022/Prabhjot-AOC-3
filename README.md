# Prabhjot-AOC-3

## Overview of the problem

For my Advent of Code assignment- 3 I decided to solve the Advent of Code- 2017, Day- 16th problem. The problem here states that a group of sixteen programs are dancing and they start by standing in a line from a to p. Therefore, there are 15 positions from 0 to 15, beginning from a to p. 
The problem mainly contains three conditions or the dance moves as stated in the problem i.e. Spin, Exchange and Partner. Problem says that you watch the dance for a while and record their dance moves (the input). We have to find that in what order are the programs standing after their dance i.e. it asks us to run out the positions of the dancing programs after each run through the dance. Below are the dance moves

•	Spin dance move can be written as ```sX``` in which programs move from end to front. Like ```s3``` on abcde makes cdeab or ```s1``` on ```abcde``` makes ```eabcd```.

•	Exchange dance move can be written as ```xA/B``` in which programs at positions ```A``` and ```B``` will swap places like ```x3/4``` on ```abcde``` produces ```eabdc```.

•	Partner dance move can be written as ```pA/B``` in which programs ```A``` and ```B``` will swap places like ```pe/b``` on ```abcde``` produces ```baedc```.

Under these dance moves, the problem should be solved.

## First Solution

To begin with code I first tried of framing the dance moves in the methods as we have three dance moves spin, exchange and partner. Therefore, I named the functions as ```spinDanceMove```, ```exchangeDanceMove``` and ```partnerDanceMove```. The objective of creating this function was to simply move the programs character from end to front. To do so, I created a mutable list of all the characters starting from a to p firstly inside in the function but then I thought that the variable ```programsChar``` should be declared outside the function because it will be required in other two dance move functions also. 

         private var programs = mutableListOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p')
         

The ```spinDanceMove``` function has ```positonNumber``` parameter which is basically the number of iterations or repetitions the programs characters will do permutations or number of times the programs will dance. As the aim of this method is to move the programs character from end to front so we have to first divide the programs standing in the line (like s2 on ```abcde``` produces ```deabc```, here ```abcde``` should be divided into ```abc``` and de```.) Now, we have to find the index from which the spin dance move starts (in ```sX``` on ```abcde```, we have to find X) and for that we subtracted the ```programsChar``` list size from the ```positionNumber```. To slice or cut the ```programsChar``` into two parts I used the slice property of the ```mutableList``` returns a list containing elements at indices in the specified indices range.

We have to update the ```programsChar``` so we added both sliced part in such a way that the ending sliced part added in the beginning of the ```programsChar``` while we added the starting sliced part to the ending of the ```programsChar```. 

         
         fun spinDanceMove(positionNumber: Int) {
                      programsChar = ((programsChar.slice((programsChar.size - positionNumber) until programsChar.size)) 
                                                          + 
                      programsChar.slice(0 until (programsChar.size positionNumber)))).toMutableList()
                                }



