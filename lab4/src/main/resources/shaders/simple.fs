#version 120

uniform float red = 0;
uniform float green = 0;
uniform float blue = 0;
uniform float intens = 1;

vec4 calculateColor(){
    vec4 amb = vec4(red * intens,green * intens,bue * intens,1);
    return vec4(1,1,1,1);
}

void main() {
    gl_FragColor = vec4(red,green,blue,1);
}