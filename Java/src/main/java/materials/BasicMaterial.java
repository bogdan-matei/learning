package materials;

import exception.ConversionException;
import general.StorageItem;

//Used to identify materials
public class BasicMaterial extends StorageItem {

    private Integer quantity;

    public BasicMaterial() {
        quantity = 0;
    }

    public BasicMaterial(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void addMaterial(Integer toAdd) {
        quantity += toAdd;
    }

    public void consumeMaterial() throws ConversionException {
        if (quantity < 10)
            throw new ConversionException();
        quantity -= 10;
    }
}
