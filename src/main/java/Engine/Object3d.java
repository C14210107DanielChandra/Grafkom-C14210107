package Engine;

import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;
public class Object3d extends ShaderProgram{
    List<Vector3f> vertices; //untuk generate titik
    int vao;
    int vbo;

    Vector4f color;

    UniformsMap uniformsMap;

    List<Vector3f> verticesColor;
    int vboColor;

    public Object3d(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
        this.color = color;
        this.uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");

    }

    //with color
    public Object3d(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesColor = verticesColor;
        setupVAOVBOwithcolor();
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

    public void setupVAOVBOwithcolor() {
        //untuk setup VAO
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //untuk setup VBO
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);
        //List to float untuk ngubah dari list ke float

        vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(verticesColor), GL_STATIC_DRAW);
    }

    public void drawSetup() {
        bind();
        uniformsMap.setUniform("uni_color",color);

        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
    }

    public void drawSetupwithverticescolor() {
        bind();

        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);

        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glVertexAttribPointer(1, 3, GL_FLOAT, false, 0, 0);
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

        glDrawArrays(GL_TRIANGLE_FAN, 0, vertices.size());
//        glDrawArrays(GL_LINE, 0, 2);

    }

    public void drawwithverticescolor() {
        drawSetupwithverticescolor();
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

        glDrawArrays(GL_TRIANGLES, 0, vertices.size());
//        glDrawArrays(GL_LINE, 0, 2);

    }

    public void drawline() {
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

        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
//        glDrawArrays(GL_LINE, 0, 2);

    }

    public void addVertices(Vector3f newVector){
        vertices.add(newVector);
        setupVAOVBO();

    }

    public void changeVerticePos(int index, Vector3f newPos){
        vertices.set(index, newPos);
        setupVAOVBO();
    }

    // check if the clicked point is within the rectangle
    public boolean withinRectangle(Vector2f point){return false;}

    // used to prevent making an overlapping rectangle
    public boolean withinRadius(Vector2f point){return false;}

    public void move(Vector3f center){}





}
