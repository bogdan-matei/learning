package inventory;

import items.BasicWeapon;

public class WarriorBackpack extends BasicStorage<BasicWeapon> {
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("------------------------------------------------------\n");
        builder.append("You now have in your warrior backpack the following:\n");
        builder.append(super.toString());
        builder.append("------------------------------------------------------\n");
        return builder.toString();
    }
}
