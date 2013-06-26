package hide92795.bukkit.plugin.corelib;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Usage {
	private final ArrayList<String> temp;
	private final JavaPlugin plugin;
	private String usage;

	public Usage(JavaPlugin plugin) {
		this.plugin = plugin;
		temp = new ArrayList<>();
	}

	public void addCommand(String command, String desc) {
		StringBuilder sb = new StringBuilder();
		sb.append(ChatColor.GOLD);
		sb.append(command);
		sb.append("\n");

		sb.append(ChatColor.YELLOW);
		sb.append("  ");
		sb.append(desc);
		sb.append("\n");
		temp.add(sb.toString());
	}

	@Override
	public String toString() {
		if (usage == null) {
			String name = plugin.getName();
			int length = name.length();
			int all;
			if (length % 2 == 1) {
				// 奇数
				all = 31;
			} else {
				// 偶数
				all = 30;
			}
			int left = (all - length - 2) / 2;
			StringBuilder sb = new StringBuilder();
			// 始まり
			sb.append(ChatColor.YELLOW);
			for (int i = 0; i < left; i++) {
				sb.append("=");
			}
			sb.append(" ");
			sb.append(name);
			sb.append(" ");
			for (int i = 0; i < left; i++) {
				sb.append("=");
			}
			sb.append("\n");
			// 本文
			for (String command : temp) {
				sb.append(command);
			}
			sb.append(ChatColor.YELLOW);
			// 最後
			for (int i = 0; i < all; i++) {
				sb.append("=");
			}
			usage = sb.toString();
		}
		return usage;
	}
}
