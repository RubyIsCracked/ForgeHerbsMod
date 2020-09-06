package com.moosy.herbs.armor;

import com.moosy.herbs.Herbs;
import com.moosy.herbs.util.RegistryHandler;
import net.minecraft.client.audio.Sound;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {

    // Copy Line For new one
    RUBY(Herbs.MOD_ID + ":ruby", 35, new int[] {4, 6, 6 ,4  }, 40,
            SoundEvents.BLOCK_ANVIL_LAND, 5.0f, () ->  { return  Ingredient.fromItems(RegistryHandler.RUBY.get()) ;    } );

// Do new one later future me:     OOS(Herbs.MOD_ID + ":oos", 50, new int[] {4, 6, 6 ,4  }, 50,
//            SoundEvents.BLOCK_ANVIL_LAND, 10.0f, () ->  { return  Ingredient.fromItems(RegistryHandler.RUBY.get()) ;    } );
//






    private static final int[] MAX_DAMAGE_ARRAY = new int[] {11, 16, 15, 13};
   private final String name;
   private final int maxDamageFactor;
   private final int[] damageReductionAmmountArray;
   private final int enchantability;
   private final SoundEvent soundEvent;
   private final float toughness;
   private final Supplier<Ingredient> repairMaterial;

   ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmmountArray, int enchantability,
                    SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmmountArray = damageReductionAmmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;

   }



    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] + this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }
}
