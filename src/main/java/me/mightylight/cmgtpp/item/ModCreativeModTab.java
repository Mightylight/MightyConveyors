package me.mightylight.cmgtpp.item;

import me.mightylight.cmgtpp.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModTab {
    public static final CreativeModeTab MODTAB = new CreativeModeTab("CMGTPP") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.Example_Block.get());
        }
    };
}
