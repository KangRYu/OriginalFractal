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
    flowerFractal(width/2, height/2, 10, 0, 255, 255, 255);
    flowerFractal2(width/2, height/2, 300, 0, 255, 255, 255);
    swirlFractal(width/2, height/2, 10, 0, 255, 255, 255);
}

public void drawRect(float x, float y, float rectx, float recty, float w, float h, float angle, float r, float g, float b) {
    translate(x, y);
    rotate(angle);
    fill(r, g, b);
    rect(rectx, recty, w, h);
    rotate(-angle);
    translate(-x, -y);
}

public void flowerFractal(float x, float y, float length, float angle, float r, float g, float b) {
    if(length > 1000) {
        drawRect(x, y, length, length, length, length, angle, r, g, b);
    }
    else {
        drawRect(x, y, length, length, length, length, angle, r, g, b);
        flowerFractal(x, y, length + 1, angle - 1, r - 0.5f, g - 0.5f, b - 0.5f);
    }
}

public void flowerFractal2(float x, float y, float length, float angle, float r, float g, float b) {
    if(length < 10) {
        drawRect(x, y, length, length, length, length, angle, r, g, b);
    }
    else {
        drawRect(x, y, length, length, length, length, angle, r, g, b);
        flowerFractal(x, y, length - 1, angle - 1, r - 0.5f, g - 0.5f, b - 0.5f);
    }
}

public void swirlFractal(float x, float y, float length, float angle, float r, float g, float b) {
    if(length > 1000) {
        drawRect(x, y, length, 0, length, length, angle, r, g, b);
    }
    else {
        drawRect(x, y, length, 0, length, length, angle, r, g, b);
        swirlFractal(x, y, length + 1, angle - 0.01f, r - 0.5f, g - 0.5f, b - 0.5f);
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
