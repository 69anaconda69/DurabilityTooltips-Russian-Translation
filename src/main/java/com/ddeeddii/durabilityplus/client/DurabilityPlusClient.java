package com.ddeeddii.durabilityplus.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class DurabilityPlusClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("durabilityplus");

    @Override
    public void onInitializeClient() {
        ItemTooltipCallback.EVENT.register((ItemStack stack, TooltipContext context, List<Text> lines) -> {
            if(stack.getMaxDamage() == 0) {
                return;
            }

            lines.add(Text.empty());
            lines.add(TooltipHandler.GetTooltip(stack));
        });

        LOGGER.info("[DurabilityPlus] Mod loaded!");
    }
}
