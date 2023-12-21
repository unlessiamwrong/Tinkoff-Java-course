package edu.hw11.Task3;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;

@SuppressWarnings("MagicNumber")
public class Fib {
    public Class<?> generate() {
        return new ByteBuddy()
            .subclass(Object.class)
            .name("Fib")
            .defineMethod("run", long.class, Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC)
            .withParameter(int.class)
            .intercept(new Implementation.Simple(new Impl()))
            .make()
            .load(getClass().getClassLoader())
            .getLoaded();
    }

    private static class Impl implements ByteCodeAppender {
        @Override
        public Size apply(
            MethodVisitor mv,
            Implementation.Context ctx,
            MethodDescription md
        ) {
            Label startLabel = new Label();
            Label loopLabel = new Label();
            Label endLabel = new Label();
            mv.visitCode();
            mv.visitVarInsn(Opcodes.ILOAD, 0);
            mv.visitJumpInsn(Opcodes.IFNE, startLabel);
            mv.visitInsn(Opcodes.LCONST_0);
            mv.visitInsn(Opcodes.LRETURN);
            mv.visitFrame(Opcodes.F_FULL, 1, new Object[] {Opcodes.INTEGER}, 0, new Object[] {});
            mv.visitLabel(startLabel);
            mv.visitInsn(Opcodes.LCONST_0);
            mv.visitVarInsn(Opcodes.LSTORE, 1);
            mv.visitInsn(Opcodes.LCONST_1);
            mv.visitVarInsn(Opcodes.LSTORE, 3);
            mv.visitInsn(Opcodes.ICONST_0);
            mv.visitVarInsn(Opcodes.ISTORE, 5);
            mv.visitFrame(
                Opcodes.F_FULL,
                4,
                new Object[] {Opcodes.INTEGER, Opcodes.LONG, Opcodes.LONG, Opcodes.INTEGER},
                0,
                new Object[] {}
            );
            mv.visitLabel(loopLabel);
            mv.visitVarInsn(Opcodes.ILOAD, 5);
            mv.visitVarInsn(Opcodes.ILOAD, 0);
            mv.visitJumpInsn(Opcodes.IF_ICMPGE, endLabel);
            mv.visitVarInsn(Opcodes.LLOAD, 3);
            mv.visitVarInsn(Opcodes.LSTORE, 6);
            mv.visitVarInsn(Opcodes.LLOAD, 1);
            mv.visitVarInsn(Opcodes.LLOAD, 3);
            mv.visitInsn(Opcodes.LADD);
            mv.visitVarInsn(Opcodes.LSTORE, 3);
            mv.visitVarInsn(Opcodes.LLOAD, 6);
            mv.visitVarInsn(Opcodes.LSTORE, 1);
            mv.visitIincInsn(5, 1);
            mv.visitJumpInsn(Opcodes.GOTO, loopLabel);
            mv.visitFrame(
                Opcodes.F_FULL,
                4,
                new Object[] {Opcodes.INTEGER, Opcodes.LONG, Opcodes.LONG, Opcodes.INTEGER},
                0,
                new Object[] {}
            );
            mv.visitLabel(endLabel);
            mv.visitVarInsn(Opcodes.LLOAD, 1);
            mv.visitInsn(Opcodes.LRETURN);
            mv.visitEnd();
            return new Size(15, 15);

        }

    }
}
