package me.mightylight.cmgtpp.item;

import me.mightylight.cmgtpp.block.ModBlocks;
import me.mightylight.cmgtpp.block.custom.TestBlock;
import me.mightylight.cmgtpp.block.custom.TestBlockV2;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import static me.mightylight.cmgtpp.block.custom.TestBlock.FACING;

public class UpgradeKit extends Item {
    public UpgradeKit(Properties p_41383_) {
        super(p_41383_);
    }

    //Upgrade the block when this item is used on the TestBlock, so it becomes TestBlockV2. Removes the item when used correctly.
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = world.getBlockState(pos);

        if(state.getBlock() instanceof TestBlock && !world.isClientSide){
            if(state.getBlock() instanceof TestBlockV2) return super.useOn(context);

            //Sets the new upgraded block with the same direction property value as the previous block
            world.setBlock(pos,ModBlocks.TEST_BLOCKV2.get().defaultBlockState().setValue(FACING,state.getValue(FACING)),1);
            context.getItemInHand().setCount(context.getItemInHand().getCount() - 1);
        }
        return super.useOn(context);
    }
}
