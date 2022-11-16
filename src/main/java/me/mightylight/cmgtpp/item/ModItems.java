package me.mightylight.cmgtpp.item;

import me.mightylight.cmgtpp.Cmgtpp;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Cmgtpp.MODID);


    public static final RegistryObject<Item> Wrench = ITEMS.register("wrench",() -> new ConveyorWrenchItem(new Item.Properties().tab(ModCreativeModTab.MODTAB)));
    public static final RegistryObject<Item> UpgradeKit = ITEMS.register("upgrade_kit",() -> new UpgradeKit(new Item.Properties().tab(ModCreativeModTab.MODTAB)));


    public static void Register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
