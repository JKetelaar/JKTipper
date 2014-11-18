package nl.jketelaar.tipper;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;

import java.util.ArrayList;

/**
 * @author JKetelaar
 */
@ScriptManifest(author = "Paradox & Sjoerdieman",
        category = Category.FLETCHING,
        description = "A bolt tipper for Soulsplit and Torva",
        name = "JKSBoltTipper",
        servers = { "Soulsplit", "Torva" },
        version = 1.3)

public class Core extends Script {
    private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();

    private Tips tip;

    @Override
    public boolean onExecute() {
        UI ui = new UI(this);

        while (ui.getFrame().isVisible()){
            Time.sleep(500);
        }

        strategies.add(new Tip(this.tip));
        provide(strategies);
        return true;
    }

    public void setTip(Tips tip) {
        this.tip = tip;
    }
}
