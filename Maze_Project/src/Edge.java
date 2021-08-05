
public class Edge {
        Position v1;
        Position v2;

        public Edge() {
            this.v1 = new Position();
            this.v2 = new Position();
        }

        public Edge(Position v1, Position v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        @Override
        public String toString() {
            return "Position a: " + this.v1.toString() + " Position b: " + this.v2.toString();
        }
    }