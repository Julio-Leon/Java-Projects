package Homeworks;
import java.util.Scanner;
public class ProjectEliza {
	static String[] questions = new String[5];
	static String[] statements = new String[5];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String sentence1 = "";
		PromptBank prompti = new PromptBank();
		String ender = "";
		String enderClap = "yes";
		System.out.println("Hello, my name is Eliza. What is your name?");
		String name1 = in.nextLine();
		System.out.println("Hello " + name1 + ". Tell me what is on your mind today in 1 sentence.");
		sentence1 = in.nextLine();
		while ((!sentence1.equals("Exit")) || (!sentence1.equals("EXIT")) || (!sentence1.equals("exit"))) {
			if ((sentence1.equals("Exit")) || (sentence1.equals("EXIT")) || (sentence1.equals("exit"))) {
				System.out.println("Do you want to run the session again? yes/no");
				enderClap = in.next();
					enderClap = enderClap.toLowerCase();
					 if (enderClap.equals("yes")) {
						 main(args);
						 break;
					}if (enderClap.equals("no")) {
							ender = "Goodbye, until next time";
							break;
						}else {
						System.out.println("Invalid statement");
						continue;
						}	
			}else if (sentence1.charAt(sentence1.length() - 1) == '?') {
				prompti.populateQuestionsArray(sentence1);
				System.out.println("");
				sentence1 = in.nextLine();
				continue;
			}else if (sentence1.charAt(sentence1.length() - 1) == '!') {
				prompti.populateStatementsArray2(sentence1);
				System.out.println("");
				sentence1 = in.nextLine();
				continue;
			} else {
				prompti.populateStatementsArray(sentence1);
				System.out.println("");
				sentence1 = in.nextLine();			
				continue;
				} 
			}
		System.out.println(ender);
		}
	
}
 class PromptBank {

	static String [] questions = new String[3];
	static String [] statements = new String[3];
	
	
	

public static void populateQuestionsArray(String sentence1){
	questions[0] = "Is there anything else about BLANK1 and BLANK2?";
	questions[1] = "Do BLANK1 and BLANK2 bother you frequently?";
	questions[2] = "Are BLANK1 and BLANK2 things you think about often?";
	String word1 = "";
	String word2 = "";	
	String resultoo = "";
	double ranIndex = Math.random();
	if ((ranIndex >= 0) && (ranIndex <= 0.3333333)) {
		resultoo = questions[0];
	}if ((ranIndex > 0.3333333) && (ranIndex <= 0.6666666)) {
		resultoo = questions[1];
	}if ((ranIndex > 0.6666666) && (ranIndex <= 1)) {
		resultoo = questions[2];
	}if (resultoo == questions[0]) {
		/// WORD 1 ///
		String gang[] = sentence1.split(" ", 2);
		word1 = gang[0];
	questions[0] = questions[0].replace("BLANK1", word1);
		/// WORD 2 ///
	word2 = sentence1.substring(sentence1.lastIndexOf(" ") + 1);
		questions[0] = questions[0].replace("BLANK2", word2);
		questions[0] = questions[0].replace("?", "");
		System.out.print(questions[0] + "?");	
	}if (resultoo.equals(questions[1])) {
		/// WORD 1 ///
		String gang[] = sentence1.split(" ", 2);
		word1 = gang[0];
		questions[1] = questions[1].replace("BLANK1", word1);
			/// WORD 2 ///
							word2 = sentence1.substring(sentence1.lastIndexOf(" ") + 1);
			questions[1] = questions[1].replace("BLANK2", word2);
		questions[1] = questions[1].replace("?", "");
			System.out.print(questions[1] + "?");
		}if (resultoo == questions[2]) {
		/// WORD 1 ///
		String gang[] = sentence1.split(" ", 2);
		word1 = gang[0];
		questions[2] = questions[2].replace("BLANK1", word1);	
			/// WORD 2 ///
		word2 = sentence1.substring(sentence1.lastIndexOf(" ") + 1);
			questions[2] = questions[2].replace("BLANK2", word2);			
			questions[2] = questions[2].replace("?", "");
			System.out.print(questions[2] + "?");
		}	
}
public static void populateStatementsArray(String sentence1){
	statements[0] = "Tell me more about BLANK1 and BLANK2";
	statements[1] = "BLANK1 seems important to you, so does BLANK2. Please tell me more.";
	statements[2] = "BLANK1 and BLANK2 seem to be on your mind. Let's talk about it.";
	String word1 = "";
	String word2 = "";
	String resultoo = "";
	double ranIndex = Math.random();
	if ((ranIndex >= 0) && (ranIndex <= 0.3333333)) {
		resultoo = statements[0];
	}if ((ranIndex > 0.3333333) && (ranIndex <= 0.6666666)) {
		resultoo = statements[1];
	}if ((ranIndex > 0.6666666) && (ranIndex <= 1)) {
		resultoo = statements[2];
	}if (resultoo == statements[0]) {
		/// WORD 1 ///
		String gang[] = sentence1.split(" ", 2);
		word1 = gang[0];
	statements[0] = statements[0].replace("BLANK1", word1);
		/// WORD 2 ///
	word2 = sentence1.substring(sentence1.lastIndexOf(" ") + 1);
		statements[0] = statements[0].replace("BLANK2", word2);
		statements[0] = statements[0].replace(".", "");
		System.out.print(statements[0] + ".");		
	}if (resultoo.equals(statements[1])) {
		/// WORD 1 ///
		String gang[] = sentence1.split(" ", 2);
		word1 = gang[0];
		statements[1] = statements[1].replace("BLANK1", word1);
			/// WORD 2 ///
		word2 = sentence1.substring(sentence1.lastIndexOf(" ") + 1);
			statements[1] = statements[1].replace("BLANK2", word2);
			statements[1] = statements[1].replace(".", "");
			System.out.print(statements[1] + ".");
		}	
	if (resultoo == statements[2]) {
		/// WORD 1 ///
		String gang[] = sentence1.split(" ", 2);
		word1 = gang[0];
		statements[2] = statements[2].replace("BLANK1", word1);
			/// WORD 2 ///
		word2 = sentence1.substring(sentence1.lastIndexOf(" ") + 1);
			statements[2] = statements[2].replace("BLANK2", word2);	
			statements[2] = statements[2].replace(".", "");
			System.out.print(statements[2] + ".");
		}	
}	
public static void populateStatementsArray2(String sentence1){
	statements[0] = "Tell me more about BLANK1 and BLANK2";
	statements[1] = "BLANK1 seems important to you, so does BLANK2. Please tell me more.";
	statements[2] = "BLANK1 and BLANK2 seem to be on your mind. Let's talk about it.";
	String word1 = "";
	String word2 = "";
	String resultoo = "";
	double ranIndex = Math.random();
	if ((ranIndex >= 0) && (ranIndex <= 0.3333333)) {
		resultoo = statements[0];
	}if ((ranIndex > 0.3333333) && (ranIndex <= 0.6666666)) {
		resultoo = statements[1];
	}if ((ranIndex > 0.6666666) && (ranIndex <= 1)) {
		resultoo = statements[2];
	}if (resultoo == statements[0]) {
		/// WORD 1 ///
		String gang[] = sentence1.split(" ", 2);
		word1 = gang[0];
	statements[0] = statements[0].replace("BLANK1", word1);
		/// WORD 2 ///
	word2 = sentence1.substring(sentence1.lastIndexOf(" ") + 1);
		statements[0] = statements[0].replace("BLANK2", word2);
		statements[0] = statements[0].replace("!", "");
		System.out.print("WOW! Dramatic! " + statements[0]);
	}if (resultoo.equals(statements[1])) {
		/// WORD 1 ///
		String gang[] = sentence1.split(" ", 2);
		word1 = gang[0];
		statements[1] = statements[1].replace("BLANK1", word1);
			/// WORD 2 ///
		word2 = sentence1.substring(sentence1.lastIndexOf(" ") + 1);
			statements[1] = statements[1].replace("BLANK2", word2);
			statements[1] = statements[1].replace("!", "");
			System.out.print("WOW! Dramatic! " + statements[1]);
		}if (resultoo == statements[2]) {
		/// WORD 1 ///
		String gang[] = sentence1.split(" ", 2);
		word1 = gang[0];
		statements[2] = statements[2].replace("BLANK1", word1);
			/// WORD 2 ///
		word2 = sentence1.substring(sentence1.lastIndexOf(" ") + 1);
			statements[2] = statements[2].replace("BLANK2", word2);
			statements[2] = statements[2].replace("!", "");
			System.out.print("WOW! Dramatic! " + statements[2]);
		}
	}	
}