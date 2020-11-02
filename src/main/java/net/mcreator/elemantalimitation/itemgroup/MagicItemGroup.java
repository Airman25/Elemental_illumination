
package net.mcreator.elemantalimitation.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.elemantalimitation.item.MagicEarthItem;
import net.mcreator.elemantalimitation.ElemantalImitationModElements;

@ElemantalImitationModElements.ModElement.Tag
public class MagicItemGroup extends ElemantalImitationModElements.ModElement {
	public MagicItemGroup(ElemantalImitationModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmagic") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MagicEarthItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
