import Engine.*;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {
    private Window window =
            new Window
                    (800,800,"Gatau saya pusing");
    private ArrayList<Object2d> objects
            = new ArrayList<>();

    private ArrayList<Object2d> objectsrectangle
            = new ArrayList<>();

    private ArrayList<Object2d> objectsstar
            = new ArrayList<>();

    private  ArrayList<Object2d> objectscircle
            = new ArrayList<>();





    public void init(){
        window.init();
        GL.createCapabilities();


        //code
//        objects.add(new Object2d(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resource/shader/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resource/shader/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.4f,0.35f,0.0f),
//                                new Vector3f(-0.6f,-0.0f,0.0f),
//                                new Vector3f(-0.2f,-0.0f,0.0f)
//                        )
//                ),
//                new Vector4f(0.9f,1.0f,0.0f,0.0f)
//
//
//        ));


        //code with color
//        objects.add(new Object2d(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resource/shader/scenewithverticescolor.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resource/shader/scenewithverticescolor.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.0f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f)
//                        )
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(1.0f,0.0f,0.0f),
//                                new Vector3f(0.0f,1.0f,0.0f),
//                                new Vector3f(0.0f,0.0f,1.0f)
//                        )
//                )
//        ));

        //sky
        objectsrectangle.add(new Rectangle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(1.0f,1.0f,0.0f),
                                new Vector3f(-1.0f,1.0f,0.0f),
                                new Vector3f(1.0f,-1.0f,0.0f),
                                new Vector3f(-1.0f,-1.0f,0.0f)
                        )
                ),
                new Vector4f(0.0f,0.0f,1.0f,1.0f),
                Arrays.asList(0,1,2,1,3,0,2,3,0)
        ));

        //grass
        objectsrectangle.add(new Rectangle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(1.0f,-0.45f,0.0f),
                                new Vector3f(-1.0f,-0.45f,0.0f),
                                new Vector3f(1.0f,-1.0f,0.0f),
                                new Vector3f(-1.0f,-1.0f,0.0f)
                        )
                ),
                new Vector4f(0.0f,1.0f,0.0f,0.0f),
                Arrays.asList(0,1,2,1,3,0,2,3,0)
        ));

        //wall
        objectsrectangle.add(new Rectangle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.6f,-0.0f,0.0f),
                                new Vector3f(-0.6f,-0.0f,0.0f),
                                new Vector3f(0.6f,-0.5f,0.0f),
                                new Vector3f(-0.6f,-0.5f,0.0f)
                        )
                ),
                new Vector4f(0.9f,1.0f,0.0f,0.0f),
                Arrays.asList(0,1,2,1,3,0,2,3,0)
        ));

        //roof
        objectsrectangle.add(new Rectangle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.45f,0.4f,0.0f),
                                new Vector3f(-0.45f,0.4f,0.0f),
                                new Vector3f(0.7f,-0.0f,0.0f),
                                new Vector3f(-0.7f,-0.0f,0.0f)
                        )
                ),
                new Vector4f(0.9f,0.0f,0.0f,0.0f),
                Arrays.asList(0,1,2,1,3,0,2,3,0)
        ));

        //segitiga
        objectsrectangle.add(new Rectangle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.4f,0.35f,0.0f),
                                new Vector3f(-0.6f,-0.0f,0.0f),
                                new Vector3f(-0.2f,-0.0f,0.0f),
                                new Vector3f(-0.2f,-0.0f,0.0f)
                        )
                ),
                new Vector4f(0.9f,1.0f,0.0f,0.0f),
                Arrays.asList(0,1,2,1,3,0,2,3,0)
        ));


        //chimney
        objectsrectangle.add(new Rectangle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.3f,0.49f,0.0f),
                                new Vector3f(0.2f,0.49f,0.0f),
                                new Vector3f(0.3f,0.3f,0.0f),
                                new Vector3f(0.2f,0.3f,0.0f)
                        )
                ),
                new Vector4f(0.9f,1.0f,0.0f,0.0f),
                Arrays.asList(0,1,2,1,3,0,2,3,0)
        ));

        //chimneyred
        objectsrectangle.add(new Rectangle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.33f,0.54f,0.0f),
                                new Vector3f(0.17f,0.54f,0.0f),
                                new Vector3f(0.33f,0.49f,0.0f),
                                new Vector3f(0.17f,0.49f,0.0f)
                        )
                ),
                new Vector4f(1.0f,0.0f,0.0f,0.0f),
                Arrays.asList(0,1,2,1,3,0,2,3,0)
        ));

        objectsstar.add(new line( //star 1
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.85f,0.85f,0.0f),
                                new Vector3f(0.8f,0.8f,0.0f),
                                new Vector3f(0.9f,0.8f,0.0f),
                                new Vector3f(0.825f,0.75f,0.0f),
                                new Vector3f(0.875f,0.75f,0.0f)
                        )
                ),
                new Vector4f(0.5f,0.0f,0.5f,0.0f),
                Arrays.asList(3,0,4,1,2)
        ));

        objectsstar.add(new line( //star 2
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.0f,0.8f,0.0f),
                                new Vector3f(-0.05f,0.75f,0.0f),
                                new Vector3f(0.05f,0.75f,0.0f),
                                new Vector3f(-0.025f,0.7f,0.0f),
                                new Vector3f(0.025f,0.7f,0.0f)
                        )
                ),
                new Vector4f(0.5f,0.0f,0.5f,0.0f),
                Arrays.asList(3,0,4,1,2)
        ));

        objectsstar.add(new line( //star3
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.6f,0.65f,0.0f),
                                new Vector3f(-0.65f,0.6f,0.0f),
                                new Vector3f(-0.55f,0.6f,0.0f),
                                new Vector3f(-0.625f,0.55f,0.0f),
                                new Vector3f(-0.575f,0.55f,0.0f)
                        )
                ),
                new Vector4f(0.5f,0.0f,0.5f,0.0f),
                Arrays.asList(3,0,4,1,2)
        ));

        // asap
        objectscircle.add(new circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resource/shader/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resource/shader/scene.frag", GL_FRAGMENT_SHADER)
                ),
                // what you put here doesn't matter leave it empty if u want
                new ArrayList<>(
                        List.of(
                        )
                ),
                // this is color
                new Vector4f(0.0f, 0.6f, 0.7f, 0.0f),
                // this is radius
                0.1f,
                // this is the circle's center
                new Vector3f(0.3f,0.62f,0.0f)
        ));
        objectscircle.add(new circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resource/shader/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resource/shader/scene.frag", GL_FRAGMENT_SHADER)
                ),
                // what you put here doesn't matter leave it empty if u want
                new ArrayList<>(
                        List.of(
                        )
                ),
                // this is color
                new Vector4f(0.0f, 0.6f, 0.7f, 0.0f),
                // this is radius
                0.1f,
                // this is the circle's center
                new Vector3f(0.4f,0.64f,0.0f)
        ));

        objectscircle.add(new circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resource/shader/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resource/shader/scene.frag", GL_FRAGMENT_SHADER)
                ),
                // what you put here doesn't matter leave it empty if u want
                new ArrayList<>(
                        List.of(
                        )
                ),
                // this is color
                new Vector4f(0.0f, 0.6f, 0.7f, 0.0f),
                // this is radius
                0.1f,
                // this is the circle's center
                new Vector3f(0.35f,0.74f,0.0f)
        ));

        objectscircle.add(new circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resource/shader/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resource/shader/scene.frag", GL_FRAGMENT_SHADER)
                ),
                // what you put here doesn't matter leave it empty if u want
                new ArrayList<>(
                        List.of(
                        )
                ),
                // this is color
                new Vector4f(0.0f, 0.6f, 0.7f, 0.0f),
                // this is radius
                0.1f,
                // this is the circle's center
                new Vector3f(0.45f,0.76f,0.0f)
        ));


        //moon

        objectscircle.add(new circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resource/shader/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resource/shader/scene.frag", GL_FRAGMENT_SHADER)
                ),
                // what you put here doesn't matter leave it empty if u want
                new ArrayList<>(
                        List.of(
                        )
                ),
                // this is color
                new Vector4f(0.8f, 0.8f, 0.0f, 0.0f),
                // this is radius
                0.15f,
                // this is the circle's center
                new Vector3f(-0.8f,0.8f,0.0f)
        ));

        objectscircle.add(new circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resource/shader/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resource/shader/scene.frag", GL_FRAGMENT_SHADER)
                ),
                // what you put here doesn't matter leave it empty if u want
                new ArrayList<>(
                        List.of(
                        )
                ),
                // this is color
                new Vector4f(0.0f, 0.0f, 1.0f, 1.0f),
                // this is radius
                0.15f,
                // this is the circle's center
                new Vector3f(-0.75f,0.83f,0.0f)
        ));


    }
    public void loop(){
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f,
                    0.0f, 0.0f,
                    0.0f);
            GL.createCapabilities();

            //code no color


            for(Object2d object: objectsrectangle){
                object.draw();
            }



            for(Object2d object: objects){
                object.draw();
            }

            for(Object2d object: objectsstar){
                object.draw();
            }

            for(Object2d object: objectscircle){
                object.draw();
            }


//            for(Object2d object: objects){
//                object.drawwithverticescolor();
//            }

            glDisableVertexAttribArray(0);
            glfwPollEvents();
        }
    }
    public void run() {

        init();
        loop();


        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
    public static void main(String[] args) {
        new Main().run();
    }
}