package dev.bonnie.themoon.datagen;

import dev.bonnie.themoon.TheMoonMod;
import dev.bonnie.themoon.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TheMoonMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //  REQUIRED TOOL BUILD QUALITY
        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.CHEESE_BLOCK.get(),
                        ModBlocks.MOON_TENT_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BAUXITE_ORE.get());

//        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
//                .add(ModBlocks.)

        //  REQUIRED TOOL TYPE
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CHEESE_BLOCK.get(),
                        ModBlocks.MOON_TENT_BLOCK.get(),
                        ModBlocks.BAUXITE_ORE.get());
    }
}
