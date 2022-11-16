package me.mightylight.cmgtpp.block.custom;

import com.mojang.math.Vector3f;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class TestBlock extends DirectionalBlock{
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;


    public TestBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
    }


    //Moves the entity that steps on this block in a direction based on which way this block is facing
    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        Vec3 vec = new Vec3(0,0,0);
        switch(state.getValue(FACING)) {
            case NORTH -> {
                vec = new Vec3(Vector3f.ZN);
                centerX(pos, entity);
            }
            case SOUTH -> {
                vec = new Vec3(Vector3f.ZP);
                centerX(pos, entity);
            }
            case WEST -> {
                vec = new Vec3(Vector3f.XN);
                centerZ(pos, entity);
            }
            case EAST -> {
                vec = new Vec3(Vector3f.XP);
                centerZ(pos, entity);
            }
        }
        entity.move(MoverType.SELF, vec.multiply(0.2d,0,0.2d));
    }

    /**
     * Pushes the entity towards the block position on the X Axis
     * @param pos
     * block position
     * @param entity
     * entity that needs to be moved
     */
    private void centerX(BlockPos pos, Entity entity) {
        if(entity.position().x > pos.getX() + .55)
        {
            entity.move(MoverType.SELF,new Vec3(-0.1d,0,0));
        }
        else if(entity.position().x < pos.getX() + .45)
        {
            entity.move(MoverType.SELF,new Vec3(0.1d,0,0));
        }
    }




    /**
     * Pushes the entity towards the block position on the Z Axis
     * @param pos
     * block position
     * @param entity
     * entity that needs to be moved
     */
    private void centerZ(BlockPos pos, Entity entity) {
        if(entity.position().z > pos.getZ() + .55)
        {
            entity.move(MoverType.SELF,new Vec3(0,0,-0.1d));
        }
        else if(entity.position().z < pos.getZ() + .45)
        {
            entity.move(MoverType.SELF,new Vec3(0,0,0.1d));
        }
    }


    /**
     * Rotates the block based on the block state given (block state must contain the FACING Property)
     * @param level level/world where the block is
     * @param pos position of the block
     * @param state block state to change
     */
    public void Rotate(Level level, BlockPos pos, BlockState state){

        switch (state.getValue(FACING)){
            case NORTH -> {
                level.setBlock(pos,state.setValue(FACING,Direction.EAST),1);
            }
            case EAST -> {
                level.setBlock(pos,state.setValue(FACING,Direction.SOUTH),1);
            }
            case WEST -> {
                level.setBlock(pos,state.setValue(FACING,Direction.NORTH),1);
            }
            case SOUTH -> {
                level.setBlock(pos,state.setValue(FACING,Direction.WEST),1);
            }
        }
    }




    //Necessary methods for properly setting the direction of the block
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(FACING,context.getHorizontalDirection());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

}
