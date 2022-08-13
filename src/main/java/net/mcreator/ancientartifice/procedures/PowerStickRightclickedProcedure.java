package net.mcreator.ancientartifice.procedures;

import net.minecraftforge.eventbus.api.Event;

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
