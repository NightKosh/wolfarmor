package com.attributestudios.wolfarmor.item.crafting;

import java.util.Arrays;
import java.util.Optional;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemDye;
import org.apache.commons.lang3.ArrayUtils;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Helper class to assist with OreDict defined dyes
 */
abstract class OreDictHelper {
    private static final String[] DYE_ORE_NAMES = new String[] {
            "dyeWhite", "dyeOrange", "dyeMagenta", "dyeLightBlue",
            "dyeYellow", "dyeLime", "dyePink", "dyeGray",
            "dyeLightGray", "dyeCyan", "dyePurple", "dyeBlue",
            "dyeBrown", "dyeGreen", "dyeRed", "dyeBlack"
    };
    /**
     * Returns true if the color index is greater than or equal to zero
     * @param stack The stack to check
     */
    static boolean isValidDye(@Nonnull ItemStack stack) {
        return getColorIndexFromStack(stack) >= 0 || stack.getItem() instanceof ItemDye;
    }

    /**
     * Returns the index of the dye name in the DYE_ORE_NAMES list
     */
    private static int getColorIndexFromStack(@Nonnull ItemStack stack) {
        if(stack.isEmpty()) return -1;
        return Arrays.stream(OreDictionary.getOreIDs(stack))
            .mapToObj(OreDictionary::getOreName)
            .mapToInt(oreName -> ArrayUtils.indexOf(DYE_ORE_NAMES, oreName))
            .findFirst().orElse(-1);
    }

    /**
     * Gets the enum color from the stack
     */
    @Nonnull
    static Optional<EnumDyeColor> getColorFromStack(@Nonnull ItemStack stack) {
        return isValidDye(stack) ? 
            stack.getItem() instanceof ItemDye ?
                    Optional.of(EnumDyeColor.byDyeDamage(stack.getMetadata())) :
                    Optional.of(EnumDyeColor.byMetadata(getColorIndexFromStack(stack))) :
            Optional.empty();
    }
}