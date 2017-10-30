#version 120

attribute vec3 vert;

uniform mat4 project;

void main() {
    gl_Position = project * vec4(vert,1);
}