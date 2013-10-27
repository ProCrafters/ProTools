package pl.themolka.protools;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ProtoolsCommand implements CommandExecutor {

	ProTools plugin;
	
	public ProtoolsCommand(ProTools proTools) {
		plugin = proTools;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("protools") || command.getName().equalsIgnoreCase("pt")) {
			if(args.length == 0) {
				return erArg(sender, "Zbyt malo argumentów!");
			}
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("about") || args[0].equalsIgnoreCase("info") || args[0].equalsIgnoreCase("version") || args[0].equalsIgnoreCase("author")) {
					return aboutArg(sender);
				}
				if(args[0].equalsIgnoreCase("border")) {
					return borderArg(sender);
				}
				if(args[0].equalsIgnoreCase("reload")) {
					return reloadArg(sender);
				} else {
					return erArg(sender, "Podano bledny argument!");
				}
			}
			if(args.length == 2) {
				if(args[0].equalsIgnoreCase("border")) {
					return setBorderArg(sender, args[0]);
				} else {
					return erArg(sender, "Podano bledny argument!");
				}
			} else {
				return erArg(sender, "Podano zbyt duzo argumentów!");
			}
		}
		return false;
	}
	
	private boolean erArg(CommandSender sender, String arg) {
		sender.sendMessage(ChatColor.GOLD + "[ProTools] " + ChatColor.RED + arg);
		sender.sendMessage(ChatColor.RED + "Uzycie: " + plugin.getCommand("protools").getUsage());
		return true;
	}
	
	private boolean aboutArg(CommandSender sender) {
		sender.sendMessage(ChatColor.GOLD + "Version: " + ChatColor.GRAY + plugin.getDescription().getVersion());
		sender.sendMessage(ChatColor.GOLD + "Author: " + ChatColor.GRAY + plugin.getDescription().getAuthors());
		sender.sendMessage(ChatColor.GOLD + "Mail: " + ChatColor.GRAY + "themolkapl@gmail.com");
		sender.sendMessage(ChatColor.GOLD + "GitHub: " + ChatColor.GRAY + plugin.getDescription().getWebsite());
		return true;
	}
	
	private boolean borderArg(CommandSender sender) {
		sender.sendMessage(ChatColor.GOLD + "[ProTools] " + ChatColor.GRAY + "Aktualny promien mapy to " + Border.getRadius() + ".");
		return true;
	}
	
	private boolean reloadArg(CommandSender sender) {
		if(!sender.hasPermission("protools.reload")) {
			sender.sendMessage(ChatColor.GOLD + "[ProTools] " + Util.permissions());
			return true;
		}
		sender.sendMessage(ChatColor.GOLD + "[ProTools] " + ChatColor.GRAY + "Przeladowywanie pliku config.yml...");
		plugin.reloadConfig();
		sender.sendMessage(ChatColor.GOLD + "[ProTools] " + ChatColor.DARK_GREEN + "Pomyslnie przeladowano plik config.yml");
		return true;
	}
	
	private boolean setBorderArg(CommandSender sender, String arg) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Nie mozesz uzyc tej komendy z poziomu konsoli!");
			return true;
		}
		if(!sender.hasPermission("protools.setborder")) {
			sender.sendMessage(ChatColor.GOLD + "[ProTools] " + Util.permissions());
			return true;
		}
		Player player = (Player) sender;
		Location location = player.getLocation();
		try {
			int radius = Integer.parseInt(arg);
			Border.setBorder(player, location, radius);
			return true;
		} catch(NumberFormatException ex) {
			sender.sendMessage(ChatColor.GOLD + "[ProTools] " + ChatColor.RED + "Promien musi byc liczba!");
			return true;
		}
	}
	
}
