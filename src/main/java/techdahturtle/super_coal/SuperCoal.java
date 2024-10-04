package techdahturtle.super_coal;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import techdahturtle.super_coal.creativetab.SCoalCreativeTab;
import techdahturtle.super_coal.item.SCoalItems;

@Mod(SuperCoal.MOD_ID)
public class SuperCoal {
    public static final String MOD_ID = "super_coal";

    public SuperCoal(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        // Register Items
        SCoalItems.register(modEventBus);

        // Register Creative Tab
        SCoalCreativeTab.register(modEventBus);
        modEventBus.addListener(SCoalCreativeTab::registerTabs);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event){}


    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {}
    }
}
