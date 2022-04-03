public class Main {
  public static void main(String[] args) {
    Keywords Key = new Keywords();
    String[] goodKeyWords = Key.registerAllKeyWords("PositiveKeywords.txt");
    String[] badKeyWords = Key.registerAllKeyWords("NegativeKeywords.txt");
    String[] messages = Key.readFile("meeting_saved_chat.txt");
    // Good - Array[0]; Bad - Array[1]
    String[][] goodAndBad = Key.findKeywords(messages, goodKeyWords, badKeyWords); //All messages are in here sorted just need to return data to the user
    Key.displayingData(goodAndBad);
  }
}

/*
if the line does not begin with a space/indent ignore it if it is then check if it matches keyword and then push it into the array

O(n) - Real time / Linear Scale
*/