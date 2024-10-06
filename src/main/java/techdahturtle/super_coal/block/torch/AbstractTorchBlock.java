package techdahturtle.super_coal.block.torch;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.level.block.TorchBlock;

public class AbstractTorchBlock extends TorchBlock {

    public AbstractTorchBlock(SimpleParticleType flameParticle, Properties properties) {
        super(flameParticle, properties);
    }
}