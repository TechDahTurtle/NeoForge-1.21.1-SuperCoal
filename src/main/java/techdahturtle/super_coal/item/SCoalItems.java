package techdahturtle.super_coal.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import techdahturtle.super_coal.SuperCoal;

public class SCoalItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SuperCoal.MOD_ID);

    public static final DeferredItem<Item> NETHER_COAL = ITEMS.register("nether_coal", () -> new BurnableItem(new Item.Properties(), 16));
    public static final DeferredItem<Item> TINY_COAL = ITEMS.register("tiny_coal", () -> new BurnableItem(new Item.Properties(), 1));
    public static final DeferredItem<Item> TINY_NETHER_COAL = ITEMS.register("tiny_nether_coal", () -> new BurnableItem(new Item.Properties(), 2));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
