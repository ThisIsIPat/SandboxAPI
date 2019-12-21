package org.sandboxpowered.sandbox.api.item;

import org.sandboxpowered.sandbox.api.fluid.BaseFluid;

public class BucketItem extends BaseItem {
    private BaseFluid fluid;

    public BucketItem(BaseFluid fluid, Settings settings) {
        super(settings);
        this.fluid = fluid;
    }

    public BaseFluid getFluid() {
        return fluid;
    }
}