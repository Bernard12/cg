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
    if(c > 0){
        pos = vec4(vert,1);
    }else{
        pos = vec4(vert,1);
    }
    gl_Position = project * pos;
}