Welcome to Java Poker.

The interface is far from finished however the basis for the game is well underway. As I continue to develop this app it will become easier to interact with but please give me any feedback or request any features you wish to see added. ( Being the only one to see your cards is already on the list 😏. )

The design of the card logic has been built in such a way that it should accurately rate the hands of the various players from a Royal Flush right the way down to a single Two. This should enable completely fair games.

1. To interact with the game each player must create a new character:


  jeff = new Player( "Jeff", 1 );
  dave = new Player( "Dave", 2 );


They must pick a name for their character as well as manually add a position number. Please keep these sequential and beginning from 1 unless you want to dive into the Game.java file and change a few things. Each character automatically starts with 500 chips.

2. A new game must then be created:


  myWickedCoolSuperFirstPokerGame = new Game( 2 );


Note the number of players who are playing must be entered here. This helps keep track of whose go it is etc.

3. A deck of cards can then be summoned:


  thatDeckOfCardsFromWindows95WithTheCoolMoonLitBack = new Cards();


This will generate a fresh deck to start.

4. Call shuffle on the deck:


  thatDeckOfCardsFromWindows95WithTheCoolMoonLitBack.shuffle();


Woohoo. You are ready to start playing.

p.s. for ease I have decided to rename my deck of cards and game:


  Cards cards = thatDeckOfCardsFromWindows95WithTheCoolMoonLitBack;
  Game game = myWickedCoolSuperFirstPokerGame;


As mentioned above there are a number of features I would like to streamline however a basic round goes something like this:


  jeff.takeCard( cards.deal() );
  dave.takeCard( cards.deal() );
  jeff.takeCard( cards.deal() );
  dave.takeCard( cards.deal() );


Both players now have two cards.


  jeff.smallBlind();
  game.addBet( jeff );
  game.nextTurn();


Jeff has played the small blind and ended his turn.  


  dave.bigBlind();
  game.addBet( dave );
  game.nextTurn();


Dave has played the big blind and ended his turn. Jeff must call or fold.


  jeff.placeBet( 5 );
  game.addBet( jeff );
  game.nextTurn();


Three community cards are now dealt to the table.


  game.takeCard( cards.deal() );
  game.takeCard( cards.deal() );
  game.takeCard( cards.deal() );


Dave looks slighly at his cards all the while watching Jeff's shifty eyes. He plays a small bet to feel out Jeff's play style.


  dave.placeBet( 15 );
  game.addBet( dave );
  game.nextTurn();


Finally sorting out the contact lens which had slipped behind his eye Jeff concentrates on the situation at hand with a steely look of concentration. He spies a bead of sweat drop from Jeff's nose. He's matches the bet and raises. 


  jeff.placeBet( 35 );
  game.addBet( jeff );
  game.nextTurn();


Having been taken aback by the reraise dave takes a tissue from his pocket and blows his runny nose. He can't quite tell what Dave is up to as he watches his opponent shifting awkwardly in his seat. Dave wants to hold on to see the next card at least.


  dave.placeBet( 20 );
  game.addBet( dave );
  game.nextTurn();
  game.takeCard( cards.deal() );


With the keys in his pocket no longer scratching him painfully in the leg, Jeff surveys the cards. With the four on the table and the two in his hand he is feeling pretty strong. That is until he catches a wry smile coming from Dave's mouth. What does he have that is making him so happy?!?!? Jeff keeps it cool and decides to simply check.


  jeff.check();
  game.nextTurn();


"Come on Dave, snap out of it" he says to himself as he realises his mind has drifted to the MbMbaM podcast he was listening on the way to the game. The breifest glance at his opponent's look of dispair and the check he just played is enough to convince Dave that he has the upper hand. However with such a small pot it is time for him to play it cool. He also calmly checks.


  dave.check();
  game.nextTurn(); 
  game.takeCard( cards.deal() );


"Dammit" exclaims Jeff internally. He hates it when a sneeze fails to realise itself. With his mind back on the game and his opponent doing everything he can to avoid eye contact he decides to lay down a sizeable bet.


  jeff.placeBet( 100 );
  game.addBet( jeff );
  game.nextTurn();


"That's the largest bumblebee I've ever seen" thought dave as he waited patiently for his turn. Perhaps taking the bumblebee as a omen of good times to come, as any rational person might also, Dave leaps in for the attack. As he places his bet he sees his opponent develop the most obvious tell he has ever seen.


  dave.placeBet( 250 );
  game.addBet( dave );
  game.nextTurn();  


Momentarily distracted while trying to remove what felt like an enormous bumblebee from his ear Jeff realises it's now or never. He takes one last look at his cards, those on the table and his impossible to read opponent before calling the bet and leaving the result to fate.


  jeff.placeBet( 150 );
  game.addBet( jeff );


For the longest time the pair just stare at each other. Neither knowing what to do next. Together, however, and without taking their eyes off of each other they glance down at these instructions. 

They must each new up an instance of logic and pass their hand cards and the community cards they wish to use. Once there the logic can then do all the magic and sort out the scores: 


  logic = new Logic( game.seeHand(), jeff.seeHand() ); 
  logic.combineCards();
  logic.setScore();
  jeff.awardScore( logic.seeScore() );
  jeff.awardKicker( logic.seeKicker() );

  logic = new Logic( game.seeHand(), dave.seeHand() ); 
  logic.combineCards();
  logic.setScore();
  dave.awardScore( logic.seeScore() );
  dave.awardKicker( logic.seeKicker() );


With their individual hand values now in place the pair look obliviously at each other. Both hands look pretty good. Does Two Pair beat Three of a Kind ( They seemed to ask )?  How will they divide up the chips ( Was likely to also be implied )? Luckily the Game file has some clever sorting algorithms to help these two out:


  game.addPlayer( jeff );
  game.addPlayer( dave );
  game.pickWinner();
  game.handWon( game.seeWinner() );


And with that victory is given. Both Jeff and Dave look at eachother in amazement. A game written in under two days seems to have got it right. They smile and agree that the first hand was just a warm up. Next time it will be for keeps.

Those are the basic instructions to get through a game. There is a fold function that each player has that can be called as such:


  jeff.fold()


At this point however and until the end of the hand players must be aware that they should call another function in place of any folded player in the same order as they were originally playing. In a game of three this would look like:


  jeff.fold();
  game.nextTurn();

  dave.placeBet( 50 );
  game.addBet( dave );
  game.nextTurn();

  steve.placeBet( 55 );
  game.addBet( steve );
  game.nextTurn();

  game.foldMaster( jeff );

  dave.placeBet( 10 ).....


The foldMaster() function automatically skips over any player who has folded and in the case that all other players have folded it can be used to award the winnings to the one remaining player:


  jeff.fold();
  game.nextTurn();

  dave.placeBet( 50 );
  game.addBet( dave );
  game.nextTurn();

  steve.fold();

  game.foldMaster( steve );
  game.foldMaster( jeff );
  game.foldMaster( dave );


Dave would automatically be awarded the pot.


Features I would like to add:


  Some kind of interface. Absolute top of my list. It would make playing a bit easier than playing one of those Hugo games from the late 80's and also enable people to keep their cards hidden.

  Bundling of moves to make things a lot smoother and dryer.

  Split pots.

  Network play.



If you have any other requests or bug reports please let me know.

All the best,

  Skinny Pigeon 👻









