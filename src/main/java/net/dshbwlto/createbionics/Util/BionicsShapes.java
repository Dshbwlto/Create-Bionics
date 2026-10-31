package net.dshbwlto.createbionics.Util;

import com.simibubi.create.AllShapes;
import net.createmod.catnip.math.VoxelShaper;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.BiFunction;

import static net.minecraft.core.Direction.UP;

public class BionicsShapes {
    public static final VoxelShape

        DEPTH_BELL_EXTENDER_1_SINGLE = shape(-1, 0, -1, 17, 4, 17).build(),
        DEPTH_BELL_EXTENDER_1_DOUBLE = shape(-1, 0, -1, 17, 8, 17).build(),
        DEPTH_BELL_EXTENDER_1_TRIPLE = shape(-1, 0, -1, 17, 12, 17).build(),
        DEPTH_BELL_EXTENDER_1_QUADRUPLE = shape(-1, 0, -1, 17, 16, 17).build(),
        DEPTH_BELL_EXTENDER_1_QUADRUPLE_CONNECTED = shape(-1, 0, -1, 17, 16, 17).build(),

        DEPTH_BELL_EXTENDER_2_SINGLE = shape(-3, 0, -3, 19, 4, 19).build(),
        DEPTH_BELL_EXTENDER_2_DOUBLE = shape(-3, 0, -3, 19, 8, 19).build(),
        DEPTH_BELL_EXTENDER_2_TRIPLE = shape(-3, 0, -3, 19, 12, 19).build(),
        DEPTH_BELL_EXTENDER_2_QUADRUPLE = shape(-3, 0, -3, 19, 16, 19).build(),
        DEPTH_BELL_EXTENDER_2_QUADRUPLE_CONNECTED = shape(-3, 0, -3, 19, 16, 19).build(),

        DEPTH_BELL_EXTENDER_3_SINGLE = shape(-5, 0, -5, 21, 4, 21).build(),
        DEPTH_BELL_EXTENDER_3_DOUBLE = shape(-5, 0, -5, 21, 8, 21).build(),
        DEPTH_BELL_EXTENDER_3_TRIPLE = shape(-5, 0, -5, 21, 12, 21).build(),
        DEPTH_BELL_EXTENDER_3_QUADRUPLE = shape(-5, 0, -5, 21, 16, 21).build(),
        DEPTH_BELL_EXTENDER_3_QUADRUPLE_CONNECTED = shape(-5, 0, -5, 21, 16, 21).build(),

        DEPTH_BELL_EXTENDER_4_SINGLE = shape(-7, 0, -7, 23, 4, 23).build(),
        DEPTH_BELL_EXTENDER_4_DOUBLE = shape(-7, 0, -7, 23, 8, 23).build(),
        DEPTH_BELL_EXTENDER_4_TRIPLE = shape(-7, 0, -7, 23, 12, 23).build(),
        DEPTH_BELL_EXTENDER_4_QUADRUPLE = shape(-7, 0, -7, 23, 16, 23).build(),
        DEPTH_BELL_EXTENDER_4_QUADRUPLE_CONNECTED = shape(-7, 0, -7, 23, 16, 23).build(),

        DEPTH_BELL_EXTENDER_5_SINGLE = shape(-9, 0, -9, 25, 4, 25).build(),
        DEPTH_BELL_EXTENDER_5_DOUBLE = shape(-9, 0, -9, 25, 8, 25).build(),
        DEPTH_BELL_EXTENDER_5_TRIPLE = shape(-9, 0, -9, 25, 12, 25).build(),
        DEPTH_BELL_EXTENDER_5_QUADRUPLE = shape(-9, 0, -9, 25, 16, 25).build(),
        DEPTH_BELL_EXTENDER_5_QUADRUPLE_CONNECTED = shape(-9, 0, -9, 25, 16, 25).build();

    private static AllShapes.Builder shape(VoxelShape shape) {
        return new AllShapes.Builder(shape);
    }

    private static AllShapes.Builder shape(double x1, double y1, double z1, double x2, double y2, double z2) {
        return shape(cuboid(x1, y1, z1, x2, y2, z2));
    }

    private static VoxelShape cuboid(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Block.box(x1, y1, z1, x2, y2, z2);
    }

    public static class Builder {

        private VoxelShape shape;

        public Builder(VoxelShape shape) {
            this.shape = shape;
        }

        public BionicsShapes.Builder add(VoxelShape shape) {
            this.shape = Shapes.or(this.shape, shape);
            return this;
        }

        public BionicsShapes.Builder add(double x1, double y1, double z1, double x2, double y2, double z2) {
            return add(cuboid(x1, y1, z1, x2, y2, z2));
        }

        public BionicsShapes.Builder erase(double x1, double y1, double z1, double x2, double y2, double z2) {
            this.shape = Shapes.join(shape, cuboid(x1, y1, z1, x2, y2, z2), BooleanOp.ONLY_FIRST);
            return this;
        }

        public VoxelShape build() {
            return shape;
        }

        public VoxelShaper build(BiFunction<VoxelShape, Direction, VoxelShaper> factory, Direction direction) {
            return factory.apply(shape, direction);
        }

        public VoxelShaper build(BiFunction<VoxelShape, Direction.Axis, VoxelShaper> factory, Direction.Axis axis) {
            return factory.apply(shape, axis);
        }

        public VoxelShaper forDirectional(Direction direction) {
            return build(VoxelShaper::forDirectional, direction);
        }

        public VoxelShaper forAxis() {
            return build(VoxelShaper::forAxis, Direction.Axis.Y);
        }

        public VoxelShaper forHorizontalAxis() {
            return build(VoxelShaper::forHorizontalAxis, Direction.Axis.Z);
        }

        public VoxelShaper forHorizontal(Direction direction) {
            return build(VoxelShaper::forHorizontal, direction);
        }

        public VoxelShaper forDirectional() {
            return forDirectional(UP);
        }

    }

}
