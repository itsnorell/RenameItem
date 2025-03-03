package norell.rename.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import norell.rename.forms.RenameItemForm;

import java.util.Objects;

public class RenameItemCommand extends Command {

    public RenameItemCommand() {
        super("rename", "Do you want to give a special name to your items?");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;

        Item item = player.getInventory().getItemInHand();
        if (Objects.equals(item.getId(), Item.AIR.getId())) {
            player.sendMessage("§8» §cTake an item in your hand.");
            return false;
        }
        if (!item.isArmor() && !item.isTool()) {
            player.sendMessage("§8» §cThe item cannot be named.");
            return false;
        }
        RenameItemForm.openForm(player);
        return true;
    }
}
