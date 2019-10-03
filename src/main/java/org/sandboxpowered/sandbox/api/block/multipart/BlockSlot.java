package org.sandboxpowered.sandbox.api.block.multipart;

public class BlockSlot implements Slot {
    /**
     * A slot located in the center of the block.<br>
     * Used for blocks such as pipes that have a single central element.
     */
    public static final Slot CENTER = new BlockSlot();

    /**
     * This slot shouldn't be used.<br>
     * It exists to define a block that does not support Multipart.
     */
    public static final Slot EMPTY = new BlockSlot();
}