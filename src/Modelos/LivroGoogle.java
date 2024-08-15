package Modelos;

import APIs.googlebooks.Item;

import java.util.List;

public class LivroGoogle {
    private List<Item> items;

    // Getter e Setter para items
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}