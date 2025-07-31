package xyz.hungryit.rpg.dragons.dimensionfracture.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.hungryit.rpg.dragons.dimensionfracture.DimensionFracture;
import xyz.hungryit.rpg.dragons.dimensionfracture.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DimensionFracture.MOD_ID);

    public static final RegistryObject<Block> ANCIENT_ALTAR = registerBlock("ancient_altar",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> NETHER_REALITY_SHARD_ORE = registerBlock("nether_reality_shard_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE).sound(SoundType.NETHER_GOLD_ORE)));
    public static final RegistryObject<Block> END_STONE_REALITY_SHARD_ORE = registerBlock("end_stone_reality_shard_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
