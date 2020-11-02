package net.mcreator.elemantalimitation.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;

import net.mcreator.elemantalimitation.item.MagicFireItem;
import net.mcreator.elemantalimitation.item.FirePickaxeItem;
import net.mcreator.elemantalimitation.ElemantalImitationModVariables;
import net.mcreator.elemantalimitation.ElemantalImitationModElements;

import java.util.Map;

@ElemantalImitationModElements.ModElement.Tag
public class FirePickaxeInHadnTickProcedure extends ElemantalImitationModElements.ModElement {
	public FirePickaxeInHadnTickProcedure(ElemantalImitationModElements instance) {
		super(instance, 40);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FirePickaxeInHadnTick!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure FirePickaxeInHadnTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FirePickaxeInHadnTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((ElemantalImitationModVariables.MapVariables.get(world).Power).getItem() == new ItemStack(MagicFireItem.block, (int) (1)).getItem())
				&& ((ElemantalImitationModVariables.MapVariables.get(world).Fire) >= 100))
				&& ((ElemantalImitationModVariables.MapVariables.get(world).Mana) >= 0))) {
			if ((!(((itemstack)).isEnchanted()))) {
				((itemstack)).addEnchantment(Enchantments.SILK_TOUCH, (int) 1);
				((itemstack)).addEnchantment(Enchantments.EFFICIENCY, (int) 44);
			}
		} else {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> ((itemstack).copy()).getItem() == p.getItem(), (int) 1);
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(FirePickaxeItem.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}
}
