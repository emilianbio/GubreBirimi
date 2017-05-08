/**
 * 
 */
package araclar;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Emrah Denizer
 *
 */
public class Deneme {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// String text = "This is the text to be searched "
		// + "for occurrences of the http:// pattern.";
		//
		// String patternString = ".*http://.*";
		//
		// Pattern pattern = Pattern.compile(patternString);
		//
		// Matcher matcher = pattern.matcher(text);
		//
		// System.out.println("lookingAt = " + matcher.lookingAt());
		// System.out.println("matches   = " + matcher.matches());
		// System.out.println(1 + 2 + " " + (1 + 2));
		int some = 0;
		String giris = "C:\\Users\\Emrah Denizer\\Web Projelerim\\araziedindirme";
		for (int i = 0; i <= i; i++) {
			some += i;
			System.out.println(some);

			PrintWriter out = new PrintWriter(new FileWriter(giris + ".txt",
					true), true);
			out.write((Integer.toString(i) + " " + Integer.toString(some)));
			out.write(System.getProperty("line.separator"));
			out.close();
		}
	}

}
