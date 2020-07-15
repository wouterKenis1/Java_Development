public class Beer {
    int id;
    String name;
    int brewerId;
    int categoryId;
    float price;
    int stock;
    float alcohol;
    int version;

    public Beer(){
    }

    public Beer(int id, String name, int brewerId, int categoryId, float price, int stock, float alcohol, int version) {
        this.id = id;
        this.name = name;
        this.brewerId = brewerId;
        this.categoryId = categoryId;
        this.price = price;
        this.stock = stock;
        this.alcohol = alcohol;
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBrewerId() {
        return brewerId;
    }

    public void setBrewerId(int brewerId) {
        this.brewerId = brewerId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        stock = stock;
    }

    public float getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(float alcohol) {
        this.alcohol = alcohol;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
