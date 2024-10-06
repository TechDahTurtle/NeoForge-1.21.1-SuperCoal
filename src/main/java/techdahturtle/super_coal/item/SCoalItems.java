package techdahturtle.super_coal.item;

import dev.lemonjuice.scalar_core.item.FuelItem;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import techdahturtle.super_coal.SuperCoal;
import techdahturtle.super_coal.block.SCoalBlocks;

public class SCoalItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SuperCoal.MOD_ID);

    public static final DeferredItem<Item> NETHER_COAL = ITEMS.register("nether_coal", () -> new FuelItem(new Item.Properties(), 16));
    public static final DeferredItem<Item> TINY_COAL = ITEMS.register("tiny_coal", () -> new FuelItem(new Item.Properties(), 1));
    public static final DeferredItem<Item> TINY_NETHER_COAL = ITEMS.register("nether_tiny_coal", () -> new FuelItem(new Item.Properties(), 2));
    public static final DeferredItem<Item> STONE_ROD = ITEMS.register("stone_rod", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TINY_TORCH = ITEMS.register("tiny_torch", () -> new StandingAndWallBlockItem(SCoalBlocks.TINY_TORCH.get(), SCoalBlocks.TINY_WALL_TORCH.get(), new Item.Properties(), Direction.DOWN));
    public static final DeferredItem<Item> TINY_STONE_TORCH = ITEMS.register("tiny_stone_torch", () -> new StandingAndWallBlockItem(SCoalBlocks.TINY_STONE_TORCH.get(), SCoalBlocks.TINY_WALL_STONE_TORCH.get(), new Item.Properties(), Direction.DOWN));
    public static final DeferredItem<Item> TINY_NETHER_TORCH = ITEMS.register("tiny_nether_torch", () -> new StandingAndWallBlockItem(SCoalBlocks.TINY_NETHER_TORCH.get(), SCoalBlocks.TINY_WALL_NETHER_TORCH.get(), new Item.Properties(), Direction.DOWN));
    public static final DeferredItem<Item> STONE_TORCH = ITEMS.register("stone_torch", () -> new StandingAndWallBlockItem(SCoalBlocks.STONE_TORCH.get(), SCoalBlocks.STONE_WALL_TORCH.get(), new Item.Properties(), Direction.DOWN));
    public static final DeferredItem<Item> NETHER_TORCH = ITEMS.register("nether_torch", () -> new StandingAndWallBlockItem(SCoalBlocks.NETHER_TORCH.get(), SCoalBlocks.NETHER_WALL_TORCH.get(), new Item.Properties(), Direction.DOWN));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
