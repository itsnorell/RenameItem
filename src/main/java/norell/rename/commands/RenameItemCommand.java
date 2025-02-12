package norell.rename.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import norell.rename.forms.RenameItemForm;

import java.util.Objects;

public class RenameItemCommand extends Command {

    public RenameItemCommand() {
        super("eisim", "Eşyalarına özel bir isim vermek ister misin?");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;

        Item item = player.getInventory().getItemInHand();
        if (Objects.equals(item.getId(), Item.AIR.getId())) {
            player.sendMessage("§8» §cEline bir eşya al.");
            return false;
        }
        if (!item.isArmor() && !item.isTool()) {
            player.sendMessage("§8» §cElindeki eşya isimlendirilemez.");
            return false;
        }
        RenameItemForm.openForm(player);
        return true;
    }
}