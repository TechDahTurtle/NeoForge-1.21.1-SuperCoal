package techdahturtle.super_coal.creativetab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import techdahturtle.super_coal.SuperCoal;
import techdahturtle.super_coal.block.SCoalBlocks;
import techdahturtle.super_coal.item.SCoalItems;

public class SCoalCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SuperCoal.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SCOAL_ITEMS_TAB = CREATIVE_MODE_TABS.register("super_coal_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.super_coal_items.tab"))
            .icon(() -> new ItemStack(SCoalItems.TINY_COAL.get()))
            .build());
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SCOAL_BLOCKS_TAB = CREATIVE_MODE_TABS.register("super_coal_blocks", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.super_coal_blocks.tab"))
            .icon(() -> new ItemStack(SCoalBlocks.COMPRESSED_COAL_BLOCK.get()))
            .build());
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SCOAL_TORCHES_TAB = CREATIVE_MODE_TABS.register("super_coal_torches", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.super_coal_torches.tab"))
            .icon(() -> new ItemStack(SCoalBlocks.NETHER_TORCH.get()))
            .build());

    public static void registerTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == SCOAL_ITEMS_TAB.get()) {
            // Coal Items
            event.accept(SCoalItems.TINY_COAL.get());
            event.accept(SCoalItems.TINY_CHARCOAL.get());
            event.accept(SCoalItems.NETHER_COAL.get());
            event.accept(SCoalItems.TINY_NETHER_COAL.get());
            event.accept(SCoalItems.END_COAL.get());
            event.accept(SCoalItems.TINY_END_COAL.get());

            // Rod Items
            event.accept(SCoalItems.STONE_ROD.get());
            event.accept(SCoalItems.NETHER_ROD.get());

        } else if (event.getTab() == SCOAL_BLOCKS_TAB.get()) {
            // Vanilla+ Coal Blocks
            event.accept(SCoalBlocks.COMPRESSED_COAL_BLOCK.get().asItem());
            event.accept(SCoalBlocks.CHARCOAL_BLOCK.get().asItem());
            event.accept(SCoalBlocks.COMPRESSED_CHARCOAL_BLOCK.get().asItem());

            // Dimension Coal Blocks
            event.accept(SCoalBlocks.NETHER_COAL_BLOCK.get().asItem());
            event.accept(SCoalBlocks.COMPRESSED_NETHER_COAL_BLOCK.get().asItem());
            event.accept(SCoalBlocks.END_COAL_BLOCK.get().asItem());
            event.accept(SCoalBlocks.COMPRESSED_END_COAL_BLOCK.get().asItem());

            // Coal Ores
            event.accept(SCoalBlocks.NETHER_COAL_ORE.get().asItem());
            event.accept(SCoalBlocks.END_COAL_ORE.get().asItem());

        } else if (event.getTab() == SCOAL_TORCHES_TAB.get()) {
            // Torches
            event.accept(SCoalItems.TINY_TORCH.get());
            event.accept(SCoalItems.TINY_STONE_TORCH.get());
            event.accept(SCoalItems.TINY_NETHER_TORCH.get());
            event.accept(SCoalItems.STONE_TORCH.get());
            event.accept(SCoalItems.NETHER_TORCH.get());
        }
    }

    public static void register(IEventBus eventBus) {CREATIVE_MODE_TABS.register(eventBus);}
}
