package dev.bonnie.themoon.item.custom;

import dev.bonnie.themoon.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;

public class SonicScrewdriverItem extends Item {
    public SonicScrewdriverItem() {
        super(new Properties()
                .stacksTo(1)
                .rarity(Rarity.RARE)
        );
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getPlayer() != null) {
            Direction direction = Direction.UP;
            BlockPos framePos = context.getClickedPos().relative(direction);
            // Play sound
            context.getLevel().playSound(context.getPlayer(), framePos,
                    SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, 1.0F);

            // Check which hand is holding the screwdriver
            InteractionHand hand = getHandHoldingItem(context.getPlayer(), ModItems.SONIC_SCREWDRIVER.get().asItem());

            // Trigger arm swing animation on the client side for the hand holding the catalyst
            if (hand != null) {
                context.getPlayer().swing(hand, true);
            }

            return InteractionResult.CONSUME;
        }
        return InteractionResult.FAIL;
    }

    private InteractionHand getHandHoldingItem(Player player, Item item) {
        // Check main hand
        if (player.getMainHandItem().getItem() == item) {
            return InteractionHand.MAIN_HAND;
        }

        // Check offhand
        if (player.getOffhandItem().getItem() == item) {
            return InteractionHand.OFF_HAND;
        }

        // Item not found in either hand
        return null;
    }
}
