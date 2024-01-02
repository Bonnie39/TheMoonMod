package dev.bonnie.themoon.datagen;

import dev.bonnie.themoon.TheMoonMod;
import dev.bonnie.themoon.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TheMoonMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CHEESE_BLOCK);
        blockWithItem(ModBlocks.MOON_TENT_BLOCK);
        blockWithItem(ModBlocks.TENT_MATERIAL);
        blockWithItem(ModBlocks.REINFORCED_CLOTH);
        blockWithItem(ModBlocks.MOON_LAMP);
        blockWithItem(ModBlocks.BAUXITE_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
