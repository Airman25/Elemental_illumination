package net.mcreator.elemantalimitation.procedures;

import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.FluidStack;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.block.Blocks;

import net.mcreator.elemantalimitation.ElemantalImitationModVariables;
import net.mcreator.elemantalimitation.ElemantalImitationModElements;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

@ElemantalImitationModElements.ModElement.Tag
public class MagicWaterRightClickedOnBlockProcedure extends ElemantalImitationModElements.ModElement {
	public MagicWaterRightClickedOnBlockProcedure(ElemantalImitationModElements instance) {
		super(instance, 30);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MagicWaterRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MagicWaterRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MagicWaterRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MagicWaterRightClickedOnBlock!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((ElemantalImitationModVariables.MapVariables.get(world).Water) >= 1000)) {
			if (((new Object() {
				public int fillTankSimulate(BlockPos pos, int amount) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null).ifPresent(
								capability -> _retval.set(capability.fill(new FluidStack(Fluids.WATER, amount), IFluidHandler.FluidAction.EXECUTE)));
					return _retval.get();
				}
			}.fillTankSimulate(new BlockPos((int) x, (int) y, (int) z), (int) 1000)) == 100)) {
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					int _amount = (int) 1000;
					if (_ent != null)
						_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
								.ifPresent(capability -> capability.fill(new FluidStack(Fluids.WATER, _amount), IFluidHandler.FluidAction.EXECUTE));
				}
				ElemantalImitationModVariables.MapVariables
						.get(world).Water = (double) ((ElemantalImitationModVariables.MapVariables.get(world).Water) - 1000);
				ElemantalImitationModVariables.MapVariables.get(world).syncData(world);
			} else if ((Blocks.AIR.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), Blocks.WATER.getDefaultState(), 3);
				ElemantalImitationModVariables.MapVariables
						.get(world).Water = (double) ((ElemantalImitationModVariables.MapVariables.get(world).Water) - 1000);
				ElemantalImitationModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
