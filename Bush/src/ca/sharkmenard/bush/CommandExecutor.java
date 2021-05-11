package ca.sharkmenard.bush;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandExecutor implements org.bukkit.command.CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(label.equalsIgnoreCase("givebush")) {
				if(args.length >= 1) {
					if(args[0].equalsIgnoreCase("Xp")) {
						BushGenerator bush;
						if(args.length == 2) {
							try {
								int i =  Integer.parseInt(args[0]);
								bush = new BushGenerator(Bush.Xp, i);

							}catch (NumberFormatException e) {
								bush = new BushGenerator(Bush.Xp, 1);
							}
							p.getInventory().addItem(bush.getItemStack());

						}else {
							bush = new BushGenerator(Bush.Xp, 1);
							p.getInventory().addItem(bush.getItemStack());

						}
					}
					if(args[0].equalsIgnoreCase("diamond")) {
						BushGenerator bush;

						if(args.length == 2) {
							try {
								int i =  Integer.parseInt(args[0]);
								bush = new BushGenerator(Bush.Diamond, i);

							}catch (NumberFormatException e) {
								bush = new BushGenerator(Bush.Diamond, 1);
							}
							p.getInventory().addItem(bush.getItemStack());

						}else {
							bush = new BushGenerator(Bush.Xp, 1);
							p.getInventory().addItem(bush.getItemStack());
						}
					}
				}
			}

		}
		return false;
	}

}
