package sample;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product {
    private final SimpleStringProperty title;
    private final SimpleStringProperty unit;
    private final SimpleFloatProperty volume;
    private final SimpleFloatProperty purchPrice;
    private final SimpleFloatProperty sellPrice;
    private final SimpleFloatProperty drPrice;
    private final SimpleFloatProperty purchAmount;
    private final SimpleFloatProperty sellAmount;
    private final SimpleFloatProperty drAmount;

    public Product(String title, String unit, float volume, float purchPrice,float sellPrice, float drPrice, float purchAmount, float sellAmount, float drAmount) {
        this.title = new SimpleStringProperty(title);
        this.unit = new SimpleStringProperty(unit);
        this.volume = new SimpleFloatProperty(volume);
        this.purchPrice = new SimpleFloatProperty(purchPrice);
        this.sellPrice = new SimpleFloatProperty(sellPrice);
        this.drPrice = new SimpleFloatProperty(drPrice);
        this.purchAmount = new SimpleFloatProperty(purchAmount);
        this.sellAmount = new SimpleFloatProperty(sellAmount);
        this.drAmount = new SimpleFloatProperty(drAmount);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public float getPurchPrice() {
        return purchPrice.get();
    }

    public void setPurchPrice(float purchPrice) {
        this.purchPrice.set(purchPrice);
    }

    public float getSellPrice() {
        return sellPrice.get();
    }

    public SimpleFloatProperty sellPriceProperty() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice.set(sellPrice);
    }

    public float getDrPrice() {
        return drPrice.get();
    }

    public SimpleFloatProperty drPriceProperty() {
        return drPrice;
    }

    public void setDrPrice(float drPrice) {
        this.drPrice.set(drPrice);
    }

    public String getUnit() {
        return unit.get();
    }

    public SimpleStringProperty unitProperty() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit.set(unit);
    }

    public float getVolume() {
        return volume.get();
    }

    public SimpleFloatProperty volumeProperty() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume.set(volume);
    }

    public float getpurchPrice() {
        return purchPrice.get();
    }

    public SimpleFloatProperty purchPriceProperty() {
        return purchPrice;
    }

    public void setpurchPrice(float pprice) {
        this.purchPrice.set(pprice);
    }

    public float getPurchAmount() {
        return purchAmount.get();
    }

    public SimpleFloatProperty purchAmountProperty() {
        return purchAmount;
    }

    public void setPurchAmount(float purchAmount) {
        this.purchAmount.set(purchAmount);
    }

    public float getSellAmount() {
        return sellAmount.get();
    }

    public SimpleFloatProperty sellAmountProperty() {
        return sellAmount;
    }

    public void setSellAmount(float sellAmount) {
        this.sellAmount.set(sellAmount);
    }

    public float getDrAmount() {
        return drAmount.get();
    }

    public SimpleFloatProperty drAmountProperty() {
        return drAmount;
    }

    public void setDrAmount(float drAmount) {
        this.drAmount.set(drAmount);
    }
}
