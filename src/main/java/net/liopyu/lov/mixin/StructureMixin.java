package net.liopyu.lov.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StructureTemplate.class)
public class StructureMixin {
    public StructureTemplate template=(StructureTemplate)(Object) this;

    @Inject(method = "placeInWorld", at = @At("HEAD"))
    private void preventAutoWaterlogging(ServerLevelAccessor serverLevelAccessor, BlockPos blockPos1, BlockPos blockPos2, StructurePlaceSettings settings, RandomSource random, int flag, CallbackInfoReturnable<Boolean> cir) {
       /* if (settings.getProcessors()
                .stream()
                .anyMatch(processor -> processor.getType() == MyModStructureProcessorTypes.WATERLOGGED_PROCESSOR)) {
             // Disables automatic waterlogging
        }*/
        settings.setKeepLiquids(false);
        cir.setReturnValue(
                false
        );
    }
}
