package convolution;

public class Convolution_lib {
	
	private double[] rho;
	private double g = 1, gg = 1;//g = G(N,K), gg = G(N-1,K)
	
	public Convolution_lib(double[] alpha, double[] mu) {
		this.rho = new double[alpha.length];
				
		for(int i = 0; i< rho.length;i++){
			rho[i] = alpha[i]/mu[i];
		}
	}
	
	public double calcConvolution(int n, int k){
		//kは拠点番号だが、プログラム中の配列番号に合わせるため-1してある。
		if(n == 0) {
			g = 1;
			//System.out.println("GG("+n+","+k+")="+g);
			return g;
		}
		else if (k == 0){ 
			//System.out.println("GG("+n+","+k+")="+Math.pow(rho[0], n));
			g = Math.pow(rho[0], n);
			return g; 
		}
		else {
			g = calcConvolution(n, k-1) + rho[k]*calcConvolution(n-1, k);
			//System.out.println("GG("+n+","+k+")="+g);
			return g;
		}		
	}
	
	public double getG() {
		return g;
	}

	public double getGg() {
		return gg;
	}

	public void setG(double g) {
		this.g = g;
	}

	public void setGg(double gg) {
		this.gg = gg;
	}
}
