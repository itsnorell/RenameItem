package norell.rename.forms;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.ElementInput;
import cn.nukkit.form.element.ElementLabel;
import cn.nukkit.form.response.FormResponseCustom;
import cn.nukkit.form.window.FormWindowCustom;
import norell.rename.Main;
import norell.rename.manager.RenameManager;

public class RenameItemForm implements Listener {

    public static void openForm(Player player) {
        FormWindowCustom form = new FormWindowCustom("Eşya isim Değiştirme");
        form.addElement(new ElementLabel(
                String.format("§7Type the new name of the item."))
        );
        form.addElement(new ElementInput("Enter Item Name:", "NoRell's Picaxe"));

        player.showFormWindow(form, Main.RenameItemFormID);
    }

    @EventHandler
    public void onFormEvent(PlayerFormRespondedEvent event) {
        try {
            Player player = event.getPlayer();
            if (event.getFormID() == Main.RenameItemFormID) {
                if (event.getWindow() instanceof FormWindowCustom) {
                    if (event.getResponse() != null) {
                        FormResponseCustom response = (FormResponseCustom) event.getResponse();
                        String input = response.getInputResponse(1);
                        RenameManager.renameItem(player, input);
                        }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
