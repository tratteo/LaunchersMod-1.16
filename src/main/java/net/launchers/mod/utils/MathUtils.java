package net.launchers.mod.utils;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public final class MathUtils
{
    public static Vec3d fromDirection(Direction direction)
    {
        switch(direction)
        {
            case UP:
                return new Vec3d(0, 1, 0);
            case DOWN:
                return new Vec3d(0, -1, 0);
            case EAST:
                return new Vec3d(1, 0, 0);
            case WEST:
                return new Vec3d(-1, 0, 0);
            case NORTH:
                return new Vec3d(0, 0, -1);
            case SOUTH:
                return new Vec3d(0, 0, 1);
            default:
                return new Vec3d(0, 0, 0);
        }
    }
    
    public static Box getExpansionBlock(BlockPos pos, Direction facing)
    {
        Box res = new Box(pos);
        switch(facing)
        {
            case UP:
                res.expand(0.2D, 1.2D, 0.2D);
            case DOWN:
                res.expand(0.2D, 1.2D, 0.2D);
            case EAST:
                res.expand(1.2D, 0.2D, 0.2D);
            case WEST:
                res.expand(1.2D, 0.2D, 0.2D);
            case NORTH:
                res.expand(0.2D, 0.2D, 1.2D);
            case SOUTH:
                res.expand(0.2D, 0.2D, 1.2D);
            default:
                res.expand(0, 0, 0);
        }
        System.out.println(res);
        return res;
    }
}

