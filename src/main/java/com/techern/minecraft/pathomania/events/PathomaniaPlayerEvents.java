package com.techern.minecraft.pathomania.events;

import com.techern.minecraft.pathomania.blocks.*;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
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

                    IBlockState state = event.world.getBlockState(event.pos);
                    Block block = state.getBlock();

                    if (block instanceof BlockGrass) {
                        event.world.setBlockState(event.pos, BlockPath.GRASS_PATH.getDefaultState());
                    } else if (block instanceof BlockDirt) {
                        event.world.setBlockState(event.pos, BlockDirtPath.INSTANCE.getDefaultState().withProperty(BlockDirtPath.VARIANT, state.getValue(BlockDirt.VARIANT)));
                    } else if (block instanceof BlockGravel) {
                        event.world.setBlockState(event.pos, BlockPath.GRAVEL_PATH.getDefaultState());
                    } else if (block instanceof BlockClay) {
                        event.world.setBlockState(event.pos, BlockPath.CLAY_PATH.getDefaultState());
                    }
                } else if (event.entityPlayer.getHeldItem().getItem() instanceof ItemPickaxe) {

                    IBlockState state = event.world.getBlockState(event.pos);
                    Block block = state.getBlock();

                    if (block instanceof BlockHardenedClay) {
                        event.world.setBlockState(event.pos, BlockPath.HARDENED_CLAY_PATH.getDefaultState());
                    } else if (block instanceof BlockPrismarine) {
                        event.world.setBlockState(event.pos, BlockPrismarinePath.INSTANCE.getDefaultState().withProperty(BlockPrismarinePath.VARIANT, state.getValue(BlockPrismarine.VARIANT)));
                    } else if (block instanceof BlockSandStone) {
                        event.world.setBlockState(event.pos, BlockSandStonePath.INSTANCE.getDefaultState().withProperty(BlockSandStonePath.VARIANT, state.getValue(BlockSandStone.TYPE)));
                    }
                } else if (event.entityPlayer.getHeldItem().getItem() instanceof ItemAxe) {

                    IBlockState state = event.world.getBlockState(event.pos);
                    Block block = state.getBlock();

                    if (block instanceof BlockPlanks) {
                        event.world.setBlockState(event.pos, BlockPlankPath.INSTANCE.getDefaultState().withProperty(BlockPlankPath.VARIANT, state.getValue(BlockPlanks.VARIANT)));
                    }

                }
            }
        }
    }
}
