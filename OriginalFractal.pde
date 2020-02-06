public void setup() {
    size(500, 500);
    noStroke();
    rectMode(CENTER);
    fractal(250, 250, 10, 0);
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