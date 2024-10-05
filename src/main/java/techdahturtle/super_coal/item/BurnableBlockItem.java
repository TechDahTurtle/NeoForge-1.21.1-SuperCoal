package techdahturtle.super_coal.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class BurnableBlockItem extends BlockItem {
    private final int items;

    public BurnableBlockItem(Block block, Properties properties, int items) {
        super(block, properties);
        this.items = items;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return items * 200;
    }
}
