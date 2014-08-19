package in.hackerearth.compiler;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * You are converting an old code for a new version of the compiler.
 * 
 * In the old code we have used "->" for pointers. But now we have to replace
 * each "->" with a ".". But this replacement shouldn't be done inside
 * commments. A comment is a string that starts with "//" and terminates at the
 * end of the line.
 * 
 * Input:
 * 
 * At max. 2000 lines of code.
 * 
 * Each line of code consists of at maximum 60 characters.
 * 
 * Output:
 * 
 * New code with required changes.
 * 
 * Sample Input int t; //variable t t->a=0; //t->a does something return 0;
 * 
 * Sample Output int t; //variable t t.a=0; //t->a does something return 0;
 * 
 * Explanation "->" is not converted to "." inside comments.
 */

class Compiler {
public static void main(String args[]) throws Exception {

  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  String thisLine = null;

  while ((thisLine = br.readLine()) != null) {
    StringBuffer str = new StringBuffer(thisLine);
    int firstPointer = str.indexOf("->");
    int firstComment = str.indexOf("//");
    while (getModificationCondition(firstPointer, firstComment)) {
      str.replace(firstPointer, firstPointer + 2, ".");
      firstPointer = str.indexOf("->");
      firstComment = str.indexOf("//");
    }
    System.out.println(str);

  }
}

private static boolean getModificationCondition(int firstPointer,
    int firstComment) {
  if (firstPointer < 0) {
    return false;
  }

  else {
    if (firstComment >= 0)
      return firstComment > firstPointer;
    else
      return firstPointer >= 0;

  }

  // System.out.println("Hello World!");
}
}
