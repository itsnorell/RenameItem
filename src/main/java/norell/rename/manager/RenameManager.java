package norell.rename.manager;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import norell.rename.Main;

public class RenameManager {

    public static boolean renameItem(Player player, String input) {
        if (input == null || input.trim().isEmpty() || input.length() < 3 || input.length() > 15) {
            player.sendMessage("§8» §cItem name must be between 3 and 15 characters.");
            return false;
        }

        Item item = player.getInventory().getItemInHand();
        if (item.getId() == Item.AIR.getId()) {
            player.sendMessage("§8» §cTake an item in your hand.");
            return false;
        }

        if (item.getCount() > 1) {
            player.sendMessage("§8» §cYou can only name 1 item at a time.");
            return false;
        }

        if (!item.isArmor() && !item.isTool()) {
            player.sendMessage("§8» §cThe item cannot be renamed.");
            return false;
        }

        String name = "§e" + input + "\n§3Renamed by: §b" + player.getName();
        item.setCustomName(name);
        player.getInventory().setItemInHand(item);

        player.sendMessage("§8» §aItem renamed.");
        return true;
    }
}
