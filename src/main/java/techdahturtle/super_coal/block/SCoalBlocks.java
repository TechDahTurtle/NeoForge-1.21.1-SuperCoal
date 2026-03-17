package techdahturtle.super_coal.block;

import dev.lemonjuice.scalar_core.item.FuelBlockItem;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.valueproviders.UniformInt;
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

import java.util.function.Function;

public class SCoalBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SuperCoal.MOD_ID);

    public static final DeferredBlock<Block> COMPRESSED_COAL_BLOCK = registerFuelBlock("compressed_coal_block", properties -> new Block(properties.strength(2.0F).sound(SoundType.STONE)), 720);
    public static final DeferredBlock<Block> CHARCOAL_BLOCK = registerFuelBlock("charcoal_block", properties -> new Block(properties.strength(2.0F).sound(SoundType.STONE)), 80);
    public static final DeferredBlock<Block> COMPRESSED_CHARCOAL_BLOCK = registerFuelBlock("compressed_charcoal_block", properties -> new Block(properties.strength(2.0F).sound(SoundType.STONE)), 720);
    public static final DeferredBlock<Block> NETHER_COAL_BLOCK = registerFuelBlock("nether_coal_block", properties -> new LightSourceBlock(properties.strength(2.0F).sound(SoundType.STONE), 11), 160);
    public static final DeferredBlock<Block> COMPRESSED_NETHER_COAL_BLOCK = registerFuelBlock("compressed_nether_coal_block", properties -> new LightSourceBlock(properties.strength(2.0F).sound(SoundType.STONE), 15), 1440);
    public static final DeferredBlock<Block> END_COAL_BLOCK = registerFuelBlock("end_coal_block", properties -> new LightSourceBlock(properties.strength(2.0F).sound(SoundType.STONE), 3), 320);
    public static final DeferredBlock<Block> COMPRESSED_END_COAL_BLOCK = registerFuelBlock("compressed_end_coal_block", properties -> new LightSourceBlock(properties.strength(2.0F).sound(SoundType.STONE), 7), 2880);

    public static final DeferredBlock<Block> NETHER_COAL_ORE = registerBlock("nether_coal_ore", properties -> new DropExperienceBlock(UniformInt.of(2, 4), properties.strength(3F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> END_COAL_ORE = registerBlock("end_coal_ore", properties -> new DropExperienceBlock(UniformInt.of(2, 4), properties.strength(3F).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> TINY_TORCH = registerBlockWithoutBlockItem("tiny_torch", properties -> new TinyTorchBlock(ParticleTypes.FLAME, properties.instabreak().noCollision().lightLevel((state) -> 7).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> TINY_WALL_TORCH = registerBlockWithoutBlockItem("tiny_wall_torch", properties -> new TinyWallTorchBlock(ParticleTypes.FLAME, properties.instabreak().noCollision().lightLevel((state) -> 7).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> TINY_STONE_TORCH = registerBlockWithoutBlockItem("tiny_stone_torch", properties -> new TinyTorchBlock(ParticleTypes.FLAME, properties.instabreak().noCollision().lightLevel((state) -> 7).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TINY_STONE_WALL_TORCH = registerBlockWithoutBlockItem("tiny_stone_wall_torch", properties -> new TinyWallTorchBlock(ParticleTypes.FLAME, properties.instabreak().noCollision().lightLevel((state) -> 7).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TINY_NETHER_TORCH = registerBlockWithoutBlockItem("tiny_nether_torch", properties -> new TinyTorchBlock(ParticleTypes.FLAME, properties.instabreak().noCollision().lightLevel((state) -> 15).sound(SoundType.NETHER_BRICKS)));
    public static final DeferredBlock<Block> TINY_NETHER_WALL_TORCH = registerBlockWithoutBlockItem("tiny_nether_wall_torch", properties -> new TinyWallTorchBlock(ParticleTypes.FLAME, properties.instabreak().noCollision().lightLevel((state) -> 15).sound(SoundType.NETHER_BRICKS)));
    public static final DeferredBlock<Block> STONE_TORCH = registerBlockWithoutBlockItem("stone_torch", properties -> new AbstractTorchBlock(ParticleTypes.FLAME, properties.instabreak().noCollision().lightLevel((state) -> 14).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> STONE_WALL_TORCH = registerBlockWithoutBlockItem("stone_wall_torch", properties -> new AbstractWallTorchBlock(ParticleTypes.FLAME, properties.instabreak().noCollision().lightLevel((state) -> 14).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> NETHER_TORCH = registerBlockWithoutBlockItem("nether_torch", properties -> new AbstractTorchBlock(ParticleTypes.FLAME, properties.instabreak().noCollision().lightLevel((state) -> 15).sound(SoundType.NETHER_BRICKS)));
    public static final DeferredBlock<Block> NETHER_WALL_TORCH = registerBlockWithoutBlockItem("nether_wall_torch", properties -> new AbstractWallTorchBlock(ParticleTypes.FLAME, properties.instabreak().noCollision().lightLevel((state) -> 15).sound(SoundType.NETHER_BRICKS)));

    private static <T extends Block> DeferredBlock<T> registerFuelBlock(String name, Function<BlockBehaviour.Properties, T> blockFactory, int items) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, blockFactory);
        registerFuelBlockItem(name, toReturn, items);
        return toReturn;
    }

    private static <T extends Block> void registerFuelBlockItem(String name, DeferredBlock<T> block, int items) {
        SCoalItems.ITEMS.registerItem(name, properties -> new FuelBlockItem(block.get(), properties.useBlockDescriptionPrefix(), items));
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> blockFactory) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, blockFactory);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        SCoalItems.ITEMS.registerSimpleBlockItem(name, block);
    }

    public static <T extends Block> DeferredBlock<T> registerBlockWithoutBlockItem(String name, Function<BlockBehaviour.Properties, T> blockFactory) {
        return BLOCKS.registerBlock(name, blockFactory);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
