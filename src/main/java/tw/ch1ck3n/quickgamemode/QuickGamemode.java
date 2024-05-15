package tw.ch1ck3n.quickgamemode;

import org.bukkit.plugin.java.JavaPlugin;
import tw.ch1ck3n.quickgamemode.commands.GmCmd;

public final class QuickGamemode extends JavaPlugin {

    public static QuickGamemode INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        this.getCommand("gm").setExecutor(new GmCmd());
    }
}
