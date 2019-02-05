package transformer;

import general.ConversionRate;
import items.Sword;
import materials.Iron;

public class FighterAlchemy extends BasicAlchemy implements Transmutation<Sword, Iron> {

    @Override
    public Iron convertToMaterials(Sword reagent) {
        return new Iron(ConversionRate.SWORD_TO_IRON);
    }

    @Override
    public Sword convertFromMaterials(Iron reagent) {
        return reagent.getQuantity() >= ConversionRate.IRON_TO_SWORD ? new Sword() : null;
    }

}
