
ABL-Assignment
====================

Trust 
--------------------
Our goal for this assignment was to model the social property of trust 
and incorporate this into our playable experience. We wanted a bot’s level 
of trust to influence how it interacted with the player, and we wanted to give
the player mechanisms to influence this level of trust. We represent trust in
our bots through color. A low level of trust is represented by the color red,
and a high level of trust by green. A bots color may fall anywhere in this
range depending on its degree of trust, and will slowly fade from one color to
another as its level of trust changes. 
Our bots wander around the map, avoiding collision with other bots and
obstacles. If a bot can “see” the player (they are within some radius) the bot
follows the player. Bots maintain some minimum distance between other bots and
the player. 
Bots spawn with a random level of trust, but can change through
interactions with the player. If the player shots at and hits a bot, the bot’s
level of trust in the player will decrease. However, if the player spends time
within sight of the bot and does not shoot at it, the bot’s level of trust in
the player will slowly increase. A bot will only shoot at the player if it
distrusts them. 

The player can shoot at the bots by pressing spacebar, and can spawn a new bot
by pressing n. 

A Note on Bugs
--------------------
We are aware of a movement bug in our code. The problem occurs when a bot is
spawned on top of another bot. When this happens, both bots freeze and are
unable to move. This is because of the way we detect collision. Our bots will
not choose to move in a direction that causes them to collide with another bot.
When they are already overlapping, any direction they move will still be a
"collision", so our bots do not move. Occasionally this bug also arises even
when the agents are not spawned on top of one another. This happens when the
bots trajectory has been set in abl when they are not near another bot, but the
game engine updates the bot's locations faster than abl updates their
trajectories. We are able to detect when bots end up in this position, but we
have not yet come up with a solution that allows bots to break out of this
position, while maintaining the desired movement behavior of bots when they are
not "stuck". 

Assignment Instructions
--------------------
For this assignment, you will be authoring rudimentary, intermediate, and advanced ABL behaviors for a single agent that controls multiple bots.

Starter Tasks
--------------------
* Add a move action that takes a (int xdir, int ydir, int id) as input.
* Make a MoveTo behavior that moves a bot to a target location over time.
* Add a SetColor action that takes (int r, int b, int g, int id).
* Add color sensing to the BotWME (this includes changes to BotSensor.java and BotWME.java).

Intermediate Tasks
--------------------
* Add on action that creates a new Bot
* Create 4 bots and have them keep a formation around the player.

Advanced Tasks
--------------------
Design and create a multi-bot social interaction that communicates to the player via movement and bot color. The player should be able to interact with your multi-bot behavior set through movement, shooting, or some other user interaction that you design.

Here are some spaces you can design multi-bot social interactions for but feel free to create your own:
* loneliness - how would the bots make the player feel lonely?
* factions - split the bots into two factions and put the player in the middle.
* stigma - if the character or a bot had a stigma (i.e. an extremely undesirable social quality), how would the bots react? If a bot or player interacted with the stigmatized character, how should the others react?
* building trust - The player starts as not being trusted by the bots. How would they gain their trust and how would the bots performance change?

Group Work Policy
--------------------
You may work in teams of up to 4 people.

Grading
--------------------
This assigment will be graded on a 100 point scale.
* 30 Starter Tasks
* 30 Intermediate Tasks
* 40 Advanced Tasks

Turn-in
--------------------
Push your code to your group's GitHub Classroom repository. The master branch will be graded.


Questions and Answers
--------------------
*Question:* How do I build and run the project?

*Answer:* The process runs in two steps: 1) compile the .abl code into .java classes and 2) run the GameEngine with the newly-generated code. To help you with this, there are two classes that have a entry point for execution (i.e. they have a '''static void main(String args[])''' function declared):
1. **abl.build.AgentCompiler.java** - This class invokes the compile in abl.jar to transcompile .abl code into .java code.
2. **game.GameEngine.java** - This launches the game. The code for your abl agent must be transpiled by abl.jar before you can run this class.

*Question:* I have changed my code and recompiled the project but the change isn't seen when I run the GameEngine class. What do I do?

*Answer:* Periodically, Java doesn't recognize that the .java files generated by abl have change and fails to update the .class files. Run Project->Clean... on the project and try again.

*Question:* There is an debugger window that opens and my bots aren't moving. What's is happening?

*Answer:* You have the debug variable set to true in AgentCompiler.java. This tells ABL to run your agent in debug mode which opens the debugger window and automatically pauses your agent before its first decision cycle. Press the **Continue** button to proceed.

[Screenshot of the ABL debugger](misc/ABLdebugger.png)
