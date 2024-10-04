package techdahturtle.super_coal.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class BurnableItem extends Item {
    private final int items;

    public BurnableItem(Properties properties, int items) {
        super(properties);
        this.items = items;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return items * 200;
    }
}
