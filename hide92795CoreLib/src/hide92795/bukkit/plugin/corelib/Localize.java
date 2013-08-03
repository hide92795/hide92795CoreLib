package hide92795.bukkit.plugin.corelib;

import java.io.File;
import java.io.InputStream;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Localize {
	private final JavaPlugin plugin;
	private File configFile;
	private FileConfiguration config;

	public Localize(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	public void reload(String lang) throws Exception {
		configFile = new File(plugin.getDataFolder(), lang + ".yml");

		config = YamlConfiguration.loadConfiguration(configFile);
		config.options().copyDefaults(true);

		InputStream defConfigStream = plugin.getResource("jp.yml");
		if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
			config.setDefaults(defConfig);

		}

		config.save(configFile);
	}

	public String getString(Localizable path) {
		return CoreLib.getCoreLib().getTool().replaceThings(config.getString(path.getName()));
	}
}
