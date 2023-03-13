package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15C.glBindBuffer;
import static org.lwjgl.opengl.GL15C.glBufferData;

public class line extends Object3d {
    List<Integer> index;
    int ibo;

    public line(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Integer> index) {
        super(shaderModuleDataList, vertices, color);


        //index buffer obj || element buffer obj

      ;
            this.index = index;
            ibo = glGenBuffers();
            glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
            glBufferData(GL_ELEMENT_ARRAY_BUFFER,Utils.listoInt(index),GL_STATIC_DRAW);

    }

    public void draw(){
            drawSetup();
            glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
            glDrawElements(GL_LINE_LOOP,index.size(),GL_UNSIGNED_INT,0);
        }


}
