package dev.bonnie.themoon.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CHEESE_SLICE = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.3f).fast()
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 100), 0.5f)
            .build();
}
