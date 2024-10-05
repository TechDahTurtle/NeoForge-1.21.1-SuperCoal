package techdahturtle.super_coal.block;

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
import techdahturtle.super_coal.item.BurnableBlockItem;
import techdahturtle.super_coal.item.SCoalItems;

import java.util.function.Supplier;

public class SCoalBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SuperCoal.MOD_ID);

    public static final DeferredBlock<Block> COMPRESSED_COAL_BLOCK = registerBurnableBlock("compressed_coal_block", () -> new Block(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.STONE)), 720);
    public static final DeferredBlock<Block> NETHER_COAL_BLOCK = registerBurnableBlock("nether_coal_block", () -> new Block(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.STONE)), 160);
    public static final DeferredBlock<Block> COMPRESSED_NETHER_COAL_BLOCK = registerBurnableBlock("compressed_nether_coal_block", () -> new Block(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.STONE)), 1440);

    public static final DeferredBlock<Block> NETHER_COAL_ORE = registerBlock("nether_coal_ore", () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of().strength(3F).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    private static <T extends Block> DeferredBlock<T> registerBurnableBlock(String name, Supplier<T> block, int items) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBurnableBlockItem(name, toReturn, items);
        return toReturn;
    }

    private static <T extends Block> void registerBurnableBlockItem(String name, DeferredBlock<T> block, int items) {
        SCoalItems.ITEMS.register(name, () -> new BurnableBlockItem(block.get(), new Item.Properties(), items));
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        SCoalItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
