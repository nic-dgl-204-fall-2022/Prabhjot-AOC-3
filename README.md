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

The ```exchangeDanceMove``` method had two parameters ```firstPosition``` and ```secondPosition ```parameters with Int datatypes. We will be required these two positions for ```programChar``` as the objective of creating this function is to simply exchange two ```programsChar``` at positions. To achieve this I first created a temp variable and stored the ```programsChar``` at first position. Then, in the next line I assigned the value of second position char to first position char and in third line we got real first position’s value in second position from that temp variable. 


          fun exchangeDanceMove(firstPosition: Int, secondPosition: Int) {
               val tempVariable = programsChar[firstPosition]
               programsChar[firstPosition] = programsChar[secondPosition]
               programsChar[secondPosition] = tempVariable
                  }

The ```partnerDanceMove``` method has two parameters ```firstProgChar``` and ```secondProgChar``` with Char datatypes. We will be required these two chars to exchange their positions as the aim of this function is to exchange or swap the ```programsChar```. So in ```exchangeDanceMove``` function we were swapping at positions while here in ```partnerDanceMove``` we will be swapping at characters. To do this we got the ```firstProgChar``` and ```SecondProgChar``` to swap them. Therefore, we are first getting their positions using ```indexOf``` property of the mutable list (as the ```programChar``` is an ```mutableList```). After, getting those positions we will call our ```exchangeDanceMove``` function and put the positions we got, in it. 

          fun partnerDanceMove(firstProgChar: Char, SecondProgChar: Char) {
              val firstPosition = programsChar.indexOf(firstProgChar)
              val secondPosition = programsChar.indexOf(SecondProgChar)
                exchangeDanceMove(firstPosition, secondPosition)
                       }

Now, in the main function we will use three of those functions to achieve our goal of running the dance through once with all of the dance moves. To read the moves in, we are taking user input first with the variable ```stringInput``` and in the variable orders we are splitting all the strings characters from each other with a ```,``` .
            
             print("Enter input: ")
                val stringInput = readLine() ?: "
                val orders = stringInput.split(",")

Further, we created a ```forEach``` loop with ```orders``` variable and then using the ```when- else``` blocks to perform our dance move functions. In the when-else block there will be three conditions with ```s, x and p``` to implement three of the dance move functions. Whenever the order reaches to ```s``` the ```spinDanceMove``` function will be implemented as it requires ```positonNumber``` of the ```charProgram``` which will be moved from end to front.

Whenever the order reaches to ```x``` the ```exchangeDanceMove``` function will be implemented to exchange two positions of the chars. As it required the positions as parameters, we will be getting the positions with the help of the ```orderExchangeKey``` which we get by splitting the order with ```/```.  With order we are getting the character on the other hand we require their position number for ```exchangeDanceMove```.

Whenever the order reaches to ```p``` the ```partnerDanceMove``` function will be implemented to swap two ```programsChar```. ```partnerDanceMove``` function do not requires the positions so we can simply provide it the characters from using the ```order[-]```.

  
           orders.forEach { order ->
	        when (order[0]) {
	            's' -> spinDanceMove(Integer.parseInt(order.slice(1 until order.length)))
	            'x' -> {
	                val orderExchangeKey = order.split("/")
	                val firstPosition =
	                    Integer.parseInt(orderExchangeKey[0].slice(1 until orderExchangeKey[0].length))
	                val secondPosition = Integer.parseInt(orderExchangeKey[1])
	                exchangeDanceMove(firstPosition, secondPosition)
	            }
	            'p' -> partnerDanceMove(order[1], order[3])
	            else -> println("This $order is not known.")
	        }
	    }

As we are iterating for one time only we will use a variable ```i``` and will initialize it with 1. At the end we have to combine the sliced string into a single word. And to do so we are using the ```joinString``` property of the ```mutableList programsChar```. Lastly, we are printing our result.


         if(i==1){
	        val stringFromPrograms = programsChar.joinToString("")
	        println("So, answer is: $stringFromPrograms")
	    }


## Second Solution 

The question further says that you watch the dance for a while and record their dance moves ( which is our puzzle input) so after that, we have to find in what order the programs will be standing after their completion of that dance. By keeping the positions they finished in the their previous dance, the programs will be keep performing again and again. Total one billion iteration will take to complete it or to the eventual sequence.

To achieve this we created two variables in which first is ```iterations``` in which we are storing ```1_000_000_000``` to perform the dance for one billion times and second is ```copyingProgChar``` which will contain the copy of the our ```programsChar```.


          val iterations = 1_000_000_000

          val copyingProgChar = programsChar.toList()
	  
Now, we will be using while loop to run the program till ```1000000000``` iterations. The loop should be having the condition of not iterating more then the one billion times. Therefore, to apply that we simply used ```(i <= iterations)```  and added ```i++``` at the end of the while loop to update it. 

Further we used the an if condition inside the loop to check if we get the values of ```programsChar ```equal to the ```copyingProgChar```.

            while (i <= iterations) {
             orders.forEach { order ->
                  when (order[0]) {
            's' -> spinDanceMove(Integer.parseInt(order.slice(1 until order.length)))
            'x' -> {
                val orderExchangeKey = order.split("/")
                val firstPosition =
                    Integer.parseInt(orderExchangeKey[0].slice(1 until orderExchangeKey[0].length))
                val secondPosition = Integer.parseInt(orderExchangeKey[1])
                exchangeDanceMove(firstPosition, secondPosition)
            }
            'p' -> partnerDanceMove(order[1], order[3])
            else -> println("This $order is not known.")
                         }
                     }
             if (i == 1) {
               val stringFromPrograms = programsChar.joinToString("")
               println("First Part's result- $stringFromPrograms")
             }
         if (programsChar == copyingProgChar) {
        val iterationFactor = iterations / i
        i = i * iterationFactor
         }
           i++
              }
























