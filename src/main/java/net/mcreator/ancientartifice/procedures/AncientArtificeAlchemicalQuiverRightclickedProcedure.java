package net.mcreator.ancientartifice.procedures;

import net.minecraft.util.Hand;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.ancientartifice.AncientArtificeMod;

import java.util.Map;

public class AncientArtificeAlchemicalQuiverRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AncientArtificeMod.LOGGER.warn("Failed to load dependency entity for procedure AncientArtificeAlchemicalQuiverRightclicked!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				AncientArtificeMod.LOGGER.warn("Failed to load dependency itemstack for procedure AncientArtificeAlchemicalQuiverRightclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double remainingCapacity = 0;
		double maxCapacity = 0;
		maxCapacity = 128;
		remainingCapacity = (maxCapacity - itemstack.getOrCreateTag().getDouble("arrowCount"));
		System.out.println("Remaining Capacity: " + remainingCapacity);
		System.out.println("Debug 0");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == Items.ARROW
				&& remainingCapacity > 0) {
			System.out.println("Debug A");
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY))
					.getCount() <= remainingCapacity) {
				System.out.println("Debug B");
				itemstack.getOrCreateTag().putDouble("arrowCount", (itemstack.getOrCreateTag().getDouble("arrowCount")
						+ (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).getCount()));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY);
					_setstack.setCount((int) 0);
					((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY))
					.getCount() > remainingCapacity) {
				System.out.println("Debug C");
				itemstack.getOrCreateTag().putDouble("arrowCount", maxCapacity);
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY);
					_setstack.setCount(
							(int) ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).getCount()
									- remainingCapacity));
					((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			}
		}
	}
}
