# Cohen-Sutherland Line Clipping Algorithm

This repository contains an implementation of the **Cohen-Sutherland Line Clipping Algorithm** in Java, which is widely used in computer graphics for line clipping in a rectangular window. The algorithm efficiently determines the portions of a line that are visible within a defined rectangular area.

## About the Algorithm

The Cohen-Sutherland algorithm divides the 2D space into nine regions using the window boundary. Each endpoint of the line is assigned a region code, which helps quickly decide if a line is completely inside, completely outside, or partially within the clipping window. The algorithm then iteratively clips lines that are partially within the window until the visible segment is found.

## Java AWT Integration

This project utilizes **AWT (Abstract Window Toolkit)**, a part of Java's standard library for building graphical user interfaces. AWT provides the necessary components for creating windows, drawing graphics, and handling user input. In this implementation, AWT is used to:

- Create the application window to display the clipping process.
- Draw the clipping rectangle and the lines to be clipped.
- Visualize the result of the Cohen-Sutherland algorithm interactively.

## Features

- Implementation of Cohen-Sutherland line clipping.
- Visualization of clipping window and lines using Java AWT.
- Easy-to-understand code structure.
- Suitable for educational purposes and learning computer graphics basics.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed.

### Running the Code

1. Clone this repository:

   ```sh
   git clone https://github.com/kamleshhsupe01-tech/cohen_sutherland.git
   ```

2. Compile the Java source files:

   ```sh
   javac *.java
   ```

3. Run the application:

   ```sh
   java Main
   ```

*(Replace `Main` with the actual entry point class if different.)*

## Code Structure

- `Main.java` – Entry point of the application.
- `CohenSutherland.java` – Contains the algorithm implementation.
- Additional files for GUI and utility functions.

## References

- [Cohen–Sutherland Algorithm - Wikipedia](https://en.wikipedia.org/wiki/Cohen%E2%80%93Sutherland_algorithm)
- [Java AWT Documentation](https://docs.oracle.com/javase/8/docs/technotes/guides/awt/)

## License

This project is licensed under the MIT License.

---

**Feel free to explore, learn, and modify the code for your needs!**
