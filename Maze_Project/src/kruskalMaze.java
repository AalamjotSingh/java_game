import java.util.*;
public class kruskalMaze {
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String BG_ANSI_GREEN = "\u001B[42m";
    public static final String ANSI_BLUE = "\u001B[44m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String BG_ANSI_YELLOW = "\u001B[43m";
    public static final String BG_ANSI_PURPLE = "\u001B[45m";
    public static final String BG_ANSI_CYAN = "\u001B[46m";
    public static final String BG_ANSI_RED = "\u001B[41m";
    public static final String BG_ANSI_BLUE = "\u001B[44m";
    
    boolean[][] maze;
    public static Random random = new Random();
    
    public static Position[] zombiePosition;
    public static Position[] coinPosition;
    public static Position playerPosition;
    public static Position exitPosition;
    public static int moves;
    public static boolean gameOver;
    
    public kruskalMaze() {
        maze = new boolean[21][75];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (i % 2 == 0 || j % 2 == 0) {
                    maze[i][j] = true;
                } else {
                    maze[i][j] = false;
                }
            }
        }
        zombiePosition = new Position[2];
        for (int i = 0; i < 2; ++i) {
            zombiePosition[i] = new Position();
        }
        coinPosition = new Position[10];
        for (int i = 0; i < 10; ++i) {
            coinPosition[i] = new Position();
        }
        playerPosition = new Position();
        exitPosition = new Position();
        moves = 100;
        gameOver = false;
    }
    
    
    public ArrayList<Edge> getEdges() {
        ArrayList<Edge> e = new ArrayList<>();
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    if (j != 0 && j != 74) {
                        if (i + 2 < 21) {
                            e.add(new Edge(new Position(j, i), new Position(j, i + 2)));
                        }
                    }
                    if (i != 0 && i != 20) {
                        if (j + 2 < 75) {
                            e.add(new Edge(new Position(j, i), new Position(j + 2, i)));
                        }
                    }
                }
            }
        }
        Collections.shuffle(e);
        return e;
    }

    public String findParent(Map<String, String> parent, String source) {
        if (parent.get(source).equals(source)) {
            return source;
        }
        return findParent(parent, parent.get(source));
    }

    public void createMaze() {
        ArrayList<Edge> e = getEdges();
        Map<String, String> parent = new HashMap<>();
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (i % 2 != 0 && j % 2 != 0) {
                    Position x = new Position(j, i);
                    parent.put(x.toString(), x.toString());
                }
            }
        }
        // 73*4+19*4 = 368
        for (int i = 0; i < 369; i++) {
            //Check if the edge is reached
            boolean flag = false;
            while (!flag) {
                Edge p;
                try {
                    p = e.remove(0);
                } catch (IndexOutOfBoundsException iob) {
                    System.out.println("Out of bounds!");
                    return;
                }
                if (p.v1.x == p.v2.x) {
                    Position a = new Position(p.v1.x - 1, (p.v1.y + p.v2.y) / 2);
                    Position b = new Position(p.v1.x + 1, (p.v1.y + p.v2.y) / 2);
                    String p1 = findParent(parent, a.toString());
                    String p2 = findParent(parent, b.toString());
                    try {
                        if (!p1.equals(p2)) {
                            maze[Math.max(p.v1.y, p.v2.y) - 1][p.v1.x] = false;
                            if (!p2.equals(b.toString()) && p1.equals(a.toString())) {
                                parent.put(a.toString(), b.toString());
                            } else if (!p1.equals(a.toString()) && p2.equals(b.toString())) {
                                parent.put(b.toString(), a.toString());
                            } else if (p1.equals(a.toString()) && p2.equals(b.toString())) {
                                parent.put(b.toString(), a.toString());
                            } else {
                                String k = b.toString();
                                String k_parent = parent.get(k);
                                while (!k.equals(k_parent)) {
                                    String temp = parent.get(k_parent);
                                    parent.put(k_parent, k);
                                    k = k_parent;
                                    k_parent = temp;
                                }
                                parent.put(b.toString(), a.toString());
                            }
                            flag = true;
                        } else {
                            continue;
                        }
                    } catch (NullPointerException n) {
                        System.out.println(
                                p.v1.toString() + " " + p.v2.toString() + " " + a.toString() + " " + b.toString());
                        System.out.println(findParent(parent, a.toString()));
                    }
                } else {
                    Position a = new Position((p.v1.x + p.v2.x) / 2, p.v1.y - 1);
                    Position b = new Position((p.v1.x + p.v2.x) / 2, p.v1.y + 1);
                    String p1 = findParent(parent, a.toString());
                    String p2 = findParent(parent, b.toString());
                    try {
                        if (!p1.equals(p2)) {
                            maze[p.v1.y][Math.max(p.v1.x, p.v2.x) - 1] = false;
                            if (!p2.equals(b.toString()) && p1.equals(a.toString())) {
                                parent.put(a.toString(), b.toString());
                            } else if (!p1.equals(a.toString()) && p2.equals(b.toString())) {
                                parent.put(b.toString(), a.toString());
                            } else if (p1.equals(a.toString()) && p2.equals(b.toString())) {
                                parent.put(b.toString(), a.toString());
                            } else {
                                String k = b.toString();
                                String k_parent = parent.get(k);
                                while (!k.equals(k_parent)) {
                                    String temp = parent.get(k_parent);
                                    parent.put(k_parent, k);
                                    k = k_parent;
                                    k_parent = temp;
                                }
                                parent.put(b.toString(), a.toString());
                            }
                            flag = true;
                        } else {
                            continue;
                        }
                    } catch (NullPointerException n) {
                        System.out.println(
                                p.v1.toString() + " " + p.v2.toString() + " " + a.toString() + " " + b.toString());
                    }
                }
            }
        }
    }
    
    public void placeStuff(int index, String stuff) {
        Position[] stuffArray;
        Position[] notStuff;
        if (stuff.equals("Coins")) {
            stuffArray = this.coinPosition;
            notStuff = this.zombiePosition;
        } else {
            stuffArray = this.zombiePosition;
            notStuff = this.coinPosition;
        }
        while (true) {
            int row = random.nextInt(21);
            int col = random.nextInt(75);
            if (isTouched(col, row, notStuff) == -1 && !maze[row][col]) {
                stuffArray[index].x = col;
                stuffArray[index].y = row;
                return;
            }
        }
    }

    public int isTouched(int x, int y, Position[] stuff) {
        for (int i = 0; i < stuff.length; i++) {
            if (stuff[i].x == x && stuff[i].y == y) {
                return i;
            }
        }
        return -1;
    }
    public static int isTouched(int x, int y, Position stuff) {
        if (stuff.x == x && stuff.y == y) {
            return 1;
        }
        
        return -1;
    }

    public void placePlayer() {
        while (true) {
            int row = random.nextInt(21);
            if (!maze[row][1]) {
                playerPosition.y = row;
                playerPosition.x = 0;
                return;
            }
        }
    }

    public void makeExit() {
        while (true) {
            int row = random.nextInt(21);
            if (!maze[row][73]) {
                exitPosition.y = row;
                exitPosition.x = 73;
                return;
            }
        }
    }

    public void drawMaze() {
        for (int i = 0; i < maze.length; ++i) {
            for (int j = 0; j < maze[0].length; ++j) {
                if (playerPosition.x == j && playerPosition.y == i) {
                    System.out.print(BG_ANSI_GREEN +  "@"  + ANSI_RESET);
                } else if (exitPosition.x == j && exitPosition.y == i) {
                    System.out.print(BG_ANSI_RED + "E" + ANSI_RESET);
                } else if (isTouched(j, i, this.coinPosition) != -1) {
                    System.out.print(BG_ANSI_YELLOW + "C" +  ANSI_RESET);
                } else if (isTouched(j, i, this.zombiePosition) != -1) {
                    System.out.print(BG_ANSI_PURPLE + "Z" + ANSI_RESET);
                } else {
                    System.out.print(maze[i][j] ? "#" : BG_ANSI_CYAN + "." + ANSI_RESET);
                }
            }
            System.out.println("");
        }
        
        System.out.println("\n\n");
    }

    public void play() {
        Scanner s = new Scanner(System.in);
        while (!gameOver && moves != 0) {
            this.drawMaze();
            System.out.println("Remaining Moves => " + moves);
            // get move
            System.out.println("Enter you move(U/D/L/R): ");
            String move = s.next();
            move = move.toUpperCase();
            // player move
            switch (move) {
                case "U": {
                    if (playerPosition.y - 1 > 0) {
                        if (!maze[playerPosition.y - 1][playerPosition.x]) {
                            playerPosition.y--;
                            moves--;
                        } else {
                            System.out.println("You hit a wall!");
                        }
                    } else {
                        System.out.println("You hit a wall!");
                    }
                    break;
                }
                case "D": {
                    if (playerPosition.y + 1 < 21) {
                        if (!maze[playerPosition.y + 1][playerPosition.x]) {
                            playerPosition.y++;
                            moves--;
                        } else {
                            System.out.println("You hit a wall!");
                        }
                    } else {
                        System.out.println("You hit a wall!");
                    }
                    break;
                }
                case "L": {
                    if (playerPosition.x - 1 > 0) {
                        if (!maze[playerPosition.y][playerPosition.x - 1]) {
                            playerPosition.x--;
                            moves--;
                        } else {
                            System.out.println("You hit a wall!");
                        }
                    } else {
                        System.out.println("You hit a wall!");
                    }
                    break;
                }
                case "R": {
                    if (playerPosition.x + 1 < 75) {
                        if (!maze[playerPosition.y][playerPosition.x + 1]) {
                            playerPosition.x++;
                            moves--;
                        } else {
                            System.out.println("You hit a wall!");
                        }
                    } else {
                        System.out.println("You hit a wall!");
                    }
                    break;
                }
                default: {
                    System.out.println("Invalid move!");
                }
            }
            // zombies move
            for (int i = 0; i < 2; ++i) {
                ArrayList<Position> availableMoves = new ArrayList<>();
                Position p = zombiePosition[i];
                // left move
                if (p.x - 1 > 0) {
                    if (!maze[p.y][p.x - 1]) {
                        availableMoves.add(new Position(p.x - 1, p.y));
                    }
                }
                // right move
                if (p.x + 1 < 75) {
                    if (!maze[p.y][p.x + 1]) {
                        availableMoves.add(new Position(p.x + 1, p.y));
                    }
                }
                // up move
                if (p.y - 1 > 0) {
                    if (!maze[p.y - 1][p.x]) {
                        availableMoves.add(new Position(p.x, p.y - 1));
                    }
                }
                // down move
                if (p.y + 1 < 21) {
                    if (!maze[p.y + 1][p.x]) {
                        availableMoves.add(new Position(p.x, p.y + 1));
                    }
                }
                zombiePosition[i] = availableMoves.get(random.nextInt(availableMoves.size()));
            }
            // collision checks
            int coinTouched = isTouched(playerPosition.x, playerPosition.y, coinPosition);
            int zombieTouched = isTouched(playerPosition.x, playerPosition.y, zombiePosition);
            if (coinTouched != -1) {
                System.out.println("You touched a coin!");
                moves += 100;
                placeStuff(coinTouched, "Coins");
            }
            if (zombieTouched != -1) {
                System.out.println("You touched a zombie!");
                placePlayer();
            }
        }
        
        s.close();
    }

    public static void gameEnd(){
        int exitTouched = isTouched(playerPosition.x, playerPosition.y, exitPosition);
        if(exitTouched == 1){
            System.out.println("Congratulations ! You finished Level 4.");
            System.exit(0);
        }
        
    }
}
