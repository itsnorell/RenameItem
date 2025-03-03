package norell.rename;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import norell.rename.commands.*;
import norell.rename.forms.*;

public class Main extends PluginBase {

    public static int RenamePrice = 100;

    public final static int RenameItemFormID = 1;

    @Override
    public void onEnable() {
        this.getLogger().info(TextFormat.GREEN + "ReName [+]");
        getServer().getPluginManager().registerEvents(new RenameItemForm(), this);
        getServer().getCommandMap().register("eisim", new RenameItemCommand());
    }
}
