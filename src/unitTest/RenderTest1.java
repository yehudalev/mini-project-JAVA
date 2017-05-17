package unitTest;

import org.junit.Test;

import elements.AmbientLight;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Point3D;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class RenderTest1 {

	@Test
	public void basicRendering(){
		
		Scene scene = new Scene();
		
		//scene.setAmbientLight(new AmbientLight(0,0,0));
		
		scene.addGeometry(new Sphere(50, new Point3D(0.0, 0.0, -150)));
		
		Triangle triangle = new Triangle(new Point3D( 100, 0, -149),
				 						 new Point3D(  0, 100, -149),
				 						 new Point3D( 100, 100, -149));
		
		Triangle triangle2 = new Triangle(new Point3D( 100, 0, -149),
				 			 			  new Point3D(  0, -100, -149),
				 			 			  new Point3D( 100,-100, -149));
		
		Triangle triangle3 = new Triangle(new Point3D(-100, 0, -149),
				 						  new Point3D(  0, 100, -149),
				 						  new Point3D(-100, 100, -149));
		
		Triangle triangle4 = new Triangle(new Point3D(-100, 0, -149),
				 			 			  new Point3D(  0,  -100, -149),
				 			 			  new Point3D(-100, -100, -149));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
		
		ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		//render.printGrid(50);
		render.writeToImage();
		
	}
	
	
}