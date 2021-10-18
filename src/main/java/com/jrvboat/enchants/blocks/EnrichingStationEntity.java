package com.jrvboat.enchants.blocks;

import com.jrvboat.enchants.Main;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class EnrichingStationEntity extends BlockEntity {

    public EnrichingStationEntity(BlockPos pos, BlockState state) {
        super(Main.ENRICHING_STATION_ENTITY, pos, state);
    }
    public EnrichingStationEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
}
