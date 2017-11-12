#version 120

attribute vec3 vert;

uniform mat4 project;
uniform vec3 oz = vec3(0,0,1);
uniform vec3 Normal;
uniform float cs = 1;

void main() {
    vec3 n = normalize(Normal);
    float ang = dot(n,oz);
    vec4 pos;
    if(ang > 0){
        pos = vec4((1+cs/3) * vert,1);
    }else{
        pos = vec4(vert,1);
    }
    gl_Position = project * pos;
}