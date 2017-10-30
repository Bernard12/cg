#version 120

attribute vec3 vert;

uniform mat4 project;

void main() {
    vec4 pos = vec4(vert,1);
    gl_Position = project * pos;
}