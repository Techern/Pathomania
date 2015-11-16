package com.techern.minecraft.pathomania.events;

import com.techern.minecraft.pathomania.blocks.BlockDirtPath;
import com.techern.minecraft.pathomania.blocks.BlockPath;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockGravel;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemSpade;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * A class containing {@link net.minecraftforge.event.entity.player.PlayerEvent}s
 *
 * @since 0.0.1
 */
public class PathomaniaPlayerEvents {

    /**
     * Called when an {@link net.minecraft.entity.player.EntityPlayer} interacts with a {@link Block}
     *
     * @param event The {@link PlayerInteractEvent} being referenced
     * @since 0.0.1
     */
    @SubscribeEvent
    public void playerInteracting(PlayerInteractEvent event) {
        if (event.action.equals(PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK)) {
            if (event.entityPlayer.getHeldItem() != null) {
                if (event.entityPlayer.getHeldItem().getItem() instanceof ItemSpade) {
                    //TODO: Automatically generate a map of fallback blocks and what to change them to
                    IBlockState state = event.world.getBlockState(event.pos);
                    Block block = state.getBlock();

                    if (block instanceof BlockGrass) {
                        event.world.setBlockState(event.pos, BlockPath.GRASS_PATH.getDefaultState());
                    } else if (block instanceof BlockDirt) {
                        event.world.setBlockState(event.pos, BlockDirtPath.INSTANCE.getDefaultState().withProperty(BlockDirtPath.VARIANT, state.getValue(BlockDirtPath.VARIANT)));
                    } else if (block instanceof BlockGravel) {
                        event.world.setBlockState(event.pos, BlockPath.GRAVEL_PATH.getDefaultState());
                    }
                }
            }
        }
    }
}
