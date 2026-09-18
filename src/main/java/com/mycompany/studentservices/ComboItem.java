package com.mycompany.studentservices;

public class ComboItem {
    private final int id;
    private final String name;

    public ComboItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name; // this is what the JComboBox displays
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ComboItem)) return false;
        return id == ((ComboItem) obj).id; // match by ID, not name
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}