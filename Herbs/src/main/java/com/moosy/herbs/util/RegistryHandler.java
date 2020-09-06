package com.moosy.herbs.util;

import com.moosy.herbs.Herbs;
import com.moosy.herbs.blocks.BlockItemBase;
import com.moosy.herbs.blocks.OosBlock;
import com.moosy.herbs.blocks.RubyBlock;
import com.moosy.herbs.items.ItemBase;
import com.moosy.herbs.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.item.*;
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
    public static final RegistryObject<Item> OOS = ITEMS.register("oos", ItemBase::new);

    //Tools ONLY (Also 2+6=9 because of every item base damage of 1) (0.0f attack speed = 1.8 combat) The end looks like (Herbs.TAB))); do (Herbs.TAB).)); but with the added dot for funky modifications
    public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword", () ->
           new SwordItem(ModItemTier.RUBY, 9, 0.0f, new Item.Properties().group(Herbs.TAB)));

    public static final RegistryObject<SwordItem> OOS_SWORD = ITEMS.register("oos_sword", () ->
            new SwordItem(ModItemTier.OOS, 10, 0.0f, new Item.Properties().group(Herbs.TAB)));

    public static final RegistryObject<SwordItem> QUARTZ_SWORD = ITEMS.register("quartz_sword", () ->
            new SwordItem(ModItemTier.QUARTZ, 6, -2.4f, new Item.Properties().group(Herbs.TAB)));

    public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () ->
            new PickaxeItem(ModItemTier.RUBY, 0, -2.8f, new Item.Properties().group(Herbs.TAB)));

    public static final RegistryObject<AxeItem> RUBY_AXE = ITEMS.register("ruby_axe", () ->
            new AxeItem(ModItemTier.RUBY, 10, -1.4f, new Item.Properties().group(Herbs.TAB)));

    public static final RegistryObject<ShovelItem> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () ->
            new ShovelItem(ModItemTier.RUBY, -1, -1.4f, new Item.Properties().group(Herbs.TAB)));


    //Blocks ONLY
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);
    public static final RegistryObject<Block> OOS_BLOCK = BLOCKS.register("oos_block", OosBlock::new);



    // Block Items ONLY
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", () -> new BlockItemBase(RUBY_BLOCK.get()));
    public static final RegistryObject<Item> OOS_BLOCK_ITEM = ITEMS.register("oos_block", () -> new BlockItemBase(OOS_BLOCK.get()));

}
