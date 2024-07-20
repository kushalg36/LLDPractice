package VendingMachine;

public class Inventory {
    ItemShelf[] inventory = null;
    Inventory(int itemCount) {
        inventory = new ItemShelf[itemCount];
        initEmptyInventory();
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public void initEmptyInventory() {
        int startCode = 101;
        for(int i=0;i<inventory.length;i++) {
            ItemShelf shelf = new ItemShelf();
            shelf.setCode(startCode++);
            shelf.setSoldOut(true);
            inventory[i] = shelf;
        }
    }

    public void addItem(Item item, int codeNumber) throws Exception {
        for(ItemShelf itemShelf : inventory) {
            if(itemShelf.getCode() == codeNumber) {
                if(itemShelf.isSoldOut()) {
                    itemShelf.item = item;
                    itemShelf.setSoldOut(false);
                } else {
                    throw new Exception("already item is present");
                }
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception {
        for(ItemShelf itemShelf : inventory) {
            if(itemShelf.getCode() == codeNumber) {
                if(!itemShelf.isSoldOut()) {
                    return itemShelf.item;
                } else {
                    throw new Exception("already item is present");
                }
            }
        }
        throw new Exception("Invalid code!");
    }

    public void updateSoldOutItem(int codeNumber){
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.code == codeNumber) {
                itemShelf.setSoldOut(true);
            }
        }
    }

}
