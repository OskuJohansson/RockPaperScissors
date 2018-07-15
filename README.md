# Rock, Paper, Scissors

This project is a game of Rock, Paper, Scissors against a bot written in Java. Why? Mostly for a personal learning experience!

## How It Works

The handsigns have been assigned as enums in Handsigns.java along with the rules of which handsign beats which. 

The real focus is in the AI. so far, there are two levels:
* random: randomly chooses any of the three handisigns
* levelOne: checks the player's handsign from last round and favors the one that would lose to that handsign (assumes the player would play next the handsign that beats their former choice, thus choosing the one that would beat this choice). 

the method levelOne should come in handy in tie situations. 

The next goal is to create the method levelTwo that takes the player's play history into account deeper than one round back.

Keep in mind that this bot assumes you don't know how it works. If you knew which handsign it was going to play next, it would be impossible to create and AI that would win.

## How To Play

Type rock/paper/scissors or r/p/s (case sensitivity ignored) to choose the handsign you want to play. Type stop when you want to stop playing.

## What Works

The baseline logic in command line interface.

## To Do

* Database to record game history
* Better AI that utilizes the game history
* Web implementation
* Something even cooler that I haven't come up with yet