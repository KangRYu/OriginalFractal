// Settings for the shift amounts within the fractals
float lengthShift = 1;
float angleShift = 1;
// The magnitude in color shifts
float rshift = -0.5;
float gshift = -0.5;
float bshift = -0.5;
// The color phase of the flower
int colorPhase = 0;

public void setup() {
    size(500, 500);
    noStroke();
    rectMode(CENTER);
}

int len = 10; // The length of the current fractal

public void draw() {
    background(200);

    int finalColor = flowerFractal(width/2, height/2, len/2, 100, 0, 255, 255, 255);

    if(red(finalColor) == 0 && colorPhase == 0) {
        colorPhase = 1;
    }
    if(red(finalColor) == 255 && colorPhase == 1) {
        colorPhase = 0;
    }
    if(colorPhase == 1) {
        len -= 2;
    }
    len++; // Iterate over length of fractal
}

public void drawRect(float x, float y, float rectx, float recty, float w, float h, float angle, float r, float g, float b) {
    translate(x, y);
    rotate(angle);
    fill(r, g, b, 200);
    rect(rectx, recty, w, h);
    rotate(-angle);
    translate(-x, -y);
}

public int flowerFractal(float x, float y, float length, int maxLen, float angle, float r, float g, float b) {
    drawRect(x, y, length, length, length, length, angle, r, g, b);
    if(length < maxLen) {
        return color(r, g, b);
    }
    return flowerFractal(x, y, length - lengthShift, maxLen, angle - angleShift, r + rshift, g + gshift, b + bshift);
}
