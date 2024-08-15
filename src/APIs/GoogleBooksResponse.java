package APIs;

public class GoogleBooksResponse {
    private Volume[] items;

    public Volume[] getItems() {
        return items;
    }

    public void setItems(Volume[] items) {
        this.items = items;
    }
}