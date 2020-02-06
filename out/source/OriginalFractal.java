import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class OriginalFractal extends PApplet {

public void setup() {
    
    noStroke();
    rectMode(CENTER);
    fractal(250, 250, 10, 0);
}

public void draw() {
    fractal(width/2, height/2, 10, 0);
}

public void fractal(float x, float y, float length, float angle) {
    if(length > 1000) {
        translate(x, y);
        rotate(angle);
        fill((float)(255 * Math.random()), (float)(255 * Math.random()), (float)(255 * Math.random()), (float)(255 * Math.random()));
        rect(length, length, length, length);
        rotate(-angle);
        translate(-x, -y);
    }
    else {
        translate(x, y);
        rotate(angle);
        fill((float)(255 * Math.random()), (float)(255 * Math.random()), (float)(255 * Math.random()), (float)(255 * Math.random()));
        rect(length, length, length, length);
        rotate(-angle);
        translate(-x, -y);

        fractal(x, y, length + 1, angle - 1);
    }
}
  public void settings() {  size(500, 500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OriginalFractal" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
