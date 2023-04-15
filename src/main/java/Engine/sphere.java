package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;



import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;



public class sphere extends circle{
    float radiusZ;
    int stackCount;
    int sectorCount;


    public sphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float radiusX,float radiusY, Vector3f center,float radiusZ
    ,int sectorCount,int stackCount) {
        super(shaderModuleDataList, vertices, color, radiusX,radiusY, center);
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        //createBox();
        //createSphere();
        //createellipsoid();
        // createhyperboloid1sheet();
        //createhyperboloid2sheet();
        createellipticcone();
       //createelipticparaboloid();
        //createhyperboloidparaboloid();
        setupVAOVBO();
    }

    public void createBox(){

        vertices.clear();
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();

        // top left back
        temp.x = center.get(0) - radiusX/2;
        temp.y = center.get(1) + radiusY/2;
        temp.z = center.get(2) - radiusZ/2;
        tempVertices.add(temp);
        System.out.println("1"+temp);
        temp =new Vector3f();



        //bot left back
        temp.x = center.get(0) - radiusX/2;
        temp.y = center.get(1) - radiusY/2;
        temp.z = center.get(2) - radiusZ/2;
        tempVertices.add(temp);
        System.out.println(temp);
        temp =new Vector3f();

        //top left front
        temp.x = center.get(0) - radiusX/2;
        temp.y = center.get(1) + radiusY/2;
        temp.z = center.get(2) + radiusZ/2;
        tempVertices.add(temp);
        System.out.println(temp);
        temp =new Vector3f();

        //bot left front
        temp.x = center.get(0) - radiusX/2;
        temp.y = center.get(1) - radiusY/2;
        temp.z = center.get(2) + radiusZ/2;
        tempVertices.add(temp);
        System.out.println(temp);
        temp =new Vector3f();

        //top right back
        temp.x = center.get(0) + radiusX/2;
        temp.y = center.get(1) + radiusY/2;
        temp.z = center.get(2) - radiusZ/2;
        tempVertices.add(temp);
        System.out.println(temp);
        temp =new Vector3f();

        //bot right back
        temp.x = center.get(0) + radiusX/2;
        temp.y = center.get(1) - radiusY/2;
        temp.z = center.get(2) - radiusZ/2;
        tempVertices.add(temp);
        System.out.println(temp);
        temp =new Vector3f();

        //top right front
        temp.x = center.get(0) + radiusX/2;
        temp.y = center.get(1) + radiusY/2;
        temp.z = center.get(2) + radiusZ/2;
        tempVertices.add(temp);
        System.out.println(temp);
        temp =new Vector3f();

        //bot right front
        temp.x = center.get(0) + radiusX/2;
        temp.y = center.get(1) - radiusY/2;
        temp.z = center.get(2) + radiusZ/2;
        tempVertices.add(temp);
        System.out.println(temp);
        temp =new Vector3f();

        //_____________________________________________________________________________________________________________________________

        //vertices.clear();
        //kotak belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));

        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(0));

        //kotak depan
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(7));

        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));

        //kotak kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(3));

        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(0));

        //kotak kanan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(7));

        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(4));

        //kotak atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(0));

        //kotak bawah
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(7));

        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(1));
    }

    public void createellipsoid(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)(Math.cos(v) * Math.cos(u));
                float y = 0.5f * (float)(Math.cos(v) * Math.sin(u));
                float z = 0.5f * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;

    }

    public void createhyperboloid1sheet(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.1f * (float)((1/Math.cos(v)) * Math.cos(u));
                float y = 0.1f * (float)((1/Math.cos(v)) * Math.sin(u));
                float z = 0.1f * (float)(Math.tan(v));
                temp.add(new Vector3f(x,z,y));
            }
        }
        vertices = temp;

    }

    public void createhyperboloid2sheet(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI/2; u<= Math.PI/2; u+=Math.PI/60){
                float x = 0.1f * (float)((Math.tan(v)) * Math.cos(u));
                float y = 0.1f * (float)((Math.tan(v)) * Math.sin(u));
                float z = 0.1f * (float)(1.0/Math.cos(v));
                temp.add(new Vector3f(x,z,y));
            }
        }

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = Math.PI/2; u<= 3*Math.PI/2; u+=Math.PI/60){
                float x = 0.1f * (float)((Math.tan(v)) * Math.cos(u));
                float y = 0.1f * (float)((Math.tan(v)) * Math.sin(u));
                float z = 0.1f * (float)(1.0/Math.cos(v));
                temp.add(new Vector3f(x,-z,y));
            }
        }
        vertices = temp;

    }

    public void createellipticcone(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI ; v <= Math.PI; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.3f * (float)(v * Math.cos(u));
                float y = 0.4f * (float)(v * Math.sin(u));
                float z = 0.5f * (float)(v);
                temp.add(new Vector3f(x,z,y));
            }
        }
        vertices = temp;

    }

    public void createelipticparaboloid(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = Math.PI/8 ; v <= Math.PI; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)(v * Math.cos(u));
                float y = 0.5f * (float)(v * Math.sin(u));
                float z =(float)(Math.pow(v,2));
                temp.add(new Vector3f(x,z,y));
            }
        }
        vertices = temp;

    }

    public void createhyperboloidparaboloid(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = Math.PI/8 ; v <= Math.PI; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)(v * Math.tan(u));
                float y = 0.5f * (float)(v * 1/Math.cos(u));
                float z =(float)(Math.pow(v,2));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;

    }

//    public void draw(){
//        drawSetup();
//        //System.out.println(vertices.size());
////        System.out.println("index 0" + vertices.get(0));
////        System.out.println("index 5" + vertices.get(1));
////        System.out.println("index 12" + vertices.get(2));
////        System.out.println("index 13" + vertices.get(3));
////        System.out.println("index 27" + vertices.get(4));
//
//        glLineWidth(1); //ketebalan garis
//        glPointSize(1); //besar kecil vertex
//        glDrawArrays(GL_LINE_STRIP,
//                0,
//                vertices.size());
//    }
    public void createSphere(){
        float pi = (float)Math.PI;

        float sectorStep = 2 * (float)Math.PI / sectorCount;
        float stackStep = (float)Math.PI / stackCount;
        float sectorAngle, StackAngle, x, y, z;

        for (int i = 0; i <= stackCount; ++i)
        {
            StackAngle = pi / 2 - i * stackStep;
            x = radiusX * (float)Math.cos(StackAngle);
            y = radiusY * (float)Math.cos(StackAngle);
            z = radiusZ * (float)Math.sin(StackAngle);

            for (int j = 0; j <= sectorCount; ++j)
            {
                sectorAngle = j * sectorStep;
                Vector3f temp_vector = new Vector3f();
                temp_vector.x = center.get(0) + x * (float)Math.cos(sectorAngle);
                temp_vector.y = center.get(1) + y * (float)Math.sin(sectorAngle);
                temp_vector.z = center.get(2) + z;
                vertices.add(temp_vector);
            }
        }
    }


}
