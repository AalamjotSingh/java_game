# Maze Adventure Game

Welcome to the **Maze Adventure Game**! This console-based game offers an engaging maze exploration experience with multiple levels. Each level presents unique challenges, from collecting coins to avoiding zombies, navigating regions, and solving puzzles.

---

## Gameplay Instructions

### General Controls
- Use **`U`**, **`D`**, **`L`**, and **`R`** to move Up, Down, Left, and Right, respectively.
- Follow the level-specific rules to complete the objectives.

### Levels Overview

#### Level 1: Coin Collection
- Navigate the maze to collect two coins.
- Reach the exit after collecting both coins to win the level.

#### Level 2: Flood Fill Puzzle
- Use the flood-fill algorithm to explore and uncover the maze.
- Input coordinates (e.g., `AC`) to reveal sections of the maze.
- Navigate to the exit to complete the level.

#### Level 3: Regions and Zombies
- Set a wall probability to generate the maze.
- Avoid zombies while exploring regions of the maze.
- Locate the map and find the exit to win.

#### Level 4: Randomized Maze (Kruskal’s Algorithm)
- Play in a procedurally generated maze.
- Collect coins and avoid zombies within a limited number of moves.
- Escape through the exit to complete the level.

---

## Project Structure

### Core Files
- **`Maze_Project_Driver.java`**: The main driver that initializes and controls the game.
- **`Position.java`**: Represents positions within the maze.
- **`Edge.java`**: Defines edges for use in graph-based maze generation.
- **`FromTo.java`**: Tracks movement within the maze.

### Level Implementations
- **`Maze_level1.java`**: Implementation for Level 1, focusing on simple maze navigation and coin collection.
- **`Maze_level2.java`**: Level 2 implementation with flood-fill mechanics.
- **`Maze_level3.java`**: Level 3 with zombies, maps, and unique regions.
- **`kruskalMaze.java`**: Level 4, featuring randomized maze generation using Kruskal's algorithm.

### Additional Utilities
- **`UnionFind.java`**: Implements a union-find data structure for managing regions in Level 3.
- **`Zombies.java`**: Represents zombie entities and their positions within the maze.

---

## Key Algorithms

### 1. **Kruskal’s Algorithm**
- Used to generate a spanning tree for a randomized maze in Level 4.
- Ensures that all nodes in the maze are connected without cycles.

### 2. **Flood-Fill Algorithm**
- Employed in Level 2 to explore and reveal hidden sections of the maze.
- Helps players identify valid paths to navigate.

### 3. **Region Detection**
- In Level 3, regions are identified using a union-find data structure.
- Ensures connectivity between key areas while avoiding blocked paths.

---

## Challenges and Mechanics

- **Dynamic Gameplay**: Every level introduces unique mechanics and challenges.
- **Random Maze Generation**: Procedural generation ensures a new experience every time you play.
- **Limited Moves**: Some levels, such as Level 4, include a move limit for added difficulty.
- **Zombies and Obstacles**: Higher levels feature moving zombies and other obstacles, increasing the challenge.

---

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher.
- A Java IDE or terminal for running the program.

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/maze-adventure-game.git
