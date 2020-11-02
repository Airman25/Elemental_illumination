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
public class MagicFireRightClickAirProcedure extends ElemantalImitationModElements.ModElement {
	public MagicFireRightClickAirProcedure(ElemantalImitationModElements instance) {
		super(instance, 43);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MagicFireRightClickAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MagicFireRightClickAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Items.LAVA_BUCKET, (int) (1)))
				: false)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(Items.LAVA_BUCKET, (int) (1)).getItem() == p.getItem(),
						(int) 1);
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(Items.BUCKET, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			ElemantalImitationModVariables.MapVariables
					.get(world).Fire = (double) ((ElemantalImitationModVariables.MapVariables.get(world).Water) + 1000);
			ElemantalImitationModVariables.MapVariables.get(world).syncData(world);
		} else if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Items.FLINT_AND_STEEL, (int) (1)))
				: false)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(Items.FLINT_AND_STEEL, (int) (1)).getItem() == p.getItem(),
						(int) 1);
			ElemantalImitationModVariables.MapVariables
					.get(world).Fire = (double) ((ElemantalImitationModVariables.MapVariables.get(world).Water) + 1000);
			ElemantalImitationModVariables.MapVariables.get(world).syncData(world);
		} else if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Items.BLAZE_ROD, (int) (1)))
				: false)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(Items.BLAZE_ROD, (int) (1)).getItem() == p.getItem(),
						(int) 1);
			ElemantalImitationModVariables.MapVariables
					.get(world).Fire = (double) ((ElemantalImitationModVariables.MapVariables.get(world).Water) + 2000);
			ElemantalImitationModVariables.MapVariables.get(world).syncData(world);
		} else if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Items.BLAZE_POWDER, (int) (1)))
				: false)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(Items.BLAZE_POWDER, (int) (1)).getItem() == p.getItem(),
						(int) 1);
			ElemantalImitationModVariables.MapVariables
					.get(world).Fire = (double) ((ElemantalImitationModVariables.MapVariables.get(world).Water) + 500);
			ElemantalImitationModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
