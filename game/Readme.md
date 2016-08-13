Welcome to Java Poker.

The interface is far from finished however the basis for the game is well underway. As I continue to develop this app it will become easier to interact with but please give me any feedback or request any features you wish to see added. ( Being the only one to see your cards is already on the list 😏. )

The design of the card logic has been built in such a way that it should accurately rate the hands of the various players from a Royal Flush right the way down to a single Two. This should enable completely fair games.

1. To interact with the game each player must create a new character:

  jeff = new Player( "Jeff", 1 );
  dave = new Player( "Dave", 2 );


They must pick a name for their character as well as manually add a position number. Please keep these sequential and beginning from 1 unless you want to dive into the Game.java file and change a few thing. Each character automatically starts with 500 chips.

2. A new game must then be created:

  myWickedCoolSuperFirstPokerGame = new Game( 2 );


Note the number of players who are playing must be entered here. This helps keep track of whose go it is etc.

3. A deck of cards can then be summoned:

  thatDeckOfCardsFromWindows95WithTheCoolMoonLitBack = new Cards();


This will generate a fresh deck to start.

4. Call shuffle on the deck:

  thatDeckOfCardsFromWindows95WithTheCoolMoonLitBack.shuffle();


Woohoo. You are ready to start playing.

p.s. for ease I have decided to rename my deck of cards:

  Cards cards = thatDeckOfCardsFromWindows95WithTheCoolMoonLitBack;


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

Dave looks slighly at his cards all the while watchiing Jeff's shifty eyes. He plays a small bet to feel out Jeff's play style.

  dave.placeBet( 15 );
  game.addBet( dave );
  game.nextTurn();

Finally sorting out the contact lens which had slipped behind his eye Jeff concentrates at the situation at hand with a steely look of concentration. He spies a bead of sweat drop from Jeff's nose. He's matches the bet and raises. 

  jeff.placeBet( 35 );
  game.addBet( jeff );
  game.nextTurn();

Having been taken aback by the reraise dave takes a tissue from his pocket and blows his runny nose. He can't quite tell what Dave is up to as he watches his opponent shifting awkwardly in his seat. Dave wants to hold on to see the next card at least.

  dave.placeBet( 20 );
  game.addBet( dave );
  game.nextTurn();
  game.takeCard( cards.deal() );

With the keys in his pocket no longer scratching him painfully in the leg Jeff surveys the cards. With the four on the table and the two in his hand he is feeling pretty strong. That is until he catches a wry smile coming from Dave's mouth. What does he have that is making him so happy?!?!? Jeff keeps it cool and decides to simply check.

  jeff.check();
  game.nextTurn();

"Come on Dave, snap out of it" he says to himself as he realises his mind has drifted to a MbMbaM podcast he was listening on the way to the game. The breifest glance at his opponent's look of dispair and the check he just played is enough to convince Dave he has the upper hand. However with such a small pot it is time for him to play it cool. He also cooly checks.

  dave.check();
  game.nextTurn(); 
  game.takeCard( cards.deal() );

"Dammit" exclaims Jeff internally. He hates it when a sneeze fails to realise itself. With his mind back on the game and his opponent doing everything he can to avoid eye contact he decides to lay down a sizeable bet.

  jeff.placeBet( 100 );
  game.addBet( jeff );
  game.nextTurn();

"That's the largest bumblebee I've ever seen" thinks dave as he waited patiently for his turn.   












