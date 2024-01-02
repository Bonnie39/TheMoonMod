package dev.bonnie.themoon.item;

import dev.bonnie.themoon.TheMoonMod;
import dev.bonnie.themoon.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheMoonMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> THE_MOON_TAB = CREATIVE_MODE_TABS.register("the_moon",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SONIC_SCREWDRIVER.get()))
                    .title(Component.translatable("creativetab.the_mooon"))
                    .displayItems((pParameters, pOutput) -> {
                        //  BLOCKS
                        pOutput.accept(ModBlocks.CHEESE_BLOCK.get());
                        pOutput.accept(ModBlocks.MOON_TENT_BLOCK.get());
                        pOutput.accept(ModBlocks.MOON_LAMP.get());
                        pOutput.accept(ModBlocks.BAUXITE_ORE.get());
                        pOutput.accept(ModBlocks.REINFORCED_CLOTH.get());

                        //  ITEMS
                        pOutput.accept(ModItems.SONIC_SCREWDRIVER.get());
                        pOutput.accept(ModItems.CHEESE_SLICE.get());
                        pOutput.accept(ModItems.ALUMINUM_INGOT.get());

                        //  ARMOR
                        pOutput.accept(ModItems.MOON_HELMET.get());
                        pOutput.accept(ModItems.MOON_CHESTPLATE.get());
                        pOutput.accept(ModItems.MOON_LEGGINGS.get());
                        pOutput.accept(ModItems.MOON_BOOTS.get());

                    })
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
