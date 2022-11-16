package me.mightylight.cmgtpp.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class TestBlockV2 extends TestBlock{
    public TestBlockV2(Properties properties) {
        super(properties);
    }

    //When the player is sneaking, the player will not move on the conveyor
    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(entity.isShiftKeyDown()) return;
        super.stepOn(level, pos, state, entity);
    }
}
