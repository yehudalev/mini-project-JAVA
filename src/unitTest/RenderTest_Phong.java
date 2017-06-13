package unitTest;

import java.awt.Color;

import org.junit.Test;

import com.sun.scenario.effect.light.SpotLight;

import geometries.Sphere;
import geometries.Triangle;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;
import elements.*;
import primitives.Material;
public class RenderTest_Phong {

	 @Test
	    public void testRenderImage1() throws Exception {
	        Camera camera=new Camera(new Point3D(0.0, 0.0, 0.0), new Vector(0,1,0), new Vector(0, 0, -1));
	        Scene scene = new Scene(new AmbientLight(255, 255, 255), new Color(0,0,0), camera, 100);
	        /*Plane plane = new Plane(new Vector(0,1, 0), new Point3D(0.0, -130.0 , 0.0));
	        plane.setShininess(200);
	        plane.setEmmission(new Color(0,0,0));
	        plane.setMaterial(new Material( 0, 0, 0, 0 ,0));*/
	        Sphere sphere1 = new Sphere(900.0, new Point3D(0.0, 0.0 , -1300.0));
	        sphere1.set_nShininess(35);
	        sphere1.set_emmission(new Color(17,15,116));
	        sphere1.set_material(new Material(1, 1, 0, 1,0));
	        /*Triangle triangle = new Triangle(new Point3D(1000.0, -200.0, -600.0),new Point3D(-100.0, -200.0, -1000.0), new Point3D(400.0, 1000.0, -800.0));
	        triangle.setShininess(1.0);
	        triangle.setEmmission(new Color(0,0,0));
	        triangle.setMaterial(new Material(0, 0, 1, 0 ,0));
	        Sphere sphere2 = new Sphere(700.0, new Point3D(-200.0, 0.0 , -1500.0));
	        sphere2.setShininess(35.0);
	        sphere2.setEmmission(new Color(116,15,17));
	        sphere2.setMaterial(new Material(0.5, 0.5, 0, 0.5,1));
	        Sphere sphere3 = new Sphere(300.0, new Point3D(-200.0, 0.0 , -1500.0));
	        sphere3.setShininess(35.0);
	        sphere3.setEmmission(new Color(15,200,17));
	        sphere3.setMaterial(new Material(1, 1, 0, 0,1));*/
	        //scene.addGeometry(plane);
	        scene.addGeometry(sphere1);
	        /*scene.addGeometry(triangle);
	        scene.addGeometry(sphere2);
	        scene.addGeometry(sphere3);*/
	        scene.addLight(new PointLight(new Color(255,50,50), new Point3D(200.0, 200.0, -20.0), 0.000004, 0.000004, 0.000002));
	        //scene.addLight(new SpotLight(new Color(255, 50, 50), new Point3D(200.0, 200.0, -20.0), new Vector(-200.0, -200.0, -1280.0),0.002, 0.002, 0.001));
	        ImageWriter imageWriter = new ImageWriter("SceneTestPoint", 500, 500, 500, 500);
	        Render render = new Render(imageWriter, scene);
	        render.renderImage();
	    }
}
