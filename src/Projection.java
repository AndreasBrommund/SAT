public class Projection {
	public double min,max;

	public Projection(double min,double max) {
		this.min = min;
		this.max = max;
	}


	public static Projection project(Vector2[] verticies, Vector2 axis) {
		axis = axis.nor();
		double min = axis.dot(verticies[0]);
		double max = min;

		for (int i = 1; i<verticies.length; i++) {
			double p = axis.dot(verticies[i]);

			if (p < min) {
				min = p;
			}else if (p > max){
				max = p;
			}
		}

		Projection p = new Projection(min, max);
		return p;
	}

	public boolean overlap(Projection other) {
		double test1 = this.min - other.max;//test min1 and max2
		double test2 = other.min - this.max;//test min2 and max1

		if(test1 >= 0 || test2 >= 0){
			return false;
		}else {
			return true;
		}
	}

	public double getOverlap(Projection other){
		if (this.overlap(other)) {
			return Math.min(this.max, other.max) - Math.max(this.min, other.min);
		}
		return 0;
	}




}