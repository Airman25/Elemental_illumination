package net.mcreator.elemantalimitation.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;

import net.mcreator.elemantalimitation.ElemantalImitationModVariables;
import net.mcreator.elemantalimitation.ElemantalImitationModElements;

import java.util.Map;

@ElemantalImitationModElements.ModElement.Tag
public class WaterPickaxeBlockDestroyedWithToolProcedure extends ElemantalImitationModElements.ModElement {
	public WaterPickaxeBlockDestroyedWithToolProcedure(ElemantalImitationModElements instance) {
		super(instance, 26);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure WaterPickaxeBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WaterPickaxeBlockDestroyedWithTool!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		IWorld world = (IWorld) dependencies.get("world");
		((itemstack)).setDamage((int) 0);
		ElemantalImitationModVariables.MapVariables
				.get(world).Water = (double) ((ElemantalImitationModVariables.MapVariables.get(world).Water) - 100);
		ElemantalImitationModVariables.MapVariables.get(world).syncData(world);
	}
}
