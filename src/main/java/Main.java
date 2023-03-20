import Engine.*;
import org.joml.Vector2f;
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
    private ArrayList<Object3d> objects
            = new ArrayList<>();

    private ArrayList<Object3d> objectsrectangle
            = new ArrayList<>();

    private ArrayList<Object3d> objectsstar
            = new ArrayList<>();

    private  ArrayList<Object3d> objectscircle
            = new ArrayList<>();

    private  ArrayList<Object3d> objectscontrol
            = new ArrayList<>();

    ArrayList<Object3d> objectsMovable
            = new ArrayList<>();

    private ArrayList<Object3d> objectscurve
            = new ArrayList<>();

    private ArrayList<Object3d> objectsphere
            = new ArrayList<>();

    List<Vector3f> offsets = new ArrayList<>();


    boolean inMovingState = false;
    int currentRectangle = 0;




    public void init() {
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

        //rectangle with polygon
//                objects.add(new Object3d(
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

//__________________________________________________________________________________________________________________________________________
//__________________________________________________________________________________________________________________________________________
//__________________________________________________________________________________________________________________________________________

        // Gambar rumah
        //sky
//        objectsrectangle.add(new Rectangle(
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
//                                new Vector3f(1.0f,1.0f,0.0f),
//                                new Vector3f(-1.0f,1.0f,0.0f),
//                                new Vector3f(1.0f,-1.0f,0.0f),
//                                new Vector3f(-1.0f,-1.0f,0.0f)
//                        )
//                ),
//                new Vector4f(0.0f,0.0f,1.0f,1.0f),
//                Arrays.asList(0,1,2,1,3,0,2,3,0)
//        ));
//
//        //grass
//        objectsrectangle.add(new Rectangle(
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
//                                new Vector3f(1.0f,-0.45f,0.0f),
//                                new Vector3f(-1.0f,-0.45f,0.0f),
//                                new Vector3f(1.0f,-1.0f,0.0f),
//                                new Vector3f(-1.0f,-1.0f,0.0f)
//                        )
//                ),
//                new Vector4f(0.0f,1.0f,0.0f,0.0f),
//                Arrays.asList(0,1,2,1,3,0,2,3,0)
//        ));
//
//        //wall
//        objectsrectangle.add(new Rectangle(
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
//                                new Vector3f(0.6f,-0.0f,0.0f),
//                                new Vector3f(-0.6f,-0.0f,0.0f),
//                                new Vector3f(0.6f,-0.5f,0.0f),
//                                new Vector3f(-0.6f,-0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.9f,1.0f,0.0f,0.0f),
//                Arrays.asList(0,1,2,1,3,0,2,3,0)
//        ));
//
//        //roof
//        objectsrectangle.add(new Rectangle(
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
//                                new Vector3f(0.45f,0.4f,0.0f),
//                                new Vector3f(-0.45f,0.4f,0.0f),
//                                new Vector3f(0.7f,-0.0f,0.0f),
//                                new Vector3f(-0.7f,-0.0f,0.0f)
//                        )
//                ),
//                new Vector4f(0.9f,0.0f,0.0f,0.0f),
//                Arrays.asList(0,1,2,1,3,0,2,3,0)
//        ));
//
//        //segitiga
//        objectsrectangle.add(new Rectangle(
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
//                                new Vector3f(-0.2f,-0.0f,0.0f),
//                                new Vector3f(-0.2f,-0.0f,0.0f)
//                        )
//                ),
//                new Vector4f(0.9f,1.0f,0.0f,0.0f),
//                Arrays.asList(0,1,2,1,3,0,2,3,0)
//        ));
//
//
//        //chimney
//        objectsrectangle.add(new Rectangle(
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
//                                new Vector3f(0.3f,0.49f,0.0f),
//                                new Vector3f(0.2f,0.49f,0.0f),
//                                new Vector3f(0.3f,0.3f,0.0f),
//                                new Vector3f(0.2f,0.3f,0.0f)
//                        )
//                ),
//                new Vector4f(0.9f,1.0f,0.0f,0.0f),
//                Arrays.asList(0,1,2,1,3,0,2,3,0)
//        ));
//
//        //chimneyred
//        objectsrectangle.add(new Rectangle(
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
//                                new Vector3f(0.33f,0.54f,0.0f),
//                                new Vector3f(0.17f,0.54f,0.0f),
//                                new Vector3f(0.33f,0.49f,0.0f),
//                                new Vector3f(0.17f,0.49f,0.0f)
//                        )
//                ),
//                new Vector4f(1.0f,0.0f,0.0f,0.0f),
//                Arrays.asList(0,1,2,1,3,0,2,3,0)
//        ));
//
//        objectsstar.add(new line( //star 1
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
//                                new Vector3f(0.85f,0.85f,0.0f),
//                                new Vector3f(0.8f,0.8f,0.0f),
//                                new Vector3f(0.9f,0.8f,0.0f),
//                                new Vector3f(0.825f,0.75f,0.0f),
//                                new Vector3f(0.875f,0.75f,0.0f)
//                        )
//                ),
//                new Vector4f(0.5f,0.0f,0.5f,0.0f),
//                Arrays.asList(3,0,4,1,2)
//        ));
//
//        objectsstar.add(new line( //star 2
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
//                                new Vector3f(0.0f,0.8f,0.0f),
//                                new Vector3f(-0.05f,0.75f,0.0f),
//                                new Vector3f(0.05f,0.75f,0.0f),
//                                new Vector3f(-0.025f,0.7f,0.0f),
//                                new Vector3f(0.025f,0.7f,0.0f)
//                        )
//                ),
//                new Vector4f(0.5f,0.0f,0.5f,0.0f),
//                Arrays.asList(3,0,4,1,2)
//        ));
//
//        objectsstar.add(new line( //star3
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
//                                new Vector3f(-0.6f,0.65f,0.0f),
//                                new Vector3f(-0.65f,0.6f,0.0f),
//                                new Vector3f(-0.55f,0.6f,0.0f),
//                                new Vector3f(-0.625f,0.55f,0.0f),
//                                new Vector3f(-0.575f,0.55f,0.0f)
//                        )
//                ),
//                new Vector4f(0.5f,0.0f,0.5f,0.0f),
//                Arrays.asList(3,0,4,1,2)
//        ));
//
//        // asap
//        objectscircle.add(new circle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resource/shader/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resource/shader/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                // what you put here doesn't matter leave it empty if u want
//                new ArrayList<>(
//                        List.of(
//                        )
//                ),
//                // this is color
//                new Vector4f(0.0f, 0.6f, 0.7f, 0.0f),
//                // this is radius
//                0.1f,
//                // this is the circle's center
//                new Vector3f(0.3f,0.62f,0.0f)
//        ));
//        objectscircle.add(new circle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resource/shader/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resource/shader/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                // what you put here doesn't matter leave it empty if u want
//                new ArrayList<>(
//                        List.of(
//                        )
//                ),
//                // this is color
//                new Vector4f(0.0f, 0.6f, 0.7f, 0.0f),
//                // this is radius
//                0.1f,
//                // this is the circle's center
//                new Vector3f(0.4f,0.64f,0.0f)
//        ));
//
//        objectscircle.add(new circle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resource/shader/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resource/shader/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                // what you put here doesn't matter leave it empty if u want
//                new ArrayList<>(
//                        List.of(
//                        )
//                ),
//                // this is color
//                new Vector4f(0.0f, 0.6f, 0.7f, 0.0f),
//                // this is radius
//                0.1f,
//                // this is the circle's center
//                new Vector3f(0.35f,0.74f,0.0f)
//        ));
//
//        objectscircle.add(new circle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resource/shader/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resource/shader/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                // what you put here doesn't matter leave it empty if u want
//                new ArrayList<>(
//                        List.of(
//                        )
//                ),
//                // this is color
//                new Vector4f(0.0f, 0.6f, 0.7f, 0.0f),
//                // this is radius
//                0.1f,
//                // this is the circle's center
//                new Vector3f(0.45f,0.76f,0.0f)
//        ));
//
//
//        //moon
//
//        objectscircle.add(new circle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resource/shader/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resource/shader/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                // what you put here doesn't matter leave it empty if u want
//                new ArrayList<>(
//                        List.of(
//                        )
//                ),
//                // this is color
//                new Vector4f(0.8f, 0.8f, 0.0f, 0.0f),
//                // this is radius
//                0.15f,
//                // this is the circle's center
//                new Vector3f(-0.8f,0.8f,0.0f)
//        ));
//
//        objectscircle.add(new circle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resource/shader/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resource/shader/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                // what you put here doesn't matter leave it empty if u want
//                new ArrayList<>(
//                        List.of(
//                        )
//                ),
//                // this is color
//                new Vector4f(0.0f, 0.0f, 1.0f, 1.0f),
//                // this is radius
//                0.15f,
//                // this is the circle's center
//                new Vector3f(-0.75f,0.83f,0.0f)
//        ));


//__________________________________________________________________________________________________________________________________________
//__________________________________________________________________________________________________________________________________________
//__________________________________________________________________________________________________________________________________________

        //curve and moveable point


//        objectscontrol.add(new Object2d(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resource/shader/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resource/shader/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.9f,1.0f,0.0f,0.0f)
//
//
//        ));

//        objectscurve.add(new Curve(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resource/shader/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resource/shader/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f,1.0f,0.0f,1.0f)
//        ));


//        objectsphere.add(new sphere(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resource/shader/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resource/shader/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f, 1.0f, 0.0f, 1.0f),
//                0.2f,
//                0.2f,
//                new Vector3f(0.0f, 0.0f, 0.0f),
//                0.2f,
//                36,
//                18
//
//
//        ));
//        objectsphere.get(0).scaleObject(1.0f, 1.0f, 0.0f);
//        objectsphere.get(0).translateObject(0.5f, 0.0f, 0.0f);



        //---------------------------------------------------------------------------------------------------------------------------------

        //planet

        //matahari
        objectsphere.add(new sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,1.0f,0.0f,1.0f),
                0.1f,
                0.1f,
                new Vector3f(0.0f,0.0f,0.0f),
                0.2f,
                36,
                18


        ));

        objectsphere.get(0).scaleObject(0.4f,0.4f,0.4f);
        objectsphere.get(0).translateObject(0.0f,0.0f,0.0f);
        offsets.add(new Vector3f(0.0f,0.0f,0.0f));


        //merkurius
        objectsphere.add(new sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,1.0f,0.0f,1.0f),
                0.0f,
                0.2f,
                new Vector3f(0.0f,0.0f,0.0f),
                0.2f,
                36,
                18


        ));
//        objectsphere.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
        objectsphere.get(1).scaleObject(0.06f,0.06f,0.06f);
        objectsphere.get(1).translateObject(0.3f,0.0f,0.0f);
        offsets.add(new Vector3f(0.3f,0.0f,0.0f));


         //venus
        objectsphere.add(new sphere(
            Arrays.asList(
            //shaderFile lokasi menyesuaikan objectnya
            new ShaderProgram.ShaderModuleData
            ("resource/shader/scene.vert"
            , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.frag"
                                , GL_FRAGMENT_SHADER)
            ),
            new ArrayList<>(),
            new Vector4f(0.0f,1.0f,0.0f,1.0f),
                0.0f,
                        0.2f,
                        new Vector3f(0.0f,0.0f,0.0f),
                0.2f,
                        36,
                        18


                        ));
//        objectsphere.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
        objectsphere.get(2).scaleObject(0.1f,0.1f,0.1f);
        objectsphere.get(2).translateObject(0.46f,0.0f,0.0f);
        offsets.add(new Vector3f(0.46f,0.0f,0.0f));


        //Bumi
        objectsphere.add(new sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,1.0f,0.0f,1.0f),
                0.0f,
                0.2f,
                new Vector3f(0.0f,0.0f,0.0f),
                0.2f,
                36,
                18


        ));
//        objectsphere.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
        objectsphere.get(3).scaleObject(0.15f,0.15f,0.15f);
        objectsphere.get(3).translateObject(0.65f,0.0f,0.0f);
        offsets.add(new Vector3f(0.65f,0.0f,0.0f));


        //Mars
        objectsphere.add(new sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,1.0f,0.0f,1.0f),
                0.0f,
                0.2f,
                new Vector3f(0.0f,0.0f,0.0f),
                0.2f,
                36,
                18


        ));
//        objectsphere.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
        objectsphere.get(4).scaleObject(0.1f,0.1f,0.1f);
        objectsphere.get(4).translateObject(0.85f,0.0f,0.0f);
        offsets.add(new Vector3f(0.85f,0.0f,0.0f));

//
        //bulan
        objectsphere.add(new sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resource/shader/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,1.0f,0.0f,1.0f),
                0.0f,
                0.2f,
                new Vector3f(0.0f,0.0f,0.0f),
                0.2f,
                36,
                18


        ));
//        objectsphere.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
        objectsphere.get(5).scaleObject(0.025f,0.025f,0.025f);
        objectsphere.get(5).translateObject(0.69f,0.12f,0.0f);
        offsets.add(new Vector3f(0.69f,0.12f,0.0f));


   }





    public void input(){
        // if the user release the left mouse button it will stop the moving state
        if (window.getMouseinput().isLeftButtonReleased()){
            inMovingState = false;
        }
        if(window.isKeyPressed(GLFW_KEY_W)){
            //System.out.println("w");
           // objectsphere.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,1.0f,0.0f);
        }

        if(window.isKeyPressed(GLFW_KEY_F)){
            //System.out.println("w");
            objectsphere.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
            objectsphere.get(1).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
            objectsphere.get(2).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
            objectsphere.get(3).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
            objectsphere.get(4).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
            objectsphere.get(5).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);


        }

        if(window.isKeyPressed(GLFW_KEY_G)){
            //System.out.println("w");

            objectsphere.get(0).translateObject(-offsets.get(0).x,-offsets.get(0).y,-offsets.get(0).z);
            objectsphere.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,1.0f,0.0f);
            objectsphere.get(0).translateObject(offsets.get(0).x,offsets.get(0).y,offsets.get(0).z);

            objectsphere.get(1).translateObject(-offsets.get(1).x,-offsets.get(1).y,-offsets.get(1).z);
            objectsphere.get(1).rotateObject((float) Math.toRadians(0.5f),0.0f,1.0f,0.0f);
            objectsphere.get(1).translateObject(offsets.get(1).x,offsets.get(1).y,offsets.get(1).z);

            objectsphere.get(2).translateObject(-offsets.get(2).x,-offsets.get(2).y,-offsets.get(2).z);
            objectsphere.get(2).rotateObject((float) Math.toRadians(0.5f),0.0f,1.0f,0.0f);
            objectsphere.get(2).translateObject(offsets.get(2).x,offsets.get(2).y,offsets.get(2).z);

            objectsphere.get(3).translateObject(-offsets.get(3).x,-offsets.get(3).y,-offsets.get(3).z);
            objectsphere.get(3).rotateObject((float) Math.toRadians(0.5f),0.0f,1.0f,0.0f);
            objectsphere.get(3).translateObject(offsets.get(3).x,offsets.get(3).y,offsets.get(3).z);


            objectsphere.get(4).translateObject(-offsets.get(4).x,-offsets.get(4).y,-offsets.get(4).z);
            objectsphere.get(4).rotateObject((float) Math.toRadians(0.5f),0.0f,1.0f,0.0f);
            objectsphere.get(4).translateObject(offsets.get(4).x,offsets.get(4).y,offsets.get(4).z);


            objectsphere.get(5).translateObject(-offsets.get(5).x,-offsets.get(5).y,-offsets.get(5).z);
            objectsphere.get(5).rotateObject((float) Math.toRadians(0.5f),0.0f,1.0f,0.0f);
            objectsphere.get(5).translateObject(offsets.get(5).x,offsets.get(5).y,offsets.get(5).z);
        }

        if(window.getMouseinput().isLeftButtonPressed()){
            Vector2f pos = window.getMouseinput().getCurrentPos();

            pos.x = (pos.x - (window.getWidth())/2.0f) / (window.getWidth()/2.0f);

            pos.y = (pos.y - (window.getHeight())/2.0f) / ( - window.getHeight()/2.0f);

            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 1 || pos.y < -0.97))){
//                System.out.println("x : "+pos.x+" y : "+pos.y);
//                objectscontrol.get(0).addvertices(new Vector3f(pos.x,pos.y,0));

                // check if you clicked the rectangle
                boolean inRectangle = false;

                // check if you tried to place another rectangle to close
                boolean inRadius = false;

                // index of the clicked rectangle
                int rectangleToMove = 0;

                for (Object3d object : objectsMovable){
                    if (object.withinRadius(pos) == true){
                        inRadius = true;
                    }
                    if (object.withinRectangle(pos) == true){
                        inRectangle = true;
                        break;
                    }
                    rectangleToMove += 1;
                }

                // when the user clicks a rectangle it enters a moving state to move the rectangle
                if (inRectangle == true){
                    inMovingState = true;
                    currentRectangle = rectangleToMove;
                }

                // move the rectangle and line during moving state
                if (inMovingState == true){
                    Vector3f position = new Vector3f(pos, 0.0f);
                    objectsMovable.get(currentRectangle).move(position);
//                    objectsControl.get(0).changeVerticePos(currentRectangle, position);
                    objectscurve.get(0).changeVerticePos(currentRectangle, position);
                }

                // only enable clicking when the point is not in a rectangle and not in a moving state
                if (inRectangle == false && inRadius == false && inMovingState == false) {
                    System.out.println("x : " + pos.x + " y : " + pos.y);
//                    objectsControl.get(0).addVertices(new Vector3f(pos, 0.0f));
                    objectscurve.get(0).addVertices(new Vector3f(pos, 0.0f));
                    objectsMovable.add(new MovableRectangle(
                            Arrays.asList(
                                    new ShaderProgram.ShaderModuleData("resource/shader/scene.vert", GL_VERTEX_SHADER),
                                    new ShaderProgram.ShaderModuleData("resource/shader/scene.frag", GL_FRAGMENT_SHADER)
                            ),
                            // what you put here doesn't matter leave it empty if u want
                            new ArrayList<>(),
                            // this is color
                            new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
                            // this is radius
                            0.04f,
                            // this is the circle's center
                            new Vector3f(pos, 0.0f)
                    ));
                }

            }
        }
    }
    public void loop(){
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f,
                    0.0f, 0.0f,
                    0.0f);
            GL.createCapabilities();
            input();
            //code no color

            for(Object3d object: objectsphere){
                object.draw();
            }



            //code color

//            for(Object2d object: objects){
//                object.drawwithverticescolor();
//            }

            //house

//            for(Object2d object: objectsrectangle){
//                object.draw();
//            }
//
//
//
//            for(Object2d object: objects){
//                object.draw();
//            }
//
//            for(Object2d object: objectsstar){
//                object.draw();
//            }
//
//            for(Object2d object: objectscircle){
//                object.draw();
//            }


            //controled point


//            for(Object2d object: objectscontrol){
//                object.drawline();
//            }

//            for (Object3d object : objectscurve) {
//                object.drawline();
//            }
//
//            for (Object3d object : objectsMovable) {
//                object.draw();
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