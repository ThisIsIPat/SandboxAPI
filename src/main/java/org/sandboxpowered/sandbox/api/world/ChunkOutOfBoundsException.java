package org.sandboxpowered.sandbox.api.world;

public class ChunkOutOfBoundsException extends IndexOutOfBoundsException { // Move this to an exception package? Even necessary at all in the API?
    public ChunkOutOfBoundsException() {
        super("The requested chunk is out of bounds");
    }
}
