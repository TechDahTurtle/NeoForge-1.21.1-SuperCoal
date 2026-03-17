package techdahturtle.super_coal.block.torch;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

public class TinyWallTorchBlock extends AbstractWallTorchBlock {
    private static final Map<Direction, VoxelShape> AABBS = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, box(5.5D, 3.0D, 11.0D, 10.5D, 10.0D, 16.0D), Direction.SOUTH, box(5.5D, 3.0D, 0.0D, 10.5D, 10.0D, 5.0D), Direction.WEST, box(11.0D, 3.0D, 5.5D, 16.0D, 10.0D, 10.5D), Direction.EAST, box(0.0D, 3.0D, 5.5D, 5.0D, 10.0D, 10.5D)));

    public TinyWallTorchBlock(SimpleParticleType flameParticle, Properties properties) {
        super(flameParticle, properties);
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext context) {
        return getShape(blockState);
    }

    public static VoxelShape getShape(BlockState blockState) {
        return AABBS.get(blockState.getValue(FACING));
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        Direction direction = blockState.getValue(FACING);
        double d0 = (double)blockPos.getX() + 0.5D;
        double d1 = (double)blockPos.getY() + 0.4D;
        double d2 = (double)blockPos.getZ() + 0.5D;
        Direction direction1 = direction.getOpposite();

        // Keep vanilla horizontal offset math so particles match wall-facing direction.
        level.addParticle(ParticleTypes.SMOKE, d0 + 0.27D * (double)direction1.getStepX(), d1 + 0.22D, d2 + 0.27D * (double)direction1.getStepZ(), 0.0D, 0.0D, 0.0D);
        level.addParticle(this.flameParticle, d0 + 0.27D * (double)direction1.getStepX(), d1 + 0.22D, d2 + 0.27D * (double)direction1.getStepZ(), 0.0D, 0.0D, 0.0D);
    }
}
