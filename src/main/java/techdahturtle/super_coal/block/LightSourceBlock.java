package techdahturtle.super_coal.block;

import net.minecraft.world.level.block.Block;

/**
 * A block that emits light.
 *
 * @author Lemon_Juiced
 */
public class LightSourceBlock extends Block {

    /**
     * Constructor for LightSourceBlock.
     *
     * @param properties The block properties.
     * @param lightLevel The light level emitted by the block (0-15).
     */
    public LightSourceBlock(Properties properties, int lightLevel) {
        super(properties.lightLevel((state) -> lightLevel));
    }
}
