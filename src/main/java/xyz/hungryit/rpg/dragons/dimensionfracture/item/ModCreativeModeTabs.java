package xyz.hungryit.rpg.dragons.dimensionfracture.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import xyz.hungryit.rpg.dragons.dimensionfracture.DimensionFracture;
import xyz.hungryit.rpg.dragons.dimensionfracture.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DimensionFracture.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DIMENSION_FRACTURE = CREATIVE_MODE_TABS.register("dimension_fracture",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.REALITY_SHARD.get()))
                    .title(Component.translatable("creativetab.dimesionfracture.general"))
                    .displayItems((DisplayParameters, output) -> {
                        output.accept(ModItems.REALITY_CRYSTAL.get());
                        output.accept(ModItems.REALITY_SHARD.get());

                        output.accept(ModBlocks.ANCIENT_ALTAR.get());
                        output.accept(ModBlocks.NETHER_REALITY_SHARD_ORE.get());
                        output.accept(ModBlocks.END_STONE_REALITY_SHARD_ORE.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
