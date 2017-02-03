package br.com.cpbr.perguntas.model;

public class Player {

    private String image;
    private String name;
    private int pointsAmount;
    private int productsAcquired;
    private int rank;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPointsAmount() {
        return pointsAmount;
    }

    public void setPointsAmount(int pointsAmount) {
        this.pointsAmount = pointsAmount;
    }

    public int getProductsAcquired() {
        return productsAcquired;
    }

    public void setProductsAcquired(int productsAcquired) {
        this.productsAcquired = productsAcquired;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
