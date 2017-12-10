#version 120

attribute vec3 vert;

uniform mat4 project;
uniform vec3 oz = vec3(0,0,1);
uniform vec3 Normal;
uniform float cs = 1;

void main() {
    vec3 n = normalize(Normal);
    float c = dot(n,oz);
    vec4 pos;
    pos = vec4((1+cs/3)*vert,1);
    gl_Position = project * pos;
}