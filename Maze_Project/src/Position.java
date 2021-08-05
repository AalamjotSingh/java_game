public class Position {
        int x;
        int y;

        public Position() {
            this.x = -1;
            this.y = -1;
        }

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "x: " + this.x + " y: " + this.y;
        }
    }