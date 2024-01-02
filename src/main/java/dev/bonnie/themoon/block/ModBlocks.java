package dev.bonnie.themoon.block;

import dev.bonnie.themoon.TheMoonMod;
import dev.bonnie.themoon.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TheMoonMod.MOD_ID);

    public static final RegistryObject<Block> CHEESE_BLOCK = registerBlock("cheese_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f, 1f).sound(SoundType.MUD)));

    public static final RegistryObject<Block> MOON_TENT_BLOCK = registerBlock("moon_tent_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f, 1f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> TENT_MATERIAL = registerBlock("tent_material",
            () -> new Block(BlockBehaviour.Properties.of().strength(-1f, -1f).sound(SoundType.STONE).noLootTable()));

    public static final RegistryObject<Block> REINFORCED_CLOTH = registerBlock("reinforced_cloth",
            () -> new Block(BlockBehaviour.Properties.of().strength(1f, 1f).sound(SoundType.WOOL)));

    public static final RegistryObject<Block> MOON_LAMP = registerBlock("moon_lamp",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.5f, 0.5f).sound(SoundType.GLASS).lightLevel((p_152607_) -> {
                return 8;
            })));

    public static final RegistryObject<Block> BAUXITE_ORE = registerBlock("bauxite_ore",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F).sound(SoundType.STONE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
