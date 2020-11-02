package net.mcreator.elemantalimitation.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;

import net.mcreator.elemantalimitation.item.WaterPickaxeItem;
import net.mcreator.elemantalimitation.item.MagicWaterItem;
import net.mcreator.elemantalimitation.ElemantalImitationModVariables;
import net.mcreator.elemantalimitation.ElemantalImitationModElements;

import java.util.Map;

@ElemantalImitationModElements.ModElement.Tag
public class WaterPickaxeToolInHandTickProcedure extends ElemantalImitationModElements.ModElement {
	public WaterPickaxeToolInHandTickProcedure(ElemantalImitationModElements instance) {
		super(instance, 28);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WaterPickaxeToolInHandTick!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure WaterPickaxeToolInHandTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WaterPickaxeToolInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((ElemantalImitationModVariables.MapVariables.get(world).Power).getItem() == new ItemStack(MagicWaterItem.block, (int) (1)).getItem())
				&& ((ElemantalImitationModVariables.MapVariables.get(world).Water) >= 100))
				&& ((ElemantalImitationModVariables.MapVariables.get(world).Mana) >= 0))) {
			if ((!(((itemstack)).isEnchanted()))) {
				((itemstack)).addEnchantment(Enchantments.SILK_TOUCH, (int) 1);
				((itemstack)).addEnchantment(Enchantments.EFFICIENCY, (int) 50);
			}
		} else {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> ((itemstack).copy()).getItem() == p.getItem(), (int) 1);
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(WaterPickaxeItem.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}
}
