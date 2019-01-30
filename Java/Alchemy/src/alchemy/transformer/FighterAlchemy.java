package alchemy.transformer;

import alchemy.general.ConversionRate;
import alchemy.items.Sword;
import alchemy.materials.Iron;

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
