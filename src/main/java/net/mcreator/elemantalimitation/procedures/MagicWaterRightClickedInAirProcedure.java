package net.mcreator.elemantalimitation.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.IWorld;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.elemantalimitation.ElemantalImitationModVariables;
import net.mcreator.elemantalimitation.ElemantalImitationModElements;

import java.util.Map;

@ElemantalImitationModElements.ModElement.Tag
public class MagicWaterRightClickedInAirProcedure extends ElemantalImitationModElements.ModElement {
	public MagicWaterRightClickedInAirProcedure(ElemantalImitationModElements instance) {
		super(instance, 29);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MagicWaterRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MagicWaterRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Items.WATER_BUCKET, (int) (1)))
				: false)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(Items.WATER_BUCKET, (int) (1)).getItem() == p.getItem(),
						(int) 1);
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(Items.BUCKET, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			ElemantalImitationModVariables.MapVariables
					.get(world).Water = (double) ((ElemantalImitationModVariables.MapVariables.get(world).Water) + 1000);
			ElemantalImitationModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
