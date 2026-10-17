import java.util.*;
public class FirstNonRepeatingCharacter {
static char findCharacter(String text) {
int[] count = new int[256];
for (char c : text.toCharArray())
count[c]++;
for (char c : text.toCharArray())
if (count[c] == 1)
return c;
return &#39;\0&#39;;
}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print(&quot;Enter text: &quot;);
String text = sc.nextLine();
char result = findCharacter(text);
if (result == &#39;\0&#39;)
System.out.println(&quot;No non-repeating character&quot;);
else
System.out.println(&quot;First non-repeating character: &quot; + result);
sc.close();
}
}
