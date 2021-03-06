
package net.mcreator.elemantalimitation.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.elemantalimitation.ElemantalImitationModElements;

@ElemantalImitationModElements.ModElement.Tag
public class MagicEarthItem extends ElemantalImitationModElements.ModElement {
	@ObjectHolder("elemantal_imitation:magic_earth")
	public static final Item block = null;
	public MagicEarthItem(ElemantalImitationModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64));
			setRegistryName("magic_earth");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
