package tw.ch1ck3n.quickgamemode.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tw.ch1ck3n.quickgamemode.QuickGamemode;

public class GmCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) return true;

        Bukkit.getScheduler().runTask(QuickGamemode.INSTANCE, () -> {
            if (args.length != 0) return;

            GameMode mode;
            if (s.equalsIgnoreCase("gma")) mode = GameMode.ADVENTURE;
            else if (s.equalsIgnoreCase("gmc")) mode = GameMode.CREATIVE;
            else if (s.equalsIgnoreCase("gmsp")) mode = GameMode.SPECTATOR;
            else if (s.equalsIgnoreCase("gms")) mode = GameMode.SURVIVAL;
            else return;

            if (((Player) sender).getGameMode().equals(mode)) return;
            Bukkit.dispatchCommand(sender, "gamemode " + mode.toString().toLowerCase());
        });
        return true;
    }
}
