package com.attributestudios.wolfarmor.api.util;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;

import javax.annotation.Nonnull;

public interface IProxy {
    void preInit(@Nonnull FMLPreInitializationEvent preInitializationEvent);
    void init(@Nonnull FMLInitializationEvent initializationEvent);
    void postInit(@Nonnull FMLPostInitializationEvent postInitializationEvent);
    void serverAboutToStart(@Nonnull FMLServerAboutToStartEvent serverAboutToStartEvent);

    void registerEntityRenderingHandlers();
    void registerEventListeners();
    void registerGuiHandlers();
    void registerCapabilities();
    void registerPackets();
    void registerLootTables();
    void registerItemRenders(@Nonnull FMLInitializationEvent initializationEvent);
    void registerItemColorHandlers(@Nonnull FMLInitializationEvent initializationEvent);

    /**
     * Registers criteria triggers.
     */
    @Deprecated
    void registerCriteriaTriggers();
}