package dev.bonnie.themoon.item;

import dev.bonnie.themoon.TheMoonMod;
import dev.bonnie.themoon.item.custom.SonicScrewdriverItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TheMoonMod.MOD_ID);

    public static final RegistryObject<Item> SONIC_SCREWDRIVER = ITEMS.register("sonic_screwdriver", SonicScrewdriverItem::new);

    public static final RegistryObject<Item> CHEESE_SLICE = ITEMS.register("cheese_slice",
            () -> new Item(new Item.Properties().food(ModFoods.CHEESE_SLICE)));

    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MOON_HELMET = ITEMS.register("moon_helmet",
            () -> new ArmorItem(ModArmorMaterials.MOON, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> MOON_CHESTPLATE = ITEMS.register("moon_chestplate",
            () -> new ArmorItem(ModArmorMaterials.MOON, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> MOON_LEGGINGS = ITEMS.register("moon_leggings",
            () -> new ArmorItem(ModArmorMaterials.MOON, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> MOON_BOOTS = ITEMS.register("moon_boots",
            () -> new ArmorItem(ModArmorMaterials.MOON, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
