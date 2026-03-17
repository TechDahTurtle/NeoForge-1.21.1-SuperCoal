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

    public static final DeferredItem<Item> TINY_COAL = ITEMS.registerItem("tiny_coal", properties -> new FuelItem(properties, 1));
    public static final DeferredItem<Item> TINY_CHARCOAL = ITEMS.registerItem("tiny_charcoal", properties -> new FuelItem(properties, 1));
    public static final DeferredItem<Item> NETHER_COAL = ITEMS.registerItem("nether_coal", properties -> new FuelItem(properties, 16));
    public static final DeferredItem<Item> TINY_NETHER_COAL = ITEMS.registerItem("nether_tiny_coal", properties -> new FuelItem(properties, 2));
    public static final DeferredItem<Item> END_COAL = ITEMS.registerItem("end_coal", properties -> new FuelItem(properties, 32));
    public static final DeferredItem<Item> TINY_END_COAL = ITEMS.registerItem("end_tiny_coal", properties -> new FuelItem(properties, 4));

    public static final DeferredItem<Item> STONE_ROD = ITEMS.registerSimpleItem("stone_rod");
    public static final DeferredItem<Item> NETHER_ROD = ITEMS.registerSimpleItem("nether_rod");

    public static final DeferredItem<Item> TINY_TORCH = ITEMS.registerItem("tiny_torch", properties -> new StandingAndWallBlockItem(SCoalBlocks.TINY_TORCH.get(), SCoalBlocks.TINY_WALL_TORCH.get(), Direction.DOWN, properties.useBlockDescriptionPrefix()));
    public static final DeferredItem<Item> TINY_STONE_TORCH = ITEMS.registerItem("tiny_stone_torch", properties -> new StandingAndWallBlockItem(SCoalBlocks.TINY_STONE_TORCH.get(), SCoalBlocks.TINY_STONE_WALL_TORCH.get(), Direction.DOWN, properties.useBlockDescriptionPrefix()));
    public static final DeferredItem<Item> TINY_NETHER_TORCH = ITEMS.registerItem("tiny_nether_torch", properties -> new StandingAndWallBlockItem(SCoalBlocks.TINY_NETHER_TORCH.get(), SCoalBlocks.TINY_NETHER_WALL_TORCH.get(), Direction.DOWN, properties.useBlockDescriptionPrefix()));
    public static final DeferredItem<Item> STONE_TORCH = ITEMS.registerItem("stone_torch", properties -> new StandingAndWallBlockItem(SCoalBlocks.STONE_TORCH.get(), SCoalBlocks.STONE_WALL_TORCH.get(), Direction.DOWN, properties.useBlockDescriptionPrefix()));
    public static final DeferredItem<Item> NETHER_TORCH = ITEMS.registerItem("nether_torch", properties -> new StandingAndWallBlockItem(SCoalBlocks.NETHER_TORCH.get(), SCoalBlocks.NETHER_WALL_TORCH.get(), Direction.DOWN, properties.useBlockDescriptionPrefix()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
