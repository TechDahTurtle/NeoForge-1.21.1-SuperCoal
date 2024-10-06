package techdahturtle.super_coal.block;

import dev.lemonjuice.scalar_core.item.FuelBlockItem;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import techdahturtle.super_coal.SuperCoal;
import techdahturtle.super_coal.block.torch.AbstractTorchBlock;
import techdahturtle.super_coal.block.torch.AbstractWallTorchBlock;
import techdahturtle.super_coal.block.torch.TinyTorchBlock;
import techdahturtle.super_coal.block.torch.TinyWallTorchBlock;
import techdahturtle.super_coal.item.SCoalItems;

import java.util.function.Supplier;

public class SCoalBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SuperCoal.MOD_ID);

    public static final DeferredBlock<Block> COMPRESSED_COAL_BLOCK = registerFuelBlock("compressed_coal_block", () -> new Block(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.STONE)), 720);
    public static final DeferredBlock<Block> NETHER_COAL_BLOCK = registerFuelBlock("nether_coal_block", () -> new Block(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.STONE)), 160);
    public static final DeferredBlock<Block> COMPRESSED_NETHER_COAL_BLOCK = registerFuelBlock("compressed_nether_coal_block", () -> new Block(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.STONE)), 1440);

    public static final DeferredBlock<Block> NETHER_COAL_ORE = registerBlock("nether_coal_ore", () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of().strength(3F).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> TINY_TORCH = registerBlockWithoutBlockItem("tiny_torch", () -> new TinyTorchBlock(ParticleTypes.FLAME, BlockBehaviour.Properties.of().strength(0.0F).noCollission().lightLevel((state) -> 7).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> TINY_WALL_TORCH = registerBlockWithoutBlockItem("tiny_wall_torch", () -> new TinyWallTorchBlock(ParticleTypes.FLAME, BlockBehaviour.Properties.of().strength(0.0F).noCollission().lightLevel((state) -> 7).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> TINY_STONE_TORCH = registerBlockWithoutBlockItem("tiny_stone_torch", () -> new TinyTorchBlock(ParticleTypes.FLAME, BlockBehaviour.Properties.of().strength(0.0F).noCollission().lightLevel((state) -> 7).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TINY_STONE_WALL_TORCH = registerBlockWithoutBlockItem("tiny_stone_wall_torch", () -> new TinyWallTorchBlock(ParticleTypes.FLAME, BlockBehaviour.Properties.of().strength(0.0F).noCollission().lightLevel((state) -> 7).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TINY_NETHER_TORCH = registerBlockWithoutBlockItem("tiny_nether_torch", () -> new TinyTorchBlock(ParticleTypes.FLAME, BlockBehaviour.Properties.of().strength(0.0F).noCollission().lightLevel((state) -> 15).sound(SoundType.NETHER_BRICKS)));
    public static final DeferredBlock<Block> TINY_NETHER_WALL_TORCH = registerBlockWithoutBlockItem("tiny_nether_wall_torch", () -> new TinyWallTorchBlock(ParticleTypes.FLAME, BlockBehaviour.Properties.of().strength(0.0F).noCollission().lightLevel((state) -> 15).sound(SoundType.NETHER_BRICKS)));
    public static final DeferredBlock<Block> STONE_TORCH = registerBlockWithoutBlockItem("stone_torch", () -> new AbstractTorchBlock(ParticleTypes.FLAME, BlockBehaviour.Properties.of().strength(0.0F).noCollission().lightLevel((state) -> 14).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> STONE_WALL_TORCH = registerBlockWithoutBlockItem("stone_wall_torch", () -> new AbstractWallTorchBlock(ParticleTypes.FLAME, BlockBehaviour.Properties.of().strength(0.0F).noCollission().lightLevel((state) -> 14).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> NETHER_TORCH = registerBlockWithoutBlockItem("nether_torch", () -> new AbstractTorchBlock(ParticleTypes.FLAME, BlockBehaviour.Properties.of().strength(0.0F).noCollission().lightLevel((state) -> 15).sound(SoundType.NETHER_BRICKS)));
    public static final DeferredBlock<Block> NETHER_WALL_TORCH = registerBlockWithoutBlockItem("nether_wall_torch", () -> new AbstractWallTorchBlock(ParticleTypes.FLAME, BlockBehaviour.Properties.of().strength(0.0F).noCollission().lightLevel((state) -> 15).sound(SoundType.NETHER_BRICKS)));

    private static <T extends Block> DeferredBlock<T> registerFuelBlock(String name, Supplier<T> block, int items) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerFuelBlockItem(name, toReturn, items);
        return toReturn;
    }

    private static <T extends Block> void registerFuelBlockItem(String name, DeferredBlock<T> block, int items) {
        SCoalItems.ITEMS.register(name, () -> new FuelBlockItem(block.get(), new Item.Properties(), items));
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        SCoalItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static <T extends Block> DeferredBlock<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
