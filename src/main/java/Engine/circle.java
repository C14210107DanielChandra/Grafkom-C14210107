package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

//import static java.lang.Math.cos;
//import static java.lang.Math.sin;
//
//public class circle extends Object2d{
//
//    float radiusx = 0.1f;
//    float radiusy = 0.1f;
//    float center = 0.5f;
//    float y,x;
//
//    int pixel = 360/36;
//    public circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
//        super(shaderModuleDataList, vertices, color);
//    }
//
//    public void createcircle(){
//        for(double i = 0;i<360;i+=pixel){
//            x = Math.round(center + radiusx*cos(Math.toRadians(i)));
//            y = Math.round(center + radiusy*sin(Math.toRadians(i)));
//            vertices.add(new Vector3f(x,y,0.0f));
//
//        }
//    }
//}
