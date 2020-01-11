package pharmacy;

import data.ProductID;

public class MedicineDispensingLine {

    private boolean adquired;

    public MedicineDispensingLine(ProductID prodID){

        this.adquired = true;

    }

    public boolean isAdquired() {
        return adquired;
    }

}
