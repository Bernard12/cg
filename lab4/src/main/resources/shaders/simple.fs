#version 120

uniform float red = 0;
uniform float green = 0;
uniform float blue = 0;


uniform vec3 col;
uniform vec3 light = vec3(0,0,1);
uniform vec3 Normal;

float dotok(vec4 a, vec4 b){
    return a.x * b.x + a.y * b.y + a.z * b.z;
}

vec4 calc(){
    vec3 n = normalize(Normal);
    float diff = dot(n,light);
    vec3 amb = 0.3 * col;
    vec3 diffuse = diff * col;
    return vec4(amb + diffuse,1);
}

void main() {
    gl_FragColor = calc();
}