package nl.jketelaar.tipper;

import org.parabot.environment.api.utils.Filter;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.soulsplit.api.methods.Inventory;
import org.soulsplit.api.methods.Menu;
import org.soulsplit.api.wrappers.Item;

/**
 * @author JKetelaar
 */
public class Tip implements Strategy {

    private Tips tip;

    public Tip( Tips tip){
        this.tip = tip;
    }

    @Override
    public boolean activate() {
        return inventoryContains(this.tip.getBoltInventoryID()) && inventoryContains(this.tip.getTipInventoryID());
    }

    @Override
    public void execute() {
        Menu.sendAction(447, this.tip.getTipID(), getSlotID(this.tip.getTipInventoryID()), 3214);
        Time.sleep(750, 1250);
        Menu.sendAction(870, this.tip.getBoltID(), getSlotID(this.tip.getBoltInventoryID()), 3214);
        Time.sleep(750, 1250);
    }

    private boolean inventoryContains(final int id){
       return (Inventory.getItems(new Filter<Item>() {
           @Override
           public boolean accept(Item item) {
               return item.getId() == id;
           }
       }).length > 0);
    }

    private int getSlotID(int itemID){
        for (Item i : Inventory.getItems(itemID)){
            return i.getSlot();
        }

        return -1;
    }
}
