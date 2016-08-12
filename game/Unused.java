
// public int royalConverter( String card ) {
//   if( card == "K" ) {
//     return 13;
//   } else if( card == "Q" ) {
//     return 12;
//   } else if( card == "J" ) {
//     return 11;
//   } 
//   return 0;
// }

// public int aceConverterHigh( String card ) {
//   if( card == "A" ) {
//     return 14;
//   }
//   return 0;
// }

// public int aceConverterLow( String card ) {
//   if( card == "A" ) {
//     return 1;
//   }
//   return 0;
// }

// public int cardChecker( String card ) {
//   if( royalConverter( card ) != 0 ) {
//     return royalConverter( card );
//   } else if ( aceConverterHigh( card ) != 0 ) {
//     return aceConverterHigh( card );
//   }
//   return Integer.parseInt( card );
// }


// @Test
// public void characterConverter() {
//   jeff.takeCard( cards.deal() );
//   steve.takeCard( cards.deal() );
//   logic = new Logic( steve.seeHand(), jeff.seeHand() );
//   logic.combineCards();
//   assertEquals( 13, logic.royalConverter( "K" ) );
// }

// @Test
// public void characterConverter2() {
//   jeff.takeCard( cards.deal() );
//   steve.takeCard( cards.deal() );
//   logic = new Logic( steve.seeHand(), jeff.seeHand() );
//   logic.combineCards();
//   assertEquals( 14, logic.aceConverterHigh( "A" ) );
// }

// @Test
// public void characterConverter3() {
//   jeff.takeCard( cards.deal() );
//   steve.takeCard( cards.deal() );
//   logic = new Logic( steve.seeHand(), jeff.seeHand() );
//   logic.combineCards();
//   assertEquals( 1, logic.aceConverterLow( "A" ) );
// }

// @Test
// public void bigConverter() {
//   jeff.takeCard( cards.deal() );
//   steve.takeCard( cards.deal() );
//   logic = new Logic( steve.seeHand(), jeff.seeHand() );
//   logic.combineCards();
//   assertEquals( 14, logic.cardChecker( "A" ) );
// }

// @Test
// public void bigConverter2() {
//   jeff.takeCard( cards.deal() );
//   steve.takeCard( cards.deal() );
//   logic = new Logic( steve.seeHand(), jeff.seeHand() );
//   logic.combineCards();
//   assertEquals( 9, logic.cardChecker( "9" ) );
// }