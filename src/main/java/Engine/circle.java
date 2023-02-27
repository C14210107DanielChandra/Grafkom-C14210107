package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.*;

import static org.lwjgl.opengl.GL11.GL_LINE_LOOP;
import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL11.glLineWidth;
import static org.lwjgl.opengl.GL11.glPointSize;
import static org.lwjgl.opengl.GL11C.*;
import static org.lwjgl.opengl.GL15C.GL_ELEMENT_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15C.glBindBuffer;

public class circle extends Object2d {

    float radius;
    float x;
    float y;

    List<Vector3f> circle;

    Vector3f center;

    // the vertices should be the circle's line
    public circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color,
                  float radius, Vector3f center) {
        super(shaderModuleDataList, vertices, color);
        // set the vertices to be the circle's line
        this.radius = radius;
        this.center = center;
        CreateCircle();
        this.vertices = circle;
        setupVAOVBO();
    }

    public void CreateCircle() {
        // initialize the circle
        circle = new ArrayList<>();
        circle.add(new Vector3f(center.x, center.y, center.z));

        // use these variables in the loop to make shapes according to the variable's name
        float circleLine = 0.01f;
        float triangleLine = 120f;
        float squareLine = 90f;

        // for a triangle like /_\ use i = 90; i <= 450;
        // for a square like |=| use i = 45; i <= 405;
        // for a normal circle use i = 0; i <= 360;

        for (float i = 0; i <= 360; i += circleLine) {
            double rad = Math.toRadians(i);
            // calculate a point in the circle's line
            x = (float) (radius * Math.cos(rad) + center.x);
            y = (float) (radius * Math.sin(rad) + center.y);

            circle.add(new Vector3f(x, y, 0.0f));
        }

//        for (float i = 45; i <= 405; i += squareLine) {
//            double rad = Math.toRadians(i);
//            // calculate a point in the circle's line
//            x = (float) (radius * Math.cos(rad) + center.x);
//            y = (float) (radius * Math.sin(rad) + center.y);
//
//            circle.add(new Vector3f(x, y, 0.0f));
//        }

//        for (float i = 90; i <= 450; i += triangleLine) {
//            double rad = Math.toRadians(i);
//            // calculate a point in the circle's line
//            x = (float) (radius * Math.cos(rad) + center.x);
//            y = (float) (radius * Math.sin(rad) + center.y);
//
//            circle.add(new Vector3f(x, y, 0.0f));
//        }

    }

    public void draw() {
        drawSetup();
        glLineWidth(10);
        glPointSize(10);
        glDrawArrays(GL_TRIANGLE_FAN, 0, vertices.size());
    }
}