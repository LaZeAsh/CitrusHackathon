import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;

public class Keywords {
    /**
   * @param fileName - name of the file to read
   * @return Array with all the important things like the chat
   */
  public String[] registerAllKeyWords(String fileName) {
    File keyWordsFile = new File(fileName);
    Path path = Paths.get(fileName);
    int count = 0;
    try {
      count = (int) Files.lines(path).count();
    } catch (IOException e) {
      System.out.println(e);
    }
    String[] array = new String[count];
    try {
      Scanner keyWord = new Scanner(keyWordsFile);
      int i = 0;
      while (keyWord.hasNextLine()) {
        array[i] = keyWord.nextLine();
        i++;
      }
      keyWord.close();
    } catch (FileNotFoundException error) {
      System.out.println("Error");
      error.printStackTrace();
    }
    return array;
  }
  public String[] readFile(String fileName) {
    File chatsFile = new File(fileName);
    Path path = Paths.get(fileName);
    int count = 0;
    try {
      count = (int) Files.lines(path).count();
    } catch (IOException e) {
      System.out.println(e);
    }
    String[] array = new String[(int) (count / 2)]; // 52 logs (1/2 actual messages) (1/2 timestamps & sender)
    try {
      Scanner chats = new Scanner(chatsFile);
      int i = 0;
      while (chats.hasNextLine()) {
        String nextElement = chats.nextLine();
        if(nextElement.startsWith("1") | nextElement.startsWith("0") | nextElement.startsWith("2")) continue; // If the line is not the message then continue
        array[i] = nextElement;
        i++;
      }
      chats.close();
    } catch (FileNotFoundException error) {
      // Will never execute unless the file doesn't exist
      System.out.println("Error");
      error.printStackTrace();
    }
    return array;
  }

  public String[][] findKeywords(String[] messagesArr, String[] goodKeyWords, String[] badKeyWords) {
    String[][] array = new String[2][goodKeyWords.length + badKeyWords.length];
    int i = 0;
    int x = 0;
    for (String message : messagesArr) {
      for (String keyWord : goodKeyWords) {
        if(message.indexOf(keyWord) != -1) {
          array[0][i] = message.trim();
          i++;
        }
      }
      for (String word : badKeyWords) {
        if(message.contains(word)) {
          array[1][x] = message.trim();
          x++;
        }
      }
    }
    // Array[0] = Good Messages; Array[1] = Bad Messages
    return array;
  }

  public void displayingData(String[][] array) {
    System.out.println("Some things you did well on!");
    for (String element : array[0]) {
      if (element == null) break;
      System.out.println("- " + element);
    }
    System.out.println("Some things you could improve on!");
    for (String element : array[1]) {
      if(element == null) break;
      System.out.println("- " + element);
    }
  }
}
