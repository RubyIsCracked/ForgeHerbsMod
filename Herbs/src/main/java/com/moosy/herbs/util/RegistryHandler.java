package com.moosy.herbs.util;

import com.moosy.herbs.Herbs;
import com.moosy.herbs.blocks.BlockItemBase;
import com.moosy.herbs.blocks.OosBlock;
import com.moosy.herbs.blocks.RubyBlock;
import com.moosy.herbs.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Herbs.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Herbs.MOD_ID);

    public static void init() {

        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }


    // Items ONLY
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);
    public static final RegistryObject<Item> OOS_FUR = ITEMS.register("oosfur", ItemBase::new);

    //Blocks ONLY
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);
    public static final RegistryObject<Block> OOS_BLOCK = BLOCKS.register("oos_block", OosBlock::new);



    // Block Items ONLY
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", () -> new BlockItemBase(RUBY_BLOCK.get()));
    public static final RegistryObject<Item> OOS_BLOCK_ITEM = ITEMS.register("oos_block", () -> new BlockItemBase(OOS_BLOCK.get()));

}
