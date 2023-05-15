package Engine;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
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

    Matrix4f model;

    List<Object3d> childObject;

    public List<Object3d> getChildObject() {
        return childObject;
    }

    public void setChildObject(List<Object3d> childObject) {
        this.childObject = childObject;
    }

    // these bools are used to exclude certain child from rotate, scale, translate for anim purposes
    Boolean excludeRotate = false;
    Boolean excludeScale = false;
    Boolean excludeTranslate = false;




    public Object3d(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color,List<Object3d>childObject) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
        this.color = color;
        this.childObject = childObject;
        this.uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        uniformsMap.createUniform("model");
        model = new Matrix4f();


    }

    public Object3d(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
        this.color = color;
        this.childObject = new ArrayList<Object3d>();
        this.uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        uniformsMap.createUniform("model");
        uniformsMap.createUniform("view");
        uniformsMap.createUniform("projection");
        model = new Matrix4f();


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

    public void drawSetup(Camera camera, Projection projection) {
        bind();
        uniformsMap.setUniform("uni_color",color);
        uniformsMap.setUniform("model",model);
        uniformsMap.setUniform("view",camera.getViewMatrix());
        uniformsMap.setUniform("projection",projection.getProjMatrix());

        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
    }

    public void drawSetup() {
        bind();
        uniformsMap.setUniform("uni_color",color);
        uniformsMap.setUniform("model",model);

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
    public void draw(Camera camera, Projection projection) {
        drawSetup(camera,projection);
        //Menggambar vertices
        glLineWidth(1); //ketebalan garis
        glPointSize(1); //besar/kecilnya vertex

        /*
        GL_LINE
        GL_LINE_STRIP
        GL_LINE_LOOP
        GL_TRIANGLES
        GL_TRIANGLE_FAN
        GL_POINT
         */

        glDrawArrays(GL_POLYGON, 0, vertices.size());
        for (Object3d child:childObject){
            child.draw(camera,projection);
        }
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

    public void drawLine(Camera camera, Projection projection) {
        drawSetup(camera, projection);
        // Draw the vertices
        glLineWidth(4.5f);
        glPointSize(10);
        // GL_TRIANGLES
        // GL_LINE_LOOP
        // GL_LINE_STRIP
        // GL_LINES
        // GL_POINTS
        // GL_TRIANGLE_FAN
        // GL_POLYGON
        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
        for (Object3d child:childObject){
            child.drawLine(camera, projection);
        }
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

    public void translateObject(float offsetX,float offsetY,float offsetZ ){
        model = new Matrix4f().translate(offsetX,offsetY,offsetZ).mul(new Matrix4f(model));

        for(Object3d child:childObject){
            child.translateObject(offsetX,offsetY,offsetZ);
        }
    }

    public void rotateObject(float degree,float offsetX,float offsetY,float offsetZ){
        model = new Matrix4f().rotate(degree,offsetX,offsetY,offsetZ).mul(new Matrix4f(model));

        for(Object3d child:childObject){
            child.rotateObject(degree,offsetX,offsetY,offsetZ);
        }

    }

    public void scaleObject(float offsetX,float offsetY,float offsetZ ){
        model = new Matrix4f().scale(offsetX,offsetY,offsetZ).mul(new Matrix4f(model));

        for(Object3d child:childObject){
            child.scaleObject(offsetX,offsetY,offsetZ);
        }
    }

    public Vector3f updateCenterPoint(){
        Vector3f centerTemp = new Vector3f();
        model.transformPosition(0.0f,0.0f,0.0f,centerTemp);
        return centerTemp;
    }

    public Boolean getExcludeRotate() {
        return excludeRotate;
    }

    public void setExcludeRotate(Boolean excludeRotate) {
        this.excludeRotate = excludeRotate;
    }

    public Boolean getExcludeScale() {
        return excludeScale;
    }

    public void setExcludeScale(Boolean excludeScale) {
        this.excludeScale = excludeScale;
    }

    public Boolean getExcludeTranslate() {
        return excludeTranslate;
    }

    public void setExcludeTranslate(Boolean excludeTranslate) {
        this.excludeTranslate = excludeTranslate;
    }







}
