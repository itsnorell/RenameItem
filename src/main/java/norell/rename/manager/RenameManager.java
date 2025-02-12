package norell.rename.manager;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import norell.rename.Main;

public class RenameManager {

    public static boolean renameItem(Player player, String input) {
        System.out.println("Renaming item with input: " + input);
        if (input == null || input.trim().isEmpty() || input.length() < 3 || input.length() > 15) {
            player.sendMessage("§8» §cEşya adı 3 ile 15 karakter arasında olmalıdır.");
            return false;
        }

        Item item = player.getInventory().getItemInHand();
        if (item.getId() == Item.AIR.getId()) {
            player.sendMessage("§8» §cEline bir eşya al.");
            return false;
        }

        if (item.getCount() > 1) {
            player.sendMessage("§8» §cTek seferde sadece 1 eşya isimlendirebilirsiniz.");
            return false;
        }

        if (!item.isArmor() && !item.isTool()) {
            player.sendMessage("§8» §cElindeki eşya isimlendirilemez.");
            return false;
        }

        int price = input.length() * Main.RenamePrice;
        String name = "§e" + input + "\n§3İmzalayan: §b" + player.getName();
        item.setCustomName(name);
        player.getInventory().setItemInHand(item);

        player.sendMessage("§8» §aKesilen Ücret: §6" + price + " TL");
        player.sendMessage("§8» §aEşya yeniden adlandırıldı.");
        return true;
    }
}
