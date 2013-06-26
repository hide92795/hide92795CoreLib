package hide92795.bukkit.plugin.corelib;

import java.util.Random;
import org.bukkit.ChatColor;

public class Tool {
	private Random rand = new Random();
	private static final String RAINBOW[] = { "DARK_RED", "RED", "GOLD", "YELLOW", "GREEN", "DARK_GREEN", "AQUA",
			"DARK_AQUA", "BLUE", "DARK_BLUE", "LIGHT_PURPLE", "DARK_PURPLE" };


	/**
	 * Replaces all the colors
	 * 
	 * @see <a href="https://github.com/xGhOsTkiLLeRx/ColorMe/blob/master/src/main/java/de/dustplanet/colorme/Actions.java">ColorMe Plugin</a>
	 * @author xGh0sTkiLLeRx
	 * @param string
	 *            - the message
	 * @return the colored message
	 */
	public String replaceThings(String string) {
		if (string == null) {
			return "";
		}
		// While random is in there
		String sub;
		while (string.contains("\u0026random")) {
			// Without random
			int i = string.indexOf("\u0026random") + 7;
			int z = string.length();
			sub = string.substring(i, z);
			// Stop if other ampersand or section sign is found
			if (sub.contains("\u0026")) {
				sub = sub.substring(0, sub.indexOf("\u0026"));
			}
			if (sub.contains("\u00A7")) {
				sub = sub.substring(0, sub.indexOf("\u00A7"));
			}
			// Replace
			string = string.replace(sub, randomColor(sub));
			// Replace FIRST random
			string = string.replaceFirst("\u0026random", "");
			sub = "";
		}
		// While random (short) is in there
		while (string.contains("\u0026ran")) {
			// Without random
			int i = string.indexOf("\u0026ran") + 4;
			int z = string.length();
			sub = string.substring(i, z);
			// Stop if other ampersand or � is found
			if (sub.contains("\u0026")) {
				sub = sub.substring(0, sub.indexOf("\u0026"));
			}
			if (sub.contains("\u00A7")) {
				sub = sub.substring(0, sub.indexOf("\u00A7"));
			}
			// Replace
			string = string.replace(sub, randomColor(sub));
			// Replace FIRST random
			string = string.replaceFirst("\u0026ran", "");
			sub = "";
		}
		// While rainbow is in there
		while (string.contains("\u0026rainbow")) {
			// Without rainbow
			int i = string.indexOf("\u0026rainbow") + 8;
			int z = string.length();
			sub = string.substring(i, z);
			// Stop if other ampersand or section sign is found
			if (sub.contains("\u0026")) {
				sub = sub.substring(0, sub.indexOf("\u0026"));
			}
			if (sub.contains("\u00A7")) {
				sub = sub.substring(0, sub.indexOf("\u00A7"));
			}
			// Replace
			string = string.replace(sub, rainbowColor(sub));
			// Replace FIRST rainbow
			string = string.replaceFirst("\u0026rainbow", "");
			sub = "";
		}
		// While rainbow (short) is in there
		while (string.contains("\u0026rai")) {
			// Without rainbow
			int i = string.indexOf("\u0026rai") + 4;
			int z = string.length();
			sub = string.substring(i, z);
			// Stop if other ampersand or section sign is found
			if (sub.contains("\u0026")) {
				sub = sub.substring(0, sub.indexOf("\u0026"));
			}
			if (sub.contains("\u00A7")) {
				sub = sub.substring(0, sub.indexOf("\u00A7"));
			}
			// Replace
			string = string.replace(sub, rainbowColor(sub));
			// Replace FIRST rainbow
			string = string.replaceFirst("\u0026rai", "");
			sub = "";
		}
		// Normal color codes!
		string = ChatColor.translateAlternateColorCodes('\u0026', string);
		return string;
	}

	/**
	 * Creates a rainbow effect
	 * You may use this method in your own plugin,
	 * please give me credits then!
	 * 
	 * @see <a href="https://github.com/xGhOsTkiLLeRx/ColorMe/blob/master/src/main/java/de/dustplanet/colorme/Actions.java">ColorMe Plugin</a>
	 * @author xGh0sTkiLLeRx
	 * @param name
	 *            - name of the player
	 * @return the updated name
	 */
	public String rainbowColor(String name) {
		// As long as the length of the name isn't reached
		int z = 0;
		StringBuffer buf = new StringBuffer();
		for (char ch : name.toCharArray()) {
			// Reset if z reaches 12
			if (z == 12) {
				z = 0;
			}
			// Add to the new name the colored character
			buf.append(ChatColor.valueOf(RAINBOW[z]) + Character.toString(ch));
			z++;
		}
		return buf.toString();
	}

	/**
	 * Creates a random color
	 * You may use this method in your own plugin,
	 * please give me credits then!
	 * 
	 * @see <a href="https://github.com/xGhOsTkiLLeRx/ColorMe/blob/master/src/main/java/de/dustplanet/colorme/Actions.java">ColorMe Plugin</a>
	 * @author xGh0sTkiLLeRx
	 * @param name
	 *            - name of the player
	 * @return the updated name
	 */
	public String randomColor(String name) {
		StringBuffer buf = new StringBuffer();
		// As long as the length of the name isn't reached
		for (char ch : name.toCharArray()) {
			// Roll the dice between the chat color values
			int x = rand.nextInt(ChatColor.values().length);
			// Color the character
			buf.append(ChatColor.values()[x] + Character.toString(ch));
		}
		return buf.toString();
	}

}
