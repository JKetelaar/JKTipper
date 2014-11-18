package nl.jketelaar.tipper;

/**
 * @author JKetelaar
 */
public enum Tips {
    TOPAZ(9188, 9141),
    PEARL(46, 9140),
    SAPHIRE(9189, 9142),
    EMERALD(9190, 9142),
    RUBY(9191, 9143),
    DIAMOND(9192, 9143),
    DRAGON(9193, 9144);

    private int tipID;
    private int boltID;

    Tips(int tipID, int boltID) {
        this.tipID = tipID;
        this.boltID = boltID;
    }

    public int getTipID() {
        return this.tipID;
    }

    public int getBoltID() {
        return this.boltID;
    }

    public int getTipInventoryID() {
        return this.tipID + 1;
    }

    public int getBoltInventoryID() {
        return this.boltID + 1;
    }
}
