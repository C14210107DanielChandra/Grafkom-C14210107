package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;
public class Object2d extends ShaderProgram{
    List<Vector3f> vertices; //untuk generate titik
    int vao;
    int vbo;

    public Object2d(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
    }

    public void setupVAOVBO() {
        //untuk setup VAO
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //untuk setup VBO
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);
        //List to float untuk ngubah dari list ke float
    }
    public void drawSetup() {
        bind();

        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
    }
    public void draw() {
        drawSetup();
        //Menggambar vertices
        glLineWidth(10); //ketebalan garis
        glPointSize(0); //besar/kecilnya vertex

        /*
        GL_LINE
        GL_LINE_STRIP
        GL_LINE_LOOP
        GL_TRIANGLES
        GL_TRIANGLE_FAN
        GL_POINT
         */

        glDrawArrays(GL_LINE_LOOP, 0, vertices.size());
//        glDrawArrays(GL_LINE, 0, 2);

    }



}
