package net.onedaybeard.graftt;

import org.objectweb.asm.tree.ClassNode;

public interface PromoteVisibilityWhenRetrofittingInterface {

    class Foo {
        private int x = 2, y = 4;

        private int x() { return x; }
        private int y() { return y; }

        @Override
        public String toString() {
            return String.format("x: %d, y: %d", x(), y());
        }
    }

    @Graft.Recipient(Foo.class)
    class FooTransplant implements Point {

        @Graft.Fuse
        public int x() { return x(); }

        @Graft.Fuse
        public int y() { return y(); }
    }

@Graft.Recipient(ClassNode.class)
public class ClassNodeTransplant {

    @Graft.Mock
    public String name;

    public String toString() {
        return "ClassNode(" + name + ")";
    }
}
}
