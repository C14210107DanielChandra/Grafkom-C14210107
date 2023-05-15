import Engine.*;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.joml.sampling.UniformSampling;
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

    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(),window.getHeight());

    // determines which foot moved first

    float limiter = 20;
    float counter = 0;

    float anchor = 1;


    public void init() {
        window.init();
        GL.createCapabilities();
        camera.setPosition(0,0,0.5f);
        camera.setRotation((float)Math.toRadians(0.0f), (float) Math.toRadians(0.0f));


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

        //matahari

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
//                new Vector4f(0.0f,1.0f,0.0f,1.0f),
//                0.1f,
//                0.1f,
//                new Vector3f(0.0f,0.0f,0.0f),
//                0.1f,
//                36,
//                18,
//                2
//
//
//        ));
//
//        objectsphere.get(0).scaleObject(0.2f,0.2f,0.2f);
//        objectsphere.get(0).translateObject(0.0f,0.0f,0.0f);
//        objectsphere.get(0).getChildObject().add(new sphere(
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
//                new Vector4f(0.0f,1.0f,0.0f,1.0f),
//                0.1f,
//                0.1f,
//                new Vector3f(0.0f,0.0f,0.0f),
//                0.1f,
//                36,
//                18,
//                2
//
//
//        ));
//
//        objectsphere.get(0).getChildObject().get(0).translateObject(0.25f,0.0f,0.0f);
//
//        objectsphere.get(0).getChildObject().add(new sphere(
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
//                new Vector4f(0.0f,1.0f,0.0f,1.0f),
//                0.1f,
//                0.1f,
//                new Vector3f(0.0f,0.0f,0.0f),
//                0.1f,
//                36,
//                18
//        ));
//
//        objectsphere.get(0).getChildObject().get(1).translateObject(0.5f,0.0f,0.0f);
//
//        objectsphere.get(0).getChildObject().get(1).getChildObject().add(new sphere(
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
//                new Vector4f(0.0f,1.0f,0.0f,1.0f),
//                0.1f,
//                0.1f,
//                new Vector3f(0.0f,0.0f,0.0f),
//                0.1f,
//                36,
//                18
//        ));
//
//        objectsphere.get(0).getChildObject().get(0).scaleObject(0.05f,0.05f,0.05f);
//        objectsphere.get(0).getChildObject().get(1).scaleObject(0.05f,0.05f,0.05f);
//        objectsphere.get(0).getChildObject().get(1).getChildObject().get(0).scaleObject(0.025f,0.025f,0.025f);
//        objectsphere.get(0).getChildObject().get(1).getChildObject().get(0).translateObject(0.025f,-0.01f,0.0f);





//        //merkurius
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
//                new Vector4f(0.0f,1.0f,0.0f,1.0f),
//                0.0f,
//                0.2f,
//                new Vector3f(0.0f,0.0f,0.0f),
//                0.2f,
//                36,
//                18
//
//
//        ));
////        objectsphere.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//        objectsphere.get(1).scaleObject(0.06f,0.06f,0.06f);
//        objectsphere.get(1).translateObject(0.3f,0.0f,0.0f);
//        offsets.add(new Vector3f(0.3f,0.0f,0.0f));
//
//
//         //venus
//        objectsphere.add(new sphere(
//            Arrays.asList(
//            //shaderFile lokasi menyesuaikan objectnya
//            new ShaderProgram.ShaderModuleData
//            ("resource/shader/scene.vert"
//            , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resource/shader/scene.frag"
//                                , GL_FRAGMENT_SHADER)
//            ),
//            new ArrayList<>(),
//            new Vector4f(0.0f,1.0f,0.0f,1.0f),
//                0.0f,
//                        0.2f,
//                        new Vector3f(0.0f,0.0f,0.0f),
//                0.2f,
//                        36,
//                        18
//
//
//                        ));
////        objectsphere.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//        objectsphere.get(2).scaleObject(0.1f,0.1f,0.1f);
//        objectsphere.get(2).translateObject(0.46f,0.0f,0.0f);
//        offsets.add(new Vector3f(0.46f,0.0f,0.0f));
//
//
//        //Bumi
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
//                new Vector4f(0.0f,1.0f,0.0f,1.0f),
//                0.0f,
//                0.2f,
//                new Vector3f(0.0f,0.0f,0.0f),
//                0.2f,
//                36,
//                18
//
//
//        ));
////        objectsphere.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//        objectsphere.get(3).scaleObject(0.15f,0.15f,0.15f);
//        objectsphere.get(3).translateObject(0.65f,0.0f,0.0f);
//        offsets.add(new Vector3f(0.65f,0.0f,0.0f));
//
//
//        //Mars
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
//                new Vector4f(0.0f,1.0f,0.0f,1.0f),
//                0.0f,
//                0.2f,
//                new Vector3f(0.0f,0.0f,0.0f),
//                0.2f,
//                36,
//                18
//
//
//        ));
////        objectsphere.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//        objectsphere.get(4).scaleObject(0.1f,0.1f,0.1f);
//        objectsphere.get(4).translateObject(0.85f,0.0f,0.0f);
//        offsets.add(new Vector3f(0.85f,0.0f,0.0f));
//
////
//        //bulan
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
//                new Vector4f(0.0f,1.0f,0.0f,1.0f),
//                0.0f,
//                0.2f,
//                new Vector3f(0.0f,0.0f,0.0f),
//                0.2f,
//                36,
//                18
//
//
//        ));
////        objectsphere.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//        objectsphere.get(5).scaleObject(0.025f,0.025f,0.025f);
//        objectsphere.get(5).translateObject(0.69f,0.12f,0.0f);
//        offsets.add(new Vector3f(0.69f,0.12f,0.0f));
//
//

        //project

        //--------------------------------------------------------------------------------------------------------------------------------------

        // badan / kepala
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
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                2.0f,
                1.0f,
                new Vector3f(0.0f,0.0f,0.0f),
                1.0f,
                180,
                90,
                2


        ));

        objectsphere.get(0).scaleObject(0.2f,0.2f,0.2f);
        objectsphere.get(0).translateObject(0.0f,0.0f,0.0f);

        //mata kanan
        objectsphere.get(0).getChildObject().add(new sphere(
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
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                0.1f,
                0.1f,
                new Vector3f(0.0f,0.0f,0.0f),
                0.1f,
                36,
                18,
                2


        ));

        //mata kiri
        objectsphere.get(0).getChildObject().add(new sphere(
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
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                0.1f,
                0.1f,
                new Vector3f(0.0f,0.0f,0.0f),
                0.1f,
                36,
                18,
                2


        ));

        //mulut
        objectsphere.get(0).getChildObject().add(new sphere(
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
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                0.1f,
                0.1f,
                new Vector3f(0.0f,0.0f,0.0f),
                0.1f,
                36,
                18,
                6


        ));

        //ujung lidah
        objectsphere.get(0).getChildObject().add(new sphere(
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
                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                0.1f,
                0.1f,
                new Vector3f(0.0f,0.0f,0.0f),
                0.1f,
                36,
                18,
                2


        ));

        //sirip kanan
        objectsphere.get(0).getChildObject().add(new sphere(
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
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                0.1f,
                0.1f,
                new Vector3f(0.0f,0.0f,0.0f),
                0.1f,
                36,
                18,
                6


        ));

        //sirip kiri
        objectsphere.get(0).getChildObject().add(new sphere(
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
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                0.1f,
                0.1f,
                new Vector3f(0.0f,0.0f,0.0f),
                0.1f,
                36,
                18,
                6


        ));




        //gigi taring kiri
        objectsphere.get(0).getChildObject().add(new sphere(
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
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                0.1f,
                0.1f,
                new Vector3f(0.0f,0.0f,0.0f),
                0.1f,
                36,
                18,
                6


        ));
        //gigi taring kanan
        objectsphere.get(0).getChildObject().add(new sphere(
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
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                0.1f,
                0.1f,
                new Vector3f(0.0f,0.0f,0.0f),
                0.1f,
                36,
                18,
                6


        ));
        //gigi kiri
        objectsphere.get(0).getChildObject().add(new sphere(
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
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                0.1f,
                0.1f,
                new Vector3f(0.0f,0.0f,0.0f),
                0.1f,
                36,
                18,
                6


        ));
        //gigi kanan
        objectsphere.get(0).getChildObject().add(new sphere(
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
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                0.1f,
                0.1f,
                new Vector3f(0.0f,0.0f,0.0f),
                0.1f,
                36,
                18,
                6


        ));

        //ekor
        objectsphere.get(0).getChildObject().add(new sphere(
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
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                0.1f,
                0.1f,
                new Vector3f(0.0f,0.0f,0.0f),
                0.1f,
                36,
                18,
                6


        ));

        //batang lidah

        objectsphere.get(0).getChildObject().add(new sphere(
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
                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                0.1f,
                0.1f,
                new Vector3f(0.0f,0.0f,0.0f),
                0.1f,
                36,
                18,
                8

        ));

        // alis kanan
        objectscurve.add(new Curve(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resource/shader/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resource/shader/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f)
        ));

        objectscurve.get(0).addVertices(new Vector3f(-0.02f, 0.0f, 0.0f));
        objectscurve.get(0).addVertices(new Vector3f(0.0f, -0.02f, 0.0f));
        objectscurve.get(0).addVertices(new Vector3f(0.02f, 0.0f, 0.0f));

        objectscurve.get(0).translateObject(-0.02f, -0.05f, 0.09f);

        // alis kiri
        objectscurve.add(new Curve(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resource/shader/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resource/shader/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f)
        ));

        objectscurve.get(1).addVertices(new Vector3f(-0.02f, 0.0f, 0.0f));
        objectscurve.get(1).addVertices(new Vector3f(0.0f, -0.02f, 0.0f));
        objectscurve.get(1).addVertices(new Vector3f(0.02f, 0.0f, 0.0f));

        objectscurve.get(1).translateObject(0.02f, -0.05f, 0.09f);







        objectsphere.get(0).getChildObject().get(0).translateObject(1.f,1.0f,3.5f);
        objectsphere.get(0).getChildObject().get(0).scaleObject(0.025f,0.025f,0.025f);

        objectsphere.get(0).getChildObject().get(1).translateObject(-1.f,1.0f,3.5f);
        objectsphere.get(0).getChildObject().get(1).scaleObject(0.025f,0.025f,0.025f);

        objectsphere.get(0).getChildObject().get(2).translateObject(0.f,-12.0f,2.75f);
        objectsphere.get(0).getChildObject().get(2).scaleObject(0.025f,0.005f,0.0245f);

        objectsphere.get(0).getChildObject().get(3).translateObject(0.f,-2.8f,3.8f);
        objectsphere.get(0).getChildObject().get(3).scaleObject(0.028f,0.020f,0.028f);

        objectsphere.get(0).getChildObject().get(4).translateObject(-0.0f,-17.0f,1.0f);
        objectsphere.get(0).getChildObject().get(4).scaleObject(0.03f,0.01f,0.02f);
        objectsphere.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(90), 0.0f, 0.0f, 1.0f);
        objectsphere.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(-10), 0.0f, 1.0f, 0.0f);
        objectsphere.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(90), 1.0f, 0.0f, 0.0f);

        objectsphere.get(0).getChildObject().get(5).translateObject(-0.0f,-17.0f,1.0f);
        objectsphere.get(0).getChildObject().get(5).scaleObject(0.03f,0.01f,0.02f);
        objectsphere.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(270), 0.0f, 0.0f, 1.0f);
        objectsphere.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(10), 0.0f, 1.0f, 0.0f);
        objectsphere.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(90), 1.0f, 0.0f, 0.0f);

        objectsphere.get(0).getChildObject().get(6).translateObject(-3.5f,-14.2f,19.4f);
        objectsphere.get(0).getChildObject().get(6).scaleObject(0.005f,0.0022f,0.005f);

        objectsphere.get(0).getChildObject().get(7).translateObject(3.5f,-14.2f,19.4f);
        objectsphere.get(0).getChildObject().get(7).scaleObject(0.005f,0.0022f,0.005f);

        objectsphere.get(0).getChildObject().get(8).translateObject(-1.1f,-16.4f,20.0f);
        objectsphere.get(0).getChildObject().get(8).scaleObject(0.005f,0.0015f,0.005f);

        objectsphere.get(0).getChildObject().get(9).translateObject(1.1f,-16.4f,20.0f);
        objectsphere.get(0).getChildObject().get(9).scaleObject(0.005f,0.0015f,0.005f);

        objectsphere.get(0).getChildObject().get(10).translateObject(-0.0f,-14.0f,0.6f);
        objectsphere.get(0).getChildObject().get(10).scaleObject(0.04f,0.012f,0.035f);
        objectsphere.get(0).getChildObject().get(10).rotateObject((float) Math.toRadians(75), 1.0f, 0.0f, 0.0f);

        objectsphere.get(0).getChildObject().get(11).translateObject(0.0f,0.8f,0.25f);
        objectsphere.get(0).getChildObject().get(11).scaleObject(0.2f,0.1f,0.1f);
        objectsphere.get(0).getChildObject().get(11).rotateObject((float) Math.toRadians(105), 1.0f, 0.0f, 0.0f);

        objectsphere.get(0).translateObject(0.0f,-0.1f,0.0f);

   }





    public void input(){
        float move = 0.01f;
        // if the user release the left mouse button it will stop the moving state
//        if (window.getMouseinput().isLeftButtonReleased()){
////            inMovingState = false;
//        }
        if(window.isKeyPressed(GLFW_KEY_W)){
            //System.out.println("w");
           // objectsphere.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,1.0f,0.0f);

            //project rotate
//            objectsphere.get(0).rotateObject((float)Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//            objectscurve.get(0).rotateObject((float)Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//            objectscurve.get(1).rotateObject((float)Math.toRadians(0.5f),0.0f,0.0f,1.0f);



         //   objectsphere.get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(0.5f),0.0f,0.0f,1.0f);

//            for (Object3d child: objectsphere.get(0).getChildObject()){
//                Vector3f tempCenterPoint = child.updateCenterPoint();
//
//                child.translateObject(tempCenterPoint.x*-1
//                        ,tempCenterPoint.y*-1
//                        ,tempCenterPoint.z*-1);
//
//                child.rotateObject((float)Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//
//                child.translateObject(tempCenterPoint.x*+1
//                        ,tempCenterPoint.y*+1
//                        ,tempCenterPoint.z*+1);
//            }
//            for (Object3d child: objectsphere.get(0).getChildObject().get(1).getChildObject()){
//                Vector3f tempCenterPoint = objectsphere.get(0).getChildObject().get(1).updateCenterPoint();
//
//                child.translateObject(tempCenterPoint.x*-1
//                        ,tempCenterPoint.y*-1
//                        ,tempCenterPoint.z*-1);
//
//                child.rotateObject((float)Math.toRadians(0.7f),0.0f,0.0f,1.0f);
//
//                child.translateObject(tempCenterPoint.x*+1
//                        ,tempCenterPoint.y*+1
//                        ,tempCenterPoint.z*+1);
//            }

            camera.moveForward(move);
        }
        if(window.isKeyPressed(GLFW_KEY_S)){


            camera.moveBackwards(move);
        }
        if(window.isKeyPressed(GLFW_KEY_A)){


            camera.moveLeft(move);
        }
        if(window.isKeyPressed(GLFW_KEY_D)){


            camera.moveRight(move);
        }
        if(window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)){


            camera.moveDown(move);
        }
        if(window.isKeyPressed(GLFW_KEY_SPACE)){

            camera.moveUp(move);
        }
        if(window.isKeyPressed(GLFW_KEY_E)){
            camera.addRotation(camera.getPosition().x  , camera.getPosition().y + 0.01f );
        }

        if (window.getMouseinput().isLeftButtonPressed()){
            Vector2f pos = window.getMouseinput().getCurrentPos();

            Vector2f displayVector = window.getMouseinput().getDisplVec();
            camera.addRotation( (float)Math.toRadians(displayVector.y) * -0.1f , (float) Math.toRadians(displayVector.x) * -0.1f);

        }

        if (window.getMouseinput().getScroll().y != 0){
            projection.setFOV(projection.getFOV() - (window.getMouseinput().getScroll().y * 0.1f));
            window.getMouseinput().setScroll(new Vector2f());
        }

        if(window.isKeyPressed(GLFW_KEY_F)){
            //System.out.println("w"); msih salah
            objectsphere.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,1.0f,0.0f);
            objectscurve.get(0).rotateObject((float)Math.toRadians(0.5f),0.0f,1.0f,0.0f);
            objectscurve.get(1).rotateObject((float)Math.toRadians(0.5f),0.0f,1.0f,0.0f);
          //  objectsphere.get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(0.5f),0.0f,1.0f,0.0f);
//            objectsphere.get(1).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//            objectsphere.get(2).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//            objectsphere.get(3).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//            objectsphere.get(4).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//            objectsphere.get(5).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);


        }

        if(window.isKeyPressed(GLFW_KEY_G)){

            if (counter == limiter){
               anchor = anchor * -1;
            }
            if (counter == 40){
                counter = 0;
            }
            objectsphere.get(0).getChildObject().get(4).rotateObject(anchor * (float) Math.toRadians(0.35f),0.0f,0.0f,1.0f);
            objectsphere.get(0).getChildObject().get(5).rotateObject(anchor * (float) Math.toRadians(0.35f),0.0f,0.0f,1.0f);
            objectsphere.get(0).rotateObject(anchor * (float) Math.toRadians(0.35f),0.0f,0.0f,1.0f);
            objectscurve.get(0).rotateObject(anchor * (float) Math.toRadians(0.35f),0.0f,0.0f,1.0f);
            objectscurve.get(1).rotateObject(anchor * (float) Math.toRadians(0.35f),0.0f,0.0f,1.0f);
            counter += 1 ;


        }

//        if(window.getMouseinput().isLeftButtonPressed()){
//            Vector2f pos = window.getMouseinput().getCurrentPos();
//
//            pos.x = (pos.x - (window.getWidth())/2.0f) / (window.getWidth()/2.0f);
//
//            pos.y = (pos.y - (window.getHeight())/2.0f) / ( - window.getHeight()/2.0f);
//
//            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 1 || pos.y < -0.97))){
////                System.out.println("x : "+pos.x+" y : "+pos.y);
////                objectscontrol.get(0).addvertices(new Vector3f(pos.x,pos.y,0));
//
//                // check if you clicked the rectangle
//                boolean inRectangle = false;
//
//                // check if you tried to place another rectangle to close
//                boolean inRadius = false;
//
//                // index of the clicked rectangle
//                int rectangleToMove = 0;
//
//                for (Object3d object : objectsMovable){
//                    if (object.withinRadius(pos) == true){
//                        inRadius = true;
//                    }
//                    if (object.withinRectangle(pos) == true){
//                        inRectangle = true;
//                        break;
//                    }
//                    rectangleToMove += 1;
//                }
//
//                // when the user clicks a rectangle it enters a moving state to move the rectangle
//                if (inRectangle == true){
//                    inMovingState = true;
//                    currentRectangle = rectangleToMove;
//                }
//
//                // move the rectangle and line during moving state
//                if (inMovingState == true){
//                    Vector3f position = new Vector3f(pos, 0.0f);
//                    objectsMovable.get(currentRectangle).move(position);
////                    objectsControl.get(0).changeVerticePos(currentRectangle, position);
//                    objectscurve.get(0).changeVerticePos(currentRectangle, position);
//                }
//
//                // only enable clicking when the point is not in a rectangle and not in a moving state
//                if (inRectangle == false && inRadius == false && inMovingState == false) {
//                    System.out.println("x : " + pos.x + " y : " + pos.y);
////                    objectsControl.get(0).addVertices(new Vector3f(pos, 0.0f));
//                    objectscurve.get(0).addVertices(new Vector3f(pos, 0.0f));
//                    objectsMovable.add(new MovableRectangle(
//                            Arrays.asList(
//                                    new ShaderProgram.ShaderModuleData("resource/shader/scene.vert", GL_VERTEX_SHADER),
//                                    new ShaderProgram.ShaderModuleData("resource/shader/scene.frag", GL_FRAGMENT_SHADER)
//                            ),
//                            // what you put here doesn't matter leave it empty if u want
//                            new ArrayList<>(),
//                            // this is color
//                            new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                            // this is radius
//                            0.04f,
//                            // this is the circle's center
//                            new Vector3f(pos, 0.0f)
//                    ));
//                }
//
//            }
        //}
    }

    private void AnimateStopAnytime(){
        // determine which foot to begin with


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
                object.draw(camera,projection);
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

            for (Object3d object : objectscurve) {
                object.drawLine(camera,projection);
            }
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