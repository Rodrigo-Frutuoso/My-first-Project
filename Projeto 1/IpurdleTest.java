import java.util.Arrays;

/**
 * A classe {@code IpurdleTest} permite vários procedimentos da classe 
 * {@code Ipurdle}.
 * 
 * @author Antonia Lopes
 * 
 * Compilar: javac IpurdleTest.java
 * Executar: java IpurdleTest
 */

public class IpurdleTest {

	public static void main(String[] args) {

		System.out.println ("Testing Ipurdle.java \n");

		testIsValidClue ();
		System.out.println ();

		testIsMaxClue ();
		System.out.println ();

		testMinClue ();
		System.out.println ();
		
		testNextClue ();
		System.out.println ();

		testClueForGuessAndWord ();
		System.out.println ();

		testHowManyWordsWithClue ();
		System.out.println ();

		testBetterClueForGuess ();
		System.out.println ();		

		testPlayGuess ();
		System.out.println ();		
	}


	

	private static void testIsValidClue () {
		System.out.println ("Testing isValidClue ():");
		boolean error = false;
		
		int clue = 111;
		int size = 3;
		if (!Ipurdle.validClue (clue,size)) {
			System.out.println (">>> failed on valid clue");
			error = true;
		}

		clue = 3213;
		size = 4;
		if (!Ipurdle.validClue (clue,size)) {
			System.out.println (">>> failed on valid clue");
			error = true;
		}

		clue = 213;
		size = 4;
		if (Ipurdle.validClue (clue,size)) {
			System.out.println (">>> failed on invalid clue (size problem)");
			error = true;
		}

		clue = 213;
		size = 2;
		if (Ipurdle.validClue (clue,size)) {
			System.out.println (">>> failed on invalid clue (size problem)");
			error = true;
		}

		clue = 2143;
		size = 4;
		if (Ipurdle.validClue (clue,size)) {
			System.out.println (">>> failed on invalid clue (digit problem)");
			error = true;
		}
		System.out.println (error ? "FAIL" : "PASS");
	}
	
	private static void testMinClue () {
		System.out.println ("Testing MinClue ():");
		boolean error = false;

		int size = 3;
		int expectedClue = 111;
		int obtainedClue = Ipurdle.minClue (size);
		if (obtainedClue != expectedClue) {
			System.out.printf (">>> expected: %d obtained: %d %n", expectedClue, obtainedClue);
			error = true;
		}
		
		size = 5;
		expectedClue = 11111;
		obtainedClue = Ipurdle.minClue (size);
		if (obtainedClue != expectedClue) {
			System.out.printf (">>> expected: %d obtained: %d %n", expectedClue, obtainedClue);
			error = true;
		}


		System.out.println (error ? "FAIL" : "PASS");
		}

	private static void testIsMaxClue () {
		System.out.println ("Testing isMaxClue ():");
		boolean error = false;

		int size = 3;
		int clue = 333;
		if (!Ipurdle.isMaxClue (clue, size)) {
			System.out.println (">>> failed on max clue");
			error = true;
		}

		clue = 213;
		if (Ipurdle.isMaxClue (clue, size)) {
			System.out.println (">>> failed on not max clue");
			error = true;
		}

		clue = 323;
		if (Ipurdle.isMaxClue (clue, size)) {
			System.out.println (">>> failed on not max clue");
			error = true;
		}
		System.out.println (error ? "FAIL" : "PASS");
	}

	private static void testNextClue () {
		System.out.println ("Testing nextClue ():");
		boolean error = false;
		int size = 3;

		int clue = 123;
		int expectedNextClue = 131;
		int obtainedClue = Ipurdle.nextClue (clue, size);
		if (obtainedClue != expectedNextClue) {
			System.out.printf (">>> failed on next clue for %d %n", clue);
			System.out.printf (">>> expected: %d obtained: %d %n", expectedNextClue, obtainedClue);
			error = true;
		}

		clue = 111;
		expectedNextClue = 112;
		obtainedClue = Ipurdle.nextClue (clue, size);
		if (obtainedClue != expectedNextClue) {
			System.out.printf (">>> failed on next clue for %d %n", clue);
			System.out.printf (">>> expected: %d obtained: %d %n", expectedNextClue, obtainedClue);
			error = true;
		}

		clue = 313;
		expectedNextClue = 321;
		obtainedClue = Ipurdle.nextClue (clue, size);
		if (obtainedClue != expectedNextClue) {
			System.out.printf (">>> failed on next clue for %d %n", clue);
			System.out.printf (">>> expected: %d obtained: %d %n", expectedNextClue, obtainedClue);
			error = true;
		}
	
		size = 5;
		
		clue = 12223;
		expectedNextClue = 12231;
		obtainedClue = Ipurdle.nextClue (clue, size);
		if (obtainedClue != expectedNextClue) {
			System.out.printf (">>> failed on next clue for %d %n", clue);
			System.out.printf (">>> expected: %d obtained: %d %n", expectedNextClue, obtainedClue);
			error = true;
		}
		
		clue = 31333;
		expectedNextClue = 32111;
		obtainedClue = Ipurdle.nextClue (clue, size);
		if (obtainedClue != expectedNextClue) {
			System.out.printf (">>> failed on next clue for %d %n", clue);
			System.out.printf (">>> expected: %d obtained: %d %n", expectedNextClue, obtainedClue);
			error = true;
		}

		clue = 23333;
		expectedNextClue = 31111;
		obtainedClue = Ipurdle.nextClue (clue, size);
		if (obtainedClue != expectedNextClue) {
			System.out.printf (">>> failed on next clue for %d %n", clue);
			System.out.printf (">>> expected: %d obtained: %d %n", expectedNextClue, obtainedClue);
			error = true;
		}

		clue = 31111;
		expectedNextClue = 31112;
		obtainedClue = Ipurdle.nextClue (clue, size);
		if (obtainedClue != expectedNextClue) {
			System.out.printf (">>> failed on next clue for %d %n", clue);
			System.out.printf (">>> expected: %d obtained: %d %n", expectedNextClue, obtainedClue);
			error = true;
		}
		
		System.out.println (error ? "FAIL" : "PASS");
	}


	private static void testClueForGuessAndWord () {
		System.out.println ("Testing ClueForGuessAndWord  ():");
		boolean error = false;

		String guess = "TERNS";
		String word = "CIGAR";
		int expectedClue = 11211;
		int obtainedClue = Ipurdle.clueForGuessAndWord (guess,word);
		if (obtainedClue != expectedClue) {
			System.out.printf (">>> failed on clue for %s and %s %n", guess, word);
			System.out.printf (">>> expected: %d obtained: %d %n", expectedClue, obtainedClue);
			error = true;
		}

		guess = "TERNS";
		word = "REBUT";
		expectedClue = 23211;
		obtainedClue = Ipurdle.clueForGuessAndWord (guess, word);
		if (obtainedClue != expectedClue) {
			System.out.printf (">>> failed on clue for %s and %s %n", guess, word);
			System.out.printf (">>> expected: %d obtained: %d %n", expectedClue, obtainedClue);
			error = true;
		}

		guess = "TERNS";
		word = "HUMPH";
		expectedClue = 11111;
		obtainedClue = Ipurdle.clueForGuessAndWord (guess, word);
		if (obtainedClue != expectedClue) {
			System.out.printf (">>> failed on clue for %s and %s %n", guess, word);
			System.out.printf (">>> expected: %d obtained: %d %n", expectedClue, obtainedClue);
			error = true;
		}

		guess = "TERNS";
		word = "TERNS";
		expectedClue = 33333;
		obtainedClue = Ipurdle.clueForGuessAndWord (guess, word);
		if (obtainedClue != expectedClue) {
			System.out.printf (">>> failed on clue for %s and %s %n", guess, word);
			System.out.printf (">>> expected: %d obtained: %d %n", expectedClue, obtainedClue);
			error = true;
		}

		guess = "BUBBLE";
		word = "ABOUND";
		expectedClue = 221111;
		obtainedClue = Ipurdle.clueForGuessAndWord (guess,word);
		if (obtainedClue != expectedClue) {
			System.out.printf (">>> failed on clue for %s and %s %n", guess, word);
			System.out.printf (">>> expected: %d obtained: %d %n", expectedClue, obtainedClue);
			error = true;
		}
		
		guess = "BUBBLE";
		word = "BUBBLE";
		expectedClue = 333333;
		obtainedClue = Ipurdle.clueForGuessAndWord (guess,word);
		if (obtainedClue != expectedClue) {
			System.out.printf (">>> failed on clue for %s and %s %n", guess, word);
			System.out.printf (">>> expected: %d obtained: %d %n", expectedClue, obtainedClue);
			error = true;
		}


		System.out.println (error ? "FAIL" : "PASS");	
	}


	private static void testHowManyWordsWithClue () {
		System.out.println ("Testing howManyWordsWithClue ():");
		boolean error = false;

		String guess = "TERNS";						 		
		String[] words = 									    // clue
			{"CIGAR", "DWARF", "MAJOR", "RUDDY",				// 11211
					"REBUT", "REACT", "RETCH", 			 		// 23211
					"SISSY", "BLUSH", "BASIC",			 		// 11112
					"HUMPH","FOCAL","CLUCK","CLOCK","CLICK",	// 11111
			"TERNS"};							 		// 33333
		DictionaryIP dictionary = new DictionaryIP (5, words);

		int clue = 11211;
		int expectedNum = 4;
		int obtainedNum = Ipurdle.howManyWordsWithClue (dictionary, clue, guess);
		if (obtainedNum != expectedNum) {
			System.out.printf (">>> failed on  %d and %s %n", clue, guess);
			System.out.printf (">>> expected: %d obtained: %d %n", expectedNum, obtainedNum);
			error = true;
		}

		clue = 23211;
		expectedNum = 3;
		obtainedNum = Ipurdle.howManyWordsWithClue (dictionary, clue, guess);
		if (obtainedNum != expectedNum) {
			System.out.printf (">>> failed on  %d and %s %n", clue, guess);
			System.out.printf (">>> expected: %d obtained: %d %n", expectedNum, obtainedNum);
			error = true;
		}

		clue = 11111;
		expectedNum = 5;
		obtainedNum = Ipurdle.howManyWordsWithClue (dictionary, clue, guess);
		if (obtainedNum != expectedNum) {
			System.out.printf (">>> failed on  %d and %s %n", clue, guess);
			System.out.printf (">>> expected: %d obtained: %d %n", expectedNum, obtainedNum);
			error = true;
		}

		System.out.println (error ? "FAIL" : "PASS");	
	}

	private static void testBetterClueForGuess() {
		System.out.println ("Testing betterClueForGuess ():");
		boolean error = false;

		String guess = "TERNS";						 		
		String[] words = 										// clue
			{"CIGAR", "DWARF", "MAJOR", "RUDDY",				// 11211
					"REBUT", "REACT", "RETCH", 			 		// 23211
					"SISSY", "BLUSH", "BASIC",			 		// 11112
					"HUMPH","FOCAL","CLUCK","CLOCK","CLICK",	// 11111
					"TERNS"};							 		// 33333
		DictionaryIP dictionary = new DictionaryIP (5, words);

		int expectedNum = 11111;
		int obtainedNum = Ipurdle.betterClueForGuess (dictionary, guess);
		if (obtainedNum != expectedNum) {
			System.out.printf (">>> failed on dictionary1 %n");
			System.out.printf (">>> expected: %d obtained: %d %n", expectedNum, obtainedNum);
			error = true;
		}

		String[] words2 = 										// clue
			{"CIGAR", "DWARF", "MAJOR", "RUDDY",				// 11211
					"REBUT", "REACT", "RETCH", 			 		// 23211
					"SISSY", "BLUSH",					 		// 11112
					"HUMPH","FOCAL",							// 11111
					"TERNS"};							 		// 33333
		dictionary = new DictionaryIP (5, words2);

		expectedNum = 11211;
		obtainedNum = Ipurdle.betterClueForGuess (dictionary, guess);
		if (obtainedNum != expectedNum) {
			System.out.printf (">>> failed on dictionary2 %n");
			System.out.printf (">>> expected: %d obtained: %d %n", expectedNum, obtainedNum);
			error = true;
		}
		
		String[] words3 = 										// clue
			{"CIGAR", "DWARF", 									// 11211
					"REBUT", "REACT", 					 		// 23211
					"SISSY", "BLUSH",					 		// 11112
					"HUMPH","FOCAL",							// 11111
					"TERNS"};							 		// 33333
		dictionary = new DictionaryIP (5, words3);

		expectedNum = 11111;
		obtainedNum = Ipurdle.betterClueForGuess (dictionary, guess);
		if (obtainedNum != expectedNum) {
			System.out.printf (">>> failed on dictionary2 %n");
			System.out.printf (">>> expected: %d obtained: %d %n", expectedNum, obtainedNum);
			error = true;
		}

		System.out.println (error ? "FAIL" : "PASS");	
	}
	
	
	private static void testPlayGuess() {
		System.out.println ("Testing playGuess ():");
		boolean error = false;

		String guess = "TERNS";						 		
		String[] words = 										// clue
					{"CIGAR", "DWARF", "MAJOR", "RUDDY",		// 11211
					"REBUT", "REACT", "RETCH", 			 		// 23211
					"SISSY", "BLUSH", "BASIC",			 		// 11112
					"HUMPH","FOCAL","CLUCK","CLOCK","CLICK",	// 11111
					"TERNS"};							 		// 33333
		DictionaryIP dictionary = new DictionaryIP (5, words);

		int expectedClue = 11111;
		int obtainedClue = Ipurdle.playGuess (dictionary, guess);
		if (obtainedClue != expectedClue) {
			System.out.printf (">>> failed on %s and dictionary1 %n", guess);
			System.out.printf (">>> expected: %d obtained: %d %n", expectedClue, obtainedClue);
			error = true;
		}
		
		String[] expectedWords = {"HUMPH","FOCAL","CLUCK","CLOCK","CLICK"};	// 11111
		DictionaryIP expectedDictionary = new DictionaryIP (5,expectedWords);		
		if (!dictionary.equals (expectedDictionary)) {
			System.out.printf (">>> failed on %s and dictionary1 %n", guess);
			System.out.println (">>> dictionary not changed as expected");
			System.out.println (">>> expected" + Arrays.toString(expectedWords));
			System.out.println (">>> obtained" + dictionary);
			error = true;
		}


		String[] words2 = 										// clue
			{"CIGAR", "DWARF", 									// 11211
					"REBUT", "REACT", "RETCH", 			 		// 23211
					"SISSY", "BLUSH",					 		// 11112
					"HUMPH","FOCAL",							// 11111
					"TERNS"};							 		// 33333
		dictionary = new DictionaryIP (5, words2);

		expectedClue = 23211;
		obtainedClue = Ipurdle.playGuess (dictionary, guess);
		if (obtainedClue != expectedClue) {
			System.out.printf (">>> failed on %s and dictionary2 %n", guess);
			System.out.printf (">>> expected: %d obtained: %d %n", expectedClue, obtainedClue);
			error = true;
		}
		
		String[] expectedWords2 = {"REBUT", "REACT", "RETCH"};	// 23211
		expectedDictionary = new DictionaryIP (5, expectedWords2);		
		if (!dictionary.equals (expectedDictionary)) {
			System.out.printf (">>> failed on %s and dictionary2 %n", guess);
			System.out.printf (">>> dictionary not changed as expected %n");
			System.out.println (">>> expected" + Arrays.toString(expectedWords));
			System.out.println (">>> obtained" + dictionary);
			error = true;
		}

		System.out.println (error ? "FAIL" : "PASS");	
	}


}
