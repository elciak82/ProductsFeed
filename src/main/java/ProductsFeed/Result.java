package ProductsFeed;

public class Result {

    private String name;
    private int price;
    private String owner;
    private boolean onlineOnly;

    public Result(String name, int price, String owner, boolean onlineOnly) {
        this.name = name;
        this.price = price;
        this.owner = owner;
        this.onlineOnly = onlineOnly;
    }

    public String name() {
        return this.name;
    }

    public int price() {
        return this.price;
    }

    public String owner () {
        return this.owner;
    }

    public boolean onlineOnly() {
        return this.onlineOnly;
    }

    @Override
    public String toString() {
        return name + " - " + price + " - " + owner + " - " + onlineOnly;
    }

}
