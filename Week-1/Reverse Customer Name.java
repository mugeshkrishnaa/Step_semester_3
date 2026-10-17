import java.util.*;
public class ReverseCustomerName {

static String reverseName(String name) {
return new StringBuilder(name).reverse().toString();
}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print(&quot;Enter customer name: &quot;);
String name = sc.nextLine();
System.out.println(&quot;Original: &quot; + name);
System.out.println(&quot;Reversed: &quot; + reverseName(name));
sc.close();
}
}
