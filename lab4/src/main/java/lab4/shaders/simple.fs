#version 450

uniform int green;

void main() {
    gl_FragColor = vec4(1,green,0,1);
}