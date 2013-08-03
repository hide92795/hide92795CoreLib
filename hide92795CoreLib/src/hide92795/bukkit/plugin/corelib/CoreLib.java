package hide92795.bukkit.plugin.corelib;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class CoreLib extends JavaPlugin {
	private Tool tool;

	@Override
	public void onEnable() {
		tool = new Tool();
	}

	public static CoreLib getCoreLib() {
		return (CoreLib) Bukkit.getServer().getPluginManager().getPlugin("hide92795CoreLib");
	}

	public Tool getTool() {
		return tool;
	}
}
