import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;


public class SAT extends JFrame{
	
	private double[] x1 = {150,100,150,200};
	private double[] y1 = {100,150,200,150};
	
	private double[] x2 = {150,150,250,250};
	private double[] y2 = {150,250,250,150};
	
	private Shape shape1 =  new Shape(x1, y1);
	private Shape shape2 =  new Shape(x2, y2);
	
 	public SAT() {
		super("SAT");
		setSize(1000,1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		ArrayList<Vector2> axis = new ArrayList<Vector2>();
		axis.addAll(shape1.getAxes());
		axis.addAll(shape2.getAxes());
		for(Vector2 a:axis){
			Projection p1 = Projection.project(shape1.pos, a);
			Projection p2 = Projection.project(shape1.pos, a);
			System.out.println(p1.overlap(p2));
			if (!p1.overlap(p2)) {
				
				System.out.println("Don't");
			}
		}
		
		
		
		repaint();
		setVisible(true);
	}
	public static void main(String[] args) {
		new SAT();
	}
	
	@Override
	public void paint(Graphics g) {
		shape1.draw(g, Color.RED);
		shape2.draw(g, Color.GREEN);
	}
	
	class Shape {
		
		private Vector2[] pos = new Vector2[4];
		private ArrayList<Vector2> normals = new ArrayList<Vector2>();
		
		public Shape(double[] x,double [] y) {
			pos[0] = new Vector2(x[0], y[0]);
			pos[1] = new Vector2(x[1], y[1]);
			pos[2] = new Vector2(x[2], y[2]);
			pos[3] = new Vector2(x[3], y[3]);
			
			normals.add(new Vector2(-1*(y[0]-y[3]),x[0]-x[3]));
			normals.add(new Vector2(-1*(y[1]-y[0]),x[1]-x[0]));
			normals.add(new Vector2(-1*(y[2]-y[1]),x[2]-x[1]));
			normals.add(new Vector2(-1*(y[3]-y[2]),x[3]-x[2]));
			
			 
		}
		 
		public ArrayList<Vector2> getAxes(){
			return normals ;
		}
		
		public void draw(Graphics g,Color c){
			g.setColor(c); 
			int[] x = new int[4]; 
			int[] y = new int[4]; 
			
			for(int i = 0;i < pos.length;i++){
				x[i] = (int)pos[i].x; 
				y[i] = (int)pos[i].y;
			}
			
			g.drawPolygon(x, y, 4);
			for(Vector2 v:normals){
				g.drawLine(700, 700, 700+(int)(v.x), 700+(int)(v.y));
			}
			
		}
		
	}
}
