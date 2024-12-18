// Import required modules
import Game from "./src/model/game.js";
import View from "./src/view/view.js";
import Controller from "./src/controller/controller.js"; 
import VirtualKeyboard from "./src/mobile/virtualkeyboard.js";
import Motion from "./src/mobile/motion.js";

// Define grid dimensions
const GRID_ROWS = 20;
const GRID_COLUMNS = 10;

// Get root element from DOM
const element = document.querySelector("#root");

// Initialize game components
const game = new Game(GRID_ROWS, GRID_COLUMNS);
const view = new View({
  element,
  width: 720,
  height: 640,
  rows: GRID_ROWS,
  columns: GRID_COLUMNS,
});

// Set up controls
const controller = new Controller(game, view);
const motion = new Motion(game, view);
const virtualKeyboard = new VirtualKeyboard();

// Configure audio settings
let audio = document.getElementById("soundtrack");
audio.volume = 0.1;
let rotateSound = document.createElement("rotate");
rotateSound.volume = 0.3;

/* 
To run this code:
1. Make sure you have all required files in the correct directory structure
2. Open index.html in a web browser that supports ES6 modules
3. The game should automatically initialize and start running
4. Use arrow keys or virtual keyboard controls to play
*/
