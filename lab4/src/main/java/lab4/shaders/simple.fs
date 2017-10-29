#version 450

uniform float red = 0;
uniform float green = 0;
uniform float blue = 0;
uniform float intens = 0;

void main() {
    gl_FragColor = vec4(red * intens,green * intens,blue * intens,1);
}