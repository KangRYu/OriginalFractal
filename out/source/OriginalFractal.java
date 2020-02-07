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

// Settings for the shift amounts within the fractals
float lengthShift = 1;
float angleShift = 1;
float rshift = -0.5f;
float gshift = -0.5f;
float bshift = -0.5f;

public void setup() {
    
    noStroke();
    rectMode(CENTER);
}

int len = 10;
public void draw() {
    background(200);
    //portalFractal(width/2, height/2, 10, len, 0, 255, 255, 255);
    flowerFractal(width/2, height/2, len, 100, 0, 255, 255, 255);
    //swirlFractal(width/2, height/2, 10, len, 0, 0, 0, 0);
    len++;
}

public void drawRect(float x, float y, float rectx, float recty, float w, float h, float angle, float r, float g, float b) {
    translate(x, y);
    rotate(angle);
    fill(r, g, b);
    rect(rectx, recty, w, h);
    rotate(-angle);
    translate(-x, -y);
}

public void portalFractal(float x, float y, float length, int maxLen, float angle, float r, float g, float b) {
    if(length > maxLen) {
        drawRect(x, y, length, length, length, length, angle, r, g, b);
    }
    else {
        drawRect(x, y, length, length, length, length, angle, r, g, b);
        portalFractal(x, y, length + lengthShift, maxLen, angle - angleShift, r + rshift, g + gshift, b + bshift);
    }
}

public void flowerFractal(float x, float y, float length, int maxLen, float angle, float r, float g, float b) {
    if(length < maxLen) {
        drawRect(x, y, length, length, length, length, angle, r, g, b);
    }
    else {
        drawRect(x, y, length, length, length, length, angle, r, g, b);
        flowerFractal(x, y, length - lengthShift, maxLen, angle - angleShift, r + rshift, g + gshift, b + bshift);
    }
}

public void swirlFractal(float x, float y, float length, int maxLen, float angle, float r, float g, float b) {
    if(length > maxLen) {
        drawRect(x, y, length, 0, length, length, angle, r, g, b);
    }
    else {
        drawRect(x, y, length, 0, length, length, angle, r, g, b);
        swirlFractal(x, y, length + lengthShift, maxLen, angle - 0.01f, r - rshift, g - gshift, b - bshift);
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
