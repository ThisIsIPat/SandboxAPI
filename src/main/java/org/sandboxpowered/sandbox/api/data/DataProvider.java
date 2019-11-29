package org.sandboxpowered.sandbox.api.data;

public interface DataProvider {
    void write(DataFile file);

    String getName();
}
