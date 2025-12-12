# 🎨 OOP_Project_2026

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Swing](https://img.shields.io/badge/GUI-Swing-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Stable%20v2.0-green?style=for-the-badge)

# OOP_Project_2026

A robust Java application demonstrating Object-Oriented Programming (OOP) principles — Projet for FCI Assuit.

## What’s new (v1.0.0 → v2.0.0)

Overview
- v2.0.0 is a major release that refactors the application structure and adds an interactive launcher GUI. The project separates file I/O and area-calculation logic from the presentation layer to improve modularity and usability.

Breaking changes
- src/Main.java was removed. The new entry point is ProjectInterface.main(). Update any run configurations, scripts, or automation that previously relied on Main.
- Some classes and responsibilities were reorganized; imports or run scripts may need adjustments.

New files
- src/ProjectInterface.java — an interactive launcher GUI to select an input file, draw shapes, and save the computed sum.
- src/DrowController.java — handles reading input, calculating the sum of areas, launching the drawing window, and saving sumAreas.txt.

Removed / modified files
- src/Main.java — removed (its responsibilities moved to ProjectInterface and DrowController).
- README.md — project structure and run instructions were clarified and improved.
- sumAreas.txt — output sample updated.

Notable behavior / API
- New entry point for normal use: ProjectInterface.main().
- Useful DrowController methods:
  - drawShapes(File inputFile) — calculate areas then display the drawing UI.
  - saveSumToTextFile(File inputFile) — save "Sum Of Areas = ..." to sumAreas.txt.
  - calculateSumOfAreas(File inputFile) — returns the computed sum as double.
- The input format is unchanged: first an integer count, then pairs of shapeType and value per line (e.g., "circle 5.0").

Improvements
- Clear separation of concerns (UI vs. processing).
- Improved README with a Project Structure section and corrected clone instructions.
- GUI improvements: file chooser, status label, and scrollable drawing panel.

Upgrade / migration steps
1. Update your IDE run configuration to use ProjectInterface (main) or call DrowController methods directly for non-GUI runs.
2. Ensure input.txt remains in the expected format (count followed by shape entries).
3. Run the project and verify sumAreas.txt is generated/updated as expected.
4. If you have automation or CI that referenced Main, update those scripts to use ProjectInterface or a direct DrowController invocation.

---

## 📂 Project Structure

Here's an overview of the project's file organization:

```OOP_Project_2026/
├── src/
│   ├── interfaces/
│   │   └── Drawable.java       # Interface defining common behavior (draw, getArea)
│   ├── Circle.java             # Concrete class representing a 2D Circle
│   ├── Cube.java               # Concrete class representing a 3D Cube
│   ├── DrawingPanel.java       # Custom JPanel logic for dynamic rendering & scrolling
│   └── ProjectInterface.java   # Main entry point (GUI Launcher)
│   └── DrowController.java     # Input processing & controller logic
├── assets/                     # Images and GIFs used in this README
├── input.txt                   # Sample input file for testing
├── sumAreas.txt                # print sum of all shapes areas
└── README.md                   # Project documentation
```

---

## 🚀 How to Run

1. ```Clone the repository:
   git clone https://github.com/0xezzdev/OOP_Project_2026.git
   ```
2. Open in IDE (IntelliJ IDEA, Eclipse, or NetBeans).
3. Update your run configuration to use the ProjectInterface main class (ProjectInterface.main).
4. Alternatively, call DrowController.calculateSumOfAreas(File) from code for non-GUI runs.
---

## 📝 Input File Format

To test the application, create a text file (e.g., `shapes.txt`) with the following format (adjust based on your parser logic):

```text
4
Circle 50
Cube 100
Circle 75
Cube 60
```
---

## 👤 Author
* **Ezzeldeen (0xezzdev)**

---

© 2025 Ezzeldeen. All Rights Reserved.
