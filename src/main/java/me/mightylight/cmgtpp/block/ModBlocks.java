package me.mightylight.cmgtpp.block;

import me.mightylight.cmgtpp.Cmgtpp;
import me.mightylight.cmgtpp.block.custom.TestBlock;
import me.mightylight.cmgtpp.block.custom.TestBlockV2;
import me.mightylight.cmgtpp.item.ModCreativeModTab;
import me.mightylight.cmgtpp.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Cmgtpp.MODID);

    public static final RegistryObject<Block> TEST_BLOCK = RegisterBlock("test_block",
            () -> new TestBlock(BlockBehaviour.Properties.of(Material.METAL))
            , ModCreativeModTab.MODTAB);

    public static final RegistryObject<Block> TEST_BLOCKV2 = RegisterBlock("test_block_upgrade",
            () -> new TestBlockV2(BlockBehaviour.Properties.of(Material.METAL))
            , ModCreativeModTab.MODTAB);



    public static final RegistryObject<Block> Example_Block = RegisterBlock("example_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL))
            , ModCreativeModTab.MODTAB);


    /**
     * Registers a block to the game and adds the blockItem in the tab specified
     * @param name
     * name of the block
     * @param block
     * @param tab
     * creative mode tab where the item should go
     * @param <T>
     * @return
     */
    private static <T extends Block> RegistryObject<T> RegisterBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        RegisterBlockItem(name,toReturn,tab);
        return toReturn;
    }


    //Gets called by RegisterBlock, handles the item part of the block registration
    private static <T extends Block>RegistryObject<Item> RegisterBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }



    public static void Register(IEventBus eventbus){
        BLOCKS.register(eventbus);
    }
}
