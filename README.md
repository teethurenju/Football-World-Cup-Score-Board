Football World Cup Score Board
--------------------------------------

Football World Cup Score Board that shows matches and scores. 

Java Module contains FootballScoreBoard class which works as a Sports score board which have options to Record live football matches and summary of all matches completed.

How to run the module
--------------------------------------

Just run the main class FootballScoreBoard.java
Enter the details through the command line

1. To start the game :- Press 'S'
2. To update the score of the game :- Press 'U'
3. To finish the game :- Press 'F'
4. To get the summary of game :- Press 'R'
5. To quit the game :- Press 'Q'

Implementation Details
--------------------------------------

Implementation consist of 4 methods for starting a game, update the game,finish the game and get the summary of the game.

Method Details
--------------------------------------

	scoreBoardMenu
	----------
	Initial call to invoke the Football World Cup Score Board
	
	startGame
	---------
	1. Method accepts home team and away team names
	2. Set the values of team name and team score(initially 0-0) to the DTO class
	3. Show the live match score
	
	updateGame
	----------
	1. Method accepts home team and away team updated scores
	2. Set the values of team updated score to the DTO class
	3. Show the live match score
	
	finishGame
	----------
	1. matchStatus = false, then the game is finished
	2. Add all the finished match details to a list
	
	getMatchSummary
	---------------
	1. Get the match list which holds the details of matches which is completed
	2. Reverse the list, since we need last completed match should come in the list first
	3. Sort the list based on the total goal scored in the match
	4. Show the match summary with the sorted list
	5. Return the list
	  
	
