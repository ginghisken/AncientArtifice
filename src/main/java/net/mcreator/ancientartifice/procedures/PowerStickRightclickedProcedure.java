package net.mcreator.ancientartifice.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.ancientartifice.item.PowerStickItem;
import net.mcreator.ancientartifice.AncientArtificeMod;

import java.util.Map;

public class PowerStickRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AncientArtificeMod.LOGGER.warn("Failed to load dependency entity for procedure PowerStickRightclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == PowerStickItem.block) {
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag().putString("rarity",
					"common");
		}
	}
}
