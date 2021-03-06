package com.techern.minecraft.pathomania.proxy;

import net.minecraft.block.Block;

/**
 * A proxy class that holds functions to be executed differently on the client and server {@link net.minecraftforge.fml.relauncher.Side}s
 *
 * @since 0.0.1
 */
public abstract class CommonProxy {

    /**
     * Registers a {@link Block}'s inventory model
     *
     * @param block The {@link Block} being registered
     * @param metadata The {@link Integer} used to store metadata
     * @param modelLocation A {@link String} depicting the location of the model
     * @since 0.0.1
     */
    public abstract void registerBlockInventoryModel(Block block, int metadata, String modelLocation);

}