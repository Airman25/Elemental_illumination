package net.mcreator.elemantalimitation.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.elemantalimitation.item.MagicWaterItem;
import net.mcreator.elemantalimitation.item.MagicFireItem;
import net.mcreator.elemantalimitation.item.MagicEarthItem;
import net.mcreator.elemantalimitation.item.MagicAirItem;
import net.mcreator.elemantalimitation.item.BaseMagicItem;
import net.mcreator.elemantalimitation.ElemantalImitationModVariables;
import net.mcreator.elemantalimitation.ElemantalImitationModElements;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

@ElemantalImitationModElements.ModElement.Tag
public class SuperPowerOnOffProcedure extends ElemantalImitationModElements.ModElement {
	public SuperPowerOnOffProcedure(ElemantalImitationModElements instance) {
		super(instance, 3);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SuperPowerOnOff!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SuperPowerOnOff!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((ElemantalImitationModVariables.MapVariables.get(world).MenuOn) == (true))) {
			if (((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getItem() == new ItemStack(MagicEarthItem.block, (int) (1)).getItem())) {
				ElemantalImitationModVariables.MapVariables.get(world).Power = new ItemStack(MagicEarthItem.block, (int) (1));
				ElemantalImitationModVariables.MapVariables.get(world).syncData(world);
			} else if (((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getItem() == new ItemStack(MagicWaterItem.block, (int) (1)).getItem())) {
				ElemantalImitationModVariables.MapVariables.get(world).Power = new ItemStack(MagicWaterItem.block, (int) (1));
				ElemantalImitationModVariables.MapVariables.get(world).syncData(world);
			} else if (((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getItem() == new ItemStack(MagicFireItem.block, (int) (1)).getItem())) {
				ElemantalImitationModVariables.MapVariables.get(world).Power = new ItemStack(MagicFireItem.block, (int) (1));
				ElemantalImitationModVariables.MapVariables.get(world).syncData(world);
			} else if (((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getItem() == new ItemStack(MagicAirItem.block, (int) (1)).getItem())) {
				ElemantalImitationModVariables.MapVariables.get(world).Power = new ItemStack(MagicAirItem.block, (int) (1));
				ElemantalImitationModVariables.MapVariables.get(world).syncData(world);
			} else if (((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getItem() == new ItemStack(BaseMagicItem.block, (int) (1)).getItem())) {
				ElemantalImitationModVariables.MapVariables.get(world).Power = new ItemStack(BaseMagicItem.block, (int) (1));
				ElemantalImitationModVariables.MapVariables.get(world).syncData(world);
			} else if (((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getItem() == new ItemStack(BaseMagicItem.block, (int) (1)).getItem())) {
				ElemantalImitationModVariables.MapVariables.get(world).Power = new ItemStack(MagicEarthItem.block, (int) (1));
				ElemantalImitationModVariables.MapVariables.get(world).syncData(world);
			} else if (((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getItem() == new ItemStack(BaseMagicItem.block, (int) (1)).getItem())) {
				ElemantalImitationModVariables.MapVariables.get(world).Power = new ItemStack(MagicEarthItem.block, (int) (1));
				ElemantalImitationModVariables.MapVariables.get(world).syncData(world);
			}
			if (((entity instanceof PlayerEntity)
					? ((PlayerEntity) entity).inventory.hasItemStack((ElemantalImitationModVariables.MapVariables.get(world).Power))
					: false)) {
				ElemantalImitationModVariables.MapVariables.get(world).Power = new ItemStack(Blocks.AIR, (int) (1));
				ElemantalImitationModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
