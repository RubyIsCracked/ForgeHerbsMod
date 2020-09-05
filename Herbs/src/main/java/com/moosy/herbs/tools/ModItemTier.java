package com.moosy.herbs.tools;

import com.moosy.herbs.util.RegistryHandler;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {

    RUBY(3, 3000, 12.0f, 3.0f, 30, () ->{
        return Ingredient.fromItems(RegistryHandler.RUBY.get());
    }), // For second one instead of semi colin use comma <----

    OOS(3, 3000, 12.0f, 3.0f, 30, () ->{
        return Ingredient.fromItems(RegistryHandler.OOS_SWORD.get());
    }),

    QUARTZ(3, 3000, 12.0f, 3.0f, 30, () ->{
        return Ingredient.fromItems(RegistryHandler.OOS_SWORD.get());
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.get();
    }
}

