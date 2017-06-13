package unitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import elements.Camera;
import geometries.Plane;
import primitives.*;

public class Plane_Test {

	@Test
	public void testIntersectionPoints() {
		final int WIDTH = 3;
		final int HEIGHT = 3;
		Ray[][] rays = new Ray[HEIGHT][WIDTH];
		Camera camera = new Camera(new Point3D(0.0, 0.0, 0.0), new Vector(0.0, 1.0, 0.0), new Vector(0.0, 0.0, -1.0));
		// plane orthogonal to the view plane
		Plane plane = new Plane(new Vector(0.0, 0.0, -1.0), new Point3D(0.0, 0.0, -3.0));
		// 45 degrees to the view plane
		Plane plane2 = new Plane(new Vector(0.0, 0.25, -1.0), new Point3D(0.0, 0.0, -3.0));
		List<Point3D> intersectionPointsPlane = new ArrayList<Point3D>();
		List<Point3D> intersectionPointsPlane2 = new ArrayList<Point3D>();
		System.out.println("Camera:\n" + camera);
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				rays[i][j] = camera.constructRayThroughPixel(WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);
				List<Point3D> rayIntersectionPoints = plane.FindIntersections(rays[i][j]);
				List<Point3D> rayIntersectionPoints2 = plane2.FindIntersections(rays[i][j]);
				for (Point3D iPoint : rayIntersectionPoints)
					intersectionPointsPlane.add(iPoint);
				for (Point3D iPoint : rayIntersectionPoints2)
					intersectionPointsPlane2.add(iPoint);
			}
		}
		assertTrue(intersectionPointsPlane.size() == 9);
		assertTrue(intersectionPointsPlane2.size() == 9);
		for (Point3D iPoint : intersectionPointsPlane)
			System.out.println(iPoint);
		System.out.println("---");
		for (Point3D iPoint : intersectionPointsPlane2)
			System.out.println(iPoint);
	}
	
	
	//test Get Normal
	 @Test
	    public void testGetNormal() {
	        System.out.println("getNormal");
	        Point3D point=new Point3D (1,0,0);
	        Plane instance = new Plane(new Vector(1,1,1),new Point3D (1,0,0));
	        String expResult = "( 1.00 , 1.00 , 1.00 )";
	        String result = instance.getNormal(point).toString();
	        assertEquals(expResult, result);
	        // TODO review the generated test code and remove the default call to fail.
	        //fail("The test case is a prototype.");
	    }
	/*
	@Test
	public void testIntersectionPoints2() {
		final int WIDTH = 3;
		final int HEIGHT = 3;
		Ray[][] rays = new Ray[HEIGHT][WIDTH];
		Camera camera = new Camera(new Point3D(0.0, 0.0, 0.0), new Vector(-2.0, 0.0, 3.0), new Vector(4.0, 0.0, -1.0));
		// plane orthogonal to the view plane
		Plane plane = new Plane(new Vector(1.0, -1.0, 2.0), new Point3D(-8.0, 4.0, 3.0));
		// 45 degrees to the view plane
		Plane plane2 = new Plane(new Vector(0.0, 0.0, 0.0), new Point3D(0.0, 0.0, 0.0));
		List<Point3D> intersectionPointsPlane = new ArrayList<Point3D>();
		List<Point3D> intersectionPointsPlane2 = new ArrayList<Point3D>();
		System.out.println("Camera:\n" + camera);
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				rays[i][j] = camera.constructRayThroughPixel(WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);
				List<Point3D> rayIntersectionPoints = plane.FindIntersections(rays[i][j]);
				List<Point3D> rayIntersectionPoints2 = plane2.FindIntersections(rays[i][j]);
				for (Point3D iPoint : rayIntersectionPoints)
					intersectionPointsPlane.add(iPoint);
				for (Point3D iPoint : rayIntersectionPoints2)
					intersectionPointsPlane2.add(iPoint);
			}
		}
		assertTrue(intersectionPointsPlane.size() == 0);
		assertTrue(intersectionPointsPlane2.size() == 0);
		for (Point3D iPoint : intersectionPointsPlane)
			System.out.println(iPoint);
		System.out.println("---");
		for (Point3D iPoint : intersectionPointsPlane2)
			System.out.println(iPoint);
	}
*/
}
